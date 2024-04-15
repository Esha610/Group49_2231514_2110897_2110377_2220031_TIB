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
public class TheEffectsOfAdministrativeController implements Initializable {

    @FXML
    private Button currentAdministrativeProcesses;
    @FXML
    private Button areasforImprovement;
    @FXML
    private Button technologicalSupport;
    @FXML
    private TextField contactListofTheDepartments;
    @FXML
    private TableView<?> listOfDepartments;
    @FXML
    private TableColumn<?, ?> nameOfTheDepartmentsTC;
    @FXML
    private TableColumn<?, ?> emailTC;
    @FXML
    private Button communicate;
    @FXML
    private Button okay;
    @FXML
    private TextField email;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void currentAdministrativeProcessesButtonMouseOnClicked(ActionEvent event) {
    }

    @FXML
    private void areasforImprovementButtonMouseOnClicked(ActionEvent event) {
    }

    @FXML
    private void technologicalSupportButtonMouseOnClicked(ActionEvent event) {
    }

    @FXML
    private void communicateButtonMouseOnClicked(ActionEvent event) {
    }

    @FXML
    private void OkayButtonMouseOnClicked(ActionEvent event) {
    }
    
}
