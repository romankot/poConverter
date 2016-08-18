package com.ecodocx.poconverter;

import com.ecodocx.poconverter.elements.*;

/**
 * Created by Roman on 8/9/2016.
 */
public class Factory {

    public static BaseElement makeElement(String line, boolean isScript)
    {
        String words[] = line.split("\\s+");
        String type = words[0];
        if (isScript) {
            if (type.equals("End")) {
                type = "End";
            } else
                type = "ScriptLine";
        }
        switch (type) {
            case "Sheet":
                return new Sheet(line);
            case "Text":
                return new Text(line);
            case "Variable":
                return new Variable(line);
            case "Date":
                return new Date(line);
            case "ProcPage":
                return new ProcPage(line);
            case "ProcPageOfPages":
                return new ProcPage(line);
            case "Rect":
                return new Rect(line);
            case "Image":
                return new Image(line);
            case "Frame":
                return new Frame(line);
            case "Block":
                return new Block(line);
            case "Field":
                return new Field(line);
            case "End":
                return new End(line);
            case "Script":
                return new Script(line);
            case "ScriptLine":
                return new ScriptLine(line);
            case "Overlay":
                return new Overlay(line);
            case "Line":
                return new Line(line);
            default:
                return null;
        }
    }
}
