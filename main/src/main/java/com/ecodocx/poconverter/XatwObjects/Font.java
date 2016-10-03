package com.ecodocx.poconverter.XatwObjects;

import com.ecodocx.poconverter.elements.Field;
import com.ecodocx.poconverter.elements.Text;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
/**
 * Created by Roman on 8/19/2016.
 */
public class Font {
    public static Node createInstance(Document document, Text text) {
        Element font = document.createElement("font");
        font.setAttribute("typeface", text.getFont());
        font.setAttribute("size", text.getFontSize());
        if (text.getTextStyle() == java.awt.Font.BOLD) {
            font.setAttribute("bold", "1");
        }
        font.setAttribute("italic", "0");
        return font;
    }
    public static Node createInstance(Document document, Field field) {
        Element font = document.createElement("font");
        font.setAttribute("typeface", field.getFont());
        font.setAttribute("size", field.getFontSize());
        font.setAttribute("italic", "0");
        font.setAttribute("bold", "0");
        return font;
    }
}
