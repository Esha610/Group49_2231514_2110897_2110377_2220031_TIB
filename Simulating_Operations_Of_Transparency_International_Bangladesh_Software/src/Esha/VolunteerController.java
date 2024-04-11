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
import javafx.scene.control.ChoiceBox;

/**
 * FXML Controller class
 *
 * @author mumta
 */
public class VolunteerController implements Initializable {

    @FXML
    private ChoiceBox<?> timingChoiceBox;
    @FXML
    private Button submitButton;
    @FXML
    private ChoiceBox<?> campaignAreaChoiceBox;
    @FXML
    private ChoiceBox<?> fieldOfActivityChoiceBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void submitForm(ActionEvent event) {
    }

    
}
