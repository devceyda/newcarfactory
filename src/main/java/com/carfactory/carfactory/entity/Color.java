package com.carfactory.carfactory.entity;

public class Color {

    private int ColorID;
    private String Color;

    public Color(int colorID, String color) {
        ColorID = colorID;
        Color = color;

    }

    public Color() {
    }

    public int getColorID() {
        return ColorID;
    }

    public void setColorID(int colorID) {
        ColorID = colorID;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

}
