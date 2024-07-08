package com.saiful.input;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JSonInputTest {

    @Test
    void readInput() {
        JSonInput input = new JSonInput();
        List<From> result = input.readInput("graph.json");
        assertEquals(5, result.size());
    }
}