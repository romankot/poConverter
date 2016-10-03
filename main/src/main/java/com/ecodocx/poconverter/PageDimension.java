package com.ecodocx.poconverter;

/**
 * Created by Roman on 9/28/2016.
 */
public class PageDimension {
    private double left;
    private double top;
    private double width;
    private double height;

    PageDimension(String size, String orientation){
        if (size == "A4" && orientation == "Portrait") {
            left = 0.0;
            top = 0.0;
            width = 8.3;
            height = 11.7;
        }
        if (size == "A4" && orientation == "Landscape") {
            left = 0.0;
            top = 0.0;
            width = 11.7;
            height = 8.3;
        }
        if (size == "Letter" && orientation == "Landscape") {
            left = 0.0;
            top = 0.0;
            width = 11;
            height = 8.5;
        }

    }

    public PageDimension() {
        left = 0.0;
        top = 0.0;
        width = 8.3;
        height = 11.7;
    }

    public double getLeft() {
        return left;
    }

    public double getTop() {
        return top;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}
