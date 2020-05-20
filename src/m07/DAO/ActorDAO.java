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
import m07.entitats.Actor;

/**
 *
 * @author rvallez
 */
public class ActorDAO {
    private EntityManagerFactory emf = null;

    public ActorDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public List<Actor> findActor() {
        EntityManager em = getEntityManager();

        try {
            Query q = em.createNamedQuery("Actor.findAll", Actor.class
            );
            return q.getResultList();

        } finally {
            em.close();
        }
    }
    
    public Actor find(int actorId) {
        EntityManager em = getEntityManager();

        try {
            Query q = em.createNamedQuery("Actor.find", Actor.class);
            q.setParameter("actorId", actorId);
            return ((Actor) q.getSingleResult());

        } finally {
            em.close();
        }
    }
    
     public List<Actor> findByName(String firstName) {
        EntityManager em = getEntityManager();

        try {
            Query q = em.createNamedQuery("Actor.findByName", Actor.class);
            q.setParameter("firstName", firstName);
            return q.getResultList();

        } finally {
            em.close();
        }
    }
}
