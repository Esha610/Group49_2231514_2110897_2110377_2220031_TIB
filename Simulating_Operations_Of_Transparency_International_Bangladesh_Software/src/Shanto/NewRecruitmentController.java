package Shanto;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.application.Platform;

public class NewRecruitmentController implements Initializable {

    @FXML private ListView<String> jobVacancyListView;
    @FXML private ListView<String> applicantListView;
    @FXML private TextField newJobVacancyField;
    @FXML private TextField newApplicantField;

    private ObservableList<String> jobVacancies;
    private ObservableList<String> applicants;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        jobVacancies = FXCollections.observableArrayList();
        applicants = FXCollections.observableArrayList();

        jobVacancyListView.setItems(jobVacancies);
        applicantListView.setItems(applicants);
    }

    @FXML
    private void exitApplication(ActionEvent event) {
        Platform.exit();
    }

    
    
    @FXML
    private void viewAllJobVacancies(ActionEvent event) {
        ArrayList<String> allJobVacancies = new ArrayList<>();
        allJobVacancies.add("Software Engineer- 1 Seat");
        allJobVacancies.add("Marketing Manager- 2 Seat");
        allJobVacancies.add("Graphic Designer- 1 Seat");
        allJobVacancies.add("Accountant- 3 Seat");
        allJobVacancies.add("Customer Service Representative- 3 Seat");
        allJobVacancies.add("Data Analyst- 1 Seat");
        allJobVacancies.add("Sales Associate- 2 Seat");
        allJobVacancies.add("Human Resources Manager- 2 Seat");
        allJobVacancies.add("Project Manager- 1 Seat");
        allJobVacancies.add("Registered Nurse- 4 Seat");
        jobVacancies.setAll(allJobVacancies);
    }

    @FXML
    private void viewAllApplicants(ActionEvent event) {
        ArrayList<String> allApplicants = new ArrayList<>();

        // "Software Engineer" 
        allApplicants.add("Md. Hasanur Rahman - Software Engineer");
        allApplicants.add("Tahmina Akter - Software Engineer");
        allApplicants.add("Mahmudul Hasan - Software Engineer");
        allApplicants.add("Sadia Afrin - Software Engineer");
        allApplicants.add("Shafiqul Islam - Software Engineer");

        // "Marketing Manager" 
        allApplicants.add("Farzana Islam - Marketing Manager");
        allApplicants.add("Rahimul Haque - Marketing Manager");
        allApplicants.add("Mehnaz Begum - Marketing Manager");
        allApplicants.add("Nasir Uddin - Marketing Manager");
        allApplicants.add("Ayesha Khanam - Marketing Manager");

        // "Graphic Designer" 
        allApplicants.add("Abdul Karim - Graphic Designer");
        allApplicants.add("Nazia Sultana - Graphic Designer");
        allApplicants.add("Mahmuda Akhter - Graphic Designer");
        allApplicants.add("Tareq Rahman - Graphic Designer");
        allApplicants.add("Nusrat Jahan - Graphic Designer");

        //  "Accountant" 
        allApplicants.add("Rezaul Islam - Accountant");
        allApplicants.add("Sumaiya Akter - Accountant");
        allApplicants.add("Mohammad Ali - Accountant");
        allApplicants.add("Ayesha Siddika - Accountant");
        allApplicants.add("Hasan Mahmud - Accountant");

        // "Customer Service Representative" 
        allApplicants.add("Aminul Haque - Customer Service Representative");
        allApplicants.add("Monira Akter - Customer Service Representative");
        allApplicants.add("Shakil Ahmed - Customer Service Representative");
        allApplicants.add("Farida Begum - Customer Service Representative");
        allApplicants.add("Rahman Khan - Customer Service Representative");

        // "Data Analyst" 
        allApplicants.add("Sadia Islam - Data Analyst");
        allApplicants.add("Rahat Khan - Data Analyst");
        allApplicants.add("Fahim Ahmed - Data Analyst");
        allApplicants.add("Nadia Rahman - Data Analyst");
        allApplicants.add("Arif Hossain - Data Analyst");

        // "Sales Associate" 
        allApplicants.add("Monirul Islam - Sales Associate");
        allApplicants.add("Ayesha Kabir - Sales Associate");
        allApplicants.add("Mustafizur Rahman - Sales Associate");
        allApplicants.add("Anika Chowdhury - Sales Associate");
        allApplicants.add("Saiful Islam - Sales Associate");

        //  "Human Resources Manager"
        allApplicants.add("Nazmul Hossain - Human Resources Manager");
        allApplicants.add("Tasnim Islam - Human Resources Manager");
        allApplicants.add("Jannatul Ferdous - Human Resources Manager");
        allApplicants.add("Kamrul Hasan - Human Resources Manager");
        allApplicants.add("Salma Akter - Human Resources Manager");

        // "Project Manager" 
        allApplicants.add("Raihan Uddin - Project Manager");
        allApplicants.add("Mim Akter - Project Manager");
        allApplicants.add("Nafiz Ahmed - Project Manager");
        allApplicants.add("Nusrat Khan - Project Manager");
        allApplicants.add("Imran Hossain - Project Manager");

        //  "Registered Nurse" 
        allApplicants.add("Sharmeen Sultana - Registered Nurse");
        allApplicants.add("Zahirul Islam - Registered Nurse");
        allApplicants.add("Rifat Rahman - Registered Nurse");
        allApplicants.add("Sharmin Akter - Registered Nurse");
        allApplicants.add("Ahsan Khan - Registered Nurse");
  
        applicants.setAll(allApplicants);
    }



    @FXML
    private void addNewJobVacancy(ActionEvent event) {
        String newJobVacancy = newJobVacancyField.getText();
        if (!newJobVacancy.isEmpty()) {
            jobVacancies.add(newJobVacancy);
            newJobVacancyField.clear();
        }
    }
    
    @FXML
    private void addNewApplicant(ActionEvent event) {
        String newApplicant = newApplicantField.getText();
        if (!newApplicant.isEmpty()) {
            applicants.add(newApplicant);
            newApplicantField.clear();
        }
    }

    @FXML
    private void logout(ActionEvent event) {
        loadScene("/mainpkg/LoginSc.fxml", event);
    }

    @FXML
    private void goBack(ActionEvent event) {
        loadScene("ExecutiveDirector.fxml", event);
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
