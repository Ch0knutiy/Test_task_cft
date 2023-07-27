package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class InputParser {
    private String outFileName;
    private ArrayList<String> inputFileNames;
    private boolean isString;
    private boolean isReverse;

    public InputParser(){
        isString = false;
        isReverse = false;
    }

    public boolean parse(String[] args){
        int argsCounter = 0;
        if(args.length >=3){
            for(int i = 0; i < 2; i++) {
                if (("-a".equalsIgnoreCase(args[argsCounter]) || "-d".equalsIgnoreCase(args[argsCounter])) && argsCounter == 0) {
                    if ("-d".equalsIgnoreCase(args[argsCounter])) {
                        isReverse = true;
                    }
                    argsCounter++;
                }
                else if ("-s".equalsIgnoreCase(args[argsCounter]) || "-i".equalsIgnoreCase(args[argsCounter])) {
                    if ("-s".equalsIgnoreCase(args[argsCounter])) {
                        isString = true;
                    }
                    argsCounter++;
                    if (argsCounter == 1)
                        break;
                }
                else return  false;
            }

            outFileName = args[argsCounter++];
            inputFileNames = new ArrayList<String>(Arrays.stream(args).toList().subList(argsCounter, args.length));
            return inputFileNames.size() >= 1;
        }
        else return false;
    }

    public String getOutFileName(){
        return outFileName;
    }

    public ArrayList<String> getInputFileNames() {
        return inputFileNames;
    }

    public boolean isReverse() {
        return isReverse;
    }

    public boolean isString() {
        return isString;
    }
}