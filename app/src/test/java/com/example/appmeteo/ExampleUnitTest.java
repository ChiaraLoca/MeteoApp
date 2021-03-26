package com.example.appmeteo;

import com.example.appmeteo.controller.ConnectionController;
import com.example.appmeteo.controller.MeteoController;
import com.example.appmeteo.model.meteo.Meteo;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void jsonTest() {
        String s= "{\"coord\": { \"lon\": 139,\"lat\": 35},\n" +
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
                "       \"temp\": 281.52,\n" +
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
        MeteoController meteoController= MeteoController.getInstance();
        Meteo meteo=meteoController.jsonToMeteo(s);
        System.out.println(meteo);
    }

    @Test
    public void connectionTest()
    {
        ConnectionController connectionController = ConnectionController.getConnectionController();

        System.out.println(connectionController.getWeatherByCityName("Delebio"));

    }
}