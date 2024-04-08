package Shanto;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class StrategicPlanningController implements Initializable {

    @FXML
    private TextField newStrategicGoalField;
    @FXML
    private ListView<String> goalsListView;
    @FXML
    private TextField newActionPlanField;

    
    
    private ObservableList<String> goalItems;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        goalItems = FXCollections.observableArrayList();
        goalsListView.setItems(goalItems);
    }

    @FXML
    private void exitApplication(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    private void viewGoals(ActionEvent event) {
        // Implement logic to view all strategic goals
    }

    @FXML
    private void addGoal(ActionEvent event) {
        String newGoal = newStrategicGoalField.getText();
        if (!newGoal.isEmpty()) {
            goalItems.add(newGoal);
            newStrategicGoalField.clear();
        } else {
            showAlert(Alert.AlertType.ERROR, "Error", "Please enter a strategic goal.");
        }
    }

    @FXML
    private void viewActionPlans(ActionEvent event) {
         }

    @FXML
    private void createPlan(ActionEvent event) {
        String newActionPlan = newActionPlanField.getText();
        if (!newActionPlan.isEmpty()) {
            // Implement logic to create new action plan for selected goal
            newActionPlanField.clear();
        } else {
            showAlert(Alert.AlertType.ERROR, "Error", "Please enter a new action plan.");
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

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
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
