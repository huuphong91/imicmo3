package com.phongtoanhuu.hhh.imicmo3.Views.OpeningSchedulerFragment;

import com.phongtoanhuu.hhh.imicmo3.Entities.OpeningSchedulerEntity;

import java.util.List;

public interface CallBackOpeningSchedulerFragment {
    void getApiListOpeningSchedulerThanhCong(List<OpeningSchedulerEntity> listOpeningScheduler);

    void getApiListOpeningSchedulerThatBai(String sThongBao);
}
