
package Alif;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ProgramManagerController implements Initializable {

    @FXML
    private Button logout;
    @FXML
    private Button programObjectivesAndOrganizationalStrategy;
    @FXML
    private Button programManagement;
    @FXML
    private Button preparingAProject;
    @FXML
    private Button managingTheStakeholders;
    @FXML
    private Button managingRiskStrategies;
    @FXML
    private Button teamLeadershipAndCollaboration;
    @FXML
    private Button reportingAndDocumentation;
    @FXML
    private Button monitoringProjectProgress;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void programManagementButtonMouseOnClicked(ActionEvent event) {
        loadScene("/Alif/ProgramManagement.fxml", event);
        
    }

    @FXML
    private void preparingAProjectButtonMouseOnClicked(ActionEvent event) {
        loadScene("/Alif/PreparingAProject.fxml", event);
        
        
    }

    @FXML
    private void managingTheStakeholdersButtonMouseOnClicked(ActionEvent event) {
        loadScene("/Alif/ManagingTheStakeholders.fxml", event);
    }

    @FXML
    private void managingRiskStrategiesButtonMouseOnClicked(ActionEvent event) {
        loadScene("/Alif/ManagingRiskStrategies.fxml", event);
        
        
    }

    @FXML
    private void teamLeadershipAndCollaborationButtonMouseOnClicked(ActionEvent event) {
        loadScene("/Alif/TeamLeadershipandCollaboration.fxml", event);
    }

    @FXML
    private void reportingAndDocumentationButtonMouseOnClicked(ActionEvent event) {
        loadScene("/Alif/ReportingAndDocumentation.fxml", event);
    }

    @FXML
    private void monitoringProjectProgressButtonMouseOnClicked(ActionEvent event) {
        loadScene("/Alif/MonitoringProjectProgress.fxml", event);
        
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

    @FXML
    private void logoutButtonOnClick(ActionEvent event) {
        loadScene("/Alif/LoginSc.fxml", event);
    }

    @FXML
    private void programObjectivesAndOrganizationalStrategyButtonMouseOnClicked(ActionEvent event) {
        loadScene("/Alif/ProgramObjectivesSupportOrganizationalStrategy.fxml", event);
    }


}
