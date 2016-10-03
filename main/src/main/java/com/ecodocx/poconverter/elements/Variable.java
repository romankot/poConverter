package com.ecodocx.poconverter.elements;

import com.ecodocx.poconverter.BaseElementVisitor;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Roman on 8/9/2016.
 */
public class Variable extends BaseElement {

    String variable;
    float x;
    float y;
    boolean flip = false;
    String fontName;
    String fontSize;
    boolean right = false;
    String format;
    private boolean wrapKeepSp = false;

    public Variable(BaseElement parent, String line) {
        super(parent, line);
        List<String> allMatches = new ArrayList<String>();
        Scanner sc = new Scanner(line).useDelimiter("\\s");
        while (sc.hasNext()) {
            allMatches.add(sc.next());
        }
        variable = allMatches.get(1);
        x = Float.parseFloat(allMatches.get(3));
        y = Float.parseFloat(allMatches.get(5));
        if (allMatches.contains("flip"))
            flip = true;
        if (allMatches.contains("Right"))
            right = true;
        fontName = allMatches.get(8);
        fontSize = allMatches.get(9);
        if (allMatches.contains("Format")){
            format = allMatches.get(allMatches.indexOf("Format") + 1);
        }
        if (allMatches.contains("WrapKeepSp"))
            wrapKeepSp = true;
    }
    public void accept(BaseElementVisitor visitor, Element parentElement) {
        visitor.visit(this, parentElement);
    }

}
