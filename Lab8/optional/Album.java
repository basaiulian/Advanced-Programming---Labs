package com.company.lab8.compulsory;

import com.github.javafaker.Faker;

public class Album {
    private String albumName;
    private Integer artistId;
    private Integer releaseYear;
    private int listeners;

    public Album() {
        this.albumName="";
        this.artistId=null;
        this.releaseYear=null;
        this.listeners=0;
    }

    public Album(String name, Integer artistId, Integer releaseYear) {
        this.albumName = name;
        this.artistId = artistId;
        this.releaseYear = releaseYear;
    }

    public String getName() {
        return albumName;
    }

    public void setName(String name) {
        this.albumName = name;
    }

    public Integer getArtistId() {
        return artistId;
    }

    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Override
    public String toString() {
        return "Album{" +
                "albumName='" + albumName + '\'' +
                ", artistId=" + artistId +
                ", releaseYear=" + releaseYear +
                '}';
    }
}
