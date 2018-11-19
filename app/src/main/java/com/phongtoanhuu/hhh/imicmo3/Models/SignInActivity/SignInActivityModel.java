package com.phongtoanhuu.hhh.imicmo3.Models.SignInActivity;

import android.support.annotation.NonNull;

import com.phongtoanhuu.hhh.imicmo3.Entities.AccountEntity;
import com.phongtoanhuu.hhh.imicmo3.Entities.MetaDataObject;
import com.phongtoanhuu.hhh.imicmo3.Services.ResponseService;
import com.phongtoanhuu.hhh.imicmo3.Services.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;

public class SignInActivityModel {
    private CallBackSignInActivityModel callBackSignInActivityModel;

    public SignInActivityModel(CallBackSignInActivityModel callBackSignInActivityModel) {
        this.callBackSignInActivityModel = callBackSignInActivityModel;
    }

    public void xuLyGetApiUserInfo(String username, String password) {
        ResponseService service = RetrofitInstance.getRetrofitInstance().create(ResponseService.class);
        Call<MetaDataObject<AccountEntity>> call = service.getUer(username,password);
        call.enqueue(new Callback<MetaDataObject<AccountEntity>>() {
            @Override
            public void onResponse(@NonNull Call<MetaDataObject<AccountEntity>> call, @NonNull retrofit2.Response<MetaDataObject<AccountEntity>> response) {


                assert response.body() != null;
                AccountEntity accountEntity = response.body().getResult();
                if (accountEntity != null) {
                    callBackSignInActivityModel.xuLyGetUserInfoThanhCong(accountEntity);

                } else {
                    callBackSignInActivityModel.xuLyGetUserInfoThatBai("Thất bại");
                }




            }

            @Override
            public void onFailure(@NonNull Call<MetaDataObject<AccountEntity>> call, @NonNull Throwable t) {
                t.getMessage();
            }

        });
    }


}
