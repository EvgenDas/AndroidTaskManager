package com.dashencko.androidtaskmanager.Models;

public class Category {

    private int id;

    private String title;


    public Category(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setId(int id) {
        this.id = id;
    }


}
