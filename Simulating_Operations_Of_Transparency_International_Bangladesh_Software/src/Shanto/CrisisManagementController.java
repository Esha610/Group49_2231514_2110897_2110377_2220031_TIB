
package Shanto;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class CrisisManagementController implements Initializable {

    @FXML    private ListView<String> crisisTypesListView;
    @FXML    private TextArea responseActionsTextArea;

    // Initialize list if needed
    ObservableList<String> crisisTypes = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize the list here if needed
        crisisTypes.add("Natural Disasters");
        crisisTypes.add("Security Threats");
        crisisTypes.add("Reputational Crises");
        crisisTypesListView.setItems(crisisTypes);
    }

    @FXML
    private void exitApplication(ActionEvent event) {
        // Exit the application
        Platform.exit();
    }

    @FXML
    private void viewNaturalDisasters(ActionEvent event) {
        // Implement code to view natural disasters
        displayMessage("View Natural Disasters", "Viewing natural disasters...");
    }

    @FXML
    private void viewSecurityThreats(ActionEvent event) {
        // Implement code to view security threats
        displayMessage("View Security Threats", "Viewing security threats...");
    }

    @FXML
    private void viewReputationalCrises(ActionEvent event) {
        // Implement code to view reputational crises
        displayMessage("View Reputational Crises", "Viewing reputational crises...");
    }

    @FXML
    private void emergencyResponse(ActionEvent event) {
        // Implement code for emergency response
        displayMessage("Emergency Response", "Performing emergency response actions...");
    }

    @FXML
    private void communicationPlan(ActionEvent event) {
        // Implement code for communication plan
        displayMessage("Communication Plan", "Implementing communication plan...");
    }

    @FXML
    private void refreshCrisisTypes(ActionEvent event) {
        // Implement code to refresh crisis types
        displayMessage("Refresh Crisis Types", "Refreshing crisis types...");
    }

    @FXML
    private void refreshResponseActions(ActionEvent event) {
        // Implement code to refresh response actions
        displayMessage("Refresh Response Actions", "Refreshing response actions...");
    }

    // Helper method to display alert messages
    private void displayMessage(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void goBack(ActionEvent event) {
        // Implement code to navigate back to the previous screen
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PreviousScreen.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void logOut(ActionEvent event) {
       
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Logout");
        alert.setHeaderText(null);
        alert.setContentText("You have been logged out.");
        alert.showAndWait();       
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}
