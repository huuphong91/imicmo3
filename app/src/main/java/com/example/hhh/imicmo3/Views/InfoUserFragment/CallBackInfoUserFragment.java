package com.example.hhh.imicmo3.Views.InfoUserFragment;

import com.example.hhh.imicmo3.Entities.JobRecruimentEntity;

import java.util.List;

public interface CallBackInfoUserFragment {
    void getListRecruimentThanhCong(List<JobRecruimentEntity> recruimentEntities);

    void getListRecruimentThatBai(String sThongbao);
}
