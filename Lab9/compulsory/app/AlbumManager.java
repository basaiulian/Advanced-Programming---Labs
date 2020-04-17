package main.java.app;

import com.github.javafaker.Faker;
import entity.Albums;
import entity.Artists;
import main.java.repo.AlbumRepository;
import main.java.repo.ArtistRepository;


public class AlbumManager {

    public static void main(String[] args) {
        ArtistRepository artistRepository = new ArtistRepository();
        Artists artist = new Artists();
        artist.setCountry(Faker.instance().country().name());
        artist.setName(Faker.instance().name().lastName());
        String artistName = artist.getName();

        //[Artists]
        //create, findById, findByName
        artistRepository.create(artist);
        System.out.println("\nArtist with ID 40: " + artistRepository.findById(40).getName() + "\n");
        System.out.println("Created artist:   NAME: " + artist.getName() + "  ||  ID: " + artistRepository.findByName(artistName).get(0).getId() + "\n");

        AlbumRepository albumRepository = new AlbumRepository();
        Albums album = new Albums();
        album.setArtistId(artistRepository.findByName(artistName).get(0).getId());
        album.setName(Faker.instance().book().title());
        album.setReleaseYear(Faker.instance().number().numberBetween(1900, 2020));

        //[Albums]
        //create, findById, findByName, findByArtist
        albumRepository.create(album);
        System.out.println("\nAlbum with ID 20: " + albumRepository.findById(20).getName());
        System.out.println("\nAlbums with some name: ");
        albumRepository.printList(albumRepository.findByName("Gone with the Wind"));
        System.out.println("\nAlbums of some artis: ");
        albumRepository.printList(albumRepository.findByArtist(100));


    }
}
