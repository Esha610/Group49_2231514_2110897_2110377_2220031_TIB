
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


public class ViewQualityAssuranceController implements Initializable {

    @FXML
    private ListView<String> assessmentView;
    @FXML
    private ListView<String> improvementView;

    private ObservableList<String> assessmentData = FXCollections.observableArrayList();
    private ObservableList<String> solutionsData = FXCollections.observableArrayList();

    private static final String FILE_PATH = "qualityAssurance_data.ser";    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        assessmentView.setItems(assessmentData);
        improvementView.setItems(solutionsData);
        loadSavedData();
    }   
    
    @FXML
    private void exitApplication(ActionEvent event) {
          Platform.exit();
    }


    @FXML
    private void viewAssessmentResults(ActionEvent event) {
        ArrayList<String> allAssessments = new ArrayList<>();
        allAssessments.add("Problem 1 - Low Employee Productivity");
        allAssessments.add("Problem 2 - High Employee Turnover Rate");
        allAssessments.add("Problem 3 - Decreasing Customer Satisfaction Scores");
        allAssessments.add("Problem 4 - Rising Operational Costs");
        allAssessments.add("Problem 5 - Inefficient Supply Chain Management");
        allAssessments.add("Problem 6 - Outdated Technology Infrastructure");
        allAssessments.add("Problem 7 - Regulatory Compliance Challenges");
        allAssessments.add("Problem 8 - Cybersecurity Vulnerabilities");
        allAssessments.add("Problem 9 - Poor Marketing Campaign Performance");
        allAssessments.add("Problem 10 - Environmental Sustainability Concerns");
        assessmentData.setAll(allAssessments); 
        saveData();

    }
    @FXML
    private void viewImplementSolutions(ActionEvent event) {
        ArrayList<String> allSolutions = new ArrayList<>();
        allSolutions.add("Solution 1( Problem 1) - Employee Training Programs for Skill Enhancement ");
        allSolutions.add("Solution 2 (Problem 1)- Performance Incentive Schemes for Employee Retention ");
        allSolutions.add("Solution 3 (Problem 1) - Implementing Flexible Work Arrangements ");
        allSolutions.add("-------------------------------------------------------------------------------------------------");        
        allSolutions.add("Solution 1 (Problem 2)- Enhanced Onboarding and Mentorship Programs ");
        allSolutions.add("Solution 2 (Problem 2)- Improving Employee Benefits and Work-Life Balance Initiatives ");
        allSolutions.add("Solution 3 (Problem 2)- Conducting Exit Interviews to Identify Root Causes ");
        allSolutions.add("-------------------------------------------------------------------------------------------------");        
        allSolutions.add("Solution 1 (Problem 3)- Implementing Customer Feedback Surveys and Analysis ");
        allSolutions.add("Solution 2 (Problem 3)- Enhancing Customer Service Training for Employees ");
        allSolutions.add("Solution 3 (Problem 3)- Offering Personalized Customer Experiences ");
        allSolutions.add("-------------------------------------------------------------------------------------------------");        
        allSolutions.add("Solution 1 (Problem 4)- Implementing Cost-Reduction Strategies and Process Optimization ");
        allSolutions.add("Solution 2 (Problem 4)- Negotiating Better Supplier Contracts and Agreements ");
        allSolutions.add("Solution 3 (Problem 4)- Investing in Energy-Efficient Technologies and Practices ");
        allSolutions.add("-------------------------------------------------------------------------------------------------");        
        allSolutions.add("Solution 1 (Problem 5)- Upgrading Warehouse Management Systems for Better Inventory Tracking ");
        allSolutions.add("Solution 2 (Problem 5)- Implementing Just-In-Time Inventory Management Practices ");
        allSolutions.add("Solution 3 (Problem 5)- Strengthening Supplier Relationships and Communication Channels ");
        allSolutions.add("------------------------------------------------------------------------------------------------");        
        allSolutions.add("Solution 1 (Problem 6)- Adopting Cloud-Based Solutions for Scalability and Efficiency ");
        allSolutions.add("Solution 2 (Problem 6)- Modernizing IT Infrastructure with the Latest Technologies ");
        allSolutions.add("Solution 3 (Problem 6)- Enhancing Data Security Measures and Compliance Protocols ");
        allSolutions.add("-------------------------------------------------------------------------------------------------");        
        allSolutions.add("Solution 1 (Problem 7)- Conducting Regular Audits and Compliance Assessments ");
        allSolutions.add("Solution 2 (Problem 7)- Providing Ongoing Training and Education on Regulatory Changes ");
        allSolutions.add("Solution 3 (Problem 7)- Implementing Robust Compliance Management Systems ");
        allSolutions.add("-------------------------------------------------------------------------------------------------");        
        allSolutions.add("Solution 1 (Problem 8)- Enhancing Employee Awareness and Training on Cybersecurity Risks ");
        allSolutions.add("Solution 2 (Problem 8)- Implementing Multi-Layered Security Protocols and Access Controls ");
        allSolutions.add("Solution 3 (Problem 8)- Investing in Cybersecurity Insurance and Incident Response Plans ");
        allSolutions.add("-------------------------------------------------------------------------------------------------");        
        allSolutions.add("Solution 1 (Problem 9)- Conducting Market Research and Analysis for Target Audience Insights ");
        allSolutions.add("Solution 2 (Problem 9)- Refining Marketing Strategies Based on Data Analytics ");
        allSolutions.add("Solution 3 (Problem 9)- Leveraging Social Media Platforms for Brand Engagement ");
        allSolutions.add("-------------------------------------------------------------------------------------------------");        
        allSolutions.add("Solution 1 (Problem 10)- Implementing Recycling and Waste Reduction Initiatives in Operations ");
        allSolutions.add("Solution 2 (Problem 10)- Investing in Renewable Energy Sources for Operations");
        allSolutions.add("Solution 3 (Problem 10)- Partnering with Environmental Organizations for Sustainability Programs ");
        solutionsData.setAll(allSolutions);  
        saveData();
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
