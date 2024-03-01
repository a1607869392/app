package com.coolweather.myapplication.bean;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

public class DayWeatherBean {




    /* "cityid":"101271201", #城市编号
    "city":"内江", #城市名称
    "cityEn":"neijiang",
    "country":"中国",
    "countryEn":"China",
    "update_time":"2020-07-15 10:25:23", #更新时间
    "data":[
        {
            " "data":[
        {
            "day":"19日（星期一）",
            "date":"2024-02-19",
            "week":"星期一",
            "wea":"晴",
            "wea_img":"qing",
            "wea_day":"阴",
            "wea_day_img":"yin",
            "wea_night":"阴",
            "wea_night_img":"yin",
            "tem":"-0.8",
            "tem1":"3",
            "tem2":"-5",
            "humidity":"16%",
            "visibility":"30km",
            "pressure":"1027",
            "win":[
                "北风",
                "东北风"
            ],
            "win_speed":"3-4级转<3级",
            "win_meter":"13km/h",
            "sunrise":"07:02",
            "sunset":"17:53",
            "air":"21",
            "air_level":"优",
            "air_tips":"各类人群可多参加户外活动，多呼吸一下清新的空气。",
            },*/
    @SerializedName("day")
    private String day;

    @SerializedName("date")
    private String date;


    @SerializedName("wea")
    private String wea;

    @SerializedName("tem")
    private String tem;
    @SerializedName("tem1")
    private String tem1;
    @SerializedName("win_speed")
    private String winSpeed;
    @SerializedName("air_level")
    private String airLevel;
    @SerializedName("air_tips")
    private String airTips;
    @SerializedName("tem2")
    private String tem2;



    public String getTem1() {
        return tem1;
    }

    public void setTem1(String tem1) {
        this.tem1 = tem1;
    }

    public String getTem2() {
        return tem2;
    }

    public void setTem2(String tem2) {
        this.tem2 = tem2;
    }






    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "DayWeatherBean{" +
                "day='" + day + '\'' +
                ", date='" + date + '\'' +
                ", wea='" + wea + '\'' +
                ", tem='" + tem + '\'' +
                ", tem1='" + tem1 + '\'' +
                ", winSpeed='" + winSpeed + '\'' +
                ", airLevel='" + airLevel + '\'' +
                ", airTips='" + airTips + '\'' +
                ", tem2='" + tem2 + '\'' +
                '}';
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }



    public String getWea() {
        return wea;
    }

    public void setWea(String wea) {
        this.wea = wea;
    }






    public String getWinSpeed() {
        return winSpeed;
    }

    public void setWinSpeed(String winSpeed) {
        this.winSpeed = winSpeed;
    }

    public String getTem() {
        return tem;
    }

    public void setTem(String tem) {
        this.tem = tem;
    }

    public String getAirLevel() {
        return airLevel;
    }

    public void setAirLevel(String airLevel) {
        this.airLevel = airLevel;
    }

    public String getAirTips() {
        return airTips;
    }

    public void setAirTips(String airTips) {
        this.airTips = airTips;
    }
}
