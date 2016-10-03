package com.ecodocx.poconverter.XatwObjects;

import com.ecodocx.poconverter.elements.Text;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * represents xatw text object
 */
public class LabelText  {

    public static Node createInstance(Document document, Text text) {
        Element labelText = document.createElement("label");
        labelText.setAttribute("type", "text");
        labelText.setAttribute("backgroundColor", "transparent");
        labelText.setAttribute("foregroundColor", "#000000");
        labelText.setAttribute("visible", "yes");
        labelText.setAttribute("shading", "none");
        labelText.setAttribute("lineSpacing", "0.0 in");
        labelText.appendChild(BoundingRect.createInstance(document, text));
        labelText.appendChild(Margin.craeteInstance(document));
        labelText.appendChild(Border.createInstance(document));
        labelText.appendChild(Font.createInstance(document, text));
        labelText.appendChild(Tab.createInstance(document));
        Element etext = document.createElement("text");
        etext.setTextContent(text.getText());
        labelText.appendChild(etext);
        return labelText;
    }
}
