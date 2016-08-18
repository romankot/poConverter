package com.ecodocx.poconverter.elements;

/**
 * Created by Roman on 8/10/2016.
 */
public class Frame extends BaseElement {
    public Frame(String line) {
        super(line);
    }
    @Override
    public void accept(BaseElementVisitor visitor) {
        visitor.visit(this);
        for (BaseElement element : childrenList) {
            element.accept(visitor);
        }
    }
}
