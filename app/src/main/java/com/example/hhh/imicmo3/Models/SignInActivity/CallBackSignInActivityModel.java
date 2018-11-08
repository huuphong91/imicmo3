package com.example.hhh.imicmo3.Models.SignInActivity;

import com.example.hhh.imicmo3.Entities.AccountEntity;

public interface CallBackSignInActivityModel {
    void xuLyGetUserInfoThanhCong(AccountEntity accountEntity);

    void xuLyGetUserInfoThatBai(String sThongBao);
}
