package com.coolweather.myapplication.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serial;
import java.util.Arrays;
import java.util.List;

import kotlin.jvm.internal.SerializedIr;

public class WeatherBean {
    /* "cityid":"101010100",
    "city":"北京",
    "cityEn":"beijing",
    "country":"中国",
    "countryEn":"China",
    "update_time":"2024-02-19 23:17:00",
    "data":Array[7],
    "aqi":Object{...}
   2024-02-19 23:26:51.317 10546-10546 fan
    com.coolweather.myapplication        D  -----主线程收到了数据------
    {"cityid":"101010100","city":"北京","cityEn":"beijing","country":"中国","countryEn":"China","update_time":"2024-02-20 00:04:00","data":[{"day":"19日（星期一）","date":"2024-02-19","week":"星期一","wea":"晴","wea_img":"qing","wea_day":"阴","wea_day_img":"yin","wea_night":"阴","wea_night_img":"yin","tem":"-1.1","tem1":"3","tem2":"-5","humidity":"16%","visibility":"30km","pressure":"1027","win":["北风","东北风"],"win_speed":"3-4级转<3级","win_meter":"13km\/h","sunrise":"07:02","sunset":"17:53","air":"21","air_level":"优","air_tips":"各类人群可多参加户外活动，多呼吸一下清新的空气。","alarm":{"alarm_type":"寒潮","alarm_level":"蓝色","alarm_title":"北京市发布寒潮蓝色预警","alarm_content":"市气象台2024年2月18日10时10分发布寒潮蓝色预警信号：受冷空气影响，预计18日夜间至20日北京地区将出现寒潮天气，最低气温降幅将达8℃，平原地区最低气温将降至-5℃左右；18日傍晚至19日阵风可达7级左右，请注意防范。（预警信息来源：国家预警信息发布中心）"},"hours":[{"hours":"20时","wea":"雨夹雪","wea_img":"yu","tem":"-2","win":"东北风","win_speed":"<3级"},{"hours":"21时","wea":"阴","wea_img":"yin","tem":"-2","win":"东北风","win_speed":"<3级"},{"hours":"22时","wea":"阴","wea_img":"yin","tem":"-2","win":"东北风","win_speed":"<3级"},{"hours":"23时","wea":"阴","wea_img":"yin","tem":"-2","win":"东北风","win_speed":"<3级"},{"hours":"00时","wea":"阴","wea_img":"yin","tem":"-3","win":"东北风","win_speed":"<3级"},{"hours":"01时","wea":"阴","wea_img":"yin","tem":"-3","win":"东北风","win_speed":"<3级"},{"hours":"02时","wea":"阴","wea_img":"yin","tem":"-3","win":"东北风","win_speed":"<3级"},{"hours":"03时","wea":"阴","wea_img":"yin","tem":"-4","win":"东北风","win_speed":"<3级"},{"hours":"04时","wea":"阴","wea_img":"yin","tem":"-4","win":"东北风","win_speed":"<3级"},{"hours":"05时","wea":"阴","wea_img":"yin","tem":"-4","win":"东北风","win_speed":"<3级"},{"hours":"06时","wea":"阴","wea_img":"yin","tem":"-4","win":"东风","win_speed":"<3级"},{"hours":"07时","wea":"阴","wea_img":"yin","tem":"-4","win":"东风","win_speed":"<3级"}],"index":[{"title":"紫外线指数","level":"最弱","desc":"辐射弱，涂擦SPF8-12防晒护肤品。"},{"title":"减肥指数","level":"较不宜","desc":"天气寒冷，推荐您进行室内运动。"},{"title":"血糖指数","level":"极不易发","desc":"无需担心过敏，可放心外出，享受生活。"},{"title":"穿衣指数","level":"寒冷","desc":"建议着厚羽绒服等隆冬服装。"},{"title":"洗车指数","level":"适宜","desc":"天气较好，适合擦洗汽车。"},{"title":"空气污染扩散指数","level":"较差","desc":"气象条件较不利于空气污染物扩散。。"}],"uvIndex":"2","uvDescription":"低"},{"day":"20日（星期二）","date":"2024-02-20","week":"星期二","wea":"阴","wea_img":"yin","wea_day":"阴","wea_day_img":"yin","wea_night":"阴","wea_night_img":"yin","tem":"-1","tem1":"-1","tem2":"-5","humidity":"34","visibility":"","pressure":"","win":["北风","东南风"],"win_speed":"<3级","win_meter":"","sunrise":"07:01","sunset":"17:54","air":"60","air_level":"良","air_tips":"","alarm":{"alarm_type":"","alarm_level":"","alarm_content":""},"hours":[{"hours":"08时","wea":"阴","wea_img":"yin","tem":"-4","win":"东风","win_speed":"<3级"},{"hours":"09时","wea":"阴","wea_img":"yin","tem":"-3","win":"东风","win_speed":"<3级"},{"hours":"10时","wea":"阴","wea_img":"yin","tem":"-2","win":"东风","win_speed":"<3级"},{"hours":"11时","wea":"阴","wea_img":"yin","tem":"-1","win":"东南风","win_speed":"<3级"},{"hours":"12时","wea":"阴","wea_img":"yin","tem":"-1","win":"东风","win_speed":"<3级"},{"hours":"13时","wea":"阴","wea_img":"yin","tem":"-1","win":"东风","win_speed":"<3级"},{"hours":"14时","wea":"阴","wea_img":"yin","tem":"-1","win":"东北风","win_speed":"<3级"},{
*/
    @SerializedName("cityid")
    private String cityId;

    @SerializedName("city")
    private String city;

    @SerializedName("update_time")
    private String updateTime;

    @SerializedName("data")
    public List<DayWeatherBean> dayWeathers;


    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public List<DayWeatherBean> getDayWeathers() {
        return dayWeathers;
    }

    public void setDayWeathers(List<DayWeatherBean> dayWeathers) {
        this.dayWeathers = dayWeathers;
    }

    @Override
    public String toString() {
        return "WeatherBean{" +
                "cityId='" + cityId + '\'' +
                ", city='" + city + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", dayWeathers=" + dayWeathers +
                '}';
    }
}
