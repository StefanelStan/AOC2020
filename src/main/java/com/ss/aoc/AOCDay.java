package com.ss.aoc;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

public abstract class AOCDay {
    protected String testDataFilename;
    protected String dataFileName;

    abstract long task1(boolean isTest);

    abstract long task2(boolean isTest);

    protected List<String> getDataAsStringLines(boolean isTest) {
        try {
            return FileUtils.readLines(getFile(isTest), StandardCharsets.UTF_8);
        } catch (final IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    protected String getDataAsString(boolean isTest) {
        try {
            return FileUtils.readFileToString(getFile(isTest), StandardCharsets.UTF_8);
        } catch (final IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    private File getFile(boolean isTest) {
        String fileName = isTest ? "aoc/" + testDataFilename : "aoc/" + dataFileName;
        ClassLoader classLoader = this.getClass().getClassLoader();
        // Getting resource(File) from class loader
        return new File(classLoader.getResource(fileName).getFile());
    }
}
