package com.phongtoanhuu.hhh.imicmo3.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.phongtoanhuu.hhh.imicmo3.Entities.VideoGroupEntity;
import com.phongtoanhuu.hhh.imicmo3.R;

import java.util.ArrayList;

public class VideoGroupAdapter extends RecyclerView.Adapter<VideoGroupAdapter.ViewHolder> {
    private Context context;
    private ArrayList<VideoGroupEntity> listVGroup;
    private static ItemClickListener listener;


    public void setOnItemClickListener(ItemClickListener listener) {
        this.listener = listener;
    }

    public VideoGroupAdapter(Context context, ArrayList<VideoGroupEntity> listVGroup) {
        this.context = context;
        this.listVGroup = listVGroup;
    }

    @NonNull
    @Override
    public VideoGroupAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_item_fragment_video_group, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoGroupAdapter.ViewHolder holder, int position) {
        VideoGroupEntity videoGroupEntity = listVGroup.get(position);
        holder.tvCourse.setText(videoGroupEntity.getVGroupName());
        String imageUrl = videoGroupEntity.getImages();
        Glide.with(context).load(imageUrl).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return listVGroup.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
         ImageView imageView;
         TextView tvCourse;
       public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_vgroup);
            tvCourse = itemView.findViewById(R.id.text_vgroup);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onItemClick(getAdapterPosition(), v);
        }

        @Override
        public boolean onLongClick(View v) {
            listener.onItemLongClick(getAdapterPosition(), v);
            return false;
        }
    }
    public interface ItemClickListener{
        void onItemClick(int position, View v);
        void onItemLongClick(int position, View v);
    }
}
