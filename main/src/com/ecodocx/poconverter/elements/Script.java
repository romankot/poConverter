package com.ecodocx.poconverter.elements;

import java.util.ArrayList;

/**
 * Created by Roman on 8/15/2016.
 */
public class Script extends BaseElement {
    String id;
    String parentBlock;
    ArrayList<String> script = new ArrayList<>();
    public Script(String line) {
        super(line);
        String words[] = line.split("\\s+");
        id = words[1];
        parentBlock = words[2];
    }
    public static void main(String args[]) {
        Script sheet = new Script("Script 4 \"Sheet\"");
        sheet.getType();
    }
}
