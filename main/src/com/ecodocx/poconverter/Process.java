package com.ecodocx.poconverter;

import com.ecodocx.poconverter.elements.BaseElement;

import java.util.ArrayList;

/**
 * Created by Roman on 8/8/2016.
 */
public class Process {

    String version;
    private ArrayList<BaseElement> array;

    Process() {
        array = new ArrayList<>();
    }

    void addElement(BaseElement element) {
        array.add(element);
    }

}
