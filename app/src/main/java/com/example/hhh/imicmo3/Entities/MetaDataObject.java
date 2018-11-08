package com.example.hhh.imicmo3.Entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MetaDataObject<T> {
    @SerializedName("ErrorMessage")
    @Expose
    private String errorMessage;
    @SerializedName("Result")
    @Expose
    private T result = null;
    @SerializedName("ReturnCode")
    @Expose
    private String returnCode;
    @SerializedName("TotalRecord")
    @Expose
    private Integer totalRecord;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public Integer getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(Integer totalRecord) {
        this.totalRecord = totalRecord;
    }
}
