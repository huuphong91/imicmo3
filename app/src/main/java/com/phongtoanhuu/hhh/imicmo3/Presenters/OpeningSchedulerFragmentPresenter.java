package com.phongtoanhuu.hhh.imicmo3.Presenters;

import com.phongtoanhuu.hhh.imicmo3.Entities.OpeningSchedulerEntity;
import com.phongtoanhuu.hhh.imicmo3.Models.OpeningSchedulerFragment.CallBackOpeningSchedulerFragmentModel;
import com.phongtoanhuu.hhh.imicmo3.Models.OpeningSchedulerFragment.OpeningSchedulerFragmentModel;
import com.phongtoanhuu.hhh.imicmo3.Views.OpeningSchedulerFragment.CallBackOpeningSchedulerFragment;

import java.util.List;

public class OpeningSchedulerFragmentPresenter implements CallBackOpeningSchedulerFragmentModel {

    private OpeningSchedulerFragmentModel openingSchedulerFragmentModel = null;
    private CallBackOpeningSchedulerFragment callBackOpeningSchedulerFragment;

    public OpeningSchedulerFragmentPresenter(CallBackOpeningSchedulerFragment callBackOpeningSchedulerFragment) {
        this.callBackOpeningSchedulerFragment = callBackOpeningSchedulerFragment;
        openingSchedulerFragmentModel = new OpeningSchedulerFragmentModel(this);
    }
    public void getApiListOpeningScheduler() {
        openingSchedulerFragmentModel.xuLyGetApiListOpeningScheduler();

    }
    @Override
    public void xuLyGetApiListOpeningSchedulerThanhCong(List<OpeningSchedulerEntity> listOpeningScheduler) {
        callBackOpeningSchedulerFragment.getApiListOpeningSchedulerThanhCong(listOpeningScheduler);
    }

    @Override
    public void xuLyGetApiListOpeningSchedulerThatBai(String sThongBao) {
        callBackOpeningSchedulerFragment.getApiListOpeningSchedulerThatBai(sThongBao);
    }
}
