package Shanto;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;

public class RiskManagementController implements Initializable {

    @FXML    private TableView<String> riskAssessmentTableView;
    @FXML    private TableColumn<String, String> riskTypeColumn;
    @FXML    private TableView<String> riskMitigationTableView;
    @FXML    private TableColumn<String, String> mitigationActionColumn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        riskTypeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()));
        riskAssessmentTableView.getItems().addAll(
            "Financial Risks", "Operational Risks", "Strategic Risks", "Compliance Risks", "Technological Risks",
            "Market Risks", "Reputational Risks", "Legal Risks", "Environmental Risks", "Human Resources Risks"
        );      
        mitigationActionColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()));
        riskMitigationTableView.getItems().addAll(
            "Implement risk monitoring and reporting systems", "Develop contingency plans for key operational areas",
            "Strengthen internal controls and compliance frameworks", "Enhance cybersecurity measures and data protection",
            "Diversify revenue streams and investment portfolios", "Conduct regular risk assessments and scenario analyses",
            "Engage in stakeholder communication and transparency efforts", "Review and update legal and regulatory compliance",
            "Implement sustainable practices and environmental management systems", "Invest in employee training and development"
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
    private void viewRiskAssessmentDetails(ActionEvent event) {
        String selectedRisk = riskAssessmentTableView.getSelectionModel().getSelectedItem();
        if (selectedRisk != null) {
            String details = getRiskAssessmentDetails(selectedRisk);
            displayDetails("Risk Assessment Details", details);
        } else {
            displayNoSelectionAlert("Risk Assessment Details");
        }
    }

    @FXML
    private void viewRiskMitigationDetails(ActionEvent event) {
        String selectedMitigation = riskMitigationTableView.getSelectionModel().getSelectedItem();
        if (selectedMitigation != null) {
            String details = getRiskMitigationDetails(selectedMitigation);
            displayDetails("Risk Mitigation Details", details);
        } else {
            displayNoSelectionAlert("Risk Mitigation Details");
        }
    }

   private String getRiskAssessmentDetails(String risk) {
    switch (risk) {
        case "Financial Risks":
            return "Risk Type: Financial Risks\n"
                 + "Likelihood: High\n"
                 + "Impact: Severe\n"
                 + "Mitigation Measures: Strengthen internal controls and financial reporting systems";
        case "Operational Risks":
            return "Risk Type: Operational Risks\n"
                 + "Likelihood: Medium\n"
                 + "Impact: Moderate\n"
                 + "Mitigation Measures: Develop contingency plans for key operational areas";
        case "Strategic Risks":
            return "Risk Type: Strategic Risks\n"
                 + "Likelihood: Low\n"
                 + "Impact: High\n"
                 + "Mitigation Measures: Conduct regular strategic reviews and scenario analyses";
        default:
            return "Risk Type: " + risk + "\n"
                 + "Likelihood: High\n"
                 + "Impact: Severe\n"
                 + "Mitigation Measures: Implement risk monitoring and reporting systems";
    }
}

private String getRiskMitigationDetails(String mitigation) {
    switch (mitigation) {
        case "Implement risk monitoring and reporting systems":
            return "Mitigation Action: Implement risk monitoring and reporting systems\n"
                 + "Responsibility: Risk Management Team\n"
                 + "Timeline: Immediate\n"
                 + "Status: In Progress";
        case "Develop contingency plans for key operational areas":
            return "Mitigation Action: Develop contingency plans for key operational areas\n"
                 + "Responsibility: Operations Department\n"
                 + "Timeline: 1 month\n"
                 + "Status: Planning Phase";
        case "Strengthen internal controls and compliance frameworks":
            return "Mitigation Action: Strengthen internal controls and compliance frameworks\n"
                 + "Responsibility: Compliance Team\n"
                 + "Timeline: Ongoing\n"
                 + "Status: Implemented";
        default:
            return "Mitigation Action: " + mitigation + "\n"
             + "Responsibility: Risk Management Team\n"
             + "Timeline: Immediate\n"
             + "Status: In Progress";
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
