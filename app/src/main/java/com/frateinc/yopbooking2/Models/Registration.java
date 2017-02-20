package com.frateinc.yopbooking2.Models;

/**
 * Created by Afpa on 16/02/2017.
 */

public class Registration {

    int id;
    int id_event;
    int id_user;

    public Registration(int id, int id_event, int id_user) {
        this.id = id;
        this.id_event = id_event;
        this.id_user = id_user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
}
