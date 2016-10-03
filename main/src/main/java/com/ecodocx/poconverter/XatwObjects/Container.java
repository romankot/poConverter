package com.ecodocx.poconverter.XatwObjects;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * Created by Roman on 9/5/2016.
 */
public class Container {
    public static Node createContainer(Document document) {
        Element container = document.createElement("container");
        container.setAttribute("name", "Container");
        container.setAttribute("visible", "yes");
        container.setAttribute("shading", "none");
        return container;
    }
}
