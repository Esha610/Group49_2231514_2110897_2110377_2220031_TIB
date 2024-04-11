package Shanto;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TransferRequestsController implements Initializable {

    @FXML    private ListView<String> transferRequestsListView;
    @FXML    private ListView<String> requestListView; 

    private ObservableList<String> transferRequests = FXCollections.observableArrayList(); 

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        transferRequestsListView.setItems(transferRequests);
    }    

    @FXML
    private void exitApplication(ActionEvent event) {   
        System.exit(0);
    }

    @FXML
    private void approveRequest(ActionEvent event) {
        String selectedRequest = transferRequestsListView.getSelectionModel().getSelectedItem();
        if (selectedRequest != null) {
            showAlert(Alert.AlertType.INFORMATION, "Request Approved", "Transfer request approved successfully.");
            transferRequestsListView.getItems().remove(selectedRequest);
            requestListView.getItems().add(selectedRequest + " - Approved");
        } else {
            showAlert(Alert.AlertType.ERROR, "Error", "Please select a transfer request to approve.");
        }
    }

    @FXML
    private void disapproveRequest(ActionEvent event) {    
        String selectedRequest = transferRequestsListView.getSelectionModel().getSelectedItem();
        if (selectedRequest != null) {
            showAlert(Alert.AlertType.INFORMATION, "Request Disapproved", "Transfer request disapproved.");
            transferRequestsListView.getItems().remove(selectedRequest);
            requestListView.getItems().add(selectedRequest + " - Disapproved");
        } else {
            showAlert(Alert.AlertType.ERROR, "Error", "Please select a transfer request to disapprove.");
        }
    }


    @FXML
    private void viewAllTransferRequests(ActionEvent event) {
        transferRequestsListView.setItems(transferRequests); 
        transferRequests.addAll(
            "Employee Transfer from Marketing Department to Sales Department",
            "Transfer Request for Relocation to Another Branch",
            "Transfer Request due to Family Relocation",
            "Employee Transfer from Customer Service to Human Resources",
            "Internal Transfer Request for Career Growth",
            "Interdepartmental Transfer Request for Project Assignment",
            "Transfer Request to Work in a Different City",
            "Employee Transfer from IT Department to Finance Department",
            "Transfer Request for Job Rotation Opportunity",
            "Transfer Request due to Commute Distance"
        );
    }


    @FXML
    private void logout(ActionEvent event) {
        loadScene("/mainpkg/LoginSc.fxml", event);
    }

    @FXML
    private void goBack(ActionEvent event) {
        loadScene("/Shanto/ExecutiveDirector.fxml", event);
    }

    private void loadScene(String fxmlFile, ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        try {
            AnchorPane root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
