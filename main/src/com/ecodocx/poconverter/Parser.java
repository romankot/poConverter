package com.ecodocx.poconverter;

import com.ecodocx.poconverter.elements.BaseElement;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by Roman on 8/8/2016.
 */
public class Parser {

    private BufferedReader reader;
    private BaseElement root;
    private LinkedList<BaseElement> stack;
    private BaseElement currElem;
    private String line;
    private BaseElement parent;

    Parser(BufferedReader reader) {
        this.reader = reader;
        stack = new LinkedList<>();
    }

    public BaseElement getModel() throws IOException {

        root = new BaseElement("Root element");
        stack.push(root);
        parent = root;

        while ((line = reader.readLine()) != null) {
            if (BaseElement.isValid(line.trim()) || parent.getType().equals("Script")) {
                currElem = Factory.makeElement(line.trim(), parent.getType().equals("Script"));
                if (currElem.isComplex()) {
                    stack.push(currElem);
                    parent.addChild(currElem);
                    parent = currElem;
                }
                else
                    if (currElem.getType().equals("End")) { // ending complex object
                        stack.pop();
                        parent = stack.peek();
                    }
                    else { // just element. add as child
                        parent.addChild(currElem);
                    }
            }
        }
        return root;
    }
}
