package org.example.Factories;


import org.example.Documents.excelDocument;
import org.example.Documents.document;

public class excelFactory extends DocumentFactory {
    @Override
    public document createDoc() {
        return new excelDocument();
    }
}
