package com.phongtoanhuu.hhh.imicmo3.Models.SignInActivity;

import com.phongtoanhuu.hhh.imicmo3.Entities.AccountEntity;

public interface CallBackSignInActivityModel {
    void xuLyGetUserInfoThanhCong(AccountEntity accountEntity);

    void xuLyGetUserInfoThatBai(String sThongBao);
}
