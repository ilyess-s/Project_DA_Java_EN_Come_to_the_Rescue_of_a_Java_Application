	package com.hemebiotech.analytics;

	import java.io.BufferedReader;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;


	public class AnalyticsCounter {
		private static int headacheCount = 0;	// initialize to 0
		private static int rashCount = 0;		// initialize to 0
		private static int pupilCount = 0;		// initialize to 0

		public static void main(String[] args) throws IOException {
			// first get input
			try (BufferedReader reader = new BufferedReader(new FileReader("Project02Eclipse\\symptoms.txt"));
				 FileWriter writer = new FileWriter("result.out")) {
			String line = reader.readLine();

			int i = 0;	// set i to 0
			int headCount = 0;	// counts headaches
			while (line != null) {
				i++;	// increment i
				System.out.println("symptom from file: " + line);
				if (line.equals("headache")) {
					headacheCount++;
					System.out.println("number of headaches: " + headCount);
				}
				else if (line.equals("rash")) {
					rashCount++;
				}
				else if (line.equals("pupils")) {
					pupilCount++;
				}

				line = reader.readLine();	// get another symptom
			}

			writer.write("headache: " + headacheCount + "\n");
			writer.write("rash: " + rashCount + "\n");
			writer.write("dilated pupils: " + pupilCount + "\n");
		}
	}
}