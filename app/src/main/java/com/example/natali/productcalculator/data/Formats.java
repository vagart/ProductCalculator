package com.example.natali.productcalculator.data;

public class Formats {
    private int width;
    private int height;
    private String title;

    public Formats() {
    }
    public Formats(int width, int height) {
        this.height = height;
        this.width  = width;
        this.title  = String.valueOf(height) + 'x' + String.valueOf(width);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
