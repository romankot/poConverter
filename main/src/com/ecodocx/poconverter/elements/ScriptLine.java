package com.ecodocx.poconverter.elements;

/**
 * Created by Roman on 8/15/2016.
 */
public class ScriptLine extends BaseElement {
    public ScriptLine(String line) {
        super(line);
    }

    @Override
    public String getType() {
        return "ScriptLine";
    }
}
