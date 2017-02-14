package com.frateinc.yopbooking2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.frateinc.yopbooking2.R;
import com.frateinc.yopbooking2.models.Event;

import org.w3c.dom.Text;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static com.frateinc.yopbooking2.R.id.txtDetailsPartyName;

/**
 * Created by Afpa on 08/02/2017.
 */

public class DetailsEvent extends AppCompatActivity {
    TextView txtDetailsPartyName;
    TextView txtDetailsOrg;
    TextView txtDetailsDate;
    TextView txtDetailsAdress;
    TextView txtDetailsZipcode;
    TextView txtDetailsComment;
    String eventId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_event);

        txtDetailsPartyName = (TextView) findViewById(R.id.txtDetailsPartyName);
        txtDetailsOrg = (TextView) findViewById(R.id.txtDetailsOrg);
        txtDetailsDate = (TextView) findViewById(R.id.txtDetailsDate);
        txtDetailsAdress = (TextView) findViewById(R.id.txtDetailsAdress);
        txtDetailsZipcode = (TextView) findViewById(R.id.txtDetailsZipcode);
        txtDetailsComment = (TextView) findViewById(R.id.txtDetailsComment);

        eventId = getIntent().getStringExtra("liste_event");

        try {
            FindEventsById data = new FindEventsById();
            data.execute(eventId);
            Event evt = data.get();

            txtDetailsPartyName.setText(evt.getTitle());
            txtDetailsOrg.setText("Par " + evt.getFirstname() + " " + evt.getLastname());
            txtDetailsDate.setText(evt.getDate()+" à " + evt.getHour()+ " h.");
            txtDetailsAdress.setText(evt.getAdress());
            txtDetailsZipcode.setText(String.valueOf(evt.getZipcode() + " " + evt.getCity()));


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(eventId);


    }
}
