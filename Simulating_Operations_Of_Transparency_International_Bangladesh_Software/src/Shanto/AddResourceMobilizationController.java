package Shanto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
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
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;



public class AddResourceMobilizationController implements Initializable {

    @FXML
    private TextField newResourceNameField;
    @FXML
    private TextField newDonorNameField;

    private ObservableList<String> resources = FXCollections.observableArrayList();
    private ObservableList<String> donors = FXCollections.observableArrayList();

    
    
    private static final String FILE_PATH = "Resource_data.ser";
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {        
        loadSavedData();
    }    

    @FXML
    private void exitApplication(ActionEvent event) {
         Platform.exit();
    }


@FXML
private void addNewResource(ActionEvent event) {
    String newResourceName = newResourceNameField.getText();

    if (!newResourceName.isEmpty()) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Resource Details");
        dialog.setHeaderText(null);
        dialog.setContentText("Please enter additional details for " + newResourceName + ":");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            String details = result.get();
            resources.add(newResourceName + " (" + details + ")");
            newResourceNameField.clear();
            saveData();
            showAlert("Resource Added", "New resource added: " + newResourceName + " (" + details + ")");
        }
    
    }
}

@FXML
private void addNewDonor(ActionEvent event) {
    String newDonorName = newDonorNameField.getText();

    if (!newDonorName.isEmpty()) {
        // Get additional details if needed
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Donor Details");
        dialog.setHeaderText(null);
        dialog.setContentText("Please enter additional details for " + newDonorName + ":");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            String details = result.get();
            donors.add(newDonorName + " (" + details + ")");
            newDonorNameField.clear();
            saveData();
            showAlert("Donor Added", "New donor added: " + newDonorName + " (" + details + ")");
        }
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

    
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
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
