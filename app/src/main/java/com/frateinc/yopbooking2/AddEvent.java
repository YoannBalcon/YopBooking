package com.frateinc.yopbooking2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.frateinc.yopbooking2.ApiMethod.InsertEvent;
import com.frateinc.yopbooking2.Models.Event;

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
//        txtAddEventOrg = (EditText) findViewById(R.id.txtAddEventOrg);
        txtAddEventHour = (EditText) findViewById(R.id.txtAddEventHour);
        txtAddEventAddress = (EditText) findViewById(R.id.txtAddEventAddress);
        txtAddEventZipcode = (EditText) findViewById(R.id.txtAddEventZipcode);
        txtAddEventLocation = (EditText) findViewById(R.id.txtAddEventLocation);
        txtAddEventComment = (EditText) findViewById(R.id.txtAddEventComment);

        btnAddEvent.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Editable v_txtAddEventName = txtAddEventName.getText();
//                Editable v_txtAddEventOrg = txtAddEventOrg.getText();
//                String v_txtAddEventOrg = Param.userId;
                Editable v_txtAddEventHour = txtAddEventHour.getText();
                Editable v_txtAddEventAddress = txtAddEventAddress.getText();
                Editable v_txtAddEventZipcode = txtAddEventZipcode.getText();
                Editable v_txtAddEventLocation = txtAddEventLocation.getText();
                Editable v_txtAddEventComment = txtAddEventComment.getText();

                Event addedEvent = new Event(v_txtAddEventName.toString(), Param.userId, Integer.parseInt(v_txtAddEventHour.toString()), v_txtAddEventAddress.toString(), Integer.parseInt(v_txtAddEventZipcode.toString()), v_txtAddEventLocation.toString(), v_txtAddEventComment.toString());
                if (TextUtils.isEmpty(v_txtAddEventName.toString())) {
                    txtAddEventName.setError("ERROR");
                    return;
//                } else if (TextUtils.isEmpty(v_txtAddEventOrg.toString())) {
//                    txtAddEventOrg.setError("ERROR");
//                    return;
//                } else if (TextUtils.isEmpty(v_txtAddEventHour.toString())) {
//                    txtAddEventHour.setError("ERROR");
//                    return;
//                } else if (TextUtils.isEmpty(v_txtAddEventAddress.toString())) {
//                    txtAddEventAddress.setError("ERROR");
//                    return;
//                } else if (TextUtils.isEmpty(v_txtAddEventZipcode.toString())) {
//                    txtAddEventZipcode.setError("ERROR");
//                    return;
//                } else if (TextUtils.isEmpty(v_txtAddEventLocation.toString())) {
//                    txtAddEventLocation.setError("ERROR");
//                    return;
//                } else if (TextUtils.isEmpty(v_txtAddEventComment.toString())) {
//                    txtAddEventComment.setError("ERROR");
//                    return;
                } else {

                    InsertEvent data = new InsertEvent(addedEvent);
                    data.execute();
                    Toast.makeText(AddEvent.this, "Event created", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(AddEvent.this, ListEvents.class);
                    AddEvent.this.startActivity(intent);
                }

            }

        });


    }
}
