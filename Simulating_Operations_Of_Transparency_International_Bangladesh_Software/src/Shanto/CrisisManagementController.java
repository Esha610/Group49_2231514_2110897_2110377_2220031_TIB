
package Shanto;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class CrisisManagementController implements Initializable {

    @FXML    private ListView<String> crisisTypesListView;
    @FXML    private TextArea responseActionsTextArea;

   
    ObservableList<String> crisisTypes = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        crisisTypes.add("Natural Disasters");
        crisisTypes.add("Security Threats");
        crisisTypes.add("Reputational Crises");
        crisisTypesListView.setItems(crisisTypes);
    }

    @FXML
    private void exitApplication(ActionEvent event) {
       
        Platform.exit();
    }

    @FXML
    private void viewNaturalDisasters(ActionEvent event) {
       
        displayMessage("View Natural Disasters", "Viewing natural disasters...");
    }

    @FXML
    private void viewSecurityThreats(ActionEvent event) {
      
        displayMessage("View Security Threats", "Viewing security threats...");
    }

    @FXML
    private void viewReputationalCrises(ActionEvent event) {
       
        displayMessage("View Reputational Crises", "Viewing reputational crises...");
    }

    @FXML
    private void emergencyResponse(ActionEvent event) {
      
        displayMessage("Emergency Response", "Performing emergency response actions...");
    }

    @FXML
    private void communicationPlan(ActionEvent event) {
      
        displayMessage("Communication Plan", "Implementing communication plan...");
    }

    @FXML
    private void refreshCrisisTypes(ActionEvent event) {
        
        displayMessage("Refresh Crisis Types", "Refreshing crisis types...");
    }

    @FXML
    private void refreshResponseActions(ActionEvent event) {
       
        displayMessage("Refresh Response Actions", "Refreshing response actions...");
    }

    
    private void displayMessage(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
