/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Esha;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author mumta
 */
public class ResearcherrController implements Initializable {

    @FXML
    private BorderPane borderPane;
    @FXML
    private MenuBar menuBar;
    @FXML
    private MenuItem uploadResearchMenuItem;
    @FXML
    private MenuItem evaluationMenuItem;
    @FXML
    private MenuItem deleteMenuItem;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox vBox;
    @FXML
    private HBox menteesHBox;
    @FXML
    private Button menteesButton;
    @FXML
    private HBox reportsHBox;
    @FXML
    private Button reportsButton;
    @FXML
    private HBox workshopHBox;
    @FXML
    private Button workshopButton;
    @FXML
    private HBox logoutHBox;
    @FXML
    private Button logoutButton;
    @FXML
    private TabPane tabPane;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
}
