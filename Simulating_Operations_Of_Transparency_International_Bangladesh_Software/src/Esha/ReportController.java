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
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author mumta
 */
public class ReportController implements Initializable {

    @FXML
    private ListView<?> hotlineReportsListView;
    @FXML
    private TextArea investigationDetailsTextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void goBack(ActionEvent event) {
    }

    @FXML
    private void exitApplication(ActionEvent event) {
    }

    @FXML
    private void investigateReports(ActionEvent event) {
    }

    @FXML
    private void clearInvestigation(ActionEvent event) {
    }
    
}
