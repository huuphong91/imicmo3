package com.example.hhh.imicmo3.Presenters;

import com.example.hhh.imicmo3.Entities.AccountEntity;
import com.example.hhh.imicmo3.Models.RegisterUserActivity.CallBackRegisterUserActivityModel;
import com.example.hhh.imicmo3.Models.RegisterUserActivity.RegisterUserActivityModel;
import com.example.hhh.imicmo3.Views.RegisterUserActivity.CallBackRegisterUserActivity;

public class RegisterUserActivityPresenter implements CallBackRegisterUserActivityModel {
    private CallBackRegisterUserActivity callBackRegisterUserActivity;
    private RegisterUserActivityModel registerUserActivityModel = null;

    public RegisterUserActivityPresenter(CallBackRegisterUserActivity callBackRegisterUserActivity) {
        registerUserActivityModel = new RegisterUserActivityModel(this);
        this.callBackRegisterUserActivity = callBackRegisterUserActivity;
    }

    public void registerUser(String user, String pass, String email, String fullname, String mobile) {
        registerUserActivityModel.xyLyRegisterUser(user,pass,email,fullname,mobile);
    }
    @Override
    public void xuLyRegisterUserThanhCong(String sThongBao) {
        callBackRegisterUserActivity.registerUserThanhCong(sThongBao);

    }

    @Override
    public void xuLyReigterUserThatBai(String sThongBao) {
        callBackRegisterUserActivity.registerUserThatBai(sThongBao);
    }
}
