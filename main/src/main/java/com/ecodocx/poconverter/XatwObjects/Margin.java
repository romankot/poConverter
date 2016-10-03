package com.ecodocx.poconverter.XatwObjects;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * Created by Roman on 8/19/2016.
 */
public class Margin {
    public static Node craeteInstance(Document document) {
        Element margin = document.createElement("margin");
        margin.setAttribute("left", "0.0 in");
        margin.setAttribute("right", "0.0 in");
        margin.setAttribute("top", "0.0 in");
        margin.setAttribute("bottom", "0.0 in");
        return margin;
    }
}
