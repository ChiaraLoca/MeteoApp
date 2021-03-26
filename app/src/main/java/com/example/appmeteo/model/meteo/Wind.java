package com.example.appmeteo.model.meteo;



import java.io.IOException;
import java.io.Writer;

public class Wind {
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


}
