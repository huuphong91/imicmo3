package com.example.hhh.imicmo3.Models.DeveloperActivity;

import android.util.Log;

import com.example.hhh.imicmo3.Entities.DeveloperEntity;
import com.example.hhh.imicmo3.Entities.MetaData;
import com.example.hhh.imicmo3.Services.ResponseService;
import com.example.hhh.imicmo3.Services.RetrofitInstance;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/*
 * class dùng để xử lý dữ liệu, sau đó đẩy vào interface CallBackDeveloperModel
 */
public class DeveloperModel {
    private CallBackDeveloperModel callBackDeveloperModel;

    public DeveloperModel(CallBackDeveloperModel callBackDeveloperModel) {
        this.callBackDeveloperModel = callBackDeveloperModel;
    }

    public void getApiDeveloper() {
        ResponseService service = RetrofitInstance.getRetrofitInstance().create(ResponseService.class);
        Call<MetaData<DeveloperEntity>> call = service.getDeveloper();
        // xử lý dữ liệu trả vè
        //nhận dữ liệu và add vào List để hiển thị lên View

        call.enqueue(new Callback<MetaData<DeveloperEntity>>() {
            @Override
            public void onResponse(Call<MetaData<DeveloperEntity>> call, Response<MetaData<DeveloperEntity>> response) {
                List<DeveloperEntity> listDeveloper = response.body().getResult();
                if (listDeveloper != null) {
                    callBackDeveloperModel.getApiListDeviloperSuccess(listDeveloper);
                } else {
                    callBackDeveloperModel.getApiListDeviloperFailure("Xử lý lấy Video Group thất bại");
                }
            }

            @Override
            public void onFailure(Call<MetaData<DeveloperEntity>> call, Throwable t) {

            }
        });

    }
}
