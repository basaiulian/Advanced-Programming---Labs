package main.java.repo;

import entity.Albums;
import main.java.util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

public class AlbumRepository {
    private EntityManagerFactory entityManagerFactory = PersistenceUtil.getInstance().getEntityManagerFactory();
    private List<Albums> albumList = new ArrayList<Albums>();

    public void create(Albums album) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(album);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Albums findById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Albums album = entityManager.find(Albums.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return album;
    }

    public List<Albums> findByName(String name) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            albumList = entityManager.createNamedQuery("Albums.findByName").setParameter("name", name).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        entityManager.close();
        return albumList;
    }

    public List<Albums> findByArtist(int artistId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        albumList = new ArrayList<Albums>();
        try {
            albumList = entityManager.createNamedQuery("Albums.findByArtist").setParameter("id", artistId).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        entityManager.close();
        return albumList;
    }

    public void printList(List<Albums> list) {
        for (Albums albums : list) {
            System.out.println("ID: " + albums.getId() + " | NAME: " + albums.getName() + " | RELEASE YEAR: " + albums.getReleaseYear());
        }
    }

}