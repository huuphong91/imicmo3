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
import com.phongtoanhuu.hhh.imicmo3.Entities.VideoYouTubeEntity;
import com.phongtoanhuu.hhh.imicmo3.R;

import java.util.ArrayList;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {

    private Context context;
    private ArrayList<VideoYouTubeEntity> listVideo;
    private static ItemClickListener listener;


    public void setOnItemClickListener(ItemClickListener listener) {
        this.listener = listener;
    }

    public VideoAdapter(Context context, ArrayList<VideoYouTubeEntity> listVideo) {
        this.context = context;
        this.listVideo = listVideo;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_item_activity_video, viewGroup, false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        VideoYouTubeEntity currentVideo = listVideo.get(position);

        holder.txtTitle.setText(currentVideo.getTitle());
        String imageUrl = currentVideo.getThumbnail();
        Glide.with(context).load(imageUrl).into(holder.imgThumbnail);
    }

    @Override
    public int getItemCount() {
        return listVideo.size();
    }


    public static class VideoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        public ImageView imgThumbnail;
        public TextView txtTitle;

        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            imgThumbnail = itemView.findViewById(R.id.imgThumbnail);
            txtTitle = itemView.findViewById(R.id.txtTitle);


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

    public interface ItemClickListener {
        void onItemClick(int position, View v);

        void onItemLongClick(int position, View v);
    }

}
