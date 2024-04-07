package Shanto;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class StakeholderEngagementController implements Initializable {

    @FXML
    private ListView<String> stakeholderListView;
    @FXML
    private TextField stakeholderNameField;
    @FXML
    private TextField stakeholderDescriptionArea;

    private ObservableList<String> stakeholderItems = FXCollections.observableArrayList();
    private StakeholderDescriptions stakeholderDescriptions = new StakeholderDescriptions();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        stakeholderListView.setItems(stakeholderItems);
    }

    @FXML
    private void exitApplication(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    private void viewAllStakeholders(ActionEvent event) {
        ArrayList<String> allStakeholders = new ArrayList<>();
        allStakeholders.add("Stakeholder 1");
        allStakeholders.add("Stakeholder 2");
        allStakeholders.add("Stakeholder 3");
        allStakeholders.add("Stakeholder 4");
        allStakeholders.add("Stakeholder 5");
        stakeholderItems.setAll(allStakeholders);
    }

    @FXML
    private void addNewStakeholder(ActionEvent event) {
        String newStakeholderName = stakeholderNameField.getText();
        String newStakeholderDescription = stakeholderDescriptionArea.getText();

        if (!newStakeholderName.isEmpty() && !newStakeholderDescription.isEmpty()) {
            stakeholderItems.add(newStakeholderName);
            stakeholderDescriptions.put(newStakeholderName, newStakeholderDescription);
            stakeholderNameField.clear();
            stakeholderDescriptionArea.clear();
        } else {
            showAlert(Alert.AlertType.ERROR, "Error", "Please enter both stakeholder name and description.");
        }
    }

    @FXML
    private void viewDescription(ActionEvent event) {
        String selectedStakeholder = stakeholderListView.getSelectionModel().getSelectedItem();
        if (selectedStakeholder != null) {
            String description = getDescription(selectedStakeholder);
            stakeholderDescriptionArea.setText(description);
        } else {
            showAlert(Alert.AlertType.ERROR, "Error", "Please select a stakeholder to view its description.");
        }
    }

    private String getDescription(String stakeholderName) {
        String description = stakeholderDescriptions.getDescription(stakeholderName);
        if (description != null) {
            return description;
        } else {
            return "No description available for " + stakeholderName;
        }
    }

    @FXML
    private void logout(ActionEvent event) {
        loadScene("/mainpkg/LoginSc.fxml", event);
    }

    @FXML
    private void goBack(ActionEvent event) {
        loadScene("/Shanto/SecretaryGeneral.fxml", event);
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
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
}
