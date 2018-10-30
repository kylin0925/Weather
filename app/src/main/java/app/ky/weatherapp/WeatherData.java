package app.ky.weatherapp;

import java.util.List;
class Coord{
    float lon;
    float lat;
}
class Weather{
    int id;
    String main;
    String description;
    String icon;
}
class Main{
    float temp;
    float pressure;
    int humidity;
    float temp_min;
    float temp_max;
}
class Wind{
    float speed;
    float deg;
}
class Clouds{
    int all;
}
class Sys{
    int type;
    int id;
    float message;
    String country;
    long sunrise;
    long sunset;
}
public class WeatherData {

    Coord coord;            //:{"lon":121.56,"lat":25.04},
    List<Weather> weather;  //"weather":[{"id":800,"main":"Clear","description":"clear sky","icon":"01d"}],
    String base;            // "base":"stations",

    Main main;          // "main":{"temp":299.15,"pressure":1014,"humidity":41,"temp_min":299.15,"temp_max":299.15},
    int visibility;     // "visibility":10000,
    Wind wind;          // "wind":{"speed":7.7,"deg":70},
    Clouds clouds;      // "clouds":{"all":0},
    long dt;            // "dt":1540788660,
    Sys sys;            // "sys":{"type":1,"id":7479,"message":0.007,"country":"TW","sunrise":1540763953,"sunset":1540804522},
    int id;             //"id":1668341,
    String name;        //   "name":"Taipei",
    int cod;            //   "cod":200

}
