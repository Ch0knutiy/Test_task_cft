package org.example.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Reader {
    private String value;
    private Scanner scanner;
    private boolean empty = false;
    public Reader(File file){
        try{
            scanner = new Scanner(file);
            if(scanner.hasNext())
                value = scanner.next();
            else{
                empty = true;
                System.out.println(file.getName() + " is empty");
            }
        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
            empty = true;
        }
    }
    public void read(boolean isString, boolean isReverse){
        if(scanner.hasNext())
            value = scanner.next();
        else
            empty = true;
    }
}
