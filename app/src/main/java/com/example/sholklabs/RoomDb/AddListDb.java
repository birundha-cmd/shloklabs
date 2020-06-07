package com.example.sholklabs.RoomDb;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class AddListDb implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "hdn_ScheduleCode")
    private String hdn_ScheduleCode;


    @ColumnInfo(name = "LTE_INSP_Label1")
    private String LTE_INSP_Label1;

    @ColumnInfo(name = "LTE_INSP_Label2")
    private String LTE_INSP_Label2;

    @ColumnInfo(name = "LTE_INSP_Label3")
    private String LTE_INSP_Label3;

    @ColumnInfo(name = "LTE_INSP_Label4")
    private String LTE_INSP_Label4;

    @ColumnInfo(name = "LTE_INSP_Label5")
    private String LTE_INSP_Label5;

    @ColumnInfo(name = "LTE_INSP_Label6")
    private String LTE_INSP_Label6;


    @ColumnInfo(name = "hdn_Lattitude")
    private String hdn_Lattitude;

    @ColumnInfo(name = "hdn_Longitude")
    private String hdn_Longitude;


    public String getHdn_ScheduleCode() {
        return hdn_ScheduleCode;
    }

    public void setHdn_ScheduleCode(String hdn_ScheduleCode) {
        this.hdn_ScheduleCode = hdn_ScheduleCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getLTE_INSP_Label4() {
        return LTE_INSP_Label4;
    }

    public void setLTE_INSP_Label4(String LTE_INSP_Label4) {
        this.LTE_INSP_Label4 = LTE_INSP_Label4;
    }

    public String getLTE_INSP_Label5() {
        return LTE_INSP_Label5;
    }

    public void setLTE_INSP_Label5(String LTE_INSP_Label5) {
        this.LTE_INSP_Label5 = LTE_INSP_Label5;
    }

    public String getLTE_INSP_Label6() {
        return LTE_INSP_Label6;
    }

    public void setLTE_INSP_Label6(String LTE_INSP_Label6) {
        this.LTE_INSP_Label6 = LTE_INSP_Label6;
    }

    public String getHdn_Lattitude() {
        return hdn_Lattitude;
    }

    public void setHdn_Lattitude(String hdn_Lattitude) {
        this.hdn_Lattitude = hdn_Lattitude;
    }

    public String getHdn_Longitude() {
        return hdn_Longitude;
    }

    public void setHdn_Longitude(String hdn_Longitude) {
        this.hdn_Longitude = hdn_Longitude;
    }


    public String getLTE_INSP_Label1() {
        return LTE_INSP_Label1;
    }

    public void setLTE_INSP_Label1(String LTE_INSP_Label1) {
        this.LTE_INSP_Label1 = LTE_INSP_Label1;
    }
}
