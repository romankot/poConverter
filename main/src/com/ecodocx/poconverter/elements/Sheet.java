package com.ecodocx.poconverter.elements;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Roman on 8/9/2016.
 */
public class Sheet extends BaseElement {

    private final String regex = "^Sheet W (\"[^\"]*\"|[^ ]*) H ([^ ]*) ([^ ]*) CPI ([^ ]*) LPI ([^ ]*)";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher;
    List<String> allMatches = new ArrayList<String>();

    private float width;
    private float height;
    private boolean repeat;
    private float cpi;
    private float lpi;
    private List<BaseElement> sheetChildren;

    public Sheet(String line) {
        super(line);
        matcher = pattern.matcher(line);
        while (matcher.find()) {
            allMatches.add(matcher.group());
        }
        width = Float.parseFloat(allMatches.get(0));
        height = Float.parseFloat(allMatches.get(1));
        repeat = Boolean.parseBoolean(allMatches.get(2));
        cpi = Float.parseFloat(allMatches.get(3));
        lpi = Float.parseFloat(allMatches.get(4));
    }

    @Override
    public void addChild(BaseElement childElement) {
        sheetChildren.add(childElement);
    }
}
