package com.example.appmeteo.model.meteo;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsonable;

import java.io.IOException;
import java.io.Writer;

public class Wind implements Jsonable {
    private double speed;
    private double deg;

    @Override
    public String toString() {
        return "Wind{" +
                "speed=" + speed +
                ", deg=" + deg +
                '}';
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDeg() {
        return deg;
    }

    public void setDeg(double deg) {
        this.deg = deg;
    }

    public Wind() {
    }

    public Wind(double speed, double deg) {
        this.speed = speed;
        this.deg = deg;
    }

    @Override
    public String toJson() {
        JsonObject jsonObject = new JsonObject();

        jsonObject.put("speed", this.speed);
        jsonObject.put("deg", this.deg);



        return jsonObject.toJson();
    }

    @Override
    public void toJson(Writer writable) throws IOException {
        try {
            writable.write(this.toJson());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
