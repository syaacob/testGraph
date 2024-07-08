package com.saiful.input;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class JSonInput {

    public List<From>  readInput(String fileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return List.of(objectMapper.readValue(new FileInputStream(fileName), From[].class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Train> readTrainInput(String fileName){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return List.of(objectMapper.readValue(new FileInputStream(fileName), Train[].class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Package> readPackageInput(String fileName){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return List.of(objectMapper.readValue(new FileInputStream(fileName), Package[].class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
