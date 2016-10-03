package com.ecodocx.poconverter;

import com.ecodocx.poconverter.elements.*;

/**
 * Created by Roman on 8/9/2016.
 */
public class Factory {

    public static BaseElement makeElement(BaseElement parent, String line, boolean isScript)
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
                return new Sheet(parent, line);
            case "Text":
                return new Text(parent, line);
            case "Variable":
                return new Variable(parent, line);
            case "Date":
                return new Date(parent, line);
            case "ProcPage":
                return new ProcPage(parent, line);
            case "ProcPageOfPages":
                return new ProcPage(parent, line);
            case "Rect":
                return new Rect(parent, line);
            case "Image":
                return new Image(parent, line);
            case "Frame":
                return new Frame(parent, line);
            case "Block":
                return new Block(parent, line);
            case "FBlock":
                return new FBlock(parent, line);
            case "Field":
                return new Field(parent, line);
            case "End":
                return new End(parent, line);
            case "Script":
                return new Script(parent, line);
            case "ScriptLine":
                return new ScriptLine(parent, line);
            case "Overlay":
                return new Overlay(parent, line);
            case "Line":
                return new Line(parent, line);
            default:
                return null;
        }
    }
}
