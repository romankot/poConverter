package com.ecodocx.poconverter.elements;

import com.ecodocx.poconverter.BaseElementVisitor;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roman on 8/8/2016.
 */
public class BaseElement {
    String line;
    String type;
    List<BaseElement> childrenList = new ArrayList<>();
    protected BaseElement parent = null;

    public BaseElement(BaseElement parent, String line) {
        this.parent = parent;
        this.line = line;
        String words[] = line.split("\\s+");
        type = words[0];
    }
    public boolean isComplex() {
        return BaseElement.isComplex(line);
    }

    public static boolean isComplex(String trim) {
        if (trim.startsWith("Sheet") ||
            trim.startsWith("Block") ||
            trim.startsWith("FBlock") ||
            trim.startsWith("Frame") ||
            trim.startsWith("Script")  ) {
            return true;
        }
        else return false;
    }

    public void accept(BaseElementVisitor visitor, Element parentElement) {
        parentElement = visitor.visit(this, parentElement);
        for (BaseElement element: this.childrenList){
            element.accept(visitor, parentElement);
        }
    }

    public int getChildrenNumber() {
        return childrenList.size();
    }

    public BaseElement getParent() {
        return parent;
    }

    enum Elements {Sheet, Text, End, Line, Variable, Overlay, Frame, Block, FBlock,
        Field, Rect, ProcPageOfPages, Date, Script};

    public static boolean isValid(String testString) {
        String fword = testString.split(" ")[0];
        for (Elements c : Elements.values()) {
            if (fword.contentEquals(c.name())) {
                return true;
            }
        }
        return false;
    }

    public String getType() {
        return type;
    }

    public void addChild(BaseElement element){
        childrenList.add(element);
    }

    public float getWidth() {
        return 0;
    }
}
