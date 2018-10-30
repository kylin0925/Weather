package app.ky.weatherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    public static String LOCATION = "location";
    String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new RCAdapter(this));
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                test2();
            }
        });

        thread.start();
    }
    void test(){
        String data = "";
        try {
            InputStream file = getAssets().open("weather_data.txt");
            InputStreamReader is = new InputStreamReader(file);
            BufferedReader br = new BufferedReader(is);
            String tmp = "";
            while( (tmp = br.readLine()) != null){
                data+=tmp;
            }
            Gson gson = new Gson();
            WeatherData weatherData = gson.fromJson(data,WeatherData.class);
            Log.e(TAG,weatherData.name);
        }catch (Exception ex){
            Log.e(TAG,"open asset file error " + ex.toString());
        }

    }

    void test2(){
        WeatherDataFetcher wdf = new WeatherDataFetcher();
        WeatherData data= wdf.getDailyData("taipei","86e282026b633b0359939db3813c22cd");
        Log.e(TAG,data.toString());
    }
}
