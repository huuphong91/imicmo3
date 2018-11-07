package com.example.hhh.imicmo3.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hhh.imicmo3.Entities.DeveloperEntity;
import com.example.hhh.imicmo3.R;


import java.util.List;
import java.util.Random;

public class DeveloperAdapter extends RecyclerView.Adapter<DeveloperAdapter.DeveloperViewHolder> {
    private Context context;
    private List<DeveloperEntity> listDeveloper;

    public DeveloperAdapter(Context context, List<DeveloperEntity> listDeveloper) {
        this.context = context;
        this.listDeveloper = listDeveloper;
    }

    @NonNull
    @Override
    public DeveloperViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_item_developer, parent, false);
        return new DeveloperViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull DeveloperViewHolder holder, int position) {
        DeveloperEntity currentDev = listDeveloper.get(position);
        holder.tvFullName.setText(currentDev.getFullName());
        holder.tvEmail.setText(currentDev.getEmail());
        holder.tvMobile.setText(currentDev.getMobile());
        String imgUrl = currentDev.getImage();
        Glide.with(context).load(imgUrl).into(holder.imgDev);

        holder.cardView.setCardBackgroundColor(getRandomColorCode());
    }

    @Override
    public int getItemCount() {
        return listDeveloper.size();

    }
    class DeveloperViewHolder extends RecyclerView.ViewHolder {
        ImageView imgDev;
        TextView tvFullName, tvEmail, tvMobile;
        CardView cardView;
        public DeveloperViewHolder(@NonNull View itemView) {
            super(itemView);
            imgDev = itemView.findViewById(R.id.img_developer);
            tvFullName = itemView.findViewById(R.id.tv_fullName_developer);
            tvEmail = itemView.findViewById(R.id.tv_email_developer);
            tvMobile = itemView.findViewById(R.id.tv_mobile_developer);
            cardView = itemView.findViewById(R.id.card_view_developer);
        }
    }


    public int getRandomColorCode() {
        int[] developerColors = context.getResources().getIntArray(R.array.developercolors);
        int randomColor = developerColors[new Random().nextInt(developerColors.length)];
        return  randomColor;
    }

}
