package main.java.repo;

import entity.Artists;
import main.java.util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

public class ArtistRepository {
    private List<Artists> artistList = new ArrayList<Artists>();
    private EntityManagerFactory entityManagerFactory = PersistenceUtil.getInstance().getEntityManagerFactory();

    public void create(Artists artist) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(artist);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Artists findById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Artists artist = entityManager.find(Artists.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return artist;
    }

    public List<Artists> findByName(String name) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            artistList = entityManager.createNamedQuery("Artists.findByName").setParameter("name", name).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        entityManager.close();
        return artistList;
    }
}