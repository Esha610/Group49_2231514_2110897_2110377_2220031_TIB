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
 * @author User
 */
public class MenteesController implements Initializable {

    @FXML
    private ListView<?> studentListView;
    @FXML
    private ListView<?> menteeRequestListView;
    @FXML
    private TextArea menteeProfileTextArea;

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
    private void acceptMenteeRequest(ActionEvent event) {
    }

    @FXML
    private void declineMenteeRequest(ActionEvent event) {
    }

    @FXML
    private void setMeeting(ActionEvent event) {
    }
    
}
