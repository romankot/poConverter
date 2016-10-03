package com.ecodocx.poconverter.elements;

import com.ecodocx.poconverter.BaseElementVisitor;
import org.w3c.dom.Element;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Roman on 8/15/2016.
 */
public class Overlay extends BaseElement {
    private LinkedList<String> words = new LinkedList<>();
    private boolean alias = false;
    String overlayName;
    String variable = "empty";
    public Overlay(BaseElement parent, String line) {
        super(parent, line);
        Scanner sc = new Scanner(line).useDelimiter("\\s");
        while (sc.hasNext()) {
            words.add(sc.next());
        }
        overlayName = words.getLast();
        if (words.contains("Alias"))
            alias = true;
        variable = words.get(words.indexOf("Variable") + 1);
    }
    public void accept(BaseElementVisitor visitor, Element parentElement) {
        visitor.visit(this, parentElement);
    }
}
