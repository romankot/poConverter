package com.ecodocx.poconverter.elements;

import com.ecodocx.poconverter.BaseElementVisitor;
import org.w3c.dom.Element;

/**
 * Created by Roman on 8/11/2016.
 */
public class End extends BaseElement {
    public End(BaseElement parent, String line) {
        super(parent, "End element");
    }
    public void accept(BaseElementVisitor visitor, Element parentElement) {
        //visitor.visit(this, parentElement);
    }
}
