	package com.hemebiotech.analytics;

	import java.io.IOException;
	import java.util.Map;


public class AnalyticsCounter {
	public static void main(String[] args) throws IOException {
		// first get input
		ISymptomReader reader = new FileSymptomReader("Project02Eclipse/symptoms.txt");

		try {
			Map<String, Integer> symptoms = reader.readSymptoms();

			for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
				System.out.println(entry.getKey() + ": " + entry.getValue());
			}
		}
	catch (IOException e) {
		System.err.println("Error reading symptoms: " + e.getMessage());
		}
	}
}
