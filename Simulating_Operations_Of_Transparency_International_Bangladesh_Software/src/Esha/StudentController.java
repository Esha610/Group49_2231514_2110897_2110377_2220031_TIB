/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Esha;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mumta
 */
public class StudentController implements Initializable {

    @FXML
    private BorderPane borderPane;
    @FXML
    private MenuBar menuBar;
    @FXML
    private Menu extrasMenu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void researchMaterialsMenuItemClicked(ActionEvent event) {
    }

    @FXML
    private void reportIncidentMenuItemClicked(ActionEvent event) {
    }

    @FXML
    private void sendFeedbackMenuItemClicked(ActionEvent event) {
    }

    @FXML
    private void mentorsButtonClicked(ActionEvent event) {
            loadScene("/Esha/requestingmentorship.fxml", event);
        
    }

    @FXML
    private void volunteersButtonClicked(ActionEvent event) {
    }

    @FXML
    private void workshopButtonClicked(ActionEvent event) {
    }

    @FXML
    private void logoutButtonClicked(ActionEvent event) {
    }

    
    private void loadScene(String fxmlFile, ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        try {
            AnchorPane root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }    
    
    
    
    
    
}
