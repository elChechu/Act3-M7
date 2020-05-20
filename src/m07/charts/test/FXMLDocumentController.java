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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.persistence.EntityManagerFactory;
import m07.DAO.ActorDAO;
import m07.DAO.DAO;
import m07.DAO.FilmDAO;
import m07.entitats.Actor;
import m07.entitats.Film;

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
        
        EntityManagerFactory emf2 = DAO.getEntityManagerFactory();
        
        ActorDAO actorDao = new ActorDAO(emf);
        FilmDAO filmDao = new FilmDAO(emf2);
        List<Film> filmList = filmDao.findFilm();
        List<Actor> actorList = actorDao.findActor();

        actorList.forEach((actor) -> {
            System.out.println(actor.getFirstName() + " - " + actor.getLastName());
        });
        
        
        filmList.forEach((film) -> {
            System.out.println(film.getFilmId()  + " - " + film.getRating());
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
    
    private void circleTest(Stage stage){
         
        Scene scene = new Scene(new Group());
        stage.setTitle("Imported Fruits");
        stage.setWidth(500);
        stage.setHeight(500);
 
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data("Grapefruit", 13),
                new PieChart.Data("Oranges", 25),
                new PieChart.Data("Plums", 10), 
               new PieChart.Data("Pears", 22),
                new PieChart.Data("Apples", 30));
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Imported Fruits");

        ((Group) scene.getRoot()).getChildren().add(chart);
        stage.setScene(scene);
        stage.show();
    
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
