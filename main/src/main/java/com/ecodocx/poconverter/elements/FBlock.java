package com.ecodocx.poconverter.elements;

import com.ecodocx.poconverter.BaseElementVisitor;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Roman on 8/22/2016.
 */
public class FBlock extends BaseElement {
    private String scriptBefore;
    private  String name;
    private  float yoffset = 0;
    private  float advY = 0;

    public FBlock(BaseElement parent, String line) {
        super(parent, line);
        List<String> words = new ArrayList<>();
        Scanner sc = new Scanner(line).useDelimiter("\\s");
        while (sc.hasNext()) {
            words.add(sc.next());
        }
        name = words.get(1);
        if (words.contains("YOffset")) {
            yoffset = Float.parseFloat(words.get(words.indexOf("YOffset") + 1));}
        if (words.contains("AdvY")) {
            advY = Float.parseFloat(words.get(words.indexOf("AdvY") + 1));}
        if (words.contains("ScriptBefore"))
            scriptBefore = words.get(words.indexOf("AdvY") + 1);
    }
    @Override
    public void accept(BaseElementVisitor visitor, Element parentElement) {
        parentElement = visitor.visit(this, parentElement);
        for(BaseElement element: this.childrenList){
            element.accept(visitor, parentElement);
        }
    }

    public String getName() {
        return name.replace("\"", "");
    }

    public float getYoffset() {
        return yoffset;
    }

    public float getAdvY() {
        return advY;
    }
}
