package com.phongtoanhuu.hhh.imicmo3.Services;

import com.phongtoanhuu.hhh.imicmo3.Entities.AccountEntity;
import com.phongtoanhuu.hhh.imicmo3.Entities.CareerEntity;
import com.phongtoanhuu.hhh.imicmo3.Entities.DeveloperEntity;
import com.phongtoanhuu.hhh.imicmo3.Entities.JobRecruimentEntity;
import com.phongtoanhuu.hhh.imicmo3.Entities.LocationEntity;
import com.phongtoanhuu.hhh.imicmo3.Entities.MetaData;
import com.phongtoanhuu.hhh.imicmo3.Entities.MetaDataObject;
import com.phongtoanhuu.hhh.imicmo3.Entities.OpeningSchedulerEntity;
import com.phongtoanhuu.hhh.imicmo3.Entities.TypeOfWorkEntity;
import com.phongtoanhuu.hhh.imicmo3.Entities.VideoGroupEntity;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ResponseService {
    @GET("api/getVGroups")
    Call<MetaData<VideoGroupEntity>> getVideoGroup();

    @GET("api/getOpeningScheduler")
    Call<MetaData<OpeningSchedulerEntity>> getOpeningScheduler();

    @GET("api/getDeveloper")
    Call<MetaData<DeveloperEntity>> getDeveloper();

    @GET("api/getProfilePerson/")
    Call<MetaDataObject<AccountEntity>> getUer(@Query("user") String user, @Query("pass") String pass);

    @GET("api/getRecruiments/{profileId}")
    Call<MetaData<JobRecruimentEntity>> getRecruiment(@Path("profileId") String profileId);

    @GET("api/insertProfilePerson/")
    Call<ResponseBody> registerUser(@Query("fullname") String fullname,
                                    @Query("email") String email,
                                    @Query("mobile") String mobile,
                                    @Query("user") String user,
                                    @Query("pass") String pass);

    @GET("api/getTypeOfWorks")
    Call<MetaData<TypeOfWorkEntity>> getTypeOfWork();

    @GET("api/getLocations")
    Call<MetaData<LocationEntity>> getLocation();

    @GET("api/getCareers")
    Call<MetaData<CareerEntity>> getCareer();

    @GET("api/getJobRecruiment/")
    Call<MetaData<JobRecruimentEntity>> getJobRecruiment(@Query("id") String location,
                                                               @Query("id1") String career,
                                                               @Query("id2") String typeofwork);

    @GET("api/insertRecruiment/")
    Call<ResponseBody> insertRecruiment(@Query("profileid") String profileid,
                                    @Query("jobrecruimentid") String jobrecruimentid,
                                    @Query("deadline") String deadline,
                                    @Query("desiderate") String desiderate);



}
