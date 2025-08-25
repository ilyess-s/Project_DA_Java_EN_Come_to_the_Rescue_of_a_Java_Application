package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class FileSymptomWriter implements ISymptomWriter {
    private String filepath;

    public FileSymptomWriter(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) throws IOException {
        try (FileWriter writer = new FileWriter(filepath)) {
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }
        }
    }
}
