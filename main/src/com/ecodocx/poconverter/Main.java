package com.ecodocx.poconverter;

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
                Parser parser = new Parser(Files.newBufferedReader(Paths.get(args[1]), Charset.defaultCharset()));
                parser.start();

            } catch (InvalidPathException e) {
                System.err.println("Argument" + args[0] + " invalid path");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                System.exit(1);
            }
        } else
            System.err.println("Argument must be path to process file");
    }
}
