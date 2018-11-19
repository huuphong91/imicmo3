package com.phongtoanhuu.hhh.imicmo3.Models.VideoGroupFragment;

import com.phongtoanhuu.hhh.imicmo3.Entities.VideoGroupEntity;

import java.util.List;

/*
* lớp CallBack cho Model*/
public interface CallBackVideoGroupFragmentModel {
    void xuLyGetApiListVideoGroupThanhCong(List<VideoGroupEntity> listVideoGroup);

    void xuLyGetApiListVideoGroupThatBai(String sThongBao);
}
