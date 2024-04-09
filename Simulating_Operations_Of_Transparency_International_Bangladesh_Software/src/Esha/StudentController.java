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
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author mumta
 */
public class StudentController implements Initializable {

    @FXML
    private BorderPane borderPane;
    @FXML
    private MenuBar menuBar;
    @FXML
    private Menu extrasMenu;
    @FXML
    private MenuItem researchMaterialsMenuItem;
    @FXML
    private MenuItem reportIncidentMenuItem;
    @FXML
    private MenuItem sendFeedbackMenuItem;
    @FXML
    private Button mentorsButton;
    @FXML
    private Button volunteersButton;
    @FXML
    private Button workshopButton;
    @FXML
    private Button logoutButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void reportIncidentMenuItemClicked(ActionEvent event) {
    }
    
}
