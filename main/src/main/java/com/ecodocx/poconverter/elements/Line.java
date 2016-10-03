package com.ecodocx.poconverter.elements;

import com.ecodocx.poconverter.BaseElementVisitor;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Roman on 8/15/2016.
 */
public class Line extends BaseElement {
    private float x;
    private float y;
    private float w;
    private float h;
    private boolean flip = false;
    private float outline;

    public Line(BaseElement parent, String line) {
        super(parent, line);
        List<String> words = new ArrayList<>();
        Scanner sc = new Scanner(line).useDelimiter("\\s");
        while (sc.hasNext()) {
            words.add(sc.next());
        }
        x = Float.parseFloat(words.get(words.indexOf("X") + 1));
        y = Float.parseFloat(words.get(words.indexOf("Y") + 1));
        w = Float.parseFloat(words.get(words.indexOf("W") + 1));
        h = Float.parseFloat(words.get(words.indexOf("H") + 1));
        if (words.contains("flip")) {
            flip = true;
        }
        //outline = Float.parseFloat(words.craeteInstance(words.indexOf("Outline") + 1)); // todo
    }
    public void accept(BaseElementVisitor visitor, Element parentElement) {
        visitor.visit(this, parentElement);
    }

    public String getXinch() {
        return String.valueOf(x / 25.4);
    }

    public String getYinch() {
        return String.valueOf(y / 25.4);
    }

    public String getTextWidthInch() {
        return String.valueOf(w / 25.4);
    }

    public String getTextHeightInch() {
        return String.valueOf(h / 25.4);
    }
}
