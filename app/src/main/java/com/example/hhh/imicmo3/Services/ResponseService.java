package com.example.hhh.imicmo3.Services;

import com.example.hhh.imicmo3.Entities.DeveloperEntity;
import com.example.hhh.imicmo3.Entities.MetaData;
import com.example.hhh.imicmo3.Entities.OpeningSchedulerEntity;
import com.example.hhh.imicmo3.Entities.VideoGroupEntity;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ResponseService {
    @GET("api/getVGroups")
    Call<MetaData<VideoGroupEntity>> getVideoGroup();

    @GET("api/getOpeningScheduler")
    Call<MetaData<OpeningSchedulerEntity>> getOpeningScheduler();

    @GET("api/getDeveloper")
    Call<MetaData<DeveloperEntity>> getDeveloper();

    

}
