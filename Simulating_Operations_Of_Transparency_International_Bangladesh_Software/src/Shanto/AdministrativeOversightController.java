
package Shanto;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class AdministrativeOversightController implements Initializable {

    @FXML
    private TextField budgetField;
    @FXML
    private TableView<String> complianceTableView;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize TableView
        TableColumn<String, String> column = new TableColumn<>("Compliance Data");
        column.setCellValueFactory(new PropertyValueFactory<>(""));
        complianceTableView.getColumns().add(column);

        // Populate TableView with sample data
        ObservableList<String> data = FXCollections.observableArrayList(
            "Compliance Data 1",
            "Compliance Data 2",
            "Compliance Data 3"
        );
        complianceTableView.setItems(data);
    }


    @FXML
    private void exitApplication(ActionEvent event) {
        // Exit the application
        Platform.exit();
    }

    @FXML
    private void viewBudget(ActionEvent event) {
        // Implement code to view the budget
        // For demonstration purposes, show a message indicating that the budget is being viewed
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("View Budget");
        alert.setHeaderText(null);
        alert.setContentText("Viewing budget..."); 
        alert.showAndWait();
    }

    @FXML
    private void updateBudget(ActionEvent event) {
        // Implement code to update the budget
        // For demonstration purposes, show a message indicating that the budget is being updated
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Update Budget");
        alert.setHeaderText(null);
        alert.setContentText("Updating budget..."); 
        alert.showAndWait();
    }

    @FXML
    private void viewCompliance(ActionEvent event) {
        // Implement code to view compliance data
        // For demonstration purposes, show a message indicating that compliance data is being viewed
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("View Compliance Data");
        alert.setHeaderText(null);
        alert.setContentText("Viewing compliance data..."); 
        alert.showAndWait();
    }

    @FXML
    private void manageCompliance(ActionEvent event) {
        // Implement code to manage compliance
        // For demonstration purposes, show a message indicating that compliance management is being performed
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Manage Compliance");
        alert.setHeaderText(null);
        alert.setContentText("Managing compliance..."); 
        alert.showAndWait();
    }

    @FXML
    private void viewBudgetDetails(ActionEvent event) {
        // Implement code to view detailed budget information
        // For demonstration purposes, show a message indicating that detailed budget information is being viewed
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("View Budget Details");
        alert.setHeaderText(null);
        alert.setContentText("Viewing detailed budget information..."); 
        alert.showAndWait();
    }

    @FXML
    private void refreshCompliance(ActionEvent event) {
        // Implement code to refresh compliance data
        // For demonstration purposes, show a message indicating that compliance data is being refreshed
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Refresh Compliance Data");
        alert.setHeaderText(null);
        alert.setContentText("Refreshing compliance data..."); 
        alert.showAndWait();
    }



}
