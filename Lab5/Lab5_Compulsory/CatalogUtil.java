package com.company.lab5.compulsory;

import java.net.URI;
import java.net.URISyntaxException;

import java.awt.*;
import java.io.*;

public class CatalogUtil {
    public static void save(Catalog catalog)
            throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Catalog load(String path)
            throws IOException {
        Catalog catalog = new Catalog();
        FileInputStream file = new FileInputStream(path);
        try (ObjectInputStream ois = new ObjectInputStream(file)) {
            catalog = (Catalog) ois.readObject();
            ois.close();
            file.close();
        } catch (IOException e) {
            System.out.println("IOException");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Catalog class not found");
            e.printStackTrace();
        }
        return catalog;
    }

    public static void view(Document doc) throws URISyntaxException, IOException {
        Desktop desktop = Desktop.getDesktop();
        if (doc.getLocation().contains("http://") || doc.getLocation().contains("https://")) {
            System.out.println("This is an URL.");
            URI uri = new URI(doc.getLocation());
            desktop.browse(uri);
        } else {
            System.out.println("This is a local file.");
            File file = new File(doc.getLocation());
            desktop.open(file);
        }
    }
}