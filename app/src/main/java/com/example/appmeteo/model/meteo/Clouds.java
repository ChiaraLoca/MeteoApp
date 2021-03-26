package com.example.appmeteo.model.meteo;



import java.io.IOException;
import java.io.Writer;

public class Clouds {
    private double all;

    @Override
    public String toString() {
        return "Clouds{" +
                "all=" + all +
                '}';
    }

    public double getAll() {
        return all;
    }

    public void setAll(double all) {
        this.all = all;
    }

    public Clouds() {
    }

    public Clouds(double all) {
        this.all = all;
    }


}
