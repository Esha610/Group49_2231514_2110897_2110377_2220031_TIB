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
public class FinanceAndAdministrationManagerController implements Initializable {

    @FXML
    private Button logout;
    @FXML
    private Button financialManagement;
    @FXML
    private Button procurementManagement;
    @FXML
    private Button financialReporting;
    @FXML
    private Button financialRegulations;
    @FXML
    private Button theEffectsofAdministrative;
    @FXML
    private Button strategicPlanningofFinance;
    @FXML
    private Button internalControlsEnhancement;
    @FXML
    private Button financialTrainingandCapacityBuilding;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void LogoutButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void financialManagementButtonMouseOnClicked(ActionEvent event) {
        loadScene("/Alif/FinancialManagement.fxml", event);
    }

    @FXML
    private void procurementManagementButtonMouseOnClicked(ActionEvent event) {
        loadScene("/Alif/ProcurementManagement.fxml", event);
    }

    @FXML
    private void financialReportingButtonMouseOnClicked(ActionEvent event) {
        loadScene("/Alif/FinancialReporting.fxml", event);
    }

    @FXML
    private void financialRegulationsButtonMouseOnClicked(ActionEvent event) {
        loadScene("/Alif/FinancialRegulations.fxml", event);
    }

    @FXML
    private void theEffectsofAdministrativeButtonMouseOnClicked(ActionEvent event) {
        loadScene("/Alif/TheEffectsOfAdministrative.fxml", event);
    }

    @FXML
    private void strategicPlanningofFinanceButtonMouseOnClicked(ActionEvent event) {
        loadScene("/Alif/StrategicPlanningOfFinance.fxml", event);
    }

    @FXML
    private void internalControlsEnhancementButtonMouseOnClicked(ActionEvent event) {
        loadScene("/Alif/InternalControlsEnhancement.fxml", event);
        
    }

    @FXML
    private void financialTrainingandCapacityBuildingButtonMouseOnClicked(ActionEvent event) {
        loadScene("/Alif/FinancialTraining.fxml", event);
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
