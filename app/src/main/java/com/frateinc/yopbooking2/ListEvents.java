package com.frateinc.yopbooking2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.frateinc.yopbooking2.ApiMethod.FindEvents;
import com.frateinc.yopbooking2.Models.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by rico on 17/02/17.
 */

public class ListEvents extends AppCompatActivity {
    List<Event> events = new ArrayList<>();
    Button btnLogin;
    String userName;
    TextView txtUserName;
    FloatingActionButton btnAddEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = getIntent().getStringExtra("user_name");

        List<Event> events = null;
        try {

            FindEvents data = new FindEvents();
            data.execute();
            events = data.get();
            ListView listView = (ListView) findViewById(R.id.listViewEvents);
            final ListEventAdapter adapter = new ListEventAdapter(this, events);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Event levent = adapter.getItem(position);

                    Log.i("selected id event:", String.valueOf(levent.getId()));
                    Intent i = new Intent(getApplicationContext(), DetailsEvent.class);
                    startActivity(i);

                }
            });

//            final Button button = (Button) findViewById(R.id.btnAddEvent);
//            button.setOnClickListener(new View.OnClickListener() {
//                public void onClick(View v) {
//                    // Perform action on click
//                    Intent activityChangeIntent = new Intent(ListEvents.this, AddEvent.class);
//
//                    // currentContext.startActivity(activityChangeIntent);
//
//                    ListEvents.this.startActivity(activityChangeIntent);
//                }
//            });


            FloatingActionButton btnAddEvent = (FloatingActionButton)findViewById(R.id.btnAddEvent);
            btnAddEvent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent activityChangeIntent = new Intent(ListEvents.this, AddEvent.class);
                    ListEvents.this.startActivity(activityChangeIntent);
                }
            });


            final Button btnLogin = (Button) findViewById(R.id.btnLogin);
            btnLogin.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    // Perform action on click
                    Intent activityChangeIntent = new Intent(ListEvents.this, Login.class);

                    // currentContext.startActivity(activityChangeIntent);

                    ListEvents.this.startActivity(activityChangeIntent);
                }
            });
            TextView txtUserName = (TextView) findViewById(R.id.txtUserName);
            txtUserName.setText("Welcome " + userName);

//
//            btnEventMore.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, DetailsEvent.class);
//                intent.putExtra("intVariableName", v.getId()); //where v is button that is cliked, you will find it as a parameter to onClick method
//                startActivity(intent);
//            }
//            });
//
//            btnEventRegister.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent i = new Intent(getApplicationContext(),RegisterEvent.class);
//                    startActivity(i);
//                }
//            });


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }


}
