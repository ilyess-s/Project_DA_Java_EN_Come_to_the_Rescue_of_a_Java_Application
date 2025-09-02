package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        //Defile file path
        String inputFilePath = "Project02Eclipse/symptoms.txt";
        String outputFilePath = "Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/results.out";

        //Creates required objects
        ISymptomReader symptomReader = new FileSymptomReader(inputFilePath); // Lire à partir du fichier
        ISymptomWriter symptomWriter = new FileSymptomWriter(outputFilePath); // Écrire dans un autre fichier
        AnalyticsCounter analyticsCounter = new AnalyticsCounter(); // Instance pour traiter les données

        try {
            //read symptoms from file
            Map<String, Integer> symptomCounts = analyticsCounter.countSymptoms(symptomReader);

            //write symptoms to file
            analyticsCounter.writeSymptoms(symptomCounts, symptomWriter);

            // Message indiquant que le traitement est terminé
            System.out.println("Traitement terminé, les résultats ont été écrits dans " + outputFilePath);

        } catch (IOException e) {
            // Gérer les erreurs de lecture ou d'écriture
            System.err.println("Erreur lors du traitement des symptômes : " + e.getMessage());
        }
    }
}
