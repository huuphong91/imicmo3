package com.example.hhh.imicmo3.Models.RegisterUserActivity;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.hhh.imicmo3.Services.ResponseService;
import com.example.hhh.imicmo3.Services.RetrofitInstance;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;

public class RegisterUserActivityModel {
    private CallBackRegisterUserActivityModel callBackRegisterUserActivityModel;

    public RegisterUserActivityModel(CallBackRegisterUserActivityModel callBackRegisterUserActivityModel) {
        this.callBackRegisterUserActivityModel = callBackRegisterUserActivityModel;
    }

    public  void xyLyRegisterUser(String user,String pass,String email,String fullname,String mobile) {
        ResponseService service = RetrofitInstance.getRetrofitInstance().create(ResponseService.class);
        Call<ResponseBody> call = service.registerUser(fullname,email,mobile,user,pass);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(@NonNull Call<ResponseBody> call, @NonNull retrofit2.Response<ResponseBody> response) {


                assert response.body() != null;
                String sThongBao = null;
                try {
                    sThongBao = response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                assert sThongBao != null;
                if (sThongBao.equals("true")) {
                    callBackRegisterUserActivityModel.xuLyRegisterUserThanhCong("Đăng ký thành công");


                } else {
                    callBackRegisterUserActivityModel.xuLyReigterUserThatBai("Đăng ký thất bại");

                }




            }

            @Override
            public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {
                t.getMessage();
            }

        });
    }
}
