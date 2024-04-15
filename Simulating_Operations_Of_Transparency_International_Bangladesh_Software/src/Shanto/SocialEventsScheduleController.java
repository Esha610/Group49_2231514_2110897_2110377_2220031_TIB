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

public class SocialEventsScheduleController {

    @FXML
    private TableView<SocialEvent> eventsTableView;
    @FXML
    private TableColumn<SocialEvent, String> eventNameCol;
    @FXML
    private TableColumn<SocialEvent, String> eventTimeCol;
    @FXML
    private TableColumn<SocialEvent, String> eventDateCol;
    @FXML
    private TableColumn<SocialEvent, String> eventLocationCol;
    @FXML
    private TextField eventNameTextField;
    @FXML
    private TextField eventTimeTextField;
    @FXML
    private DatePicker eventDatePicker;
    @FXML
    private TextField eventLocationTextField;
    @FXML
    private Button addEventButton;

    private static final String DATA_FILE = "social_events.bin";

    public void initialize() {
        eventNameCol.setCellValueFactory(cellData -> cellData.getValue().eventNameProperty());
        eventTimeCol.setCellValueFactory(cellData -> cellData.getValue().eventTimeProperty());
        eventDateCol.setCellValueFactory(cellData -> cellData.getValue().eventDateProperty());
        eventLocationCol.setCellValueFactory(cellData -> cellData.getValue().eventLocationProperty());

        loadData();
    }

    @FXML
    private void addEvent(ActionEvent event) {
        String eventName = eventNameTextField.getText();
        String eventTime = eventTimeTextField.getText();
        String eventDate = eventDatePicker.getValue().toString();
        String eventLocation = eventLocationTextField.getText();

        if (eventName.isEmpty() || eventTime.isEmpty() || eventDate.isEmpty() || eventLocation.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Validation Error", "All fields are required.");
            return;
        }

        SocialEvent newEvent = new SocialEvent(eventName, eventTime, eventDate, eventLocation);
        eventsTableView.getItems().add(newEvent);

        eventNameTextField.clear();
        eventTimeTextField.clear();
        eventDatePicker.getEditor().clear();
        eventLocationTextField.clear();

        saveData(); 

        showAlert(Alert.AlertType.INFORMATION, "Success", "Social event added successfully.");
    }

    @FXML
    private void viewAllEvents(ActionEvent event) {
        eventsTableView.getItems().clear();

        List<SocialEvent> events = loadData();

        if (events == null || events.isEmpty()) {
            events = new ArrayList<>();
            events.add(new SocialEvent("Pohela Boishakh Celebration", "9:00 AM", "April 14, 2024", "Various Locations"));
            events.add(new SocialEvent("Victory Day Parade", "9:00 AM", "December 16, 2024", "National Parade Ground"));
            events.add(new SocialEvent("Ekushey Book Fair", "3:00 PM", "February 1, 2024", "Bangla Academy"));
            events.add(new SocialEvent("Dhaka International Film Festival", "6:00 PM", "January 12, 2024", "Various Cinemas"));
            events.add(new SocialEvent("Bangabandhu Birth Anniversary", "10:00 AM", "March 17, 2024", "National Memorial"));
            events.add(new SocialEvent("Ramadan Iftar Party", "6:30 PM", "Ramadan 25, 2024", "Residential Area"));
            events.add(new SocialEvent("Independence Day Celebration", "9:00 AM", "March 26, 2024", "Various Locations"));
            events.add(new SocialEvent("Durga Puja Festival", "10:00 AM", "October 5, 2024", "Puja Pandals"));
            events.add(new SocialEvent("Bengali New Year Mela", "10:00 AM", "April 15, 2024", "Dhaka University Campus"));
            events.add(new SocialEvent("Chobi Mela International Photo Fest", "11:00 AM", "January 30, 2024", "Various Galleries"));
        }
        eventsTableView.getItems().addAll(events);
    }


    private void saveData() {
        List<SocialEvent> events = new ArrayList<>(eventsTableView.getItems());
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(events);
        } catch (IOException e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to save data.");
        }
    }

    private List<SocialEvent> loadData() {
        List<SocialEvent> events = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            events = (List<SocialEvent>) ois.readObject();
        } catch (FileNotFoundException e) {
            showAlert(Alert.AlertType.ERROR, "Error", "No saved data found.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to load data.");
        }
        return events;
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
