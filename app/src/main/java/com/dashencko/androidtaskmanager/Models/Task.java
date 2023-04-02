package com.dashencko.androidtaskmanager.Models;

import java.time.LocalDate;
import java.util.Date;

public class Task {

    private int id;

    private int category;
    private String title, description, elapsed_time, name, status, color;
    private String priority;
    private LocalDate estimate_date;
    private LocalDate actual_date;
    private LocalDate today_date;

    public Task(int id, String title, String description, String elapsed_time, String name, String status, String priority, LocalDate estimate_date, LocalDate actual_date, LocalDate today_date) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.elapsed_time = elapsed_time;
        this.name = name;
        this.status = status;
        this.priority = priority;
        this.estimate_date = estimate_date;
        this.actual_date = actual_date;
        this.today_date = today_date;
    }

    public Task(int id, String title, String description, String name, String priority, String color, int category) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.name = name;
        this.priority = priority;
        this.color = color;
        this.category = category;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getElapsed_time() {
        return elapsed_time;
    }

    public void setElapsed_time(String elapsed_time) {
        this.elapsed_time = elapsed_time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public LocalDate getEstimate_date() {
        return estimate_date;
    }

    public void setEstimate_date(LocalDate estimate_date) {
        this.estimate_date = estimate_date;
    }

    public LocalDate getActual_date() {
        return actual_date;
    }

    public void setActual_date(LocalDate actual_date) {
        this.actual_date = actual_date;
    }

    public LocalDate getToday_date() {
        return today_date;
    }

    public void setToday_date(LocalDate today_date) {
        this.today_date = today_date;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
}