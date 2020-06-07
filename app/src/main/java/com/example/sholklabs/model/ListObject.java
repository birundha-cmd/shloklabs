package com.example.sholklabs.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ListObject implements Serializable {

    @SerializedName("GetInspectionsResult")
    @Expose
    private String getInspectionsResult;
    @SerializedName("recordCount")
    @Expose
    private Integer recordCount;

    public String getGetInspectionsResult() {
        return getInspectionsResult;
    }

    public void setGetInspectionsResult(String getInspectionsResult) {
        this.getInspectionsResult = getInspectionsResult;
    }

    public Integer getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(Integer recordCount) {
        this.recordCount = recordCount;
    }


}
