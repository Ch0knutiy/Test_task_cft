package org.example.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.function.Function;

import static java.lang.Integer.parseInt;

public class Reader {
    private String value;
    private Scanner scanner;
    private boolean empty = false;
    private Function<String,Boolean> readCompare;
    private Function<String,Boolean> readVerify;
    public Reader(File file, boolean isString, boolean isReverse){
        try{
            scanner = new Scanner(file);
            if(scanner.hasNext())
                value = scanner.next();
            else{
                empty = true;
                scanner.close();
                System.out.println(file.getName() + " is empty");
            }
            if(isString) {
                readCompare = (String str) -> value.compareTo(str) > 0;
                readVerify = (String str) -> {
                    if (str.contains(" "))
                        return false;
                    if(isReverse)
                        return readCompare.apply(str);
                    else
                        return !readCompare.apply(str);
                };
            }
            else {
                readCompare = (String str) -> parseInt(value) > parseInt(str);
                readVerify = (String str) -> {
                    try{
                        if(isReverse)
                            return readCompare.apply(str);
                        else
                            return !readCompare.apply(str);
                    }
                    catch (NumberFormatException e){
                        return false;
                    }
                };
            }
        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
            empty = true;
        }
    }
    public void read(){
        while(true) {
            if (scanner.hasNext()) {
                String str = scanner.next();
                if(readVerify.apply(str)){
                    value = str;
                    break;
                }
            }
            else {
                empty = true;
                scanner.close();
                break;
            }
        }
    }

    public String getValue() {
        return value;
    }

    public boolean isEmpty() {
        return empty;
    }
}
