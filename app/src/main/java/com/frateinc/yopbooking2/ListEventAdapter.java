package com.frateinc.yopbooking2;

import android.content.Context;

import java.util.List;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

import com.frateinc.yopbooking2.Models.Event;


/**
 * Created by Afpa on 14/02/2017.
 */

public class ListEventAdapter extends ArrayAdapter<Event> {


    Button btnEventRegister;
    Button btnEventMore;
    TableLayout tblEvent;
    TextView lblEventBy;


    public ListEventAdapter(Context context, List<Event> listEvents) {
        super(context, 0, listEvents);
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        // Get the data item for this position

        final Event lEvent = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view

        if (convertView == null) {


            convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_view, parent, false);

        }

        // Lookup view for data population

        TextView lblEventTitle = (TextView) convertView.findViewById(R.id.lblEventTitle);
        TextView lblEventBy = (TextView) convertView.findViewById(R.id.lblEventBy);

        tblEvent = (TableLayout) convertView.findViewById(R.id.tblEvent);
        tblEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), DetailsEvent.class);
                intent.putExtra("event_id","" + lEvent.getId());
                getContext().startActivity(intent);
            }
        });





        // Populate the data into the template view using the data object


        lblEventTitle.setText(lEvent.getTitle());
        lblEventBy.setText("Par " + lEvent.getFirstname() + " " + lEvent.getLastname() );


        // Return the completed view to render on screen

        return convertView;

    }
}

