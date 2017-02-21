package com.frateinc.yopbooking2;

import android.os.AsyncTask;
import android.util.Log;

import com.frateinc.yopbooking2.models.Event;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Afpa on 13/02/2017.
 */

public class InsertEvent extends AsyncTask<String, Void, Event> {

    private final String link = "http://10.105.49.65:8080/api/v1/newevent";

    private Event event;

    public InsertEvent(Event event) {
        this.event = event;
    }

    @Override
    protected Event doInBackground(String... params) {
        StringBuilder sb = new StringBuilder();
        HttpURLConnection urlConnection;
        Event evt = null;

        try {
            URL url = new URL(link);

            JSONObject jsonParam = new JSONObject();
            jsonParam.put("title", event.getTitle());
            jsonParam.put("user_id", event.getUser_id());
            jsonParam.put("hour", event.getHour());
            jsonParam.put("address", event.getaddress());
            jsonParam.put("zipcode", event.getZipcode());
            jsonParam.put("city", event.getCity());
            jsonParam.put("comment", event.getComment());
            jsonParam.put("creationDate", event.getCreationDate());
            jsonParam.put("enable", "true");

            urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.setReadTimeout(99999999);
            urlConnection.setConnectTimeout(99999999);
            urlConnection.setRequestMethod("POST");
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);
            urlConnection.setRequestProperty("User-Agent", "yopbooking");
            urlConnection.setRequestProperty("Accept", "application/json");



            OutputStream os = urlConnection.getOutputStream();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));

            writer.write(jsonParam.toString());
            writer.flush();
            os.close();

            //urlConnection.connect();


            Log.i(InsertEvent.class.getName(), String.valueOf(urlConnection.getResponseCode())) ;

            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();

            System.out.print(sb.toString());

            // } else {
            //     System.out.println("PAS OK");
            //}
            urlConnection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return evt;

    }

}


//            if (urlConnection.getResponseCode() == HttpsURLConnection.HTTP_OK) {
//                System.out.println("OK");
//
//                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
//                BufferedReader br = new BufferedReader(new InputStreamReader(in));
//
//                String line;
//                while ((line = br.readLine()) != null) {
//                    sb.append(line);
//                }
//                br.close();
//
//            } else {
//                System.out.println("PAS OK");
//            }
//            urlConnection.disconnect();
