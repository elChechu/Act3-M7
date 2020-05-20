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
import m07.entitats.Category;

/**
 *
 * @author rvallez
 */
public class CategoryDAO {
    private EntityManagerFactory emf = null;

    public CategoryDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public List<Category> findAll() {
        EntityManager em = getEntityManager();

        try {
            Query q = em.createNamedQuery("Category.findAll", Category.class);
            return q.getResultList();

        } finally {
            em.close();
        }
    }
    
    public List<Category> findByName(String name) {
        EntityManager em = getEntityManager();

        try {
            Query q = em.createNamedQuery("Category.findByName", Category.class);
            q.setParameter("name", name);
            return q.getResultList();

        } finally {
            em.close();
        }
    }
    
}
