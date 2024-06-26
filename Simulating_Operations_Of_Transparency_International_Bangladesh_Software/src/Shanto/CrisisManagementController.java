package Shanto;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.beans.property.SimpleStringProperty;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CrisisManagementController implements Initializable {

    @FXML    private TableView<String> crisisTypesTableView;
    @FXML    private TableColumn<String, String> crisisTypeColumn;
    @FXML    private TableColumn<String, String> crisisDetailsColumn;
    @FXML    private TableView<String> responseActionsTableView;
    @FXML    private TableColumn<String, String> responseActionColumn;
    @FXML    private TableColumn<String, String> responseDetailsColumn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
        crisisTypeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()));
        crisisTypesTableView.getItems().addAll(
            "Natural Disasters", "Cybersecurity Breaches",
            "Workplace Accidents", "Product Recalls",
            "Financial Crises","Public Health Emergencies",
            "Terrorist Attacks", "Environmental Disasters",
            "Supply Chain Disruptions", "Reputation Crises"
        );      
        responseActionColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()));
        responseActionsTableView.getItems().addAll(
            "Activate emergency response teams and protocols", "Conduct threat assessments and forensic investigations",
            "Provide immediate medical assistance and first aid", "Implement recall procedures and notify affected parties",
            "Engage financial experts and regulators to stabilize markets", "Mobilize healthcare resources and coordinate with public health agencies",
            "Coordinate with law enforcement and security agencies to ensure public safety", "Initiate environmental cleanup efforts and containment measures",
            "Identify alternative suppliers and logistics routes", "Implement crisis communication strategies to protect reputation and maintain transparency"
        );
    }


   

    @FXML
    private void exitApplication(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void goBack(ActionEvent event) {
        loadScene("/Shanto/SecretaryGeneral.fxml", event);
    }

    @FXML
    private void logOut(ActionEvent event) {
        loadScene("/mainpkg/LoginSc.fxml", event);
    }

    @FXML
    private void viewCrisisDetails(ActionEvent event) {
        String selectedCrisis = crisisTypesTableView.getSelectionModel().getSelectedItem();
        if (selectedCrisis != null) {
            String details = getCrisisDetails(selectedCrisis);
            displayDetails("Crisis Details", details);
        } else {
            displayNoSelectionAlert("Crisis Details");
        }
    }

    @FXML
    private void viewResponseDetails(ActionEvent event) {
        String selectedResponse = responseActionsTableView.getSelectionModel().getSelectedItem();
        if (selectedResponse != null) {
            String details = getResponseDetails(selectedResponse);
            displayDetails("Response Details", details);
        } else {
            displayNoSelectionAlert("Response Details");
        }
    }

        private String getCrisisDetails(String crisis) {
        switch (crisis) {
            case "Natural Disasters":
                return "Crisis: Natural Disasters\n"
                     + "Severity: High\n"
                     + "Affected Area: Operations\n"
                     + "Date: 02/15/2024";
            case "Cybersecurity Breaches":
                return "Crisis: Cybersecurity Breaches\n"
                     + "Severity: Critical\n"
                     + "Affected Area: Information Technology\n"
                     + "Date: 02/20/2024";
            case "Workplace Accidents":
                return "Crisis: Workplace Accidents\n"
                     + "Severity: Moderate\n"
                     + "Affected Area: Health and Safety\n"
                     + "Date: 02/25/2024";
            default:
                return "Crisis: " + crisis + "\n"
                     + "Severity: High\n"
                     + "Affected Area: Operations\n"
                     + "Date: 02/15/2024";
        }
    }

    private String getResponseDetails(String response) {
        switch (response) {
            case "Activate emergency response teams and protocols":
                return "Response: Activate emergency response teams and protocols\n"
                     + "Action Plan: Initiate emergency procedures and mobilize response teams\n"
                     + "Lead: Crisis Management Director\n"
                     + "Status: Ongoing";
            case "Conduct threat assessments and forensic investigations":
                return "Response: Conduct threat assessments and forensic investigations\n"
                     + "Action Plan: Investigate security breaches and analyze potential threats\n"
                     + "Lead: Security Officer\n"
                     + "Status: In Progress";
            case "Provide immediate medical assistance and first aid":
                return "Response: Provide immediate medical assistance and first aid\n"
                     + "Action Plan: Deploy medical personnel and resources to affected areas\n"
                     + "Lead: Health and Safety Coordinator\n"
                     + "Status: Completed";
            default:
                return "Response: " + response + "\n"
                    + "Action Plan: Activate crisis management team\n"
                    + "Lead: Crisis Management Director\n"
                    + "Status: Ongoing";
        }
    }

    private void displayDetails(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void displayNoSelectionAlert(String title) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText("Please select a row to view details.");
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
