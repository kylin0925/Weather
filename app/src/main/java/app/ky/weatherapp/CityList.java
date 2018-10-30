package app.ky.weatherapp;

import java.util.HashMap;
import java.util.Map;

public class CityList {

    public static Map<String,String> cityMap;

    static{
        cityMap = new HashMap<>();
        cityMap.put("基隆市","Keelung");
        cityMap.put("臺北市","Taipei");
        cityMap.put("新北市","");
        cityMap.put("桃園市","");
        cityMap.put("新竹縣","Hsinchu");
        cityMap.put("新竹市","Hsinchu");
        cityMap.put("苗栗縣","");
        cityMap.put("臺中市","");
        cityMap.put("彰化縣","");
        cityMap.put("南投縣","");
        cityMap.put("雲林縣","");
        cityMap.put("嘉義縣","");
        cityMap.put("嘉義市","Jiayi Shi");
        cityMap.put("臺南市","");
        cityMap.put("高雄市","Kaohsiung");
        cityMap.put("屏東縣","");
        cityMap.put("宜蘭縣","Yilan");
        cityMap.put("花蓮縣","Hualien");
        cityMap.put("臺東縣","Taitung");
        cityMap.put("澎湖縣","Penghu");
        cityMap.put("金門縣","");
        cityMap.put("連江縣","");
    };



}
