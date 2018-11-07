package com.example.hhh.imicmo3.Entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JobRecruimentEntity {
    @SerializedName("CareerId")
    @Expose
    private String careerId;
    @SerializedName("CareerName")
    @Expose
    private String careerName;
    @SerializedName("CorporationId")
    @Expose
    private String corporationId;
    @SerializedName("Deadline")
    @Expose
    private String deadline;
    @SerializedName("Description")
    @Expose
    private String description;
    @SerializedName("Experience")
    @Expose
    private String experience;
    @SerializedName("JobRecruimentId")
    @Expose
    private String jobRecruitmentId;
    @SerializedName("JobDescription")
    @Expose
    private String jobDescription;
    @SerializedName("LocationId")
    @Expose
    private String locationId;
    @SerializedName("LocationName")
    @Expose
    private String locationName;
    @SerializedName("Salary")
    @Expose
    private String salary;
    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("TypeName")
    @Expose
    private String typeName;
    @SerializedName("TypeOfWorkId")
    @Expose
    private String typeOfWorkId;


    public JobRecruimentEntity() {
    }

    public JobRecruimentEntity(String jobRecruitmentId, String deadline) {
        this.jobRecruitmentId = jobRecruitmentId;
        this.deadline = deadline;

    }

    public JobRecruimentEntity(String careerName, String corporationId, String deadline, String locationName, String salary, String jobRecruitmentId) {
        this.careerName = careerName;
        this.corporationId = corporationId;
        this.deadline = deadline;
        this.locationName = locationName;
        this.salary = salary;
        this.jobRecruitmentId = jobRecruitmentId;
    }

    public String getCareerId() {
        return careerId;
    }

    public void setCareerId(String careerId) {
        this.careerId = careerId;
    }

    public String getCareerName() {
        return careerName;
    }

    public void setCareerName(String careerName) {
        this.careerName = careerName;
    }

    public String getCorporationId() {
        return corporationId;
    }

    public void setCorporationId(String corporationId) {
        this.corporationId = corporationId;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getJobRecruitmentId() {
        return jobRecruitmentId;
    }

    public void setJobRecruitmentId(String jobRecruitmentId) {
        this.jobRecruitmentId = jobRecruitmentId;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeOfWorkId() {
        return typeOfWorkId;
    }

    public void setTypeOfWorkId(String typeOfWorkId) {
        this.typeOfWorkId = typeOfWorkId;
    }
}
