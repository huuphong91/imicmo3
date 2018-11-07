package com.example.hhh.imicmo3.Presenters;

import com.example.hhh.imicmo3.Entities.DeveloperEntity;
import com.example.hhh.imicmo3.Models.DeveloperActivity.CallBackDeveloperModel;
import com.example.hhh.imicmo3.Models.DeveloperActivity.DeveloperModel;
import com.example.hhh.imicmo3.Views.DeveloperActivity.CallBackDeveloperActvity;

import java.util.List;

/*
 * Lớp này dùng để xử lý logic
 * nhận dữ liệu từ model thông qua CallBackDevelopModel
 * nhiệm vụ đẩy lên View và hướng dẫn cách View hiển thị
 * */
public class DeveloperActivityPresenter implements CallBackDeveloperModel {
    private DeveloperModel developerModel;
    private CallBackDeveloperActvity callBackDeveloperActvity;

    public DeveloperActivityPresenter(CallBackDeveloperActvity callBackDeveloperActvity) {
        this.callBackDeveloperActvity = callBackDeveloperActvity;
        developerModel = new DeveloperModel(this);
    }

    public void loadData(){
        developerModel.getApiDeveloper();
    }

    @Override
    public void getApiListDeviloperSuccess(List<DeveloperEntity> listDeveloper) {
        callBackDeveloperActvity.getApiListDeviloperSuccess(listDeveloper);
    }

    @Override
    public void getApiListDeviloperFailure(String message) {
        callBackDeveloperActvity.getApiListDeviloperFailure(message);
    }
}
