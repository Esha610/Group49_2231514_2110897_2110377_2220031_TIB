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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CrisisManagementController implements Initializable {

    @FXML
    private TableView<String> crisisTypesTableView;
    @FXML
    private TableColumn<String, String> crisisTypeColumn;
    @FXML
    private TableColumn<String, String> crisisDetailsColumn;
    @FXML
    private TableView<String> responseActionsTableView;
    @FXML
    private TableColumn<String, String> responseActionColumn;
    @FXML
    private TableColumn<String, String> responseDetailsColumn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize crisis types table
        crisisTypeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()));
        crisisTypesTableView.getItems().addAll(
            "Natural Disasters", "Cybersecurity Breaches", "Workplace Accidents", "Product Recalls", "Financial Crises",
            "Public Health Emergencies", "Terrorist Attacks", "Environmental Disasters", "Supply Chain Disruptions", "Reputation Crises"
        );

        // Initialize response actions table
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
        loadScene("ExecutiveDirector.fxml", event);
    }

    @FXML
    private void logOut(ActionEvent event) {
        loadScene("LoginSc.fxml", event);
    }

    @FXML
    private void viewCrisisDetails(ActionEvent event) {
        // Implement code to view crisis details
    }

    @FXML
    private void viewResponseDetails(ActionEvent event) {
        // Implement code to view response details
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
