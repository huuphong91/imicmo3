package com.example.hhh.imicmo3.Entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CareerEntity {
    @SerializedName("CareerId")
    @Expose
    private String CareerId;
    @SerializedName("CareerName")
    @Expose
    private String CareerName;
    @SerializedName("CareerDescription")
    @Expose
    private String CareerDescription;

    public CareerEntity(String careerId, String careerName, String careerDescription) {
        CareerId = careerId;
        CareerName = careerName;
        CareerDescription = careerDescription;
    }

    public String getCareerId() {
        return CareerId;
    }

    public void setCareerId(String careerId) {
        CareerId = careerId;
    }

    public String getCareerName() {
        return CareerName;
    }

    public void setCareerName(String careerName) {
        CareerName = careerName;
    }

    public String getCareerDescription() {
        return CareerDescription;
    }

    public void setCareerDescription(String careerDescription) {
        CareerDescription = careerDescription;
    }
}
