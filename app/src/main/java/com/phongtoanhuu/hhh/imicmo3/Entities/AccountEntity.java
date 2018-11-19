package com.phongtoanhuu.hhh.imicmo3.Entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AccountEntity implements Parcelable {
    @SerializedName("Email")
    @Expose
    private String Email;
    @SerializedName("PassWord")
    @Expose
    private String PassWord;
    @SerializedName("FullName")
    @Expose
    private String FullName;
    @SerializedName("Address")
    @Expose
    private String Address;
    @SerializedName("Mobile")
    @Expose
    private String Mobile;
    @SerializedName("UserName")
    @Expose
    private String UserName;
    @SerializedName("ProfileId")
    @Expose
    private String ProfileId;

    public AccountEntity() {
    }

    public AccountEntity(String email, String passWord, String fullName, String address, String mobile, String userName, String profileId) {
        Email = email;
        PassWord = passWord;
        FullName = fullName;
        Address = address;
        Mobile = mobile;
        UserName = userName;
        ProfileId = profileId;
    }

    protected AccountEntity(Parcel in) {
        Email = in.readString();
        PassWord = in.readString();
        FullName = in.readString();
        Address = in.readString();
        Mobile = in.readString();
        UserName = in.readString();
        ProfileId = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Email);
        dest.writeString(PassWord);
        dest.writeString(FullName);
        dest.writeString(Address);
        dest.writeString(Mobile);
        dest.writeString(UserName);
        dest.writeString(ProfileId);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AccountEntity> CREATOR = new Creator<AccountEntity>() {
        @Override
        public AccountEntity createFromParcel(Parcel in) {
            return new AccountEntity(in);
        }

        @Override
        public AccountEntity[] newArray(int size) {
            return new AccountEntity[size];
        }
    };

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getProfileId() {
        return ProfileId;
    }

    public void setProfileId(String profileId) {
        ProfileId = profileId;
    }
}
