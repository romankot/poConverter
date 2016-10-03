package com.ecodocx.poconverter.XatwObjects;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * represents xatw text object
 */
public class Field {
    public static Node createInstance(Document document, com.ecodocx.poconverter.elements.Field ffield) {
        Element field = document.createElement("field");
        field.setAttribute("name", ffield.getFieldName());
        field.setAttribute("type", "text");
        field.setAttribute("backgroundColor", "transparent");
        field.setAttribute("foregroundColor", "#000000");
        field.setAttribute("visible", "yes");
        field.setAttribute("shading", "none");
        field.setAttribute("lineSpacing", "0.0 in");
        field.setAttribute("resizableWidth", "yes");
        field.appendChild(BoundingRect.createInstance(document, ffield));
        field.appendChild(Margin.craeteInstance(document));
        field.appendChild(Border.createInstance(document));
        field.appendChild(com.ecodocx.poconverter.XatwObjects.Font.createInstance(document, ffield));
        field.appendChild(Tab.createInstance(document));

        return field;
    }
}
