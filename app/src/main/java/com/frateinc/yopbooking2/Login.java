package com.frateinc.yopbooking2;


import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import static com.frateinc.yopbooking2.Param.userId;

public class Login extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        final Spinner dropdown = (Spinner) findViewById(R.id.spinner);
        final String[] items = new String[]{"Stal", "RiCo", "Giovanni"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        final Button button = (Button) findViewById(R.id.btnListLogin);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String currentItem = (String) dropdown.getSelectedItem();


                if (currentItem.contentEquals("Stal")) {
                    Param.userId = 1;
                } else if (currentItem.contentEquals("RiCo")) {
                    Param.userId = 2;
                } else if (currentItem.contentEquals("Giovanni")) {
                    Param.userId = 3;
                }

                System.out.print((String) dropdown.getSelectedItem());

                // Perform action on click
                Intent intent = new Intent(Login.this, MainActivity.class);
                intent.putExtra("user_name", currentItem);

                // currentContext.startActivity(activityChangeIntent);
                Login.this.startActivity(intent);

            }
        });

    }
}