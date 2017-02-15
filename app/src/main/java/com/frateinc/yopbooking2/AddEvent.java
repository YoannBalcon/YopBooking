package com.frateinc.yopbooking2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.frateinc.yopbooking2.R;
import com.frateinc.yopbooking2.models.Event;

import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

import static android.R.attr.data;

/**
 * Created by Afpa on 13/02/2017.
 */

public class AddEvent extends AppCompatActivity {
    Button btnAddEvent;
    EditText txtAddEventName;
    EditText txtAddEventOrg;
    EditText txtAddEventHour;
    EditText txtAddEventAddress;
    EditText txtAddEventZipcode;
    EditText txtAddEventLocation;
    EditText txtAddEventComment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_event);

    btnAddEvent = (Button) findViewById(R.id.btnAddEvent);
    txtAddEventName = (EditText) findViewById(R.id.txtAddEventName);
     txtAddEventOrg = (EditText) findViewById(R.id.txtAddEventOrg);
     txtAddEventHour = (EditText) findViewById(R.id.txtAddEventHour);
     txtAddEventAddress = (EditText) findViewById(R.id.txtAddEventAddress);
     txtAddEventZipcode = (EditText) findViewById(R.id.txtAddEventZipcode);
     txtAddEventLocation = (EditText) findViewById(R.id.txtAddEventLocation);
     txtAddEventComment = (EditText) findViewById(R.id.txtAddEventComment);

        btnAddEvent.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Editable v_txtAddEventName = txtAddEventName.getText();
                Editable v_txtAddEventOrg = txtAddEventOrg.getText();
                Editable v_txtAddEventHour = txtAddEventHour.getText();
                Editable v_txtAddEventAddress = txtAddEventAddress.getText();
                Editable v_txtAddEventZipcode = txtAddEventZipcode.getText();
                Editable v_txtAddEventLocation = txtAddEventLocation.getText();
                Editable v_txtAddEventComment = txtAddEventComment.getText();

                Event addedEvent = new Event(v_txtAddEventName.toString(), Integer.parseInt(v_txtAddEventOrg.toString()), Integer.parseInt(v_txtAddEventHour.toString()), v_txtAddEventAddress.toString(), Integer.parseInt(v_txtAddEventZipcode.toString()), v_txtAddEventLocation.toString(), v_txtAddEventComment.toString());

                InsertEvent data = new InsertEvent(addedEvent);
                data.execute();

            }
        });
    }

}
