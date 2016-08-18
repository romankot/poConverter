package com.ecodocx.poconverter.elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Roman on 8/10/2016.
 */
public class ProcPage extends BaseElement {

    float x;
    float y;
    boolean flip = false;
    String fontName;
    String fontSize;
    boolean wrapKeepSpace = false;

    public ProcPage(String line) {
        super(line);

        List<String> allMatches = new ArrayList<String>();
        Scanner sc = new Scanner(line).useDelimiter("\\s");
        while (sc.hasNext()) {
            allMatches.add(sc.next());
        }
        x = Float.parseFloat(allMatches.get(2));
        y =  Float.parseFloat(allMatches.get(4));
        if (allMatches.get(5).equals("flip") )
            flip = true;
        fontName = allMatches.get(7);
        fontSize = allMatches.get(8);
        if (line.contains("WrapKeepSp") )
            wrapKeepSpace = true;
    }
    public static void main(String args[]) {
        ProcPage ppage = new ProcPage("ProcPage X 188.32 Y 33.54 flip Font \"Arial\" 10 Cp \"Ansi\" WrapKeepSp");
        ppage.getType();
    }
}
