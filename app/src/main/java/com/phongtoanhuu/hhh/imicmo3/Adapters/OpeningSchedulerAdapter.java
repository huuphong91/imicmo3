package com.phongtoanhuu.hhh.imicmo3.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.phongtoanhuu.hhh.imicmo3.Entities.OpeningSchedulerEntity;
import com.phongtoanhuu.hhh.imicmo3.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class OpeningSchedulerAdapter extends RecyclerView.Adapter<OpeningSchedulerAdapter.MyViewHolder> {
    private Context context;

    private List<OpeningSchedulerEntity> listResult;


    public OpeningSchedulerAdapter(Context mContext, List<OpeningSchedulerEntity> listResult) {
        this.context = mContext;
        this.listResult = listResult;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view ;
        LayoutInflater inflater = LayoutInflater.from(context);
        view=inflater.inflate(R.layout.custom_item_fragment_opening_scheduler,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ParseToDateStype parseToDateStype = new ParseToDateStype();
        //holder.ngayKhaiGiang.setText(parseToDateStype.ParseDate(listResult.get(position).getCreateDate()));
        holder.ngayKhaiGiang.setText( "Ngày khai giảng - " + listResult.get(position).getOpenningDate());
        holder.loCation.setText(listResult.get(position).getLocation());
        Glide.with(context).load(listResult.get(position).getImageLink()).into(holder.hinhKhaiGiang);

    }

    @Override
    public int getItemCount() {
        return listResult.size();
    }



    static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView ngayKhaiGiang;
        TextView loCation;
        ImageView hinhKhaiGiang;




        MyViewHolder(View itemView){
            super(itemView);
            ngayKhaiGiang=itemView.findViewById(R.id.txt_ngaykhaigiang);
            loCation=itemView.findViewById(R.id.txtLocation);
            hinhKhaiGiang=itemView.findViewById(R.id.img_hinhkhaigiang);


        }








    }
    public static class ParseToDateStype{
        public String ParseDate(String dateInput){

            String timeStamp=dateInput.substring(6,dateInput.length()-7);
            String dateFormat = "dd-MM-yyyy hh:mm";
            @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);

            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(Long.parseLong(timeStamp));
            return simpleDateFormat.format(calendar.getTime());

        }

    }


}
