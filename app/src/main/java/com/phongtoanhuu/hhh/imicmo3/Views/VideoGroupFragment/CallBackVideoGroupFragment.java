package com.phongtoanhuu.hhh.imicmo3.Views.VideoGroupFragment;

import com.phongtoanhuu.hhh.imicmo3.Entities.VideoGroupEntity;

import java.util.List;

public interface CallBackVideoGroupFragment {
    void getApiListVideoGroupThanhCong(List<VideoGroupEntity> listVideoGroup);

    void getApiListVideoThatBai(String sThongBao);
}
