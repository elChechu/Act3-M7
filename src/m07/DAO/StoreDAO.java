/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m07.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import m07.entitats.Store;

/**
 *
 * @author rvallez
 */
public class StoreDAO {
    private EntityManagerFactory emf = null;

    public StoreDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public List<Store> findStore() {
        EntityManager em = getEntityManager();

        try {
            Query q = em.createNamedQuery("Store.findAll", Store.class);
            return q.getResultList();

        } finally {
            em.close();
        }
    }
    
    public Store findById(int storeId) {
        EntityManager em = getEntityManager();

        try {
            Query q = em.createNamedQuery("Store.findById", Store.class);
            q.setParameter("storeId", storeId);
            return ((Store) q.getSingleResult());

        } finally {
            em.close();
        }
    }
}
