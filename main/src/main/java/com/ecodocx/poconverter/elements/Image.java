package com.ecodocx.poconverter.elements;

import com.ecodocx.poconverter.BaseElementVisitor;
import org.w3c.dom.Element;

/**
 * Created by Roman on 8/10/2016.
 */
public class Image extends BaseElement {
    public Image(BaseElement parent, String line) {
        super(parent, line);
    }
    public void accept(BaseElementVisitor visitor, Element parentElement) {
        visitor.visit(this, parentElement);
    }
}
