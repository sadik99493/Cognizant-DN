package org.example.Factories;

import org.example.Documents.WordDocument;
import org.example.Documents.document;

public class WordFactory extends DocumentFactory {
    @Override
    public document createDoc() {
        return new WordDocument();
    }
}
