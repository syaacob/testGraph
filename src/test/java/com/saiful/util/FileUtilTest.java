package com.saiful.util;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class FileUtilTest {

    @Test
    void listFilesInDir() {

        Set<String> results = FileUtil.listFilesInDir("input/sample2");
        assertEquals(3,results.size());
        System.out.println(results);
    }
}