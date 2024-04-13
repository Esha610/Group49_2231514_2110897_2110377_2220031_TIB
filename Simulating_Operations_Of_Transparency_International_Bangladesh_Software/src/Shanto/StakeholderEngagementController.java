package Shanto;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class StakeholderEngagementController implements Initializable {

    @FXML    private ListView<String> stakeholderListView;
    @FXML    private TextField stakeholderNameField;
    @FXML    private TextField stakeholderDescriptionArea;

    private ObservableList<String> stakeholderItems = FXCollections.observableArrayList();
    private StakeholderDescriptions stakeholderDescriptions = new StakeholderDescriptions();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        stakeholderListView.setItems(stakeholderItems);
    }

    @FXML
    private void exitApplication(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    private void viewAllStakeholders(ActionEvent event) {
        ArrayList<String> allStakeholders = new ArrayList<>();
        allStakeholders.add("Government of Bangladesh");
        allStakeholders.add("Non-Governmental Organizations (NGOs)");
        allStakeholders.add("Private Sector Companies (e.g., BRAC, Grameenphone)");
        allStakeholders.add("International Development Agencies (e.g., World Bank, UNDP)");
        allStakeholders.add("Local Communities (e.g., residents of a specific village)");
        allStakeholders.add("Civil Society Organizations (e.g., Transparency International Bangladesh)");
        allStakeholders.add("Academic Institutions (e.g., Dhaka University, BRAC University)");
        allStakeholders.add("Media Organizations (e.g., Prothom Alo, bdnews24.com)");
        allStakeholders.add("Trade Unions (e.g., Bangladesh Garment Sramik Samhati)");
        allStakeholders.add("Environmental Activists (e.g., Bangladesh Poribesh Andolon)");
        stakeholderItems.setAll(allStakeholders);
    }

    @FXML
    private void addNewStakeholder(ActionEvent event) {
        String newStakeholderName = stakeholderNameField.getText();
        String newStakeholderDescription = stakeholderDescriptionArea.getText();

        if (!newStakeholderName.isEmpty() && !newStakeholderDescription.isEmpty()) {
            stakeholderItems.add(newStakeholderName);
            stakeholderDescriptions.put(newStakeholderName, newStakeholderDescription);
            stakeholderNameField.clear();
            stakeholderDescriptionArea.clear();
        } else {
            showAlert(Alert.AlertType.ERROR, "Error", "Please enter both stakeholder name and description.");
        }
    }

    @FXML
    private void viewDescription(ActionEvent event) {
        String selectedStakeholder = stakeholderListView.getSelectionModel().getSelectedItem();
        if (selectedStakeholder != null) {
            String description = getDescription(selectedStakeholder);
            stakeholderDescriptionArea.setText(description);
        } else {
            showAlert(Alert.AlertType.ERROR, "Error", "Please select a stakeholder to view its description.");
        }
    }

    private String getDescription(String stakeholderName) {
        String description = stakeholderDescriptions.getDescription(stakeholderName);
        if (description != null) {
            return description;
        } else {
            switch (stakeholderName) {
                case "Government of Bangladesh":
                    return "The Government of Bangladesh, often referred to as the GoB,\n is the central governing authority of the country.\n It oversees the administration of various sectors including education, health, finance, and infrastructure.";
                case "Non-Governmental Organizations (NGOs)":
                    return "Non-Governmental Organizations (NGOs) are non-profit organizations\n independent of the government. They play a\n crucial role in social development, providing services such as healthcare, education, and poverty alleviation.";
                case "Private Sector Companies (e.g., BRAC, Grameenphone)":
                    return "Private sector companies in Bangladesh operate across various\n industries such as telecommunications, banking,\n manufacturing, and retail. They contribute significantly to the country's economy and employment.";
                case "International Development Agencies (e.g., World Bank, UNDP)":
                    return "International development agencies collaborate with the government\n and local organizations to support development\n initiatives in Bangladesh. They provide financial assistance, technical expertise, and policy advice.";
                case "Local Communities (e.g., residents of a specific village)":
                    return "Local communities in Bangladesh represent the grassroots level of\n society. They are composed of individuals living\n in specific geographical areas and often work together to address local issues and promote development.";
                case "Civil Society Organizations (e.g., Transparency International Bangladesh)":
                    return "Civil society organizations (CSOs) in Bangladesh play a vital role in\n advocating for human rights, democracy, and\n good governance. They engage in activities such as monitoring government actions, conducting research, and raising public awareness.";
                case "Academic Institutions (e.g., Dhaka University, BRAC University)":
                    return "Academic institutions in Bangladesh provide higher education and research\n opportunities in various fields. They contribute\n to knowledge creation, skill development, and intellectual growth.";
                case "Media Organizations (e.g., Prothom Alo, bdnews24.com)":
                    return "Media organizations in Bangladesh, including newspapers, television channels,\n and online platforms, play a crucial role\n in disseminating information, shaping public opinion, and promoting accountability.";
                case "Trade Unions (e.g., Bangladesh Garment Sramik Samhati)":
                    return "Trade unions represent the collective interests of workers in Bangladesh.\n They advocate for labor rights, negotiate with\n employers on behalf of workers, and work to improve working conditions and wages.";
                case "Environmental Activists (e.g., Bangladesh Poribesh Andolon)":
                    return "Environmental activists in Bangladesh raise awareness about environmental\n issues, advocate for sustainable development\n practices, and mobilize communities to protect natural resources and mitigate environmental degradation.";
                default:
                    return "No description available for " + stakeholderName;
                }
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
