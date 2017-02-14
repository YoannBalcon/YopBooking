package com.frateinc.yopbooking2.models;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Afpa on 09/02/2017.
 */

public class Event {
    int id;
    String title;
    int organisator_id;
    Date date;
    int hour;
    String adress;
    int zipcode;
    String city;
    String comment;
    Date creationDate;
    String firstname;
    String lastname;

    ArrayList<Event> events = new ArrayList<Event>();

    public Event() {
    }

    public Event(int id, String title, int organisator_id, Date date, int hour, String adress, int zipcode, String city, String comment, Date creationDate, String firstname, String lastname) {
        this.id = id;
        this.title = title;
        this.organisator_id = organisator_id;
        this.date = date;
        this.hour = hour;
        this.adress = adress;
        this.zipcode = zipcode;
        this.city = city;
        this.comment = comment;
        this.creationDate = creationDate;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getOrganisator_id() {
        return organisator_id;
    }

    public void setOrganisator_id(int organisator_id) {
        this.organisator_id = organisator_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }


    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return this.title + " " + this.firstname;
    }


}
