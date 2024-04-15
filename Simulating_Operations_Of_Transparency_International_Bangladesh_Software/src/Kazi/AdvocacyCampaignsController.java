package Kazi;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AdvocacyCampaignsController implements Initializable {

    @FXML
    private ListView<String> campaignListView;
    @FXML
    private TextField newCampaignsField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        campaignListView.getItems().addAll(getSampleCampaigns());
    }    

    private List<String> getSampleCampaigns() {
        List<String> campaigns = new ArrayList<>();
        campaigns.add("Summer Sale 2024");
        campaigns.add("Back to School Campaign");
        campaigns.add("Holiday Season Specials");
        campaigns.add("New Year's Resolution Deals");
        campaigns.add("Valentine's Day Promotions");
        campaigns.add("Spring Clearance Event");
        campaigns.add("Mother's Day Specials");
        campaigns.add("Father's Day Deals");
        campaigns.add("Graduation Celebration Sale");
        campaigns.add("Black Friday Extravaganza");
        return campaigns;
    }

    @FXML
    private void exitApplication(ActionEvent event) {
       
        System.exit(0);
    }

    @FXML
    private void openCampaign(ActionEvent event) {
        String selectedCampaign = campaignListView.getSelectionModel().getSelectedItem();
        if (selectedCampaign != null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Open Campaign");
            alert.setHeaderText(null);
            alert.setContentText("Opening campaign: " + selectedCampaign);
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please select a campaign to open.");
            alert.showAndWait();
        }
    }

    @FXML
    private void createCampaign(ActionEvent event) {
        String newCampaignName = newCampaignsField.getText(); // Corrected field name
        if (!newCampaignName.isEmpty()) {
            campaignListView.getItems().add(newCampaignName);
            newCampaignsField.clear(); // Corrected field name
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a name for the new campaign.");
            alert.showAndWait();
        }
    }

    @FXML
    private void deleteCampaign(ActionEvent event) {
        String selectedCampaign = campaignListView.getSelectionModel().getSelectedItem();
        if (selectedCampaign != null) {
            campaignListView.getItems().remove(selectedCampaign);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Delete Campaign");
            alert.setHeaderText(null);
            alert.setContentText("Deleted campaign: " + selectedCampaign);
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please select a campaign to delete.");
            alert.showAndWait();
        }
    }

    @FXML
    private void logout(ActionEvent event) {
            loadScene("/mainpkg/LoginSc.fxml", event);
    }

    @FXML
    private void goBack(ActionEvent event) {

            loadScene("/Kazi/Student.fxml", event);
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
