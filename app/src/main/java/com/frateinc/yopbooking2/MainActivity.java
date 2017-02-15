package com.frateinc.yopbooking2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView;

import com.frateinc.yopbooking2.models.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static android.R.attr.value;

public class MainActivity extends AppCompatActivity {
    List<Event> events = new ArrayList<>();
//    TextView lblEventTitle;
//    TextView lblEventBy;
//    Button btnEventRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        lblEventTitle = (TextView) findViewById(R.id.lblEventTitle);
//        lblEventBy = (TextView) findViewById(R.id.lblEventBy);
//        btnEventRegister = (Button)findViewById(R.id.btnEventRegister);

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
                    Intent i = new Intent(getApplicationContext(), DetailsEvent.class );
                    i.putExtra("liste_film", levent.getId());
                    startActivity(i);

                }
            });

            final Button button = (Button) findViewById(R.id.btnAddEvent);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    // Perform action on click
                    Intent activityChangeIntent = new Intent(MainActivity.this, AddEvent.class);

                    // currentContext.startActivity(activityChangeIntent);

                    MainActivity.this.startActivity(activityChangeIntent);
                }
            });




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
