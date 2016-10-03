package com.ecodocx.poconverter.elements;

import com.ecodocx.poconverter.BaseElementVisitor;
import org.w3c.dom.Element;

/**
 * Created by Roman on 8/15/2016.
 */
public class ScriptLine extends BaseElement {
    public ScriptLine(BaseElement parent, String line) {
        super(parent, line);
    }
    public void accept(BaseElementVisitor visitor, Element parentElement) {
        visitor.visit(this, parentElement);
    }
    @Override
    public String getType() {
        return "ScriptLine";
    }
}
