package org.example;

import org.example.Documents.document;
import org.example.Factories.DocumentFactory;
import org.example.Factories.WordFactory;
import org.example.Factories.excelFactory;

import javax.swing.text.Document;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //creating a word factory
        DocumentFactory wordfact = new WordFactory();

        //generating a word doc from wordfact
        document wordDoc = wordfact.createDoc();

        //creating a word document
        wordDoc.create();

        //repeating the above process for creating excel doc
        DocumentFactory excelFact = new excelFactory();
        document excelDoc = excelFact.createDoc();
        excelDoc.create();
    }
}