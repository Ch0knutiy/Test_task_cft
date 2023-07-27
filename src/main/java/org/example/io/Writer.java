package org.example.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    FileWriter writer;
    public Writer(File file) {
        try {
            writer = new FileWriter(file);
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void write(String str){
        if (str == null)
            return;
        try{
            writer.write(str + "\n");
            writer.flush();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
