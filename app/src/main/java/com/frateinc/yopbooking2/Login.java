package com.frateinc.yopbooking2;


import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Login extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        final Spinner dropdown = (Spinner)findViewById(R.id.spinner);
        String[] items = new String[]{"Stal", "RiCo", "Giovanni"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        final Button button = (Button) findViewById(R.id.btnListLogin);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Param.userId = (String) dropdown.getSelectedItem();
                System.out.print((String) dropdown.getSelectedItem());

                // Perform action on click
                Intent activityChangeIntent = new Intent(Login.this, AddEvent.class);
                // currentContext.startActivity(activityChangeIntent);
                Login.this.startActivity(activityChangeIntent);

            }
        });

    }
}