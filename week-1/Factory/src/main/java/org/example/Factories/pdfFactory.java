package org.example.Factories;

import org.example.Documents.document;
import org.example.Documents.PdfDocument;

public class pdfFactory extends DocumentFactory{

    @Override
    public document createDoc() {
        return new PdfDocument();
    }
}
