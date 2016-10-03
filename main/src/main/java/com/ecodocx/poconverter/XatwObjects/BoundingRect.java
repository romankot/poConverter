package com.ecodocx.poconverter.XatwObjects;

import com.ecodocx.poconverter.PageDimension;
import com.ecodocx.poconverter.elements.Field;
import com.ecodocx.poconverter.elements.Line;
import com.ecodocx.poconverter.elements.Text;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * Created by Roman on 8/19/2016.
 */
public class BoundingRect {
    Document parent;
    public BoundingRect(Document document, Text text) {
        parent = document;
    }

    public static Node createInstance(Document document, Text text) {

        Element boundingRect = document.createElement("boundingRect");
        boundingRect.setAttribute("left", text.getXinch()+ " in");
        boundingRect.setAttribute("top", text.getYinch()+ " in");
        boundingRect.setAttribute("width", text.getTextWidthInch() + " in");
        boundingRect.setAttribute("height", text.getTextHeightInch()+ " in");
        return boundingRect;
    }
    public static Node createInstance(Document document, Line line) {

        Element boundingRect = document.createElement("boundingRect");
        boundingRect.setAttribute("left", line.getXinch()+ " in");
        boundingRect.setAttribute("top", line.getYinch()+ " in");
        boundingRect.setAttribute("width", line.getTextWidthInch() + " in");
        boundingRect.setAttribute("height", line.getTextHeightInch()+ " in");
        return boundingRect;
    }

    public static Node createInstance(Document document, Field field) {
        Element boundingRect = document.createElement("boundingRect");
        boundingRect.setAttribute("left", field.getXinch()+ " in");
        boundingRect.setAttribute("top", field.getYinch()+ " in");
        boundingRect.setAttribute("width", field.getTextWidthInch() + " in");
        boundingRect.setAttribute("height", field.getTextHeightInch()+ " in");
        return boundingRect;
    }


    public static Node createInstance(Document document, double left, double top, double width, double height) {
        Element boundingRect = document.createElement("boundingRect");
        boundingRect.setAttribute("left", left + " in");
        boundingRect.setAttribute("top", top + " in");
        boundingRect.setAttribute("width", width + " in");
        boundingRect.setAttribute("height", height + " in");
        return boundingRect;
    }

    public static Node createInstance(Document document, PageDimension pageDimension) {
        Element boundingRect = document.createElement("boundingRect");
        boundingRect.setAttribute("left", pageDimension.getLeft() + " in");
        boundingRect.setAttribute("top", pageDimension.getTop() + " in");
        boundingRect.setAttribute("width", pageDimension.getWidth() + " in");
        boundingRect.setAttribute("height", pageDimension.getHeight() + " in");
        return boundingRect;
    }
}
