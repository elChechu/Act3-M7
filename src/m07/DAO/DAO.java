/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m07.DAO;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author rvallez
 */
public class DAO {
    
    private static EntityManagerFactory emf;
    
    private static final String PERSISTENCE_UNIT = "sakila-ferreria";
    
    public static EntityManagerFactory getEntityManagerFactory() {
        if( (emf == null ) || !emf.isOpen()) {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        }
        return emf;
    }

    public static void close() {
        if(emf.isOpen()) {
            emf.close();
        }
    }
    
}
