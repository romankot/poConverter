package com.ecodocx.poconverter.elements;

import com.ecodocx.poconverter.BaseElementVisitor;
import org.w3c.dom.Element;

import java.util.ArrayList;

/**
 * Created by Roman on 8/15/2016.
 */
public class Script extends BaseElement {
    String id;
    String parentBlock;
    ArrayList<String> script = new ArrayList<>();
    public Script(BaseElement parent, String line) {
        super(parent, line);
        String words[] = line.split("\\s+");
        id = words[1];
        parentBlock = words[2];
    }
    public void accept(BaseElementVisitor visitor, Element parentElement) {
        visitor.visit(this, parentElement);
    }

}
