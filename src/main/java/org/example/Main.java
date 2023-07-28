package org.example;

import org.example.io.Reader;
import org.example.io.Writer;

import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        InputParser parser = new InputParser();
        if(!parser.parse(args)) {
            System.out.println("Invalid parameters passed");
            System.exit(1);
        }
        ArrayList<Reader> readers = new ArrayList<>();
        for(String fileName: parser.getInputFileNames()){
            readers.add(new Reader(new File(fileName), parser.isString(), parser.isReverse()));
        }
        Sorter sorter = new Sorter(new Writer(new File(parser.getOutFileName())),readers, parser.isString(), parser.isReverse());
        sorter.sort();
        System.exit(0);
    }
}