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

public class ResearchPolicyAnalysisController implements Initializable {

    @FXML    private ListView<String> projectsListView;
    @FXML    private TextField projectNameField;
    @FXML    private TextArea projectDescriptionArea;

    private ObservableList<String> projects = FXCollections.observableArrayList();
    private programDescriptions projectDescriptions = new programDescriptions();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        projectsListView.setItems(projects);
    }

    @FXML
    private void exitApplication(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    private void viewAllProjects(ActionEvent event) {
        ArrayList<String> allProjects = new ArrayList<>();
        allProjects.add("Building a New Hospital");
        allProjects.add("Developing a Mobile App for Remote Learning");
        allProjects.add("Renewable Energy Infrastructure Project");
        allProjects.add("Urban Revitalization Initiative");
        allProjects.add("Research and Development of a COVID-19 Vaccine");
        allProjects.add("Construction of Affordable Housing Units");
        allProjects.add("Implementing a Waste Management System");
        allProjects.add("Expansion of Public Transportation System");
        allProjects.add("Digital Transformation of Government Services");
        allProjects.add("Promotion of Sustainable Agriculture Practices");
        projects.setAll(allProjects);
    }

    @FXML
    private void addNewProject(ActionEvent event) {
        String newProjectName = projectNameField.getText();
        String newProjectDescription = projectDescriptionArea.getText();

        if (!newProjectName.isEmpty()) {
            projects.add(newProjectName);
            projectDescriptions.put(newProjectName, newProjectDescription);
            projectNameField.clear();
            projectDescriptionArea.clear();
        } else {
            showAlert(Alert.AlertType.ERROR, "Error", "Please enter both project name and description.");
        }
    }


    @FXML
    private void viewDescription(ActionEvent event) {
        String selectedProject = projectsListView.getSelectionModel().getSelectedItem();
        if (selectedProject != null) {
            String description = getDescription(selectedProject);
            projectDescriptionArea.setText(description);
        } else {
            showAlert(Alert.AlertType.ERROR, "Error", "Please select a project to view its description.");
        }
    }

    private String getDescription(String projectName) {
        String description = projectDescriptions.getDescription(projectName);
        if (description != null) {
            return description;
        } else {
            switch (projectName) {
                case "Building a New Hospital":
                    return "This project involves the construction of a state-of-the-art hospital facility to provide quality healthcare services to the community.";
                case "Developing a Mobile App for Remote Learning":
                    return "The project aims to develop a mobile application platform to facilitate remote learning and educational access.";
                case "Renewable Energy Infrastructure Project":
                    return "This project focuses on building infrastructure for renewable energy sources such as solar, wind, and hydroelectric power.";
                case "Urban Revitalization Initiative":
                    return "The urban revitalization initiative aims to rejuvenate urban areas through redevelopment and community engagement.";
                case "Research and Development of a COVID-19 Vaccine":
                    return "This project involves extensive research and development efforts towards creating a vaccine to combat the COVID-19 pandemic.";
                case "Construction of Affordable Housing Units":
                    return "The project aims to construct affordable housing units to address housing shortages and provide shelter for low-income families.";
                case "Implementing a Waste Management System":
                    return "This project focuses on implementing efficient waste management systems to promote environmental sustainability.";
                case "Expansion of Public Transportation System":
                    return "The project involves expanding the existing public transportation infrastructure to improve accessibility and reduce traffic congestion.";
                case "Digital Transformation of Government Services":
                    return "This project aims to digitize and modernize government services to enhance efficiency, transparency, and citizen engagement.";
                case "Promotion of Sustainable Agriculture Practices":
                    return "The project focuses on promoting sustainable agriculture practices to ensure food security and mitigate environmental impact.";
                default:
                    return "No description available for " + projectName;
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
    
    
    
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
