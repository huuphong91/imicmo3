package com.phongtoanhuu.hhh.imicmo3.Models.OpeningSchedulerFragment;

import android.support.annotation.NonNull;

import com.phongtoanhuu.hhh.imicmo3.Entities.MetaData;
import com.phongtoanhuu.hhh.imicmo3.Entities.OpeningSchedulerEntity;
import com.phongtoanhuu.hhh.imicmo3.Services.ResponseService;
import com.phongtoanhuu.hhh.imicmo3.Services.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class OpeningSchedulerFragmentModel {
    private CallBackOpeningSchedulerFragmentModel callBackOpeningSchedulerFragmentModel = null;

    public OpeningSchedulerFragmentModel(CallBackOpeningSchedulerFragmentModel callBackOpeningSchedulerFragmentModel) {
        this.callBackOpeningSchedulerFragmentModel = callBackOpeningSchedulerFragmentModel;
    }

    public void xuLyGetApiListOpeningScheduler() {
        ResponseService service = RetrofitInstance.getRetrofitInstance().create(ResponseService.class);
        Call<MetaData<OpeningSchedulerEntity>> call = service.getOpeningScheduler();
        call.enqueue(new Callback<MetaData<OpeningSchedulerEntity>>() {
            @Override
            public void onResponse(@NonNull Call<MetaData<OpeningSchedulerEntity>> call, retrofit2.Response<MetaData<OpeningSchedulerEntity>> response) {
                // xử lý dữ liệu trả vè
                //nhận dữ liệu và add vào List để hiển thị lên View
                assert response.body() != null;
                List<OpeningSchedulerEntity> listOpeningScheduler = response.body().getResult();
                if (listOpeningScheduler != null) {
                    callBackOpeningSchedulerFragmentModel.xuLyGetApiListOpeningSchedulerThanhCong(listOpeningScheduler);
                } else {
                    callBackOpeningSchedulerFragmentModel.xuLyGetApiListOpeningSchedulerThatBai("Thất bại");
                }




            }

            @Override
            public void onFailure(@NonNull Call<MetaData<OpeningSchedulerEntity>> call, @NonNull Throwable t) {

            }

        });
    }
}
