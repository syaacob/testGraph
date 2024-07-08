package com.saiful.input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputFile {
    private final String file;
    public InputFile(String file){
        this.file = file;
    }

    public List<String> readFile() {
        BufferedReader reader;
        List<String> output = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line != null){
                output.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return output;
    }


}
