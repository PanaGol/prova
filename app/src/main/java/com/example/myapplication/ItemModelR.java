package com.example.myapplication;

public class ItemModelR {
    private String number;
    private String name, ct, lutech;



    public ItemModelR(String number, String name, String ct, String lutech) {
        this.number = number;
        this.name = name;
        this.ct= ct;
        this.lutech = lutech;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
    public String getCt() {
        return ct;
    }
    public String getLutech() {
        return lutech;
    }
}