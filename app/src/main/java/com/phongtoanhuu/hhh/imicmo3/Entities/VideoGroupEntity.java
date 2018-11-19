package com.phongtoanhuu.hhh.imicmo3.Entities;

import android.os.Parcel;
import android.os.Parcelable;

public class VideoGroupEntity implements Parcelable {
    private String Images;

    private Integer Status;

    private String VGroupId;

    private String VGroupName;

    public VideoGroupEntity(String images, Integer status, String VGroupId, String VGroupName) {
        Images = images;
        Status = status;
        this.VGroupId = VGroupId;
        this.VGroupName = VGroupName;
    }

    protected VideoGroupEntity(Parcel in) {
        Images = in.readString();
        if (in.readByte() == 0) {
            Status = null;
        } else {
            Status = in.readInt();
        }
        VGroupId = in.readString();
        VGroupName = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Images);
        if (Status == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(Status);
        }
        dest.writeString(VGroupId);
        dest.writeString(VGroupName);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<VideoGroupEntity> CREATOR = new Creator<VideoGroupEntity>() {
        @Override
        public VideoGroupEntity createFromParcel(Parcel in) {
            return new VideoGroupEntity(in);
        }

        @Override
        public VideoGroupEntity[] newArray(int size) {
            return new VideoGroupEntity[size];
        }
    };

    public String getImages() {
        return Images;
    }

    public void setImages(String images) {
        Images = images;
    }

    public Integer getStatus() {
        return Status;
    }

    public void setStatus(Integer status) {
        Status = status;
    }

    public String getVGroupId() {
        return VGroupId;
    }

    public void setVGroupId(String VGroupId) {
        this.VGroupId = VGroupId;
    }

    public String getVGroupName() {
        return VGroupName;
    }

    public void setVGroupName(String VGroupName) {
        this.VGroupName = VGroupName;
    }
}
