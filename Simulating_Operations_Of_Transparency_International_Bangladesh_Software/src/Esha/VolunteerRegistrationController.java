package Esha;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;

public class VolunteerRegistrationController implements Initializable {

    @FXML
    private ChoiceBox<String> campaignChoiceBox;
    @FXML
    private TextArea timingChoiceBox;
    @FXML
    private ChoiceBox<String> activityChoiceBox;
    @FXML
    private TextArea additionalInfoTextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            // Initialize ChoiceBoxes
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
        // Retrieve data from the form and process it
        String campaignArea = campaignChoiceBox.getValue();
        String timing = timingChoiceBox.getText(); // Changed from getValue() to getText()
        String activity = activityChoiceBox.getValue();
        String additionalInfo = additionalInfoTextArea.getText();
        
        // Perform further actions with the retrieved data
        System.out.println("Campaign Area: " + campaignArea);
        System.out.println("Timing: " + timing);
        System.out.println("Field of Activity: " + activity);
        System.out.println("Additional Information: " + additionalInfo);
        
    // Show an alert confirming that the data is saved
    showAlert("Success", "Data saved successfully!");
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
        // Add logic to go back to the previous event
    }

    @FXML
    private void logOut(ActionEvent event) {
        // Add logic to log out
    }
}
