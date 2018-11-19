package com.phongtoanhuu.hhh.imicmo3.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.phongtoanhuu.hhh.imicmo3.Entities.JobRecruimentEntity;
import com.phongtoanhuu.hhh.imicmo3.R;

import java.util.List;

public class InfoUserAdapter extends RecyclerView.Adapter<InfoUserAdapter.MyViewHolder>  {
    private Context context;
    private List<JobRecruimentEntity> jobList;

    public InfoUserAdapter (Context context, List<JobRecruimentEntity> jobList) {
        this.context = context;
        this.jobList = jobList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_item_rv_fragment_info_user, parent, false);
        MyViewHolder vh = new MyViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        JobRecruimentEntity currentJob = jobList.get(position);

        holder.tvJobRecruitmentId.setText(currentJob.getJobRecruitmentId());
        holder.tvDeadline.setText(currentJob.getDeadline());

    }

    @Override
    public int getItemCount() {
        return jobList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView tvJobRecruitmentId;
        public TextView tvDeadline;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvJobRecruitmentId = itemView.findViewById(R.id.tv_jobRecruitmentId);
            tvDeadline = itemView.findViewById(R.id.tv_deadline);
        }
    }
}
