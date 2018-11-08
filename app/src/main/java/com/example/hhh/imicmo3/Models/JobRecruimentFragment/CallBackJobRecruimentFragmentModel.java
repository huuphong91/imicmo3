package com.example.hhh.imicmo3.Models.JobRecruimentFragment;

import com.example.hhh.imicmo3.Entities.CareerEntity;
import com.example.hhh.imicmo3.Entities.JobRecruimentEntity;
import com.example.hhh.imicmo3.Entities.LocationEntity;
import com.example.hhh.imicmo3.Entities.TypeOfWorkEntity;

import java.util.List;

public interface CallBackJobRecruimentFragmentModel {
    void xuLyGetListTypeOfWork(List<TypeOfWorkEntity> typeOfWorkEntities);

    void xuLyGetListCareer(List<CareerEntity> careerEntityList);

    void xuLyGetListLocation(List<LocationEntity> locationEntities);

    void xuLyGetListJobRecruimentAll(List<JobRecruimentEntity> jobRecruimentEntities);

    void xuLyInsertRecruimentThanhCong(String sThongBao);

    void xuLyInsertRecruimentThatBai(String sThongBao);
}
