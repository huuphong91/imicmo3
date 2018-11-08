package com.example.hhh.imicmo3.Models.InfoUserFragment;

import com.example.hhh.imicmo3.Entities.JobRecruimentEntity;

import java.util.List;

public interface CallBackInfoUserFragmentModel {
    void xuLyGetListRecruimentThanhCong(List<JobRecruimentEntity> recruimentEntities);

    void xuLyGetListRecruimentThatBai(String sThongbao);
}
