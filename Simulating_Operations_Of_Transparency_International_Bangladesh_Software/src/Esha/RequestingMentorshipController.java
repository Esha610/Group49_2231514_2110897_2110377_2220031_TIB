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
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class RequestingMentorshipController implements Initializable {

    @FXML
    private ChoiceBox<String> goalsChoiceBox;
    @FXML
    private ChoiceBox<String> skillChoiceBox;
    @FXML
    private ChoiceBox<String> fieldChoiceBox;
    @FXML
    private TextArea extraTextArea;
    @FXML
    private Button submitButton;
    @FXML
    private Button backButton;
    @FXML
    private Button logoutButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
            
    goalsChoiceBox.getItems().addAll(
        "Enhance Programming Skills",
        "Improve Time Management",
        "Develop Leadership Qualities",
        "Learn Effective Communication",
        "Master Problem-Solving Techniques"
    );

    skillChoiceBox.getItems().addAll(
        "Java Programming",
        "Graphic Design",
        "Public Speaking",
        "Project Management",
        "Data Analysis"
    );

    fieldChoiceBox.getItems().addAll(
        "Software Development",
        "Digital Marketing",
        "Finance and Accounting",
        "Healthcare Management",
        "Environmental Science"
    );

    }    

    @FXML
    private void submitForm(ActionEvent event) {
        // Retrieve data from the form and process it
        String selectedGoal = goalsChoiceBox.getValue();
        String selectedSkill = skillChoiceBox.getValue();
        String selectedField = fieldChoiceBox.getValue();
        String extraDescription = extraTextArea.getText();
        
        // Process the data (e.g., submit mentorship request)
        System.out.println("Selected Goal: " + selectedGoal);
        System.out.println("Selected Skill: " + selectedSkill);
        System.out.println("Selected Field: " + selectedField);
        System.out.println("Extra Description: " + extraDescription);
    }

    @FXML
    private void goBack(ActionEvent event) {
            loadScene("/Esha/Student.fxml", event);

    }

    @FXML
    private void logout(ActionEvent event) {
            loadScene("/mainpkg/LoginSc.fxml", event);

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
