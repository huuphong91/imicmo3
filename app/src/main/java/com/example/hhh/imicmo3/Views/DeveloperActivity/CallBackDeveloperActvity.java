package com.example.hhh.imicmo3.Views.DeveloperActivity;


import com.example.hhh.imicmo3.Entities.DeveloperEntity;

import java.util.List;
/*
* Lớp định nghĩa các hàm hiển thị dữ liệu/ get API và được implement trong Activity class*/
public interface CallBackDeveloperActvity {
    void getApiListDeviloperSuccess(List<DeveloperEntity> listDeveloper);
    void getApiListDeviloperFailure(String message);
}
