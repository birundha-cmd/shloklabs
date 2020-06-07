package com.example.sholklabs.model;

import java.io.Serializable;

public class ListResponse implements Serializable {
    private String hdn_ScheduleCode;
    private String LTE_INSP_Label2;
    private String LTE_INSP_Label3;
    private String LTE_INSP_Label5;
    private String LTE_INSP_Label1;



    public String getHdn_ScheduleCode() {
        return hdn_ScheduleCode;
    }

    public void setHdn_ScheduleCode(String hdn_ScheduleCode) {
        this.hdn_ScheduleCode = hdn_ScheduleCode;
    }

    public String getLTE_INSP_Label2() {
        return LTE_INSP_Label2;
    }

    public void setLTE_INSP_Label2(String LTE_INSP_Label2) {
        this.LTE_INSP_Label2 = LTE_INSP_Label2;
    }

    public String getLTE_INSP_Label3() {
        return LTE_INSP_Label3;
    }

    public void setLTE_INSP_Label3(String LTE_INSP_Label3) {
        this.LTE_INSP_Label3 = LTE_INSP_Label3;
    }

    public String getLTE_INSP_Label5() {
        return LTE_INSP_Label5;
    }

    public void setLTE_INSP_Label5(String LTE_INSP_Label5) {
        this.LTE_INSP_Label5 = LTE_INSP_Label5;
    }

    public String getLTE_INSP_Label1() {
        return LTE_INSP_Label1;
    }

    public void setLTE_INSP_Label1(String LTE_INSP_Label1) {
        this.LTE_INSP_Label1 = LTE_INSP_Label1;
    }
}
