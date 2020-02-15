package com.assessment2.pojo;

import java.util.Date;
import java.util.List;


public class Forecast {

    Date dt;
    Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    List<Weather> weather;
    Rain rain;

    public Main getMain() {
        return main;
    }

    public Date getDt() {
        return dt;
    }

    public void setDt(Date dt) {
        this.dt = dt;
    }

    public Rain getRain() {
        return rain;
    }

    public void setRain(Rain rain) {
        this.rain = rain;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }
}

class Rain {
    double _3h;

    public double get3h() {
        return _3h;
    }

    public void set3h(double _3h) {
        this._3h = _3h;
    }
}

class Weather {
    long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}