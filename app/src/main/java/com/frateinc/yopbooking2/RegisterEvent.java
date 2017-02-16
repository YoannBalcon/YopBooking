package com.frateinc.yopbooking2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.frateinc.yopbooking2.R;

import org.w3c.dom.Text;

/**
 * Created by Afpa on 08/02/2017.
 */

public class RegisterEvent extends AppCompatActivity {
    String eventId;
    TextView lbltestid;
    EditText txtRegisterFirstname;
    EditText txtRegisterLastname;
    Button btnRegisterEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_event);

        lbltestid = (TextView) findViewById(R.id.lbltestid);
        txtRegisterFirstname = (EditText) findViewById(R.id.txtRegisterFirstname);
        txtRegisterLastname = (EditText) findViewById(R.id.txtRegisterLastname);

        eventId = getIntent().getStringExtra("event_id");
        lbltestid.setText(eventId);

        btnRegisterEvent.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                txtRegisterFirstname.getText();
                txtRegisterLastname.getText();

//                Param.userId;

            }
        });
    }
}