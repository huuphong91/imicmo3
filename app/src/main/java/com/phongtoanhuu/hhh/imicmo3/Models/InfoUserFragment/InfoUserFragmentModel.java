package com.phongtoanhuu.hhh.imicmo3.Models.InfoUserFragment;

import android.support.annotation.NonNull;

import com.phongtoanhuu.hhh.imicmo3.Entities.JobRecruimentEntity;
import com.phongtoanhuu.hhh.imicmo3.Entities.MetaData;
import com.phongtoanhuu.hhh.imicmo3.Services.ResponseService;
import com.phongtoanhuu.hhh.imicmo3.Services.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class InfoUserFragmentModel {
    private CallBackInfoUserFragmentModel callBackInfoUserFragmentModel;

    public InfoUserFragmentModel(CallBackInfoUserFragmentModel callBackInfoUserFragmentModel) {
        this.callBackInfoUserFragmentModel = callBackInfoUserFragmentModel;
    }

    public void xuLyGetListRecruimentTheoProfileId(String profileId) {
        ResponseService service = RetrofitInstance.getRetrofitInstance().create(ResponseService.class);
        Call<MetaData<JobRecruimentEntity>> call = service.getRecruiment(profileId);
        call.enqueue(new Callback<MetaData<JobRecruimentEntity>>() {
            @Override
            public void onResponse(@NonNull Call<MetaData<JobRecruimentEntity>> call, retrofit2.Response<MetaData<JobRecruimentEntity>> response) {
                // xử lý dữ liệu trả vè
                //nhận dữ liệu và add vào List để hiển thị lên View
                assert response.body() != null;
                List<JobRecruimentEntity> listRecruiment = response.body().getResult();

                if (listRecruiment != null && listRecruiment.size()>0) {
                   callBackInfoUserFragmentModel.xuLyGetListRecruimentThanhCong(listRecruiment);
                } else  {
                    callBackInfoUserFragmentModel.xuLyGetListRecruimentThatBai("Bạn chưa ứng tuyển công việc nào");
                }




            }

            @Override
            public void onFailure(@NonNull Call<MetaData<JobRecruimentEntity>> call, @NonNull Throwable t) {
                t.getMessage();
            }

        });
    }
}
