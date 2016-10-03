package com.ecodocx.poconverter.XatwObjects;

import com.ecodocx.poconverter.elements.Line;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * Created by Roman on 8/23/2016.
 */
public class XLine {
    public static Node getInstance(Document document, Line line) {
        Element eline = document.createElement("line");
        eline.setAttribute("foregroundColor", "#000000");
        eline.setAttribute("visible", "yes");
        eline.setAttribute("thickness", "0.01");
        eline.setAttribute("lineStyle", "solid");
        eline.setAttribute("backgroundColor", "transparent");
        eline.setAttribute("normalized", "yes");
        eline.appendChild(BoundingRect.createInstance(document, line));
        return eline;
    }
}
