package Shanto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;



public class ViewResourceMobilizationController implements Initializable {

    @FXML    private ListView<String> resourceListView;
    @FXML    private ListView<String> donorListView;

    private ObservableList<String> resources = FXCollections.observableArrayList();
    private ObservableList<String> donors = FXCollections.observableArrayList();
    private static final String FILE_PATH = "Resource_data.ser";
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        resourceListView.setItems(resources);
        donorListView.setItems(donors);
        loadSavedData();
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
        saveData();
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
        saveData();
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
    
    
        private void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(new ArrayList<>(resources));
            oos.writeObject(new ArrayList<>(donors));
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadSavedData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            ArrayList<String> savedResources = (ArrayList<String>) ois.readObject();
            ArrayList<String> savedDonors = (ArrayList<String>) ois.readObject();
            resources.setAll(savedResources);
            donors.setAll(savedDonors);
            System.out.println("Data loaded successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("No saved data found.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    
}
