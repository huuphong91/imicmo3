package com.example.hhh.imicmo3.Views.SignInActivity;

import com.example.hhh.imicmo3.Entities.AccountEntity;

public interface CallBackSignInActivity {
    void getApiUserInFoThanhCong(AccountEntity accountEntity);

    void getApiUserInFoThatBai(String sThongBao);
}
