package com.example.sholklabs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.sholklabs.Apis.ApiClient;
import com.example.sholklabs.Apis.ApiInterface;
import com.example.sholklabs.RoomDb.AddListDb;
import com.example.sholklabs.RoomDb.DataBaseClient;
import com.example.sholklabs.model.ListObject;
import com.example.sholklabs.model.ListResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
   private ArrayList<ListResponse>listResponses=new ArrayList<>();
    private ArrayList<AddListDb> taskList=new ArrayList<>();
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
        progressBar=findViewById(R.id.progressBar);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        if (isNetworkAvailable() ){
            ListApiResponse();
        }else{

          getList();


        }

    }

    private void ListApiResponse(){
        progressBar.setVisibility(View.VISIBLE);
        ApiInterface apiInterface= ApiClient.getClient().create(ApiInterface.class);
        final Call<ListObject>listObjectCall=apiInterface.listResponse();
        listObjectCall.enqueue(new Callback<ListObject>() {
            @Override
            public void onResponse(Call<ListObject> call, Response<ListObject> response) {
                progressBar.setVisibility(View.GONE);
                ListObject listObject = response.body();
                JSONArray jsonArray = null;
                try {

                    assert listObject != null;
                    jsonArray = new JSONArray(listObject.getGetInspectionsResult());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                assert jsonArray != null;
                for (int i = 0; i < jsonArray.length(); i++) {
                    try {
                        JSONObject explrObject = jsonArray.getJSONObject(i);
                        String hdn_ScheduleCode = explrObject.getString("hdn_ScheduleCode");
                        String LTE_INSP_Label2 = explrObject.getString("LTE_INSP_Label2");
                        String LTE_INSP_Label1 = explrObject.getString("LTE_INSP_Label1");
                        String LTE_INSP_Label3 = explrObject.getString("LTE_INSP_Label3");
                        String LTE_INSP_Label5 = explrObject.getString("LTE_INSP_Label5");

                        ListResponse listResponse=new ListResponse();
                        listResponse.setHdn_ScheduleCode(hdn_ScheduleCode);
                        listResponse.setLTE_INSP_Label2(LTE_INSP_Label2);
                        listResponse.setLTE_INSP_Label3(LTE_INSP_Label3);
                        listResponse.setLTE_INSP_Label5(LTE_INSP_Label5);
                        listResponse.setLTE_INSP_Label1(LTE_INSP_Label1);
                        listResponses=new ArrayList<>();

                        listResponses.add(listResponse);
                        new DeleteList().execute();

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

                MainActivityAdapter mainActivityAdapter=new MainActivityAdapter(MainActivity.this,listResponses);
                recyclerView.setAdapter(mainActivityAdapter);
            }

            @Override
            public void onFailure(Call<ListObject> call, Throwable t) {
                progressBar.setVisibility(View.GONE);

                Log.e("",t.toString());
            }
        });
    }


    class SaveList  extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void...voids) {


            List<AddListDb>insertlist=new ArrayList<>();
            for (int i=0;i<listResponses.size();i++){
                AddListDb addListDb=new AddListDb();
                addListDb.setLTE_INSP_Label1(listResponses.get(i).getLTE_INSP_Label1());
                addListDb.setLTE_INSP_Label2(listResponses.get(i).getLTE_INSP_Label2());
                addListDb.setLTE_INSP_Label3(listResponses.get(i).getLTE_INSP_Label3());
                addListDb.setLTE_INSP_Label4(listResponses.get(i).getLTE_INSP_Label5());
                addListDb.setHdn_ScheduleCode(listResponses.get(i).getHdn_ScheduleCode());
                insertlist.add(addListDb);


            }
            DataBaseClient.getInstance(getApplicationContext()).getAppDatabase()
                    .billAppRoomInterface()
                    .insertList(insertlist);
            return null;

        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();
            getList();


        }
    }


    private void getList() {
        class GetTasks extends AsyncTask<Void, Void, List<AddListDb>> {

            @Override
            protected List<AddListDb> doInBackground(Void... voids) {
                List<AddListDb> taskList = DataBaseClient
                        .getInstance(getApplicationContext())
                        .getAppDatabase()
                        .billAppRoomInterface()
                        .getAll();
                return taskList;
            }

            @Override
            protected void onPostExecute(List<AddListDb> tasks) {
                super.onPostExecute(tasks);
                taskList=new ArrayList<>();
                taskList.addAll(tasks);
                listResponses=new ArrayList<>();

                if (taskList.size()>0){
                    for (int i=0;i<taskList.size();i++){
                        ListResponse listdb=new ListResponse();
                        listdb.setHdn_ScheduleCode(tasks.get(i).getHdn_ScheduleCode());
                        listdb.setLTE_INSP_Label1(tasks.get(i).getLTE_INSP_Label1());
                        listdb.setLTE_INSP_Label2(tasks.get(i).getLTE_INSP_Label2());
                        listdb.setLTE_INSP_Label3(tasks.get(i).getLTE_INSP_Label3());
                        listdb.setLTE_INSP_Label5(tasks.get(i).getLTE_INSP_Label4());

                        listResponses.add(listdb);

                    }
                    if (listResponses.size()>0){
                        MainActivityAdapter adapter = new MainActivityAdapter(MainActivity.this, listResponses);
                        recyclerView.setAdapter(adapter);
                    }

                }

            }
        }

        GetTasks gt = new GetTasks();
        gt.execute();


}
    class DeleteList  extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            DataBaseClient.getInstance(getApplicationContext()).getAppDatabase()
                    .billAppRoomInterface()
                    .deleteList();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if (listResponses!=null&&listResponses.size()>0) {
                new SaveList().execute();

            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
