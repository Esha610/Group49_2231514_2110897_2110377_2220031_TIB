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

public class SocialEventsScheduleController implements Initializable {

    @FXML private TableView<SocialEvent> eventsTableView;
    @FXML private TableColumn<SocialEvent, String> socialEventsNameTimeDateLocationTableColumn;
    @FXML private TextField newEventField;

    private ObservableList<SocialEvent> eventsData = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        eventsTableView.setItems(eventsData);
        socialEventsNameTimeDateLocationTableColumn.setCellValueFactory(cellData -> new SimpleStringProperty(
                cellData.getValue().getEventName() + "          " + 
                cellData.getValue().getEventTime() + "          " + 
                cellData.getValue().getEventDate() + "          " + 
                cellData.getValue().getEventLocation()));
    }

    @FXML
    private void viewAllEvents(ActionEvent event) {
        eventsData.clear();
        ArrayList<SocialEvent> sampleEvents = new ArrayList<>();
        sampleEvents.add(new SocialEvent("Pohela Boishakh Celebration",                 "9:00 AM",          "April 14, 2024",           "Various Locations"));
        sampleEvents.add(new SocialEvent("Victory Day Parade",                          "9:00 AM",          "December 16, 2024",        "National Parade Ground"));
        sampleEvents.add(new SocialEvent("Ekushey Book Fair",                           "3:00 PM",          "February 1, 2024",         "Bangla Academy"));
        sampleEvents.add(new SocialEvent("Dhaka International Film Festival",           "6:00 PM",          "January 12, 2024",         "Various Cinemas"));
        sampleEvents.add(new SocialEvent("Bangabandhu Birth Anniversary",               "10:00 AM",         "March 17, 2024",           "National Memorial"));
        sampleEvents.add(new SocialEvent("Ramadan Iftar Party",                         "6:30 PM",          "Ramadan 25, 2024",         "Residential Area"));
        sampleEvents.add(new SocialEvent("Independence Day Celebration",                "9:00 AM",          "March 26, 2024",           "Various Locations"));
        sampleEvents.add(new SocialEvent("Durga Puja Festival",                         "10:00 AM",         "October 5, 2024",          "Puja Pandals"));
        sampleEvents.add(new SocialEvent("Bengali New Year Mela",                       "10:00 AM",         "April 15, 2024",           "Dhaka University Campus"));
        sampleEvents.add(new SocialEvent("Chobi Mela International Photo Fest",         "11:00 AM",         "January 30, 2024",         "Various Galleries"));
        eventsData.addAll(sampleEvents);    
    }

    @FXML
    private void addNewEvent(ActionEvent event) {
        String newEvent = newEventField.getText();
        if (!newEvent.isEmpty()) {
            eventsData.add(new SocialEvent(newEvent, "", "", ""));
            newEventField.clear();
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
