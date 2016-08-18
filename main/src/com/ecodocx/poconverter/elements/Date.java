package com.ecodocx.poconverter.elements;

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

    public Date(String line) {
        super(line);
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
    public static void main(String args[]) {
        Date sheet = new Date("Date X 76.20 Y 86.36 flip Font \"Arial\" 12 Cp \"Ansi\" Format \"DHH:MM:SS\" WrapKeepSp");
        sheet.getType();
    }
}
