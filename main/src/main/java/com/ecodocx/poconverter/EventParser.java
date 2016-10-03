package com.ecodocx.poconverter;


import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;

public class EventParser {
    EventElement root;
    private EventElement parent;
    private BufferedReader reader;
    private EventElement currElem;

    public EventParser(BufferedReader reader) {
        this.reader = reader;
    }

    public static void main(String arg[]) {
        try {
            Path pathTojsonEvent = Paths.get(arg[0]);
            EventParser eventParser = new EventParser(Files.newBufferedReader(pathTojsonEvent, Charset.defaultCharset()));
            EventElement eventmodel = eventParser.parse();

            Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
            System.out.print("var data = ");
            System.out.println(gson.toJson(eventmodel));

            try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("eventJson199A0.txt"), "utf-8"))) {
                writer.write("var data = ");
                writer.write(gson.toJson(eventmodel));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public EventElement parse() throws Exception {

        LinkedList stack = new LinkedList<>();

        String line;
        while ((line = reader.readLine()) != null) {
            if (EventElement.isValid(line.trim()) ) {
                currElem = new EventElement(line.trim());
                if (currElem.isRoot()) {
                    root = currElem;
                    stack.push(root);
                    parent = root;
                    currElem.setParent("null");
                    continue;
                }
                if (currElem.isComplex()) {
                    currElem.setParent(parent.getName());
                    stack.push(currElem);
                    parent.addChild(currElem);
                    parent = currElem;
                }
                else
                if (currElem.getType().equals("End")) { // ending complex object
                    stack.pop();
                    parent = (EventElement) stack.peek();
                }
                else { // just element. add as child
                    currElem.setParent(parent.getName());
                    parent.addChild(currElem);
                }
            }
        }
        return root;
    }
}