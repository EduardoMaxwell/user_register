package br.com.crud.cadastrojsf;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("jsf-PU");

    public static EntityManager createEntityManager() {
        return getFactory().createEntityManager();
    }

    private static EntityManagerFactory getFactory() {
        return factory;
    }
}
