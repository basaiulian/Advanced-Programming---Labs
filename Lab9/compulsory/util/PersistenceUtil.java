package main.java.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtil {

    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MusicAlbumsPU");
    private static PersistenceUtil persistenceUtil;

    private PersistenceUtil() {
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    private void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        PersistenceUtil.entityManagerFactory = entityManagerFactory;
    }

    public static PersistenceUtil getInstance() {
        if (persistenceUtil != null) {
            return persistenceUtil;
        } else {
            persistenceUtil = new PersistenceUtil();
            persistenceUtil.setEntityManagerFactory(entityManagerFactory);
        }
        return persistenceUtil;
    }


}
