package com.ecodocx.poconverter.elements;

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
    public Overlay(String line) {
        super(line);
        Scanner sc = new Scanner(line).useDelimiter("\\s");
        while (sc.hasNext()) {
            words.add(sc.next());
        }
        overlayName = words.getLast();
        if (words.contains("Alias"))
            alias = true;
        variable = words.get(words.indexOf("Variable") + 1);
    }
    public static void main(String args[]) {
        Overlay sheet = new Overlay("Overlay Alias Variable $testOverlay \"blank.lxf\";");
        sheet.getType();
    }
}
