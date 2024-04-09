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

    @FXML    private TableView<String> eventsTableView;
    @FXML    private TableColumn<String, String> socialEventsNameTimeDateLocationTableColumn;
    @FXML    private TextField newEventField;

    private ObservableList<String> eventsData= FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        eventsTableView.setItems(eventsData);
        socialEventsNameTimeDateLocationTableColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()));
    }

    @FXML
    private void viewAllEvents(ActionEvent event) {
        eventsData.clear();
        ArrayList<String> sampleEvents = new ArrayList<>();
        sampleEvents.add("          Pohela Boishakh Celebration                   9:00 AM                      April 14, 2024                          Various Locations");
        sampleEvents.add("          Victory Day Parade                            9:00 AM                      December 16, 2024                       National Parade Ground");
        sampleEvents.add("          Ekushey Book Fair                             3:00 PM                      February 1, 2024                        Bangla Academy");
        sampleEvents.add("          Dhaka International Film Festival             6:00 PM                      January 12, 2024                        Various Cinemas");
        sampleEvents.add("          Bangabandhu Birth Anniversary                 10:00 AM                     March 17, 2024                          National Memorial");
        sampleEvents.add("          Ramadan Iftar Party                           6:30 PM                      Ramadan 25, 2024                        Residential Area");
        sampleEvents.add("          Independence Day Celebration                  9:00 AM                      March 26, 2024                          Various Locations");
        sampleEvents.add("          Durga Puja Festival                           10:00 AM                     October 5, 2024                         Puja Pandals");
        sampleEvents.add("          Bengali New Year Mela                         10:00 AM                     April 15, 2024                          Dhaka University Campus");
        sampleEvents.add("          Chobi Mela International Photo Fest           11:00 AM                     January 30, 2024                        Various Galleries");
        eventsData.addAll(sampleEvents);
    }

    @FXML
    private void addNewEvent(ActionEvent event) {
        String newEvent = newEventField.getText();
        if (!newEvent.isEmpty()) {
            eventsData.add(newEvent);
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
