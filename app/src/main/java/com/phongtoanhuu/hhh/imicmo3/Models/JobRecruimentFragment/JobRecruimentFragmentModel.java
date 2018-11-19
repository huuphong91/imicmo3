package com.phongtoanhuu.hhh.imicmo3.Models.JobRecruimentFragment;

import android.support.annotation.NonNull;

import com.phongtoanhuu.hhh.imicmo3.Entities.CareerEntity;
import com.phongtoanhuu.hhh.imicmo3.Entities.JobRecruimentEntity;
import com.phongtoanhuu.hhh.imicmo3.Entities.LocationEntity;
import com.phongtoanhuu.hhh.imicmo3.Entities.MetaData;
import com.phongtoanhuu.hhh.imicmo3.Entities.TypeOfWorkEntity;
import com.phongtoanhuu.hhh.imicmo3.Services.ResponseService;
import com.phongtoanhuu.hhh.imicmo3.Services.RetrofitInstance;
import com.phongtoanhuu.hhh.imicmo3.Utilities.Commons;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;

public class JobRecruimentFragmentModel {
    private CallBackJobRecruimentFragmentModel callBackJobRecruimentFragmentModel;


    public JobRecruimentFragmentModel(CallBackJobRecruimentFragmentModel callBackJobRecruimentFragmentModel) {
        this.callBackJobRecruimentFragmentModel = callBackJobRecruimentFragmentModel;
    }

    public void xuLyGetListTypeOfWork() {
        ResponseService service = RetrofitInstance.getRetrofitInstance().create(ResponseService.class);
        Call<MetaData<TypeOfWorkEntity>> call = service.getTypeOfWork();
        call.enqueue(new Callback<MetaData<TypeOfWorkEntity>>() {
            @Override
            public void onResponse(@NonNull Call<MetaData<TypeOfWorkEntity>> call, retrofit2.Response<MetaData<TypeOfWorkEntity>> response) {
                // xử lý dữ liệu trả vè
                //nhận dữ liệu và add vào List để hiển thị lên View
                assert response.body() != null;
                List<TypeOfWorkEntity> listTypeOfWork = response.body().getResult();
                if (listTypeOfWork != null) {
                    callBackJobRecruimentFragmentModel.xuLyGetListTypeOfWork(listTypeOfWork);
                }
            }

            @Override
            public void onFailure(@NonNull Call<MetaData<TypeOfWorkEntity>> call, @NonNull Throwable t) {

            }

        });
    }

    public void xuLyGetListCareer() {
        ResponseService service = RetrofitInstance.getRetrofitInstance().create(ResponseService.class);
        Call<MetaData<CareerEntity>> call = service.getCareer();
        call.enqueue(new Callback<MetaData<CareerEntity>>() {
            @Override
            public void onResponse(@NonNull Call<MetaData<CareerEntity>> call, retrofit2.Response<MetaData<CareerEntity>> response) {
                // xử lý dữ liệu trả vè
                //nhận dữ liệu và add vào List để hiển thị lên View
                assert response.body() != null;
                List<CareerEntity> listCareerEntity = response.body().getResult();
                if (listCareerEntity != null) {
                    callBackJobRecruimentFragmentModel.xuLyGetListCareer(listCareerEntity);
                }
            }

            @Override
            public void onFailure(@NonNull Call<MetaData<CareerEntity>> call, @NonNull Throwable t) {

            }

        });
    }

    public void xuLyGetListLocation() {
        ResponseService service = RetrofitInstance.getRetrofitInstance().create(ResponseService.class);
        Call<MetaData<LocationEntity>> call = service.getLocation();
        call.enqueue(new Callback<MetaData<LocationEntity>>() {
            @Override
            public void onResponse(@NonNull Call<MetaData<LocationEntity>> call, retrofit2.Response<MetaData<LocationEntity>> response) {
                // xử lý dữ liệu trả vè
                //nhận dữ liệu và add vào List để hiển thị lên View
                assert response.body() != null;
                List<LocationEntity> listLocationEntity = response.body().getResult();
                if (listLocationEntity != null) {
                    callBackJobRecruimentFragmentModel.xuLyGetListLocation(listLocationEntity);
                }
            }

            @Override
            public void onFailure(@NonNull Call<MetaData<LocationEntity>> call, @NonNull Throwable t) {

            }

        });
    }

    public void xuLyGetListJobRecruimentAll() {
        ResponseService service = RetrofitInstance.getRetrofitInstance().create(ResponseService.class);
        Call<MetaData<JobRecruimentEntity>> call = service.getJobRecruiment(Commons.LOCATION_ID,Commons.CAREER_ID,Commons.TYPEOFWORK_ID);
        call.enqueue(new Callback<MetaData<JobRecruimentEntity>>() {
            @Override
            public void onResponse(@NonNull Call<MetaData<JobRecruimentEntity>> call, retrofit2.Response<MetaData<JobRecruimentEntity>> response) {
                // xử lý dữ liệu trả vè
                //nhận dữ liệu và add vào List để hiển thị lên View
                assert response.body() != null;
                List<JobRecruimentEntity> listJobRecruimentEntity = response.body().getResult();
                if (listJobRecruimentEntity != null) {
                    callBackJobRecruimentFragmentModel.xuLyGetListJobRecruimentAll(listJobRecruimentEntity);
                }
            }

            @Override
            public void onFailure(@NonNull Call<MetaData<JobRecruimentEntity>> call, @NonNull Throwable t) {

            }

        });
    }

    public void xuLyInsertRecruiment(final String deadline) {
        ResponseService service = RetrofitInstance.getRetrofitInstance().create(ResponseService.class);
        Call<ResponseBody> call = service.insertRecruiment(Commons.PROFILEID,Commons.JOBRECRUIMENTID,deadline,Commons.DESIDERATE);
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
                if (!Commons.PROFILEID.equals("")&&!Commons.JOBRECRUIMENTID.equals("")&&!deadline.equals("")) {
                    callBackJobRecruimentFragmentModel.xuLyInsertRecruimentThanhCong("Đăng ký thành công");


                } else {
                    callBackJobRecruimentFragmentModel.xuLyInsertRecruimentThatBai("Bạn chưa đăng nhập/đăng ký");

                }




            }

            @Override
            public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {
                t.getMessage();
            }

        });
    }
}
