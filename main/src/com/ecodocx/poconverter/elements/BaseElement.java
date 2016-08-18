package com.ecodocx.poconverter.elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roman on 8/8/2016.
 */
public class BaseElement {
    String line;
    String type;

    List<BaseElement> childrenList = new ArrayList<>();

    public boolean isComplex() {
        return BaseElement.isComplex(line);
    }
    public static boolean isComplex(String trim) {
        if (trim.startsWith("Sheet") ||
            trim.startsWith("Block") ||
            trim.startsWith("Frame") ||
            trim.startsWith("Script")  ) {
            return true;
        }
        else return false;
    }

    public void accept(BaseElementVisitor visitor) {
        visitor.visit(this);
        for (BaseElement element: this.childrenList){
            element.accept(visitor);
        }
    }

    public int getChildrenNumber() {
        return childrenList.size();
    }

    enum Elements {Sheet, Text, End, Line, Variable, Overlay, Frame, Block,
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

    public BaseElement(String line) {
        this.line = line;
        String words[] = line.split("\\s+");
        type = words[0];
    }

    public String getType() {
        return type;
    }

    public void addChild(BaseElement element){
        childrenList.add(element);
    }
}
