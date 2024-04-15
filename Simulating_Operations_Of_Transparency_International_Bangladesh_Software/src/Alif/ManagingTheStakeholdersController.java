/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Alif;

import Alif.StakeholderDummy;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author asifk
 */
public class ManagingTheStakeholdersController implements Initializable {

    @FXML
    private TextField nameOfCompany;
    @FXML
    private TextField emailAddress;
    @FXML
    private TableColumn<StakeholderDummy, String> nameOfCompanyTC;
    @FXML
    private TableColumn<StakeholderDummy, String> emailAdressTC;
    @FXML
    private Button addANewerToTheList;
    @FXML
    private Button showTheList;
    @FXML
    private Button sendNow;
    @FXML
    private TableView<StakeholderDummy> stakeholdersTV;
    @FXML
    private TextArea feedbackTA;
    ObservableList<StakeholderDummy> TableData = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nameOfCompanyTC.setCellValueFactory(new PropertyValueFactory<>("NameOfCompany"));
        emailAdressTC.setCellValueFactory(new PropertyValueFactory<>("EmailAdress"));
        
        
    }    

    @FXML
    private void addANewerToTheListButtonMouseOnClicked(ActionEvent event) {
        TableData.add(new StakeholderDummy(nameOfCompany.getText(), emailAddress.getText() ));
    }

    @FXML
    private void showTheListButtonMouseOnClicked(ActionEvent event) {
        
        stakeholdersTV.setItems(TableData);
        
    }

    @FXML
    private void sendNowButtonMouseOnClicked(ActionEvent event) {
    }
    
}
