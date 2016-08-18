package com.ecodocx.poconverter.elements;

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

    public Line(String line) {
        super(line);
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
        //outline = Float.parseFloat(words.get(words.indexOf("Outline") + 1)); // todo
    }
    public static void main(String args[]) {
        Line text = new Line("Line X 210.82 Y 129.54 W -205.74 H 0.00 flip Outline 0.20;");
        text.getType();
    }
}
