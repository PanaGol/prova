package com.example.myapplication;

public class ItemModel {
    private String number;
    private String name;

    public ItemModel(String number, String name) {
        this.number = number;
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}