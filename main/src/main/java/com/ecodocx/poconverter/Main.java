package com.ecodocx.poconverter;

import com.ecodocx.poconverter.elements.BaseElement;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.StringTokenizer;

/**
 * Created by Roman on 8/8/2016.
 */
public class Main {
    public static void main(String args[] ) {

        int firstArg;
        if (args.length > 0) {
            try {
                Parser parser = new Parser(Files.newBufferedReader(Paths.get(args[0]), Charset.defaultCharset()));
                BaseElement model = parser.getModel();
                String xatwFormPath = "./" + Paths.get(args[0]) + ".xatw";
                String eventName  = parseEventName(args[0]);
                BaseElementToXmlVisitor xmlvisitor = new BaseElementToXmlVisitor(eventName);
                model.accept(xmlvisitor, null);
                xmlvisitor.generate(xatwFormPath);
                System.out.println("made xatw form " + xatwFormPath);

                //Runtime.getRuntime().exec("cmd merge.exe");
                String dataFilePath = "C:\\Users\\Roman\\IdeaProjects\\poConverter\\outforMerge.xml";
                String commandLine = "cmd merge.exe " + "-form=" + xatwFormPath + " -data=" + dataFilePath + " -output=./1.pdf";
                Process p = Runtime.getRuntime().exec(commandLine);
                p.waitFor();
                BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
                String line;
                while((line = reader.readLine()) != null) {
                    System.out.println(line);
                }

            } catch (InvalidPathException e) {
                System.err.println("Argument" + args[0] + " invalid path");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }else
            System.err.println("Argument must be path to process file");
    }

    private static String parseEventName(String arg) {
        String str = new File(arg).getName();

        StringTokenizer stringTokenizer = new StringTokenizer(str.substring(0, str.lastIndexOf('.')), "_");

        return stringTokenizer.nextToken();
    }
}
