package com.ecodocx.poconverter;

import com.ecodocx.poconverter.elements.BaseElement;
import com.ecodocx.poconverter.elements.Text;
import com.ecodocx.poconverter.elements.Variable;

/**
 * Created by Roman on 8/9/2016.
 */
public class Factory {

    public static BaseElement makeElement(String line)
    {
        String type = line.substring(0, line.indexOf(' '));
        switch (type) {
            case "Text":
                return new Text(line);
            case "Variable":
                return new Variable(line);
                break;
            default:
                return null;
        }
    }
}
