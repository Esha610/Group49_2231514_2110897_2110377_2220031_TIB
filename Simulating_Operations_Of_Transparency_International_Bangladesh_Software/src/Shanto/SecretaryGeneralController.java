
package Shanto;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class SecretaryGeneralController implements Initializable {

    @FXML    private Button logout;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
        logout.setCursor(Cursor.HAND);
    } 

    @FXML
    private void LogoutButtonOnClick(ActionEvent event) {
        
        loadScene("/mainpkg/LoginSc.fxml", event);

    }

    @FXML
    private void OperationalManagementButtonOnClick(ActionEvent event) {
        
        loadScene("/Shanto/OperationalManagement.fxml", event);        
    }

    @FXML
    private void QualityAssuranceButtonOnClick(ActionEvent event) {
        
        loadScene("/Shanto/QualityAssurance.fxml", event);
    }

    @FXML
    private void CrisisManagementButtonOnClick(ActionEvent event) {
        
        loadScene("/Shanto/CrisisManagement.fxml", event);

    }

    @FXML
    private void StrategicPlanningSupportButtonOnClick(ActionEvent event) {

        loadScene("/Shanto/StrategicPlanning.fxml", event);
    }

    @FXML
    private void AdministrativeOversightButtonOnClick(ActionEvent event) {
        
        loadScene("/Shanto/AdministrativeOversight.fxml", event);
    }

    @FXML
    private void CapacityBuildingButtonOnClick(ActionEvent event) {

        loadScene("/Shanto/CapacityBuilding.fxml", event);
    }

    @FXML
    private void ResearchandPolicyAnalysisButtonOnClick(ActionEvent event) {
        
        loadScene("/Shanto/ResearchAndPolicyAnalysis.fxml", event);
    }

    @FXML
    private void RiskManagementButtonOnClick(ActionEvent event) {
        
        loadScene("/Shanto/RiskManagement.fxml", event);
    }
    
    @FXML
    private void BudgetandControlButtonOnClick(ActionEvent event) {
        
        loadScene("/Shanto/ViewBudgetandControl.fxml", event);        
   
    }
    
    @FXML
    private void addResourceMobilizationOnClick(ActionEvent event) {
        
        loadScene("/Shanto/AddResourceMobilization.fxml", event);    
    }


    
    //---------------------------------------------------------------------------------------------------------------
    
    
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
