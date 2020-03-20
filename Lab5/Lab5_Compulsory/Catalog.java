package com.company.lab5.compulsory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    private String name;
    private String path;
    private List<Document> documentList;

    public Catalog() {
        documentList = new ArrayList<>();
    }

    public Catalog(String name, String path) {
        this.name = name;
        this.path = path;
        documentList = new ArrayList<>();
    }

    public Catalog(String name, String path, List<Document> documentList) {
        this.name = name;
        this.path = path;
        this.documentList = documentList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<Document> getDocumentList() {
        return documentList;
    }

    public void setDocumentList(List<Document> documentList) {
        this.documentList = documentList;
    }

    //…
    public void add(Document doc) {
        documentList.add(doc);
    }

    public Document findById(String id) {
        Document documentById = documentList.stream()
                .filter(documents -> documents.getId().equals(id))
                .findAny()
                .orElse(null);
        return documentById;
    }
}