package Esha;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ReportingCorruptionController implements Initializable {

    private static final String DATA_FILE = "corruption_data.txt";

    @FXML
    private Button submitButton;
    @FXML
    private Button backButton;
    @FXML
    private Button logoutButton;
    @FXML
    private TextArea locationTextArea;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TextArea descriptionTextArea;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
    }    

    @FXML
    private void submitForm(ActionEvent event) {
        
        String location = locationTextArea.getText();
        String date = datePicker.getValue().toString();
        String description = descriptionTextArea.getText();
        
        saveData(location, date, description);
      
        showAlert("Success", "Data has been saved successfully!");
    }

    @FXML
    private void goBack(ActionEvent event) {
        loadScene("/Esha/Student.fxml", event);
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

    @FXML
    private void logOut(ActionEvent event) {
         loadScene("/mainpkg/LoginSc.fxml", event);
    }
    
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    private void saveData(String location, String date, String description) {
        try (FileWriter writer = new FileWriter(DATA_FILE, true)) {
            writer.write(location + "," + date + "," + description + "\n");
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Failed to save data!");
        }
    }
}
