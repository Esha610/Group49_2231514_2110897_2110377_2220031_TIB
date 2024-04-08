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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ExecutiveDirectorController implements Initializable {

    @FXML private Button logout;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        logout.setCursor(Cursor.HAND);
    }    

    @FXML
    private void LogoutButtonOnClick(ActionEvent event) {
        loadScene("/mainpkg/LoginSc.fxml", event);

    }

    @FXML
    private void StakeholderEngagementButtonOnClick(ActionEvent event)     {
        
        loadScene("/Shanto/StakeholderEngagement.fxml", event);        
        
    }

    @FXML
    private void SocialEventsSheduleButtonOnClick(ActionEvent event) {
        
        loadScene("/Shanto/SocialEventsSchedule.fxml", event);        
        
    }

    @FXML
    private void NewrecruitmentButtonOnClick(ActionEvent event) {
        
        loadScene("/Shanto/NewRecruitment.fxml", event);        

    }

    @FXML
    private void TransferRequestsButtonOnClick(ActionEvent event) {
        
        loadScene("/Shanto/TransferRequests.fxml", event);        
        
    }

    @FXML
    private void BudgetandControlButtonOnClick(ActionEvent event) {
        
        loadScene("/Shanto/BudgetandControl.fxml", event);        
   
    }

    @FXML
    private void TeamBuildingandDevelopmentButtonOnClick(ActionEvent event) {
        
        loadScene("/Shanto/TeamBuildingandDevelopment.fxml", event);        
    
    }

    @FXML
    private void ResourceMobilizationOnClick(ActionEvent event) {
        
        loadScene("/Shanto/ResourceMobilization.fxml", event);        
 
    }
    

    @FXML
    private void OfficialMeetsButtonOnClick(ActionEvent event) {
        
        loadScene("/Shanto/OfficialMeets.fxml", event);        
       
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
