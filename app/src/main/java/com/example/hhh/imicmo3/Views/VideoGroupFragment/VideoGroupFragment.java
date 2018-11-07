package com.example.hhh.imicmo3.Views.VideoGroupFragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.hhh.imicmo3.Adapters.VideoGroupAdapter;
import com.example.hhh.imicmo3.Entities.VideoGroupEntity;
import com.example.hhh.imicmo3.Presenters.VideoGroupFragmentPresenter;
import com.example.hhh.imicmo3.R;

import java.util.ArrayList;
import java.util.List;

public class VideoGroupFragment extends Fragment implements CallBackVideoGroupFragment {
    private VideoGroupAdapter adapter;
    private VideoGroupFragmentPresenter videoGroupFragmentPresenter;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    public VideoGroupFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video_group,container,false);
        recyclerView = view.findViewById(R.id.recyclerview);
        progressBar = view.findViewById(R.id.pbVideoGroupFragment);
        videoGroupFragmentPresenter = new VideoGroupFragmentPresenter(this);
        videoGroupFragmentPresenter.getApiListVideoGroup();



        return view;
    }


    @Override
    public void getApiListVideoGroupThanhCong(List<VideoGroupEntity> listVideoGroup) {
            progressBar.setVisibility(View.INVISIBLE);
            recyclerView.setVisibility(View.VISIBLE);
            recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
            recyclerView.setHasFixedSize(true);
            adapter = new VideoGroupAdapter(getActivity(), (ArrayList<VideoGroupEntity>) listVideoGroup);
            recyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();


    }

    @Override
    public void getApiListVideoThatBai(String sThongBao) {
        Toast.makeText(getActivity(),sThongBao,Toast.LENGTH_SHORT).show();
    }
}
