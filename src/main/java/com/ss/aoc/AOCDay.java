package com.ss.aoc;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

public abstract class AOCDay {

    abstract long task1(boolean isTest);

    abstract long task2(boolean isTest);

    protected List<String> getDataAsStringLines(boolean isTest, String testFile, String liveFile) {
        try {
            return FileUtils.readLines(getFile(isTest, testFile, liveFile), StandardCharsets.UTF_8);
        } catch (final IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    protected String getDataAsString(boolean isTest, String testFile, String liveFile) {
        try {
            return FileUtils.readFileToString(getFile(isTest, testFile, liveFile), StandardCharsets.UTF_8);
        } catch (final IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    private File getFile(boolean isTest, String testFile, String liveFile) {
        String fileName = isTest ? "aoc/" + testFile : "aoc/" + liveFile;
        ClassLoader classLoader = this.getClass().getClassLoader();
        // Getting resource(File) from class loader
        return new File(classLoader.getResource(fileName).getFile());
    }
}
