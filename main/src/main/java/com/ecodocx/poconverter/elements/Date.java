package com.ecodocx.poconverter.elements;

import com.ecodocx.poconverter.BaseElementVisitor;
import org.w3c.dom.Element;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Roman on 8/15/2016.
 */
public class Date extends BaseElement {
    private final LinkedList<String> words;
    private float x;
    private float y;
    private boolean flip = false;
    String fontName;
    String fontSize;
    String format = "";
    boolean wrapKeepSpace = false;

    public Date(BaseElement parent, String line) {
        super(parent, line);
        words = new LinkedList<>();
        Scanner sc = new Scanner(line).useDelimiter("\\s");
        while (sc.hasNext()) {
            words.add(sc.next());
        }
        x = Float.parseFloat(words.get(words.indexOf("X") + 1));
        y = Float.parseFloat(words.get(words.indexOf("Y") + 1));

        if (words.contains("flip")) {
            flip = true;
        }
        fontName = words.get(words.indexOf("Font") + 1);
        fontSize = words.get(words.indexOf("Font") + 2);
        format = words.get(words.indexOf("Format") + 1);
        if (words.contains("WrapKeepSp")) {
            wrapKeepSpace = true;
        }
    }
    public void accept(BaseElementVisitor visitor, Element parentElement) {
        visitor.visit(this, parentElement);
    }

}
