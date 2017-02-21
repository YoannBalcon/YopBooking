package com.frateinc.yopbooking2.ApiMethod;

import android.os.AsyncTask;

import com.frateinc.yopbooking2.Config.ConfigApi;
import com.frateinc.yopbooking2.Models.Event;

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

public class FindEvents  extends AsyncTask<String, Void, List<Event>> {

<<<<<<< HEAD:app/src/main/java/com/frateinc/yopbooking2/FindEvents.java
    private final String link = "http://10.105.49.65:8080/api/v1/events";
=======
    private final String link = ConfigApi.findevent;
>>>>>>> 5f5fc67cf6861b96610c40533c9491f7a58b5d82:app/src/main/java/com/frateinc/yopbooking2/ApiMethod/FindEvents.java


    @Override
    protected List<Event> doInBackground(String... params) {
        StringBuilder sb = new StringBuilder();
        HttpURLConnection urlConnection;

        List<Event> events = new ArrayList<>();

        try {
            URL url = new URL(link);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(9999);
            urlConnection.setConnectTimeout(9999);
            urlConnection.setRequestMethod("GET");
            urlConnection.setRequestProperty("User-Agent", "yopbooking");
            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.connect();
            if (urlConnection.getResponseCode() == HttpsURLConnection.HTTP_OK) {
                System.out.println("OK FIND EVENT");

                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                BufferedReader br = new BufferedReader(new InputStreamReader(in));

                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
                br.close();

            } else {
                System.out.println("PAS OK FIND EVENT");
            }
            urlConnection.disconnect();

            JSONArray jsonArray = new JSONArray(sb.toString());

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);
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

                Event evt = new Event(id, title, user_id, eventDate, hour, address, zipcode, city, comment, currentDate, firstname, lastname);

                events.add(evt);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return events;

    }

    private static Date convertDate(String str) {
        DateFormat formatter = null;
        Date convertedDate = null;
        formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            convertedDate = (Date) formatter.parse(str);
        } catch (ParseException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        return convertedDate;
    }
}
