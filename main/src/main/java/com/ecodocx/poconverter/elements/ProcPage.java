package com.ecodocx.poconverter.elements;

import com.ecodocx.poconverter.BaseElementVisitor;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Roman on 8/10/2016.
 */
public class ProcPage extends BaseElement {

    float x;
    float y;
    boolean flip = false;
    String fontName;
    String fontSize;
    boolean wrapKeepSpace = false;

    public ProcPage(BaseElement parent, String line) {
        super(parent, line);

        List<String> allMatches = new ArrayList<String>();
        Scanner sc = new Scanner(line).useDelimiter("\\s");
        while (sc.hasNext()) {
            allMatches.add(sc.next());
        }
        x = Float.parseFloat(allMatches.get(2));
        y =  Float.parseFloat(allMatches.get(4));
        if (allMatches.get(5).equals("flip") )
            flip = true;
        fontName = allMatches.get(7);
        fontSize = allMatches.get(8);
        if (line.contains("WrapKeepSp") )
            wrapKeepSpace = true;
    }
    @Override
    public void accept(BaseElementVisitor visitor, Element parentElement) {
        visitor.visit(this, parentElement);
    }

}
