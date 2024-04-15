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
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MenteesController implements Initializable {

    @FXML
    private ListView<String> studentListView;
    @FXML
    private ListView<String> menteeRequestListView;
    @FXML
    private TextArea menteeProfileTextArea;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize the list views with sample data
        initializeStudentListView();
        initializeMenteeRequestListView();
    }    

    private void initializeStudentListView() {
        // Sample student names
        studentListView.getItems().addAll(
            "John Doe",
            "Alice Smith",
            "Bob Johnson",
            "Emily Brown",
            "Michael Wilson"
        );
    }

    private void initializeMenteeRequestListView() {
        // Sample mentee requests
        menteeRequestListView.getItems().addAll(
            "Request 1",
            "Request 2",
            "Request 3",
            "Request 4",
            "Request 5"
        );
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
    private void exitApplication(ActionEvent event) {
    
        System.exit(0);
    }

    @FXML
    private void acceptMenteeRequest(ActionEvent event) {
        
        String selectedRequest = menteeRequestListView.getSelectionModel().getSelectedItem();

        if (selectedRequest != null) {
           
            System.out.println("Mentee request accepted: " + selectedRequest);
        } else {
           
            System.out.println("Please select a mentee request to accept.");
        }
    }

    @FXML
    private void declineMenteeRequest(ActionEvent event) {
        
        String selectedRequest = menteeRequestListView.getSelectionModel().getSelectedItem();

        if (selectedRequest != null) {
         
            System.out.println("Mentee request declined: " + selectedRequest);
        } else {
            
            System.out.println("Please select a mentee request to decline.");
        }
    }

    @FXML
    private void setMeeting(ActionEvent event) {
       
        String selectedStudent = studentListView.getSelectionModel().getSelectedItem();

        if (selectedStudent != null) {
         
            System.out.println("Meeting set with student: " + selectedStudent);
        } else {
           
            System.out.println("Please select a student to set a meeting.");
        }
    }

}
