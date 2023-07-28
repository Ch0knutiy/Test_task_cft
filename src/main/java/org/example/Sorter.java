package org.example;

import org.example.io.Reader;
import org.example.io.Writer;

import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.function.Function;

import static java.lang.Integer.parseInt;

public class Sorter {
    private final Writer writer;
    private final ArrayList<Reader> readers;
    private final BiFunction<Reader, Reader, Boolean> compare;
    private final Function<ArrayList<Reader>, Reader> toWrite;
    public  Sorter(Writer writer, ArrayList<Reader> readers, boolean isString, boolean isReverse){
        this.writer = writer;
        this.readers = readers;
        if (isString)
            compare = (Reader first, Reader second) -> first.getValue().compareTo(second.getValue()) > 0;
        else
            compare = (Reader first, Reader second) -> parseInt(first.getValue()) > parseInt(second.getValue());

        toWrite = (ArrayList<Reader> pool) ->{
            Reader res = pool.get(0);
            for(int i = 1; i < pool.size(); i++){
                if(isReverse) {
                    if (!compare.apply(res, pool.get(i)))
                        res = pool.get(i);
                }
                else {
                    if (compare.apply(res, pool.get(i)))
                        res = pool.get(i);
                }
            }
            return res;
        };
    }
    public void sort(){
        for(int i = 0; i < readers.size(); i++) {
            if(readers.get(i).isEmpty()) {
                readers.remove(i);
                i--;
            }
        }
        while(readers.size() > 0){
            Reader res = toWrite.apply(readers);
            writer.write(res.getValue());
            res.read();
            if(res.isEmpty())
                readers.remove(res);
        }
    }
}
