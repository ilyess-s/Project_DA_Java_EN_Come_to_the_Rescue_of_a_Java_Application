	package com.hemebiotech.analytics;

	import java.io.IOException;
	import java.util.Map;


public class AnalyticsCounter {
	public static void main(String[] args) throws IOException {
		//Read symptoms from file
		ISymptomReader reader = new FileSymptomReader("Project02Eclipse/symptoms.txt");
		try {
			Map<String, Integer> symptoms = reader.readSymptoms();
			//Initialize counters
		 	int headacheCount = 0;
		 	int rashCount = 0;
		 	int pupilCount = 0;

			 //scans the file for iterations and the 3 symptoms above
			for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
				System.out.println(entry.getKey() + ": " + entry.getValue());

			String symptom = entry.getKey();
			int count = entry.getValue();

			if (symptom.equalsIgnoreCase("headache")) {
				headacheCount += count;
			} else if (symptom.equalsIgnoreCase("rash")) {
				rashCount += count;
			} else if (symptom.equalsIgnoreCase("dilated pupils")) {
				pupilCount += count;
			}
		}
		System.out.println("Headache count: " + headacheCount);
		System.out.println("Rash count: " + rashCount);
		System.out.println("Dilated pupils count: " + pupilCount);

		//Writes the aforementioned symptoms into a file
		ISymptomWriter writer = new FileSymptomWriter("Project02Eclipse/results.out");
		writer.writeSymptoms((symptoms));

		//confirms that the file has been successfully written
		System.out.println("Symptoms successfully written to results.out");

	} catch (IOException e) {
		System.err.println("Error reading symptoms: " + e.getMessage());
		}
	}

	public Map<String, Integer> countSymptoms(ISymptomReader reader) throws IOException {
		return reader.readSymptoms(); // Appel à l'interface ISymptomReader pour obtenir les symptômes
	}

	public void writeSymptoms(Map<String, Integer> symptomCounts, ISymptomWriter writer) throws IOException {
		writer.writeSymptoms(symptomCounts); // Appel à l'interface ISymptomWriter pour écrire les symptômes
	}
}
