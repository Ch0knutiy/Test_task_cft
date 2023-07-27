package org.example;

import org.example.io.Reader;
import org.example.io.Writer;

import java.util.ArrayList;
import java.util.function.Function;

public class Sorter {
    private Writer writer;
    private ArrayList<Reader> readers;
    private boolean isString;
    private boolean isReverse;
    private Function<ArrayList<Reader>,Reader> compare;

}
