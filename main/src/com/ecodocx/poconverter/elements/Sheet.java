package com.ecodocx.poconverter.elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;

/**
 * Created by Roman on 8/9/2016.
 */
public class Sheet extends BaseElement {

    Matcher matcher;

    private float width;
    private float height;
    private boolean repeat = false;
    private float cpi;
    private float lpi;
    private String scriptId;
    List<String> allMatches = new ArrayList<String>();

    public Sheet(String line) {
        super(line);

        //String regex2 = new String("Sheet W (\"[^\"]*\"|[^ ]*) H ([^ ]*) ([^ ]*) CPI ([^ ]*) LPI ([^ ]*)");
        // Sheet W 215.900 H 279.400 CPI 10.00 LPI 10.00 ScriptBefore 4
        Scanner sc = new Scanner(line).useDelimiter("\\s");
        while (sc.hasNext()) {
            allMatches.add(sc.next());
        }
        width = Float.parseFloat(getValueByKey("W"));
        height = Float.parseFloat(getValueByKey("H"));
        if (allMatches.contains("Repeat"))
            repeat = true;
        cpi = Float.parseFloat(getValueByKey("CPI"));
        lpi = Float.parseFloat(getValueByKey("LPI"));
        scriptId = getValueByKey("ScriptBefore");
    }

    String getValueByKey(String key) {
        int keyIndex = allMatches.indexOf(key);
        if (keyIndex >= 0)
            return allMatches.get(keyIndex + 1);
        else
            return "0";
    }
    @Override
    public void accept(BaseElementVisitor visitor) {
        visitor.visit(this);
        for(BaseElement element: this.childrenList){
            element.accept(visitor);
        }
    }

    @Override
    public void addChild(BaseElement childElement) {
        childrenList.add(childElement);
    }

    public static void main(String args[]) {
        Sheet sheet = new Sheet("Sheet W 215.900 H 279.400 Repeat CPI 10.00 LPI 6.00 ScriptBefore 4");
        sheet.getType();
    }
}
