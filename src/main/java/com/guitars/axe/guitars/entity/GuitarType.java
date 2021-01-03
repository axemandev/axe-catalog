package com.guitars.axe.guitars.entity;

public enum GuitarType {
    ACOUSTIC ("acoustic"),
    ELECTRIC ("electric"),
    CLASSICAL ("classical");

    private String value;

    private GuitarType(String value) { this.value = value; }

    public String getGuitarType() { return this.value; }
}
