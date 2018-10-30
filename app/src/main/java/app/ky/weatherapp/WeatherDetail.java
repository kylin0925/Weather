package app.ky.weatherapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class WeatherDetail extends AppCompatActivity {
    String TAG ="WeatherDetail";

    TextView txtCurrentTemp;
    TextView txtCity;
    TextView txtDescription;
    TextView txtHumidity;
    ImageView imgIcon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_detail);
        txtCurrentTemp = (TextView)findViewById(R.id.txtCurrnTemp);
        txtCity = (TextView)findViewById(R.id.txtCity);
        imgIcon = (ImageView)findViewById(R.id.imgIcon);
        txtDescription = (TextView)findViewById(R.id.txtDescription);
        txtHumidity = (TextView)findViewById(R.id.txtHumidity);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.LOCATION);
        if(message!=null){
            Log.e(TAG,"location " + message);
            txtCity.setText(message);

        }
        FetchWeatherData fetchWeatherData = new FetchWeatherData();
        fetchWeatherData.execute(message);
    }
    private class FetchWeatherData extends AsyncTask<String,Void, WeatherData>{
        Bitmap icon;

        @Override
        protected WeatherData doInBackground(String... strings) {
            String city = strings[0];
            Log.e(TAG,"query city " + city);
            WeatherDataFetcher wdf = new WeatherDataFetcher();
            WeatherData data= wdf.getDailyData(city,BuildConfig.APIKEY);
            Log.e(TAG,data.toString());
            Log.e(TAG,"icon " + data.weather.get(0).icon);
            icon = wdf.getWeatherIcon(data.weather.get(0).icon);
            return data;
        }

        @Override
        protected void onPostExecute(WeatherData weatherData) {
            super.onPostExecute(weatherData);
            txtCurrentTemp.setText("temperature  :" + String.valueOf((int)weatherData.main.temp) + "°С");
            imgIcon.setImageBitmap(icon);
            txtDescription.setText(weatherData.weather.get(0).description);
            txtHumidity.setText("humidity :" + weatherData.main.humidity + " %");
        }
    }
}
