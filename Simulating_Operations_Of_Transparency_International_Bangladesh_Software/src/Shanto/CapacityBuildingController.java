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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CapacityBuildingController implements Initializable {

    @FXML    private ListView<String> programsListView;
    @FXML    private TextField programNameField;
    @FXML    private TextArea programDescriptionArea;

    private ObservableList<String> programItems = FXCollections.observableArrayList();
    private programDescriptions programDescriptions = new programDescriptions();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        programsListView.setItems(programItems);
    }

    @FXML
    private void exitApplication(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    private void viewAllPrograms(ActionEvent event) {
        ArrayList<String> allPrograms = new ArrayList<>();
        allPrograms.add("Leadership Development");
        allPrograms.add("Project Management Training");
        allPrograms.add("Digital Marketing Certification");
        allPrograms.add("Financial Literacy Workshops");
        allPrograms.add("Health and Wellness Programs");
        allPrograms.add("Environmental Sustainability Initiatives");
        allPrograms.add("Community Outreach Campaigns");
        allPrograms.add("Crisis Management Training");
        allPrograms.add("Diversity and Inclusion Workshops");
        allPrograms.add("Entrepreneurship Bootcamp");
        programItems.setAll(allPrograms);
    }


    @FXML
    private void addNewProgram(ActionEvent event) {
        String newProgramName = programNameField.getText();
        String newProgramDescription = programDescriptionArea.getText();

        if (!newProgramName.isEmpty() && !newProgramDescription.isEmpty()) {
            programItems.add(newProgramName);
            programDescriptions.put(newProgramName, newProgramDescription);
            programNameField.clear();
            programDescriptionArea.clear();
        } else {
            showAlert(Alert.AlertType.ERROR, "Error", "Please enter both program name and description.");
        }
    }


    @FXML
    private void saveProgramChanges(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Save Program Changes");
        alert.setHeaderText(null);
        alert.setContentText("Saving program changes...");
        alert.showAndWait();
    }

    @FXML
    private void goBack(ActionEvent event) {
        loadScene("SecretaryGeneral.fxml", event);
    }

    private void logout(ActionEvent event) {
        loadScene("LoginSc.fxml", event);
    }

   
    @FXML
    private void viewDescription(ActionEvent event) {
        String selectedProgram = programsListView.getSelectionModel().getSelectedItem();
        if (selectedProgram != null) {
            String description = getDescription(selectedProgram); // Use getDescription method here
            programDescriptionArea.setText(description);
        } else {
            showAlert(Alert.AlertType.ERROR, "Error", "Please select a program to view its description.");
        }
    }
    
    private String getDescription(String programName) {
        String description = programDescriptions.getDescription(programName);
        if (description != null) {
            return description;
        } else {
            switch (programName) {
                case "Leadership Development":
                    return "This program focuses on developing leadership skills, including communication, decision-making, and team management.";
                case "Project Management Training":
                    return "Project management training covers principles, methodologies, and tools required for effective project execution and delivery.";
                case "Digital Marketing Certification":
                    return "This certification program teaches digital marketing strategies, including SEO, SEM, social media marketing, and content marketing.";
                case "Financial Literacy Workshops":
                    return "Financial literacy workshops educate participants on personal finance topics such as budgeting, saving, investing, and debt management.";
                case "Health and Wellness Programs":
                    return "Health and wellness programs promote physical and mental well-being through fitness activities, nutrition education, and stress management.";
                case "Environmental Sustainability Initiatives":
                    return "These initiatives aim to raise awareness and implement practices that reduce environmental impact and promote sustainability.";
                case "Community Outreach Campaigns":
                    return "Community outreach campaigns engage with local communities to address social issues, promote awareness, and provide support.";
                case "Crisis Management Training":
                    return "Crisis management training prepares individuals and organizations to effectively respond to and mitigate various crises and emergencies.";
                case "Diversity and Inclusion Workshops":
                    return "Diversity and inclusion workshops foster understanding, respect, and collaboration among diverse individuals and groups.";
                case "Entrepreneurship Bootcamp":
                    return "Entrepreneurship bootcamp provides aspiring entrepreneurs with essential skills and knowledge to launch and grow successful businesses.";
                default:
                    return "No description available for " + programName;
            }
        }
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
