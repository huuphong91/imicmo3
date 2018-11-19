package com.phongtoanhuu.hhh.imicmo3.Entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeveloperEntity implements Parcelable {
    @SerializedName("DeveloperId")
    @Expose
    private String developerId;
    @SerializedName("Email")
    @Expose
    private String email;
    @SerializedName("FullName")
    @Expose
    private String fullName;
    @SerializedName("Image")
    @Expose
    private String image;
    @SerializedName("Mobile")
    @Expose
    private String mobile;

    protected DeveloperEntity(Parcel in) {
        developerId = in.readString();
        email = in.readString();
        fullName = in.readString();
        image = in.readString();
        mobile = in.readString();
    }

    public static final Creator<DeveloperEntity> CREATOR = new Creator<DeveloperEntity>() {
        @Override
        public DeveloperEntity createFromParcel(Parcel in) {
            return new DeveloperEntity(in);
        }

        @Override
        public DeveloperEntity[] newArray(int size) {
            return new DeveloperEntity[size];
        }
    };

    public String getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(String developerId) {
        this.developerId = developerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(developerId);
        dest.writeString(email);
        dest.writeString(fullName);
        dest.writeString(image);
        dest.writeString(mobile);
    }
}
