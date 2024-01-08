package com.carfactory.carfactory.entity;
//-----------------------------------------------------
// Title: Color
// Author: Ceyda Kuşçuoğlu, Berke Beyazbenli, Selin Sivis, Aybüke Ersal
// Section: 1,3
// Term Project
// Summary: This class is likely used to model and manage color-related data in the application, such as storing information about different colors available for cars.
//----------------------------------------------------
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
