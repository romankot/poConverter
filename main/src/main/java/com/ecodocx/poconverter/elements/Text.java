package com.ecodocx.poconverter.elements;

import com.ecodocx.poconverter.BaseElementVisitor;
import org.w3c.dom.Element;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Roman on 8/8/2016.
 */
public class Text extends BaseElement {

    public enum textAlignment {CENTER, LEFT, RIGHT;};
    private float h;
    private float w;
    private boolean autosize = false;
    String text;
    private float x;
    private float y;
    boolean flip = false;
    String fontName;
    int fontSize;
    private String alignment = textAlignment.LEFT.name();
    boolean wrapKeepSpace = false;
    private int textStyle;

    public Text(BaseElement parent, String line) {
        super(parent, line);
        List<String> words = new ArrayList<>();
        Scanner sc = new Scanner(line).useDelimiter("\\s");
        while (sc.hasNext()) {
            words.add(sc.next());
        }
        text = words.get(1);
        Pattern p = Pattern.compile("\"([^\"]*)\"");
        Matcher m = p.matcher(line);
        if (m.find()) {
            text = m.group(1);
        }
        x = Float.parseFloat(words.get(words.indexOf("X") + 1));
        y =  Float.parseFloat(words.get(words.indexOf("Y") + 1));
        if (words.contains("W")) {
            w = Float.parseFloat(words.get(words.indexOf("W") + 1));}
        else {
            autosize = true;
        }
        if (words.contains("H")) {
            h =  Float.parseFloat(words.get(words.indexOf("H") + 1));
        }
        if (words.contains("flip") ) {
            flip = true;
        }
        fontName = words.get(words.indexOf("Font") + 1);
        fontSize = Integer.parseInt(words.get(words.indexOf("Font") + 2));
        if (words.contains("Key") && words.contains("Center") ) {
            alignment = textAlignment.CENTER.toString();
        } else if (words.contains("Key") && words.contains("Right")){
            alignment = textAlignment.RIGHT.toString();
        }
        if (words.contains("WrapKeepSp") ) {
            wrapKeepSpace = true;
        }
    }

    @Override
    public void accept(BaseElementVisitor visitor, Element parentElement) {
        visitor.visit(this, parentElement);
    }
    public String getXinch() {
        if (getAlignment().equals(textAlignment.CENTER.toString())) {
            return String.valueOf((float) (x/25.4) - getTextWidthInch()/2);
        } else if (getAlignment().equals(textAlignment.RIGHT.toString())){
            return String.valueOf((float) (x/25.4) - getTextWidthInch());
        }
        return String.valueOf((float) (x/25.4));
    }

    public String getYinch() {
        return String.valueOf(y/25.4 - getTextHeightInch()/2);
    }

    public float getTextWidthInch() {
        if (autosize) {
            AffineTransform affinetransform = new AffineTransform();
            FontRenderContext frc = new FontRenderContext(affinetransform, true, true);
            Font font = new Font(getFont(), getTextStyle(), fontSize);
            float str = (float) (font.getStringBounds(text, frc).getWidth() / 72 + 0.02);
            return str;
        } else
            return (float) (w / 25.4 + 0.02);
    }
    public float getTextHeightInch() {
        if (autosize) {
            AffineTransform affinetransform = new AffineTransform();
            FontRenderContext frc = new FontRenderContext(affinetransform, true, true);
            Font font = new Font(getFont(), getTextStyle(), fontSize);
            return (float) (font.getStringBounds(text, frc).getHeight() / 72);
        }
        return (float) (h/25.4);

    }

    public String getFont() {
        return fontName.replace("\"", "").replace("_", " ");
    }

    public String getFontSize() {
        return String.valueOf(fontSize);
    }

    public String getText() {
        return text.replace("\"", "");
    }

    public String getAlignment() {
        return alignment;
    }

    public int getTextStyle() {
        if (getFont().contains("Bold")  ){
            return Font.BOLD;
        } else{
            return Font.PLAIN;
        }
    }
}
