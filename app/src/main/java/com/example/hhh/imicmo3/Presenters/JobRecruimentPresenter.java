package com.example.hhh.imicmo3.Presenters;

import com.example.hhh.imicmo3.Entities.CareerEntity;
import com.example.hhh.imicmo3.Entities.JobRecruimentEntity;
import com.example.hhh.imicmo3.Entities.LocationEntity;
import com.example.hhh.imicmo3.Entities.TypeOfWorkEntity;
import com.example.hhh.imicmo3.Models.JobRecruimentFragment.CallBackJobRecruimentFragmentModel;
import com.example.hhh.imicmo3.Models.JobRecruimentFragment.JobRecruimentFragmentModel;
import com.example.hhh.imicmo3.Views.JobRecruimentFragment.CallBackJobRecruimentFragment;

import java.util.List;

public class JobRecruimentPresenter implements CallBackJobRecruimentFragmentModel {
    private CallBackJobRecruimentFragment callBackJobRecruimentFragment;
    private JobRecruimentFragmentModel jobRecruimentFragmentModel = null;

    public JobRecruimentPresenter(CallBackJobRecruimentFragment callBackJobRecruimentFragment) {
        this.callBackJobRecruimentFragment = callBackJobRecruimentFragment;
        jobRecruimentFragmentModel = new JobRecruimentFragmentModel(this);
    }

    public void getListTypeOfWork() {
        jobRecruimentFragmentModel.xuLyGetListTypeOfWork();
    }

    public void getListCareer() {
        jobRecruimentFragmentModel.xuLyGetListCareer();

    }

    public void getListLocation() {
        jobRecruimentFragmentModel.xuLyGetListLocation();
    }

    public void getListJobRecruimentAll() {
        jobRecruimentFragmentModel.xuLyGetListJobRecruimentAll();
    }
    @Override
    public void xuLyGetListTypeOfWork(List<TypeOfWorkEntity> typeOfWorkEntities) {
        callBackJobRecruimentFragment.getListTypeOfWorkThanhCong(typeOfWorkEntities);
    }

    @Override
    public void xuLyGetListCareer(List<CareerEntity> careerEntityList) {
        callBackJobRecruimentFragment.getListCareerThanhCong(careerEntityList);
    }

    @Override
    public void xuLyGetListLocation(List<LocationEntity> locationEntities) {
        callBackJobRecruimentFragment.getListLocationThanhCong(locationEntities);
    }

    @Override
    public void xuLyGetListJobRecruimentAll(List<JobRecruimentEntity> jobRecruimentEntities) {
        callBackJobRecruimentFragment.getListJobRecruimentAllThanhCong(jobRecruimentEntities);
    }
}
