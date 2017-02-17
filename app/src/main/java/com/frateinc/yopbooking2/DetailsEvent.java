package com.frateinc.yopbooking2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.frateinc.yopbooking2.models.Event;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;

import static java.security.AccessController.getContext;

/**
 * Created by Afpa on 08/02/2017.
 */

public class DetailsEvent extends AppCompatActivity {
    TextView txtDetailsPartyName;
    TextView txtDetailsOrg;
    TextView txtDetailsDate;
    TextView txtDetailsaddress;
    TextView txtDetailsZipcode;
    TextView txtDetailsComment;
    String eventId;
    Button btnDetailsRegister;
    Date date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_event);

        txtDetailsPartyName = (TextView) findViewById(R.id.txtDetailsPartyName);
        txtDetailsOrg = (TextView) findViewById(R.id.txtDetailsOrg);
        txtDetailsDate = (TextView) findViewById(R.id.txtDetailsDate);
        txtDetailsaddress = (TextView) findViewById(R.id.txtDetailsaddress);
        txtDetailsZipcode = (TextView) findViewById(R.id.txtDetailsZipcode);
        txtDetailsComment = (TextView) findViewById(R.id.txtDetailsComment);

        eventId = getIntent().getStringExtra("event_id");

        try {
            FindEventById data = new FindEventById();
            data.execute(eventId);
            Event evt = data.get();

//            Date date = convertDate(evt.getDate());
            txtDetailsPartyName.setText(evt.getTitle());
            txtDetailsOrg.setText("Par " + evt.getFirstname() + " " + evt.getLastname());
            txtDetailsDate.setText(evt.getDate() + " à " + evt.getHour() + " h.");
            txtDetailsaddress.setText(evt.getaddress());
            txtDetailsZipcode.setText(String.valueOf(evt.getZipcode() + " " + evt.getCity()));

            Log.i("DATEFORMATEE", String.valueOf(date));
            Log.i("EVTDATE", String.valueOf(evt.getDate()));


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("eventId= " + eventId);

        btnDetailsRegister = (Button) findViewById(R.id.btnDetailsRegister);
        btnDetailsRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(DetailsEvent.this, RegisterEvent.class);
                intent.putExtra("event_id", "" + eventId);
                DetailsEvent.this.startActivity(intent);
            }
        });
    }


//    private static Date convertDate(Date date) {
//        DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
//        String fDate = formatter.format(date);
//        Date cDate;
//
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
//        cDate = dateFormat.parse(fDate);
//
//        return cDate;
//    }


}
