package com.guitars.axe.guitars.entity;

public enum Color {
    RED ("#ff0000"),
    GREEN ("#00ff00"),
    BLUE ("#0000ff"),
    BLACK ("#000000"),
    WHITE ("#ffffff");

    private String value;

    private Color(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
