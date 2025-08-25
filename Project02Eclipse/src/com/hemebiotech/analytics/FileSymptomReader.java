package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileSymptomReader implements ISymptomReader {
    private String filepath;

    public FileSymptomReader(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public Map<String, Integer> readSymptoms() throws IOException {
        Map<String, Integer> symptomCounts = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    symptomCounts.put(line, symptomCounts.getOrDefault(line, 0) + 1);
                }
            }
        }

        return symptomCounts;
    }
}
