package com.ecodocx.poconverter;

import com.ecodocx.poconverter.elements.BaseElement;
import com.ecodocx.poconverter.elements.BaseElementToXmlVisitor;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

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
                processModel(model);

            } catch (InvalidPathException e) {
                System.err.println("Argument" + args[0] + " invalid path");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }else
            System.err.println("Argument must be path to process file");
    }

    private static void processModel(BaseElement model) {
        BaseElementToXmlVisitor xmlvisitor = new BaseElementToXmlVisitor();
        model.accept(xmlvisitor);
    }
}
