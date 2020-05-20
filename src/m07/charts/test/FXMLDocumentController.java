/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m07.charts.test;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javax.persistence.EntityManagerFactory;
import m07.DAO.ActorDAO;
import m07.DAO.DAO;
import m07.entitats.Actor;


/**
 *
 * @author rvallez
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @FXML
    private void buscarAction(ActionEvent event) {
        System.out.println("You clicked me!");
        
        //Exemple accès a una taula
        EntityManagerFactory emf = DAO.getEntityManagerFactory();
        ActorDAO actorDao = new ActorDAO(emf);
        List<Actor> actorList = actorDao.findActor();

        for(Actor actor : actorList ){
            System.out.println(actor.getFirstName() + " - " + actor.getLastName());
        }

    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
