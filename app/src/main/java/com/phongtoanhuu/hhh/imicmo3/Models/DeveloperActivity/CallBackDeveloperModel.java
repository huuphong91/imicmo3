package com.phongtoanhuu.hhh.imicmo3.Models.DeveloperActivity;

import com.phongtoanhuu.hhh.imicmo3.Entities.DeveloperEntity;

import java.util.List;

/*
 * lớp CallBack cho Model*/
public interface CallBackDeveloperModel {
    void getApiListDeviloperSuccess(List<DeveloperEntity> listDeveloper);

    void getApiListDeviloperFailure(String message);
}
