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
import m07.entitats.Film;

/**
 *
 * @author rvallez
 */
public class FilmDAO {
    private EntityManagerFactory emf = null;

    public FilmDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public List<Film> findFilm() {
        EntityManager em = getEntityManager();

        try {
            Query q = em.createNamedQuery("Film.findAll", Film.class);
            return q.getResultList();

        } finally {
            em.close();
        }
    }
    
    public Film findById(int filmId) {
        EntityManager em = getEntityManager();

        try {
            Query q = em.createNamedQuery("Film.findById", Film.class);
            q.setParameter("filmId", filmId);
            return ((Film) q.getSingleResult());

        } finally {
            em.close();
        }
    }
    
    public Film findFilm(String title) {
        EntityManager em = getEntityManager();

        try {
            Query query = em.createNamedQuery("Film.findByTitle", Film.class
            );
            query.setParameter("title", title);
            return (Film) query.getSingleResult();

        } finally {
            em.close();
        }
    }
        
}
