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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author asifk
 */
public class ProgramManagementController implements Initializable {

    @FXML
    private Button projectSummary;
    @FXML
    private Button taskList;
    @FXML
    private Button completedWork;
    @FXML
    private TextField searchTF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void projectSummaryButtonMouseOnClicked(ActionEvent event) {
    }

    @FXML
    private void taskListButtonMouseOnClicked(ActionEvent event) {
    }

    @FXML
    private void completedWorkButtonMouseOnClicked(ActionEvent event) {
    }
    
}
