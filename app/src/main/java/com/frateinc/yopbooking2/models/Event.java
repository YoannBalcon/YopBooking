package com.frateinc.yopbooking2.models;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Afpa on 09/02/2017.
 */

public class Event {
    int id;
    String title;
    int user_id;
    Date date;
    int hour;
    String address;
    int zipcode;
    String city;
    String comment;
    Date creationDate;
    String firstname;
    String lastname;

    ArrayList<Event> events = new ArrayList<Event>();

    public Event() {
    }

    public Event(String title, int user_id, int hour, String address, int zipcode, String city, String comment) {
        this.title = title;
        this.user_id = user_id;
        this.hour = hour;
        this.address = address;
        this.zipcode = zipcode;
        this.city = city;
        this.comment = comment;
    }


    public Event(int id, String title, int user_id, int hour, String address, int zipcode, String city, String comment) {
        this.id = id;
        this.title = title;
        this.user_id = user_id;
        this.hour = hour;
        this.address = address;
        this.zipcode = zipcode;
        this.city = city;
        this.comment = comment;
    }

    public Event(int id, String title, int user_id, Date date, int hour, String address, int zipcode, String city, String comment, Date creationDate, String firstname, String lastname) {
        this.id = id;
        this.title = title;
        this.user_id = user_id;
        this.date = date;
        this.hour = hour;
        this.address = address;
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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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

    public String getaddress() {
        return address;
    }

    public void setaddress(String address) {
        this.address = address;
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
        return this.title;
    }


}
