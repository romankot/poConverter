package com.ecodocx.poconverter;

import com.ecodocx.poconverter.elements.BaseElement;
import com.ecodocx.poconverter.elements.Sheet;
import com.ecodocx.poconverter.elements.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by Roman on 8/8/2016.
 */
public class Parser {

    private BufferedReader reader;
    private Process process;
    private BaseElement element;
    private LinkedList<BaseElement> stack;
    private String prevElement;
    private int lineCount = 0;
    private BaseElement currElem;

    Parser(BufferedReader reader) {
        this.reader = reader;
    }

    public void start() throws IOException {
        String line = null;
        while ((line = reader.readLine()) != null) {
            if (BaseElement.contains(line.trim())) {
                lineCount++;

                element = parseLine(line.trim());
                if (element != null ) {   // leaf
                    if ((currElem = getFirstComplexElement()) != null ) { //inside block
                        currElem.addChild(Factory.makeElement(line));
                    } else {
                        process.addElement(element);
                    }
                }
                else {  //branch

                }
                prevElement = line.substring(0, line.indexOf(' ')) + "_" + lineCount;
            }
        }
    }

    BaseElement parseLine(String line) {

        if (line.equals("End")) {
            return null;
        }

        if (line.startsWith("Sheet") ||
            line.trim().startsWith("Frame") ||
            line.trim().startsWith("Block")) {
                return parseBlockElement(line); // give block type , fabric method
        }

        return new Text(line);
    }

    private BaseElement parseBlockElement(String line) {
        String type = line.substring(0, line.indexOf(' '));
        switch (type) {
            case "Sheet":
                stack.addFirst(new Sheet(line));
                break;
        }
    }

    BaseElement getFirstComplexElement() {
        for (BaseElement element : stack ) {
            if (element.isComplex())
                return element;
        }
    }
}
