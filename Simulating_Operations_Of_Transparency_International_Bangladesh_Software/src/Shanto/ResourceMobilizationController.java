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

public class ResourceMobilizationController implements Initializable {

    @FXML    private ListView<String> resourceListView;
    @FXML    private ListView<String> donorListView;
    @FXML    private TextField newResourceNameField;
    @FXML    private TextField newDonorNameField;

    private ObservableList<String> resources = FXCollections.observableArrayList();
    private ObservableList<String> donors = FXCollections.observableArrayList();

    private programDescriptions resourceDescriptions = new programDescriptions();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        resourceListView.setItems(resources);
        donorListView.setItems(donors);
    }

    @FXML
    private void exitApplication(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    private void viewAllResources(ActionEvent event) {
        ArrayList<String> allResources = new ArrayList<>();
        allResources.add("Solar Panels for Rural Electrification");
        allResources.add("Textbooks for Primary Education");
        allResources.add("Medical Supplies for Community Health Clinics");
        allResources.add("Clean Water Wells for Remote Villages");
        allResources.add("Training Programs for Agricultural Development");
        allResources.add("Computers for Digital Literacy Initiatives");
        allResources.add("Women's Empowerment Workshops");
        allResources.add("Renewable Energy Projects");
        allResources.add("Emergency Relief Kits for Disaster Response");
        allResources.add("Job Skills Training Programs");
        resources.setAll(allResources);
    }


    @FXML
    private void addNewResource(ActionEvent event) {
        String newResourceName = newResourceNameField.getText();

        if (!newResourceName.isEmpty()) {
            resources.add(newResourceName);
            newResourceNameField.clear();
        } else {
            showAlert(Alert.AlertType.ERROR, "Error", "Please enter a resource name..");
            
        }
    }

    @FXML
    private void viewAllDonors(ActionEvent event) {
        ArrayList<String> allDonors = new ArrayList<>();
        allDonors.add("BRAC - Sir Fazle Hasan Abed");
        allDonors.add("Grameen Bank - Muhammad Yunus");
        allDonors.add("The Aga Khan Foundation");
        allDonors.add("Bill & Melinda Gates Foundation");
        allDonors.add("The World Bank");
        allDonors.add("Asian Development Bank");
        allDonors.add("United Nations Development Programme (UNDP)");
        allDonors.add("Islamic Development Bank");
        allDonors.add("Oxfam");
        allDonors.add("Save the Children");
        donors.setAll(allDonors);
    }

    @FXML
    private void addNewDonor(ActionEvent event) {
        String newDonorName = newDonorNameField.getText();

        if (!newDonorName.isEmpty()) {
            donors.add(newDonorName);
            newDonorNameField.clear();
        } else {
            showAlert(Alert.AlertType.ERROR, "Error", "Please enter a donor name.");
            
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
