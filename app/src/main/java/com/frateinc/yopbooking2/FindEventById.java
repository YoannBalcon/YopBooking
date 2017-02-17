package com.frateinc.yopbooking2;

import android.os.AsyncTask;

import com.frateinc.yopbooking2.models.Event;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by Afpa on 13/02/2017.
 */

public class FindEventById extends AsyncTask<String, Void, Event> {

    private final String link = "http://10.105.49.71:8080/api/v1/event/";


    @Override
    protected Event doInBackground(String... params) {
        StringBuilder sb = new StringBuilder();
        HttpURLConnection urlConnection;
        Event evt = null;

        try {
            URL url = new URL(link + params[0]);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(9999);
            urlConnection.setConnectTimeout(9999);
            urlConnection.setRequestMethod("GET");
            urlConnection.setRequestProperty("User-Agent", "yopbooking");
            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.connect();
            if (urlConnection.getResponseCode() == HttpsURLConnection.HTTP_OK) {
                System.out.println("OK");

                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                BufferedReader br = new BufferedReader(new InputStreamReader(in));

                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
                br.close();

            } else {
                System.out.println("PAS OK");
            }
            urlConnection.disconnect();

            JSONObject jsonObject= new JSONObject(sb.toString());

                int id = jsonObject.getInt("id");
                String title = jsonObject.getString("title");
                int user_id = jsonObject.getInt("user_id");
                String date = jsonObject.getString("date");
                int hour = jsonObject.getInt("hour");
                String address = jsonObject.getString("address");
                int zipcode = jsonObject.getInt("zipcode");
                String city = jsonObject.getString("city");
                String comment = jsonObject.getString("comment");
                String creationDate = jsonObject.getString("creationDate");
                String firstname = jsonObject.getString("firstname");
                String lastname = jsonObject.getString("lastname");

                Date eventDate = convertDate(date);
                Date currentDate = convertDate(creationDate);

                evt = new Event(id, title, user_id, eventDate, hour, address, zipcode, city, comment, currentDate, firstname, lastname);




        } catch (Exception e) {
            e.printStackTrace();
        }
        return evt;

    }

    private static Date convertDate(String str) {
        DateFormat formatter = null;
        Date convertedDate = null;
        formatter = new SimpleDateFormat("yyyy-mm-dd");
        try {
            convertedDate = formatter.parse(str);
        } catch (ParseException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        return convertedDate;
    }
}
