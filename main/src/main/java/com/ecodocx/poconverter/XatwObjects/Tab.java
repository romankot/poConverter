package com.ecodocx.poconverter.XatwObjects;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * Created by Roman on 8/19/2016.
 */
public class Tab {
    public static Node createInstance(Document document) {
        Element tab = document.createElement("tab");
        tab.setAttribute("distance", "0.5 in");
        return tab;
    }
}
