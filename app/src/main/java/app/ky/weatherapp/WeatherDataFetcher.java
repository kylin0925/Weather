package app.ky.weatherapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class WeatherDataFetcher {
    String TAG = "WeatherDataFetcher";
    static WeatherDataFetcher weatherDataFetcher = null;

    String dataurl = "https://api.openweathermap.org/data/2.5/weather?q=%s&units=metric&appid=%s";
    String iconUrl = "http://openweathermap.org/img/w/%s.png";
    public static WeatherDataFetcher getInstance(){
        if(weatherDataFetcher == null)
            return new WeatherDataFetcher();
        else
            return weatherDataFetcher;
    }
    Bitmap getWeatherIcon(String icon){
        String reqUrl = String.format(iconUrl, icon);
        Log.e(TAG,"getWeatherIcon " + reqUrl);
        return getPicture(reqUrl);
    }
    Bitmap getPicture(String url){
        Bitmap bitmap=null;

        try {
            URL u = new URL(url);
            URLConnection conn = u.openConnection();
            bitmap = BitmapFactory.decodeStream(conn.getInputStream());
        }catch (Exception ex){
            Log.e(TAG,"error " + ex);
        }
        return bitmap;
    }
    String sentHttpRequestGet(String url){
        String result = "";
        try {
            URL u = new URL(url);
            HttpURLConnection h = (HttpURLConnection) u.openConnection();

            int len = 0;

            BufferedReader br = new BufferedReader(new InputStreamReader(h.getInputStream()));

            String tmp = "";
            while ((tmp = br.readLine()) != null) {
                result +=tmp;
            }
            h.disconnect();
        }catch (Exception e){
            Log.e(TAG,"exception : " + e.toString());
        }
        return result;
    }
    WeatherData getDailyData(String city,String apiKey){
        String reqUrl = String.format(dataurl, city,apiKey);
        String weatherData = sentHttpRequestGet(reqUrl);
        try {

            Gson gson = new Gson();
            WeatherData WeatherData = gson.fromJson(weatherData,WeatherData.class);

            return WeatherData;
        }catch (Exception ex){
            Log.e(TAG,"getDailyData error " + ex.toString());
        }
        return null;
    }
}
