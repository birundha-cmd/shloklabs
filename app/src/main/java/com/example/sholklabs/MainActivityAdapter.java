package com.example.sholklabs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sholklabs.RoomDb.AddListDb;
import com.example.sholklabs.model.ListResponse;

import java.util.ArrayList;


public class MainActivityAdapter extends RecyclerView.Adapter<MainActivityAdapter.ViewHolder> {
    private Context context;
    private ArrayList<ListResponse>listResponses;

    public MainActivityAdapter(Context context, ArrayList<ListResponse> listResponses) {
        this.context = context;
        this.listResponses = listResponses;
    }

    @NonNull
    @Override
    public MainActivityAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_adapter, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainActivityAdapter.ViewHolder holder, int position) {
        ListResponse listResponse=listResponses.get(position);
        holder.scheduleCodeText.setText(listResponse.getHdn_ScheduleCode());
        holder.qualitySurveyTextView.setText(listResponse.getLTE_INSP_Label1());
        holder.requestedbyTextView.setText(listResponse.getLTE_INSP_Label3());
        holder.insskTextView.setText(listResponse.getLTE_INSP_Label5());
    }

    @Override
    public int getItemCount() {
        return listResponses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView scheduleCodeText,qualitySurveyTextView,requestedbyTextView,insskTextView;
        public ViewHolder(@NonNull View view) {
            super(view);
            scheduleCodeText=view.findViewById(R.id.scheduleCodeText);
            qualitySurveyTextView=view.findViewById(R.id.qualitySurveyTextView);
            requestedbyTextView=view.findViewById(R.id.requestedbyTextView);
            insskTextView=view.findViewById(R.id.insskTextView);
        }
    }
}
