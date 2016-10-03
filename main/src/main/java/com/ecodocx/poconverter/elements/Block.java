package com.ecodocx.poconverter.elements;

import com.ecodocx.poconverter.BaseElementVisitor;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Roman on 8/10/2016.
 */
public class Block extends BaseElement {
    private float advY;
    private float yoffset;
    private String name;

    public Block(BaseElement parent, String line) {
        super(parent, line);
        List<String> words = new ArrayList<>();
        Scanner sc = new Scanner(line).useDelimiter("\\s");
        while (sc.hasNext()) {
            words.add(sc.next());
        }
        name = words.get(1);
        if (words.contains("YOffset")) {
            yoffset = Float.parseFloat(words.get(words.indexOf("YOffset") + 1));}
        if (words.contains("AdvY")) {
            advY = Float.parseFloat(words.get(words.indexOf("AdvY") + 1));}
    }
    public void accept(BaseElementVisitor visitor, Element parentElement) {
        visitor.visit(this, parentElement);
    }

    public float getAdvY() {
        return advY;
    }

    public float getYoffset() {
        return yoffset;
    }

    public String getName() {
        return name.replace("\"", "");
    }

    @Override
    public float getWidth() {
        return parent.getWidth();
    }
}
