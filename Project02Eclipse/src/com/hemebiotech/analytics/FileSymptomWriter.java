package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class FileSymptomWriter implements ISymptomWriter {

    private String filepath;

    public FileSymptomWriter(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) throws IOException {
        // Sort the symptoms alphabetically
        Map<String, Integer> sortedSymptoms = new TreeMap<>(symptoms);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
            for (Map.Entry<String, Integer> entry : sortedSymptoms.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue());
                writer.newLine();
            }
        }
    }
}
