package com.example.hhh.imicmo3.Views.JobRecruimentFragment;

import com.example.hhh.imicmo3.Entities.CareerEntity;
import com.example.hhh.imicmo3.Entities.JobRecruimentEntity;
import com.example.hhh.imicmo3.Entities.LocationEntity;
import com.example.hhh.imicmo3.Entities.TypeOfWorkEntity;

import java.util.List;

public interface CallBackJobRecruimentFragment {
    void getListTypeOfWorkThanhCong(List<TypeOfWorkEntity> typeOfWorkEntities);

    void getListCareerThanhCong(List<CareerEntity> careerEntities);

    void getListLocationThanhCong(List<LocationEntity> locationEntities);

    void getListJobRecruimentAllThanhCong(List<JobRecruimentEntity> jobRecruimentEntities);
}
