package com.example.appmeteo.controller;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Send extends AsyncTask<String, Void, String> {
    @Override
    protected String doInBackground(String... strings) {
        StringBuilder stringBuilder = new StringBuilder();
        HttpURLConnection connection=null;
        try {
            URL url = new URL(strings[0]);
            connection = (HttpURLConnection)url.openConnection();
            InputStream in = connection.getInputStream(); // apro la connessione
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));

            if(connection.getResponseCode() != HttpURLConnection.HTTP_OK)
                return null;
            String line;
            while((line =bufferedReader.readLine())!=null)
            {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            connection.disconnect();
        }
        return stringBuilder.toString();
    }
}
