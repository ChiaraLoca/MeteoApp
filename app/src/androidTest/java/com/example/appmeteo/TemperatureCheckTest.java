package com.example.appmeteo;
import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.appmeteo.controller.MeteoController;
import com.example.appmeteo.controller.TemperatureCheckController;
import com.example.appmeteo.model.Place;
import com.example.appmeteo.model.PlacesHolder;
import com.example.appmeteo.model.db.DbWrapper;
import com.example.appmeteo.model.meteo.Meteo;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.UUID;

import static com.example.appmeteo.model.PlacesHolder.get;
import static org.junit.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class TemperatureCheckTest {
    @Test
    public void checkTest(){
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        Place here= PlacesHolder.get(appContext).getPlaces().get(0);
        assertNotNull(here);
        Meteo meteo = MeteoController.getInstance().jsonToMeteo(meteoJson);
        here.setMeteo(meteo);
        TemperatureCheckController.getInstance().startCheck(appContext);

    }
    String meteoJson= "{\"coord\": { \"lon\": 139,\"lat\": 35},\n" +
            "     \"weather\": [\n" +
            "       {\n" +
            "         \"id\": 800,\n" +
            "         \"main\": \"Clear\",\n" +
            "         \"description\": \"clear sky\",\n" +
            "         \"icon\": \"01n\"\n" +
            "       }\n" +
            "     ],\n" +
            "     \"base\": \"stations\",\n" +
            "     \"main\": {\n" +
            "       \"temp\": 273.52,\n" +
            "       \"feels_like\": 278.99,\n" +
            "       \"temp_min\": 280.15,\n" +
            "       \"temp_max\": 283.71,\n" +
            "       \"pressure\": 1016,\n" +
            "       \"humidity\": 93\n" +
            "     },\n" +
            "     \"wind\": {\n" +
            "       \"speed\": 0.47,\n" +
            "       \"deg\": 107.538\n" +
            "     },\n" +
            "     \"clouds\": {\n" +
            "       \"all\": 2\n" +
            "     },\n" +
            "     \"dt\": 1560350192,\n" +
            "     \"sys\": {\n" +
            "       \"type\": 3,\n" +
            "       \"id\": 2019346,\n" +
            "       \"message\": 0.0065,\n" +
            "       \"country\": \"JP\",\n" +
            "       \"sunrise\": 1560281377,\n" +
            "       \"sunset\": 1560333478\n" +
            "     },\n" +
            "     \"timezone\": 32400,\n" +
            "     \"id\": 1851632,\n" +
            "     \"name\": \"Shuzenji\",\n" +
            "     \"cod\": 200\n" +
            "     }";
}
