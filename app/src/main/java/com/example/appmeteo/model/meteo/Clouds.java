package com.example.appmeteo.model.meteo;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsonable;

import java.io.IOException;
import java.io.Writer;

public class Clouds implements Jsonable {
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

    @Override
    public String toJson() {
        JsonObject jsonObject = new JsonObject();

        jsonObject.put("all", this.all);



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
