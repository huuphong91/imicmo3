package com.example.hhh.imicmo3.Presenters;

import com.example.hhh.imicmo3.Entities.AccountEntity;
import com.example.hhh.imicmo3.Models.SignInActivity.CallBackSignInActivityModel;
import com.example.hhh.imicmo3.Models.SignInActivity.SignInActivityModel;
import com.example.hhh.imicmo3.Views.SignInActivity.CallBackSignInActivity;


public class SignInActivityPresenter implements CallBackSignInActivityModel {
    private CallBackSignInActivity callBackSignInActivity;
    private SignInActivityModel signInActivityModel = null;

    public SignInActivityPresenter(CallBackSignInActivity callBackSignInActivity) {
        signInActivityModel = new SignInActivityModel(this);
        this.callBackSignInActivity = callBackSignInActivity;
    }

    public void getApiUserInfo(String username, String password) {
        signInActivityModel.xuLyGetApiUserInfo(username,password);
    }
    @Override
    public void xuLyGetUserInfoThanhCong(AccountEntity accountEntity) {
        callBackSignInActivity.getApiUserInFoThanhCong(accountEntity);

    }

    @Override
    public void xuLyGetUserInfoThatBai(String sThongBao) {
        callBackSignInActivity.getApiUserInFoThatBai(sThongBao);
    }
}
