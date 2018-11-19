package com.phongtoanhuu.hhh.imicmo3.Entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TypeOfWorkEntity {
    @SerializedName("TypeOfWorkId")
    @Expose
    private String TypeOfWorkId;
    @SerializedName("TypeOfWorkDescription")
    @Expose
    private String TypeOfWorkDescription;
    @SerializedName("TypeOfWorkName")
    @Expose
    private String TypeOfWorkName;

    public TypeOfWorkEntity(String typeOfWorkId, String typeOfWorkDescription, String typeOfWorkName) {
        TypeOfWorkId = typeOfWorkId;
        TypeOfWorkDescription = typeOfWorkDescription;
        TypeOfWorkName = typeOfWorkName;
    }

    public String getTypeOfWorkId() {
        return TypeOfWorkId;
    }

    public void setTypeOfWorkId(String typeOfWorkId) {
        TypeOfWorkId = typeOfWorkId;
    }

    public String getTypeOfWorkDescription() {
        return TypeOfWorkDescription;
    }

    public void setTypeOfWorkDescription(String typeOfWorkDescription) {
        TypeOfWorkDescription = typeOfWorkDescription;
    }

    public String getTypeOfWorkName() {
        return TypeOfWorkName;
    }

    public void setTypeOfWorkName(String typeOfWorkName) {
        TypeOfWorkName = typeOfWorkName;
    }
}
