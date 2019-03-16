package wakandaforever.wakandaforever.models;

import java.io.Serializable;

public class FarmObject implements Serializable {
    private float fire;
    private float humidity;
    private float soilMoisture;
    private float temperature;
    private float waterLevel;

    public FarmObject(){

    }

    public FarmObject(float fire, float humidity, float soilMoisture, float temperature, float waterLevel) {
        this.fire = fire;
        this.humidity = humidity;
        this.soilMoisture = soilMoisture;
        this.temperature = temperature;
        this.waterLevel = waterLevel;
    }

    public float getFire() {
        return fire;
    }

    public void setFire(float fire) {
        this.fire = fire;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getSoilMoisture() {
        return soilMoisture;
    }

    public void setSoilMoisture(float soilMoisture) {
        this.soilMoisture = soilMoisture;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(float waterLevel) {
        this.waterLevel = waterLevel;
    }
}
