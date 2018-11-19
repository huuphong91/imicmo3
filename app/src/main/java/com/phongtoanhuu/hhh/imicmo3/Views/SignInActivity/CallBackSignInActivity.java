package com.phongtoanhuu.hhh.imicmo3.Views.SignInActivity;

import com.phongtoanhuu.hhh.imicmo3.Entities.AccountEntity;

public interface CallBackSignInActivity {
    void getApiUserInFoThanhCong(AccountEntity accountEntity);

    void getApiUserInFoThatBai(String sThongBao);
}
