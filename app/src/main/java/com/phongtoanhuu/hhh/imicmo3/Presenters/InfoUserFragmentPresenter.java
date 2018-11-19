package com.phongtoanhuu.hhh.imicmo3.Presenters;

import com.phongtoanhuu.hhh.imicmo3.Entities.JobRecruimentEntity;
import com.phongtoanhuu.hhh.imicmo3.Models.InfoUserFragment.CallBackInfoUserFragmentModel;
import com.phongtoanhuu.hhh.imicmo3.Models.InfoUserFragment.InfoUserFragmentModel;
import com.phongtoanhuu.hhh.imicmo3.Views.InfoUserFragment.CallBackInfoUserFragment;

import java.util.List;

public class InfoUserFragmentPresenter implements CallBackInfoUserFragmentModel {
    private CallBackInfoUserFragment callBackInfoUserFragment;
    private InfoUserFragmentModel infoUserFragmentModel = null;

    public InfoUserFragmentPresenter(CallBackInfoUserFragment callBackInfoUserFragment) {
        infoUserFragmentModel = new InfoUserFragmentModel(this);
        this.callBackInfoUserFragment = callBackInfoUserFragment;
    }

    public void getListRecruiment(String profileId) {
        infoUserFragmentModel.xuLyGetListRecruimentTheoProfileId(profileId);
    }

    @Override
    public void xuLyGetListRecruimentThanhCong(List<JobRecruimentEntity> recruimentEntities) {
        callBackInfoUserFragment.getListRecruimentThanhCong(recruimentEntities);

    }

    @Override
    public void xuLyGetListRecruimentThatBai(String sThongbao) {
        callBackInfoUserFragment.getListRecruimentThatBai(sThongbao);
    }
}
