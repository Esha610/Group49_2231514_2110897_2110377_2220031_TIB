package Shanto;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class OfficialMeetsController implements Initializable {

    @FXML    private TableView<String> meetingsTableView;
    @FXML    private TableColumn<String, String> meetingNameTimeDateLocationTableColumn; 
    @FXML    private TextField newMeetingField;

    private ObservableList<String> meetingsData;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        meetingsData = FXCollections.observableArrayList();
        meetingsTableView.setItems(meetingsData);
        meetingNameTimeDateLocationTableColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()));
    }

    @FXML
    private void viewAllMeetings(ActionEvent event) {
        meetingsData.clear();
        ArrayList<String> sampleMeetings = new ArrayList<>();
        sampleMeetings.add("          Board Meeting                          10:00 AM                        April 5,  2024                        Conference Room A");
        sampleMeetings.add("          Sales Review                           2:30  PM                        April 6,  2024                        Boardroom");
        sampleMeetings.add("          Team Stand-up                          9:00  AM                        April 7,  2024                        Office Lounge");
        sampleMeetings.add("          Marketing Strategy                     11:00 AM                        April 8,  2024                        Marketing Department");
        sampleMeetings.add("          Product Development                    3:00  PM                        April 9,  2024                        Innovation Lab");
        sampleMeetings.add("          Client Consultation                    1:30  PM                        April 10, 2024                        Client's Office");
        sampleMeetings.add("          Budget Review                          10:30 AM                        April 11, 2024                        Finance Department");
        sampleMeetings.add("          Staff Training                         2:00  PM                        April 12, 2024                        Training Room");
        sampleMeetings.add("          Project Kick-off                       9:30  AM                        April 13, 2024                        Project Office");
        sampleMeetings.add("          Executive Retreat                      8:00  AM                        April 14, 2024                        Resort Venue");
        meetingsData.addAll(sampleMeetings);
    }


    @FXML
    private void addNewMeeting(ActionEvent event) {
        String newMeeting = newMeetingField.getText();
        if (!newMeeting.isEmpty()) {
            meetingsData.add(newMeeting);
            newMeetingField.clear();
        }
    }

    
    @FXML
    private void exitApplication(ActionEvent event) {
        Platform.exit();
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
