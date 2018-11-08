package com.example.hhh.imicmo3.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.hhh.imicmo3.Entities.JobRecruimentEntity;
import com.example.hhh.imicmo3.R;

import java.util.List;

public class JobRecruimentAdapter extends BaseAdapter {
    private Context context;
    private List<JobRecruimentEntity> list;

    public JobRecruimentAdapter(Context context, List<JobRecruimentEntity> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHoler viewHoler;
        View view = convertView;
        if (view == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            view = layoutInflater.inflate(R.layout.custom_item_lv_fragment_job_recruiment,parent,false);
            viewHoler = new ViewHoler();
            viewHoler.CorporationId = view.findViewById(R.id.CorporationId);
            viewHoler.Title = view.findViewById(R.id.Title);
            viewHoler.LocationName = view.findViewById(R.id.LocationName);
            viewHoler.Salary = view.findViewById(R.id.Salary);
            viewHoler.Deadline = view.findViewById(R.id.Deadline);
            viewHoler.nopCV_Btn = view.findViewById(R.id.nopCV_Btn);
            view.setTag(viewHoler);
        }
        else {
            viewHoler = (ViewHoler) view.getTag();
        }
        JobRecruimentEntity jobRecruitments = list.get(position);
        viewHoler.CorporationId.setText(jobRecruitments.getCorporationId());
        viewHoler.Title.setText(jobRecruitments.getCareerName());
        viewHoler.LocationName.setText(jobRecruitments.getLocationName());
        viewHoler.Salary.setText(jobRecruitments.getSalary());
        viewHoler.Deadline.setText(jobRecruitments.getDeadline());

        return view;


    }

    class ViewHoler {
        TextView CorporationId,
                Title,
                LocationName,
                Salary,
                Deadline;
        Button nopCV_Btn;
    }
}
