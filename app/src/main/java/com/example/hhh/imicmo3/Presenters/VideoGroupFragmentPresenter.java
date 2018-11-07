package com.example.hhh.imicmo3.Presenters;

import com.example.hhh.imicmo3.Entities.VideoGroupEntity;
import com.example.hhh.imicmo3.Models.VideoGroupFragment.CallBackVideoGroupFragmentModel;
import com.example.hhh.imicmo3.Models.VideoGroupFragment.VideoGroupFragmentModel;
import com.example.hhh.imicmo3.Views.VideoGroupFragment.CallBackVideoGroupFragment;

import java.util.List;

public class VideoGroupFragmentPresenter implements CallBackVideoGroupFragmentModel {
    private VideoGroupFragmentModel videoGroupFragmentModel = null;
    private CallBackVideoGroupFragment callBackVideoGroupFragment;

    public VideoGroupFragmentPresenter(CallBackVideoGroupFragment callBackVideoGroupFragment) {
        this.callBackVideoGroupFragment = callBackVideoGroupFragment;
        videoGroupFragmentModel = new VideoGroupFragmentModel(this);
    }

    public void getApiListVideoGroup() {
        videoGroupFragmentModel.xuLyGetApiListVideoGroup();

    }

    @Override
    public void xuLyGetApiListVideoGroupThanhCong(List<VideoGroupEntity> listVideoGroup) {
        callBackVideoGroupFragment.getApiListVideoGroupThanhCong(listVideoGroup);
    }

    @Override
    public void xuLyGetApiListVideoGroupThatBai(String sThongBao) {
        callBackVideoGroupFragment.getApiListVideoThatBai(sThongBao);
    }
}
