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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class ResearcherController implements Initializable {

    @FXML
    private Button logout;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @FXML
    private void menteesButtonOnClick(ActionEvent event) {
        loadScene("/Esha/mentees.fxml", event);
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
    private void monitoringReportsButtonOnClick(ActionEvent event) {
        loadScene("/Esha/monitoringreports.fxml", event);
    }

    @FXML
    private void hostingWorkshopsButtonOnClick(ActionEvent event) {
        loadScene("/Esha/hostingworkshops.fxml", event);
    }

    @FXML
    private void evaluationOfWorkshopsButtonOnClick(ActionEvent event) {
        loadScene("/Esha/evaluationofworkshops.fxml", event);
    }
    
    @FXML
    private void LogoutButtonOnClick(ActionEvent event) {
         loadScene("/mainpkg/LoginSc.fxml", event);
    }

    @FXML
    private void dataRepositoryButtonOnClick(ActionEvent event) {
          loadScene("/Esha/datarepository.fxml", event);
    }
    
}
