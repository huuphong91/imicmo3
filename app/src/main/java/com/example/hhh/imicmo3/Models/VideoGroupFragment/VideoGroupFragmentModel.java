package com.example.hhh.imicmo3.Models.VideoGroupFragment;

import android.support.annotation.NonNull;

import com.example.hhh.imicmo3.Entities.MetaData;
import com.example.hhh.imicmo3.Entities.VideoGroupEntity;
import com.example.hhh.imicmo3.Services.ResponseService;
import com.example.hhh.imicmo3.Services.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class VideoGroupFragmentModel {
    private CallBackVideoGroupFragmentModel callBackVideoGroupFragmentModel;

    public VideoGroupFragmentModel(CallBackVideoGroupFragmentModel callBackVideoGroupFragmentModel) {
        this.callBackVideoGroupFragmentModel = callBackVideoGroupFragmentModel;
    }

    public void xuLyGetApiListVideoGroup() {

        ResponseService service = RetrofitInstance.getRetrofitInstance().create(ResponseService.class);
        Call<MetaData<VideoGroupEntity>> call = service.getVideoGroup();
        call.enqueue(new Callback<MetaData<VideoGroupEntity>>() {
            @Override
            public void onResponse(@NonNull Call<MetaData<VideoGroupEntity>> call, retrofit2.Response<MetaData<VideoGroupEntity>> response) {
                // xử lý dữ liệu trả vè
                //nhận dữ liệu và add vào List để hiển thị lên View
                assert response.body() != null;
                List<VideoGroupEntity> listVideoGroup = response.body().getResult();
                if (listVideoGroup != null) {
                    callBackVideoGroupFragmentModel.xuLyGetApiListVideoGroupThanhCong(listVideoGroup);
                } else {
                    callBackVideoGroupFragmentModel.xuLyGetApiListVideoGroupThatBai("Xử lý lấy Video Group thất bại");
                }
            }

            @Override
            public void onFailure(@NonNull Call<MetaData<VideoGroupEntity>> call, @NonNull Throwable t) {

            }

        });
    }
}
