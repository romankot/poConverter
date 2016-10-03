package com.ecodocx.poconverter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Roman on 9/20/2016.
 */
public class EventElement {
    String line;
    String recordType = "";
    String name = "";
    String variable = "";
    Boolean keepSp = false;
    List<EventElement> childrenList = new ArrayList<>();
    protected String parent = null;

    public EventElement(String trimLine) {
        line = trimLine;
        List<String> words = new ArrayList<>();
        Scanner sc = new Scanner(line).useDelimiter("\\s");
        while (sc.hasNext()) {
            words.add(sc.next());
        }
        recordType = words.get(0);
        switch (recordType) {
            case "Root":
                name = words.get(2).replace("\"", "");
                break;
            case "Field":
                name = words.get(1).replace("\"", "");
                if (words.size() > 2) {
                    if (words.get(2).startsWith("$")) {
                        variable = words.get(2);
                    }
                }
                break;
            case "Block":
                name = words.get(1).replace("\"", "");
                break;
            case "End":
                break;
                default:

        }
        if (words.contains("Keepsp")) {
            keepSp = true;}

    }

    public static boolean isValid(String trimLine) {
        if (trimLine.startsWith("Root") || 
            trimLine.startsWith("Block") ||
            trimLine.startsWith("Field") ||
            trimLine.startsWith("End") ) {
            return true;}
        else 
            return false;
    }

    public void addChild(EventElement element){
        childrenList.add(element);
    }

    public boolean isComplex() {
        if (recordType.equals("Block") || recordType.equals("Root")) {
            return true;
        }
        return false;
    }

    public String getType() {
        return recordType;
    }

    public boolean isRoot() {
        return recordType.equals("Root");
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }
}
