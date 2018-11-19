package com.phongtoanhuu.hhh.imicmo3.Entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OpeningSchedulerEntity {
    @SerializedName("CreateDate")
    @Expose
    private String createDate;
    @SerializedName("ImageLink")
    @Expose
    private String imageLink;
    @SerializedName("Location")
    @Expose
    private String location;
    @SerializedName("ModifyUpdate")
    @Expose
    private String modifyUpdate;
    @SerializedName("OpenDescription")
    @Expose
    private String openDescription;
    @SerializedName("OpenningDate")
    @Expose
    private String openningDate;
    @SerializedName("OpenningId")
    @Expose
    private String openningId;
    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("Views")
    @Expose
    private String views;

    public OpeningSchedulerEntity(String createDate, String imageLink, String location, String modifyUpdate, String openDescription, String openningDate, String openningId, String status, String title, String views) {
        this.createDate = createDate;
        this.imageLink = imageLink;
        this.location = location;
        this.modifyUpdate = modifyUpdate;
        this.openDescription = openDescription;
        this.openningDate = openningDate;
        this.openningId = openningId;
        this.status = status;
        this.title = title;
        this.views = views;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getModifyUpdate() {
        return modifyUpdate;
    }

    public void setModifyUpdate(String modifyUpdate) {
        this.modifyUpdate = modifyUpdate;
    }

    public String getOpenDescription() {
        return openDescription;
    }

    public void setOpenDescription(String openDescription) {
        this.openDescription = openDescription;
    }

    public String getOpenningDate() {
        return openningDate;
    }

    public void setOpenningDate(String openningDate) {
        this.openningDate = openningDate;
    }

    public String getOpenningId() {
        return openningId;
    }

    public void setOpenningId(String openningId) {
        this.openningId = openningId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }
}
