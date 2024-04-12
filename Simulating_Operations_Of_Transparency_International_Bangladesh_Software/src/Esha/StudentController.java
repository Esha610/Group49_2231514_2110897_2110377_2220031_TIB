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
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class StudentController implements Initializable {

    @FXML
    private Button logout;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private void mentorsButtonClicked(ActionEvent event) {
        loadScene("/Esha/requestingmentorship.fxml", event);
        
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

    @FXML
    private void volunteerButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void requestingMentorshipButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void reportingIncidentButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void TransferRequestsButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void sendingFeedbacksButtonOnClick(ActionEvent event) {
    }

    
    @FXML
    private void LogoutButtonOnClick(ActionEvent event) {
    }    
    
    
    
    
    
}
