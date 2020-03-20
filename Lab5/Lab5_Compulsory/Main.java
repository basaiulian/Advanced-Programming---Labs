package com.company.lab5.compulsory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;


public class Main {
    public static void main(String args[]) throws IOException, URISyntaxException {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }

    private void testCreateSave() throws IOException {
        Catalog catalog =
                new Catalog("Java Resources", "d:/Facultate/catalog.ser");
        Document firstDocument = new Document("java1", "Java Course 1",
                "D:\\Facultate\\Anul II\\Semestrul II\\[JAVA]Programare Avansata\\Cursuri\\intro_slide_en.pdf");
        firstDocument.addTag("type", "Slides");
        catalog.add(firstDocument);
        Document secondDocument = new Document();

        secondDocument.setId("java5");
        secondDocument.setName("Java Course 5");
        secondDocument.setLocation("https://profs.info.uaic.ro/~acf/java/slides/en/exceptions_slide_en.pdf");
        secondDocument.addTag("type", "Slides");
        catalog.add(secondDocument);

        List<Document> documentList = catalog.getDocumentList();
        for (Document document : documentList) {
            System.out.println(document);
        }

        CatalogUtil.save(catalog);
        CatalogUtil.load("d:/Facultate/catalog.ser");
    }

    private void testLoadView() throws IOException, URISyntaxException {
        Catalog catalog = CatalogUtil.load("d:/Facultate/catalog.ser");
        Document doc = catalog.findById("java1");
        CatalogUtil.view(doc);
    }
}
