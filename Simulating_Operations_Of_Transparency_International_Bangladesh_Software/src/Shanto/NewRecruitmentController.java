package Shanto;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

    private ObservableList<String> jobVacancies = FXCollections.observableArrayList();
    private ObservableList<String> applicants = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
   
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
        String selectedJob = jobVacancyListView.getSelectionModel().getSelectedItem();

        if (selectedJob != null) {
            switch (selectedJob) {
                case "Software Engineer- 1 Seat":
                    allApplicants.add("Md. Hasanur Rahman - Software Engineer (3 years experience in Java development)");
                    allApplicants.add("Tahmina Akter - Software Engineer (2 years experience in web application development)");
                    allApplicants.add("Mahmudul Hasan - Software Engineer (4 years experience in mobile app development)");
                    allApplicants.add("Sadia Afrin - Software Engineer (5 years experience in software engineering)");
                    allApplicants.add("Shafiqul Islam - Software Engineer (3 years experience in backend development)");
                    break;
                case "Marketing Manager- 2 Seat":
                    allApplicants.add("Farzana Islam - Marketing Manager (6 years experience in digital marketing)");
                    allApplicants.add("Rahimul Haque - Marketing Manager (4 years experience in brand management)");
                    allApplicants.add("Mehnaz Begum - Marketing Manager (5 years experience in content marketing)");
                    allApplicants.add("Nasir Uddin - Marketing Manager (3 years experience in social media marketing)");
                    allApplicants.add("Ayesha Khanam - Marketing Manager (7 years experience in marketing strategy)");
                    break;
                case "Graphic Designer- 1 Seat":
                    allApplicants.add("Abdul Karim - Graphic Designer (4 years experience in UI/UX design)");
                    allApplicants.add("Nazia Sultana - Graphic Designer (3 years experience in print design)");
                    allApplicants.add("Mahmuda Akhter - Graphic Designer (5 years experience in branding)");
                    allApplicants.add("Tareq Rahman - Graphic Designer (2 years experience in multimedia design)");
                    allApplicants.add("Nusrat Jahan - Graphic Designer (6 years experience in visual communication)");
                    break;
                case "Accountant- 3 Seat":
                    allApplicants.add("Fatima Ahmed - Accountant (6 years experience in financial accounting)");
                    allApplicants.add("Ali Khan - Accountant (5 years experience in auditing)");
                    allApplicants.add("Sara Patel - Accountant (4 years experience in bookkeeping)");
                    allApplicants.add("Aryan Sharma - Accountant (7 years experience in taxation)");
                    allApplicants.add("Priya Gupta - Accountant (3 years experience in budgeting)");
                    allApplicants.add("Rahul Singh - Accountant (8 years experience in financial reporting)");
                    allApplicants.add("Anaya Kapoor - Accountant (4 years experience in payroll management)");
                    allApplicants.add("Zara Khan - Accountant (6 years experience in cost analysis)");
                    allApplicants.add("Kunal Mehta - Accountant (5 years experience in internal auditing)");
                    allApplicants.add("Neha Shah - Accountant (7 years experience in management accounting)");
                    break;
                case "Customer Service Representative- 3 Seat":
                    allApplicants.add("Aditi Verma - Customer Service Representative (3 years experience in customer support)");
                    allApplicants.add("Rohan Patel - Customer Service Representative (4 years experience in call center operations)");
                    allApplicants.add("Anjali Gupta - Customer Service Representative (5 years experience in client relations)");
                    allApplicants.add("Vikram Singh - Customer Service Representative (6 years experience in complaint handling)");
                    allApplicants.add("Aisha Khan - Customer Service Representative (3 years experience in dispute resolution)");
                    allApplicants.add("Karan Sharma - Customer Service Representative (4 years experience in customer satisfaction)");
                    allApplicants.add("Pooja Patel - Customer Service Representative (5 years experience in order processing)");
                    allApplicants.add("Rahul Verma - Customer Service Representative (6 years experience in telephone etiquette)");
                    allApplicants.add("Nisha Singh - Customer Service Representative (4 years experience in troubleshooting)");
                    allApplicants.add("Arjun Gupta - Customer Service Representative (5 years experience in product support)");
                    break;
                case "Data Analyst- 1 Seat":
                    allApplicants.add("Sadia Islam - Data Analyst (4 years experience in data visualization)");
                    allApplicants.add("Rahat Khan - Data Analyst (3 years experience in predictive modeling)");
                    allApplicants.add("Fahim Ahmed - Data Analyst (5 years experience in database management)");
                    allApplicants.add("Nadia Rahman - Data Analyst (2 years experience in data mining)");
                    allApplicants.add("Arif Hossain - Data Analyst (6 years experience in statistical analysis)");
                    break;
                case "Sales Associate- 2 Seat":
                    allApplicants.add("Monirul Islam - Sales Associate (6 years experience in B2B sales)");
                    allApplicants.add("Ayesha Kabir - Sales Associate (4 years experience in retail sales)");
                    allApplicants.add("Mustafizur Rahman - Sales Associate (5 years experience in sales management)");
                    allApplicants.add("Anika Chowdhury - Sales Associate (3 years experience in account management)");
                    allApplicants.add("Saiful Islam - Sales Associate (7 years experience in negotiation)");
                    break;
                case "Human Resources Manager- 2 Seat":
                    allApplicants.add("Nazmul Hossain - Human Resources Manager (7 years experience in HR strategy)");
                    allApplicants.add("Tasnim Islam - Human Resources Manager (5 years experience in recruitment)");
                    allApplicants.add("Jannatul Ferdous - Human Resources Manager (6 years experience in employee relations)");
                    allApplicants.add("Kamrul Hasan - Human Resources Manager (4 years experience in performance management)");
                    allApplicants.add("Salma Akter - Human Resources Manager (8 years experience in organizational development)");
                    break;
                case "Project Manager- 1 Seat":
                    allApplicants.add("Raihan Uddin - Project Manager (6 years experience in project planning)");
                    allApplicants.add("Mim Akter - Project Manager (4 years experience in resource management)");
                    allApplicants.add("Nafiz Ahmed - Project Manager (5 years experience in risk assessment)");
                    allApplicants.add("Nusrat Khan - Project Manager (3 years experience in stakeholder communication)");
                    allApplicants.add("Imran Hossain - Project Manager (7 years experience in project execution)");
                    break;
                case "Registered Nurse- 4 Seat":
                    allApplicants.add("Amit Patel - Registered Nurse (7 years experience in critical care)");
                    allApplicants.add("Priya Sharma - Registered Nurse (5 years experience in pediatric nursing)");
                    allApplicants.add("Raj Kumar - Registered Nurse (6 years experience in geriatric nursing)");
                    allApplicants.add("Neha Singh - Registered Nurse (4 years experience in emergency nursing)");
                    allApplicants.add("Kavita Gupta - Registered Nurse (8 years experience in surgical nursing)");
                    allApplicants.add("Vivek Verma - Registered Nurse (6 years experience in psychiatric nursing)");
                    allApplicants.add("Anjali Devi - Registered Nurse (5 years experience in oncology nursing)");
                    allApplicants.add("Rajesh Kumar - Registered Nurse (7 years experience in orthopedic nursing)");
                    allApplicants.add("Deepika Singh - Registered Nurse (4 years experience in neonatal nursing)");
                    allApplicants.add("Rahul Sharma - Registered Nurse (6 years experience in rehabilitation nursing)");
                    break;
                    }
                }

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
      
}
