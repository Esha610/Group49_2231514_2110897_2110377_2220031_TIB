
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
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class SecretaryGeneralController implements Initializable {

    @FXML    private Button logout;
    @FXML    private Label secretaryGeneral;

    
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
        
        loadScene("OperationalManagement.fxml", event);        
    }

    @FXML
    private void QualityAssuranceButtonOnClick(ActionEvent event) {
        
        loadScene("QualityAssurance.fxml", event);
    }

    @FXML
    private void CrisisManagementButtonOnClick(ActionEvent event) {
        
        loadScene("CrisisManagement.fxml", event);

    }

    @FXML
    private void StrategicPlanningSupportButtonOnClick(ActionEvent event) {

        loadScene("StrategicPlanning.fxml", event);
    }

    @FXML
    private void AdministrativeOversightButtonOnClick(ActionEvent event) {
        
        loadScene("AdministrativeOversight.fxml", event);
    }

    @FXML
    private void CapacityBuildingButtonOnClick(ActionEvent event) {

        loadScene("CapacityBuilding.fxml", event);
    }

    @FXML
    private void ResearchandPolicyAnalysisButtonOnClick(ActionEvent event) {
        
        loadScene("ResearchAndPolicyAnalysis.fxml", event);
    }

    @FXML
    private void RiskManagementButtonOnClick(ActionEvent event) {
        
        loadScene("RiskManagement.fxml", event);
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
