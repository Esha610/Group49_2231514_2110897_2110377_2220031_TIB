/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Alif;

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

/**
 * FXML Controller class
 *
 * @author asifk
 */
public class ProcurementManagementController implements Initializable {

    @FXML
    private Button requirementSpecification;
    @FXML
    private Button performanceMonitoring;
    @FXML
    private Button contractNegotiation;
    @FXML
    private Button relationshipBuilding;
    @FXML
    private Button back;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void requirementSpecificationButtonMouseOnClicked(ActionEvent event) {
    }

    @FXML
    private void performanceMonitoringButtonMouseOnClicked(ActionEvent event) {
    }

    @FXML
    private void contractNegotiationButtonMouseOnClicked(ActionEvent event) {
    }

    @FXML
    private void relationshipBuildingButtonMouseOnClicked(ActionEvent event) {
    }

    @FXML
    private void backButtonMouseOnClicked(ActionEvent event) {
        loadScene("/Alif/FinanceAndAdministrationManager.fxml", event);
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
