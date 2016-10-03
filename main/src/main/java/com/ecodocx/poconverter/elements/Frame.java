package com.ecodocx.poconverter.elements;

import com.ecodocx.poconverter.BaseElementVisitor;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Roman on 8/10/2016.
 */
public class Frame extends BaseElement {
    private float width;
    List<String> allMatches = new ArrayList<String>();

    public Frame(BaseElement parent, String line) {
        super(parent, line);
        Scanner sc = new Scanner(line).useDelimiter("\\s");
        while (sc.hasNext()) {
            allMatches.add(sc.next());
        }
        width = Float.parseFloat(getValueByKey("W"));
    }
    String getValueByKey(String key) {
        int keyIndex = allMatches.indexOf(key);
        if (keyIndex >= 0)
            return allMatches.get(keyIndex + 1);
        else
            return "0";
    }
    @Override
    public void accept(BaseElementVisitor visitor, Element parentElement) {
        parentElement = visitor.visit(this, parentElement);
        for (BaseElement element : childrenList) {
            element.accept(visitor, parentElement);
        }
    }
    @Override
    public float getWidth() {
        return width;
    }
}
