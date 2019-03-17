package wakandaforever.wakandaforever.models;

import java.io.Serializable;

public class Prediction implements Serializable {

    private String createdAt;
    private String datetime;
    private float grnd_level;
    private int humidity;
    private long id;
    private float pressure;
    private float sea_level;
    private float temperature;
    private float temperature_max;
    private float temperature_min;
    private float wind_speed;

    public Prediction(){

    }

    public Prediction(String createdAt, String datetime, float grnd_level, int humidity, long id, float pressure, float sea_level, float temperature, float temperature_max, float temperature_min, float wind_speed) {
        setCreatedAt(createdAt);
        setDatetime(datetime);
        setGrnd_level(grnd_level);
        setHumidity(humidity);
        setId(id);
        setPressure(pressure);
        setSea_level(sea_level);
        setTemperature(temperature);
        setTemperature_max(temperature_max);
        setTemperature_min(temperature_min);
        setWind_speed(wind_speed);
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public float getGrnd_level() {
        return grnd_level;
    }

    public void setGrnd_level(float grnd_level) {
        this.grnd_level = grnd_level;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public float getSea_level() {
        return sea_level;
    }

    public void setSea_level(float sea_level) {
        this.sea_level = sea_level;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getTemperature_max() {
        return temperature_max;
    }

    public void setTemperature_max(float temperature_max) {
        this.temperature_max = temperature_max;
    }

    public float getTemperature_min() {
        return temperature_min;
    }

    public void setTemperature_min(float temperature_min) {
        this.temperature_min = temperature_min;
    }

    public float getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(float wind_speed) {
        this.wind_speed = wind_speed;
    }
}
