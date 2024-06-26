
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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class HostingworkshopsController implements Initializable {

    @FXML
    private Button submitButton;
    @FXML
    private Button backButton;
    @FXML
    private Button logoutButton;
    @FXML
    private RadioButton virtualRadioButton;
    @FXML
    private RadioButton inPersonRadioButton;
    @FXML
    private TextField topicTextField;
    @FXML
    private ChoiceBox<String> locationChoiceBox;
    @FXML
    private TextField topicTextField1;
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize the location choice box with sample locations
        locationChoiceBox.getItems().addAll(
            "Meeting Room 1",
            "Meeting Room 2",
            "Conference Hall A",
            "Conference Hall B",
            "Online"
        );
    }
   

    @FXML
    private void submitForm(ActionEvent event) {
        // Add code to handle form submission
        String topic = topicTextField.getText();
        String location = locationChoiceBox.getValue().toString();
        String format = virtualRadioButton.isSelected() ? "Virtual" : "In-Person";
        
        // Example: Print the submitted data
        System.out.println("Topic: " + topic);
        System.out.println("Location: " + location);
        System.out.println("Format: " + format);
    }

    @FXML
    private void goBack(ActionEvent event) {
       
        loadScene("/Esha/Researcher.fxml", event);
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
