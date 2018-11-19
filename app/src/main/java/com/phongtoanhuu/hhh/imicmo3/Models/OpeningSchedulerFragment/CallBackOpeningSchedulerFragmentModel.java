package com.phongtoanhuu.hhh.imicmo3.Models.OpeningSchedulerFragment;

import com.phongtoanhuu.hhh.imicmo3.Entities.OpeningSchedulerEntity;

import java.util.List;

public interface CallBackOpeningSchedulerFragmentModel {
    void xuLyGetApiListOpeningSchedulerThanhCong(List<OpeningSchedulerEntity> listOpeningScheduler);

    void xuLyGetApiListOpeningSchedulerThatBai(String sThongBao);
}
