package com.ecodocx.poconverter.elements;

/**
 * Created by Roman on 8/8/2016.
 */
public class BaseElement {
    String line;
    String name;
    float x;
    float y;

    public boolean isComplex() {
        return BaseElement.isComplex(line);
    }
    public static boolean isComplex(String trim) {
        if (trim.startsWith("Sheet") ||
            trim.startsWith("Block") ||
            trim.startsWith("Frame")    ) {
            return true;
        }
        else return false;
    }

    enum Elements {Sheet, Text, End, Line, Variable, Overlay, Frame, Block,
                    Field, Rect, FrameRef, ProcPageOfPages, Date};
    public static boolean contains(String test) {

        for (Elements c : Elements.values()) {
            if (c.name().startsWith(test)) {
                return true;
            }
        }
        return false;
    }

    public BaseElement(String line) {
        name = line.substring(0, line.indexOf(' '));
    }

    public void addChild(BaseElement element){

    }
}
