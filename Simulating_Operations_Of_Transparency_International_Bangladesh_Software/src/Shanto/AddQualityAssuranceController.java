
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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class AddQualityAssuranceController implements Initializable {

    @FXML
    private TextField assessmentTextField;
    @FXML
    private TextField solutionsTextField;


    private ObservableList<String> assessmentData = FXCollections.observableArrayList();
    private ObservableList<String> solutionsData = FXCollections.observableArrayList();

    private static final String FILE_PATH = "qualityAssurance_data.ser";
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        loadSavedData();
    }     

    @FXML
    private void exitApplication(ActionEvent event) {
          Platform.exit();
    }

@FXML
private void newAssessment(ActionEvent event) {
    String newAssessment = assessmentTextField.getText();
    if (!newAssessment.isEmpty()) {
        assessmentData.add(newAssessment);
        assessmentTextField.clear();
        saveData();
        showAlert("Assessment Added", "New assessment added: " + newAssessment);
    } else {
        showAlert("Error", "Please enter a description for the new assessment.");
    }        
}    

@FXML
private void newImplementation(ActionEvent event) {
    String newSolution = solutionsTextField.getText();
    if (!newSolution.isEmpty()) {
        solutionsData.add(newSolution);
        solutionsTextField.clear();
        saveData();
        showAlert("Solution Added", "New solution added: " + newSolution);
    } else {
        showAlert("Error", "Please enter a solution.");
    }       
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

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }    
    
    
        private void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(new ArrayList<>(assessmentData));
            oos.writeObject(new ArrayList<>(solutionsData));
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Failed to save data.");
        }
    }
        
        
            private void loadSavedData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            ArrayList<String> savedAssessment = (ArrayList<String>) ois.readObject();
            ArrayList<String> savedSolutions = (ArrayList<String>) ois.readObject();
            assessmentData.setAll(savedAssessment);
            solutionsData.setAll(savedSolutions);
            System.out.println("Data loaded successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("No saved data found.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
}
