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
import javafx.scene.control.CheckBox;

/**
 * FXML Controller class
 *
 * @author asifk
 */
public class MonitoringProjectProgressController implements Initializable {

    @FXML
    private CheckBox placeAvailableCB;
    @FXML
    private CheckBox approvedByHRCB;
    @FXML
    private CheckBox approvedByFmCB;
    @FXML
    private CheckBox milestoneAchivedCB;
    @FXML
    private CheckBox budgetOnTrackCB;
    @FXML
    private CheckBox scheduleMetCB;
    @FXML
    private CheckBox deliverablesCompletedCB;
    @FXML
    private Button doneProject;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void doneProjectButtonMouseOnClicked(ActionEvent event) {
    }
    
}
