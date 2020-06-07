package route;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ecommerce.ctrl.bluebookbookinghistory.Apis.ApiClient;
import com.ecommerce.ctrl.bluebookbookinghistory.Apis.ApiInterface;
import com.ecommerce.ctrl.bluebookbookinghistory.Apis.Locationresponse;
import com.ecommerce.ctrl.bluebookbookinghistory.Apis.TrackList;
import com.ecommerce.ctrl.bluebookbookinghistory.Apis.TrackLocationResponse;
import com.ecommerce.ctrl.bluebookbookinghistory.R;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.ecommerce.ctrl.bluebookbookinghistory.Apis.ApiClient.BASE_URL;

public class Test extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void userLocation(String id){
        ApiInterface api=ApiClient.getClient().create(ApiInterface.class);
        String url=BASE_URL+""+id;
        Call<TrackList>responseBodyCall=api.drawlocation(url);
        responseBodyCall.enqueue(new Callback<TrackList>() {
            @Override
            public void onResponse(Call<TrackList> call, Response<TrackList> response) {
                List<TrackLocationResponse>locationresponses;
                TrackList trackList=response.body();
                locationresponses=trackList.getLocations();
                if (locationresponses!=null&&trackList!=null){
                    for (int i=0;i<locationresponses.size();i++){
                        String lc=locationresponses.get(i).getLocation();


                    }

                }
            }

            @Override
            public void onFailure(Call<TrackList> call, Throwable t) {

            }
        });





    }
}
