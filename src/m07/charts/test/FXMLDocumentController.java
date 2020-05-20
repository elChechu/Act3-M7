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
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
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
        label.setText("Hello World!");
    }

    @FXML
    private void buscarAction(ActionEvent event) {
        System.out.println("You clicked me!");
        newWindow();
       

        //Exemple accès a taula actors
        EntityManagerFactory emf = DAO.getEntityManagerFactory();
        ActorDAO actorDao = new ActorDAO(emf);
        List<Actor> actorList = actorDao.findActor();

        actorList.forEach((actor) -> {
            System.out.println(actor.getFirstName() + " - " + actor.getLastName());
        });

    }

    
    
    private void newWindow(){
    
        Label secondLabel = new Label("Chart result");

        StackPane secondaryLayout = new StackPane();
        secondaryLayout.getChildren().add(secondLabel);

        Scene secondScene = new Scene(secondaryLayout, 230, 100);
        
        Stage newWindow = new Stage();
        newWindow.setTitle("Query result chart");
        newWindow.setScene(secondScene);
        newWindow.setX(800);
        newWindow.setY(400);
        newWindow.show();
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
