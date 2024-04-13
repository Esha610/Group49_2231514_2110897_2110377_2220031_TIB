package Esha;

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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class VolunteerRegistrationController implements Initializable {

    @FXML
    private ChoiceBox<String> campaignChoiceBox;
    @FXML
    private TextArea timingChoiceBox;
    @FXML
    private ChoiceBox<String> activityChoiceBox;
    @FXML
    private TextArea additionalInfoTextArea;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            
        campaignChoiceBox.getItems().addAll("Gulshan", "Banani", "Dhanmondi", "Uttara", "Mohakhali");

        activityChoiceBox.getItems().addAll(
            "Teaching",
            "Volunteering at a Soup Kitchen",
            "Planting Trees",
            "Medical Check-Up Camp",
            "Beach Clean-Up"
        );

    }    

    @FXML
    private void submitForm(ActionEvent event) {
       
        String campaignArea = campaignChoiceBox.getValue();
        String timing = timingChoiceBox.getText(); 
        String activity = activityChoiceBox.getValue();
        String additionalInfo = additionalInfoTextArea.getText();
        
        
        System.out.println("Campaign Area: " + campaignArea);
        System.out.println("Timing: " + timing);
        System.out.println("Field of Activity: " + activity);
        System.out.println("Additional Information: " + additionalInfo);
        
        
        VolunteerRegistrationData data = new VolunteerRegistrationData(campaignArea, timing, activity, additionalInfo);
        saveData(data);
        
       
        showAlert("Success", "Data saved successfully!");
    }

    private void saveData(VolunteerRegistrationData data) {
        
        System.out.println("Data saved: " + data);
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
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


}