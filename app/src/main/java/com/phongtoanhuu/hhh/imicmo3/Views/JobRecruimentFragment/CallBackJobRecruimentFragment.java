package com.phongtoanhuu.hhh.imicmo3.Views.JobRecruimentFragment;

import com.phongtoanhuu.hhh.imicmo3.Entities.CareerEntity;
import com.phongtoanhuu.hhh.imicmo3.Entities.JobRecruimentEntity;
import com.phongtoanhuu.hhh.imicmo3.Entities.LocationEntity;
import com.phongtoanhuu.hhh.imicmo3.Entities.TypeOfWorkEntity;

import java.util.List;

public interface CallBackJobRecruimentFragment {
    void getListTypeOfWorkThanhCong(List<TypeOfWorkEntity> typeOfWorkEntities);

    void getListCareerThanhCong(List<CareerEntity> careerEntities);

    void getListLocationThanhCong(List<LocationEntity> locationEntities);

    void getListJobRecruimentAllThanhCong(List<JobRecruimentEntity> jobRecruimentEntities);

    void insertRecruimentThanhCong(String sThongBao);

    void insertRecruimentThatBai(String sThongBao);
}
