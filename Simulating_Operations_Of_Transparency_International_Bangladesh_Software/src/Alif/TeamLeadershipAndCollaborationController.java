/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Alif;

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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author asifk
 */
public class TeamLeadershipAndCollaborationController implements Initializable {

    @FXML
    private TextField avalableMemberName;
    @FXML
    private Button addedList;
    @FXML
    private TableColumn<TLCDummy, String> availableMembersTC;
    @FXML
    private TableColumn<TLCDummy, String> emailTC;
    @FXML
    private TextField availableMemberEmail;
    @FXML
    private Button emailAvailablemembers;
    @FXML
    private Button createATeam;
    @FXML
    private TableView<TLCDummy> avalableMembersTV;
    
    ObservableList<TLCDummy> TableData = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        availableMembersTC.setCellValueFactory(new PropertyValueFactory<>("AvailableMembersName"));
        emailTC.setCellValueFactory(new PropertyValueFactory<>("EmailAddress"));
    }    

    @FXML
    private void addedListButtonMouseOnClicked(ActionEvent event) {
        TableData.add(new TLCDummy(avalableMemberName.getText(), availableMemberEmail.getText() ));
    }

    @FXML
    private void emailAvailablemembersButtonMouseOnClicked(ActionEvent event) {
    }

    @FXML
    private void createATeamButtonMouseOnClicked(ActionEvent event) {
        avalableMembersTV.setItems(TableData);
    }
    
}
