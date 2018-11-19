package com.phongtoanhuu.hhh.imicmo3.Entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RecruimentEntity {
    @SerializedName("RecruitmentId")
    @Expose
    private String RecruitmentId;
    @SerializedName("ProfileId")
    @Expose
    private String ProfileId;
    @SerializedName("JobRecruitmentId")
    @Expose
    private String JobRecruitmentId;
    @SerializedName("Deadline")
    @Expose
    private String Deadline;
    @SerializedName("Desiderate")
    @Expose
    private String Desiderate;

    public RecruimentEntity(String recruitmentId, String profileId, String jobRecruitmentId, String deadline, String desiderate) {
        RecruitmentId = recruitmentId;
        ProfileId = profileId;
        JobRecruitmentId = jobRecruitmentId;
        Deadline = deadline;
        Desiderate = desiderate;
    }

    public RecruimentEntity() {
    }

    public String getRecruitmentId() {
        return RecruitmentId;
    }

    public void setRecruitmentId(String recruitmentId) {
        RecruitmentId = recruitmentId;
    }

    public String getProfileId() {
        return ProfileId;
    }

    public void setProfileId(String profileId) {
        ProfileId = profileId;
    }

    public String getJobRecruitmentId() {
        return JobRecruitmentId;
    }

    public void setJobRecruitmentId(String jobRecruitmentId) {
        JobRecruitmentId = jobRecruitmentId;
    }

    public String getDeadline() {
        return Deadline;
    }

    public void setDeadline(String deadline) {
        Deadline = deadline;
    }

    public String getDesiderate() {
        return Desiderate;
    }

    public void setDesiderate(String desiderate) {
        Desiderate = desiderate;
    }
}
