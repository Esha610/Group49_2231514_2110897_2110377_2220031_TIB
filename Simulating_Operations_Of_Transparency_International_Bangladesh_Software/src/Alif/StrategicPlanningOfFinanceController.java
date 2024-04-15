/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Alif;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author asifk
 */
public class StrategicPlanningOfFinanceController implements Initializable {

    @FXML
    private TextField sponsorListTF;
    @FXML
    private TableView<?> sponsorListTV;
    @FXML
    private TableColumn<?, ?> sponsorListTC;
    @FXML
    private Button financialAnalysis;
    @FXML
    private Button scenarioPlanning;
    @FXML
    private Button scenarioProgress;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void financialAnalysisButtonMouseOnClicked(ActionEvent event) {
    }

    @FXML
    private void scenarioPlanningButtonMouseOnClicked(ActionEvent event) {
    }

    @FXML
    private void ScenarioProgressButtonMouseOnClicked(ActionEvent event) {
    }
    
}
