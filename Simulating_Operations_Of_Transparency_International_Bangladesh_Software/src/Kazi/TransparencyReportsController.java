package Kazi;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class TransparencyReportsController implements Initializable {

    @FXML
    private ListView<String> reportListView;
    @FXML
    private TextField newReportField;


@Override
public void initialize(URL url, ResourceBundle rb) {

    reportListView.getItems().addAll(
        "Annual Financial Report 2023",
        "Corruption Perception Index 2023",
        "Human Rights Watch Report on Bangladesh 2023",
        "World Bank Development Report 2023",
        "Global Corruption Barometer 2023",
        "Transparency International Bangladesh Annual Report 2023",
        "United Nations Sustainable Development Goals Progress Report 2023",
        "Corporate Social Responsibility Report 2023",
        "Environmental Impact Assessment Report for XYZ Project",
        "Healthcare Access and Quality Index Report 2023"
    );
}


    @FXML
    private void openReport(ActionEvent event) {

        String selectedReport = reportListView.getSelectionModel().getSelectedItem();
        if (selectedReport != null) {

            String reportDescription = "";

            switch (selectedReport) {
                case "Annual Financial Report 2023":
                    reportDescription = "This report provides a comprehensive overview of the financial performance of the organization for the fiscal year 2023.";
                    break;
                case "Corruption Perception Index 2023":
                    reportDescription = "The Corruption Perception Index (CPI) 2023 ranks countries based on perceived levels of public sector corruption. It provides insights into corruption trends globally.";
                    break;
                case "Human Rights Watch Report on Bangladesh 2023":
                    reportDescription = "The Human Rights Watch Report on Bangladesh 2023 documents human rights abuses and violations in Bangladesh, highlighting areas of concern and recommendations for improvement.";
                    break;
                case "World Bank Development Report 2023":
                    reportDescription = "The World Bank Development Report 2023 analyzes global development trends and challenges, focusing on key issues such as poverty reduction, education, and infrastructure.";
                    break;
                case "Global Corruption Barometer 2023":
                    reportDescription = "The Global Corruption Barometer 2023 surveys public perceptions of corruption worldwide, providing insights into citizens' experiences and attitudes towards corruption.";
                    break;
                case "Transparency International Bangladesh Annual Report 2023":
                    reportDescription = "The Transparency International Bangladesh Annual Report 2023 outlines the organization's activities, achievements, and challenges in combating corruption in Bangladesh.";
                    break;
                case "United Nations Sustainable Development Goals Progress Report 2023":
                    reportDescription = "The United Nations Sustainable Development Goals Progress Report 2023 assesses progress towards achieving the Sustainable Development Goals (SDGs) globally, highlighting successes and areas needing improvement.";
                    break;
                case "Corporate Social Responsibility Report 2023":
                    reportDescription = "The Corporate Social Responsibility Report 2023 details the organization's initiatives and impact in areas such as environmental sustainability, community development, and ethical business practices.";
                    break;
                case "Environmental Impact Assessment Report for XYZ Project":
                    reportDescription = "The Environmental Impact Assessment (EIA) Report for the XYZ Project evaluates the potential environmental consequences of the project, including impacts on air quality, water resources, and biodiversity.";
                    break;
                case "Healthcare Access and Quality Index Report 2023":
                    reportDescription = "The Healthcare Access and Quality Index Report 2023 assesses the availability and quality of healthcare services in different countries, highlighting disparities and areas for improvement.";
                    break;
                default:
                    reportDescription = "Description not available.";
                    break;
            }

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Open Report");
            alert.setHeaderText(selectedReport);
            alert.setContentText(reportDescription);
            alert.showAndWait();
        } else {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please select a report to open.");
            alert.showAndWait();
        }
    }

    @FXML
    private void exitApplication(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void createReport(ActionEvent event) {
       
        String newReportName = newReportField.getText();
        if (!newReportName.isEmpty()) {          
            reportListView.getItems().add(newReportName);         
            newReportField.clear();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a name for the new report.");
            alert.showAndWait();
        }
    }

    @FXML
    private void logout(ActionEvent event) {
            loadScene("/mainpkg/LoginSc.fxml", event);
    }

    @FXML
    private void goBack(ActionEvent event) {

            loadScene("/Kazi/Citizens.fxml", event);
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
