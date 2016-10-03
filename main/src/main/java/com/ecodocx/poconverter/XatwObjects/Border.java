package com.ecodocx.poconverter.XatwObjects;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * Created by Roman on 8/19/2016.
 */
public class Border {

    public static Node createInstance(Document document) {
        Element border = document.createElement("border");
        border.setAttribute("visible", "no");
        border.setAttribute("color", "#000000");
        border.setAttribute("thickness", "0.01 in");
        border.setAttribute("lineStyle", "solid");
        border.setAttribute("edges", "all");
        border.setAttribute("radius", "0.0 in");
        return border;
    }
}
