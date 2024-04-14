package Shanto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class OfficialMeetsController {

    @FXML
    private TableView<OfficialMeet> officialMeetsTableView;
    @FXML
    private TableColumn<OfficialMeet, String> titleCol;
    @FXML
    private TableColumn<OfficialMeet, String> timeCol;
    @FXML
    private TableColumn<OfficialMeet, String> dateCol;
    @FXML
    private TableColumn<OfficialMeet, String> locationCol;
    @FXML
    private TextField titleTextField;
    @FXML
    private TextField timeTextField;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TextField locationTextField;
    @FXML
    private Button addMeetButton;

    private static final String DATA_FILE = "official_meets.bin";

    public void initialize() {
        titleCol.setCellValueFactory(cellData -> cellData.getValue().titleProperty());
        timeCol.setCellValueFactory(cellData -> cellData.getValue().timeProperty());
        dateCol.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
        locationCol.setCellValueFactory(cellData -> cellData.getValue().locationProperty());

        // Load existing data when initializing
        loadData();
    }

    @FXML
    private void addOfficialMeet(ActionEvent event) {
        String title = titleTextField.getText();
        String time = timeTextField.getText();
        String date = datePicker.getValue().toString();
        String location = locationTextField.getText();

        if (title.isEmpty() || time.isEmpty() || date.isEmpty() || location.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Validation Error", "All fields are required.");
            return;
        }

        OfficialMeet newMeet = new OfficialMeet(title, time, date, location);
        officialMeetsTableView.getItems().add(newMeet);

        titleTextField.clear();
        timeTextField.clear();
        datePicker.getEditor().clear();
        locationTextField.clear();

        saveData(); // Save the newly added data

        showAlert(Alert.AlertType.INFORMATION, "Success", "Official meet added successfully.");
    }

@FXML
private void viewAllMeetings(ActionEvent event) {
    officialMeetsTableView.getItems().clear();


    List<OfficialMeet> meetings = loadData();

    if (meetings == null || meetings.isEmpty()) {
      
        meetings = new ArrayList<>();
        meetings.add(new OfficialMeet("Weekly Team Standup", "09:00 AM", "2024-04-15", "Conference Room A"));
        meetings.add(new OfficialMeet("Project Kickoff Meeting", "10:30 AM", "2024-04-16", "Boardroom"));
        meetings.add(new OfficialMeet("Client Presentation", "02:00 PM", "2024-04-18", "Client Office"));
        meetings.add(new OfficialMeet("Budget Review Meeting", "11:00 AM", "2024-04-19", "Meeting Room 2"));
        meetings.add(new OfficialMeet("Monthly Performance Review", "03:00 PM", "2024-04-20", "HR Office"));
        meetings.add(new OfficialMeet("Executive Board Meeting", "10:00 AM", "2024-04-22", "Executive Office"));
        meetings.add(new OfficialMeet("Project Status Update", "01:30 PM", "2024-04-23", "Team Collaboration Area"));
        meetings.add(new OfficialMeet("Strategic Planning Session", "09:30 AM", "2024-04-25", "Strategy Room"));
        meetings.add(new OfficialMeet("Departmental All-Hands Meeting", "11:30 AM", "2024-04-27", "Auditorium"));
        meetings.add(new OfficialMeet("Training Workshop", "02:30 PM", "2024-04-29", "Training Center"));

    }
    officialMeetsTableView.getItems().addAll(meetings);
}


    private void saveData() {
        List<OfficialMeet> meets = new ArrayList<>(officialMeetsTableView.getItems());
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(meets);
        } catch (IOException e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to save data.");
        }
    }

    private List<OfficialMeet> loadData() {
        List<OfficialMeet> meetings = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            meetings = (List<OfficialMeet>) ois.readObject();
        } catch (FileNotFoundException e) {
            showAlert(Alert.AlertType.ERROR, "Error", "No saved data found.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to load data.");
        }
        return meetings;
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

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
