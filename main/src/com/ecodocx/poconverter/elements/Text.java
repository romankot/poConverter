package com.ecodocx.poconverter.elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Roman on 8/8/2016.
 */
public class Text extends BaseElement {
    String text;
    float x;
    float y;
    boolean flip = false;
    String fontName;
    String fontSize;
    boolean wrapKeepSpace = false;

    public Text(String line) {
        super(line);
        List<String> words = new ArrayList<>();
        Scanner sc = new Scanner(line).useDelimiter("\\s");
        while (sc.hasNext()) {
            words.add(sc.next());
        }
        text = words.get(1);
        x = Float.parseFloat(words.get(words.indexOf("X") + 1));
        y =  Float.parseFloat(words.get(words.indexOf("Y") + 1));
        if (words.contains("flip") ) {
            flip = true;
        }
        fontName = words.get(words.indexOf("Font") + 1);
        fontSize = words.get(words.indexOf("Font") + 2);
        if (words.contains("WrapKeepSp") ) {
            wrapKeepSpace = true;
        }
    }

    @Override
    public void accept(BaseElementVisitor visitor) {
        visitor.visit(this);
    }

    public static void main(String args[]) {
        Text text = new Text("Text \"Page:\" X 172.45 Y 33.81 flip Font \"Arial\" 10 Cp \"Ansi\" WrapKeepSp");
        text.getType();
    }
}
