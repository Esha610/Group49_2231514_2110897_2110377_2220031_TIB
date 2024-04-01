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
import javafx.stage.Stage;

public class ExecutiveDirectorController implements Initializable {

    @FXML private Button logout;
    @FXML private Label executivedirector;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        logout.setCursor(Cursor.HAND);
    }    

    @FXML
    private void LogoutButtonOnClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginSc.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage currentStage = (Stage) logout.getScene().getWindow();
            currentStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void StakeholderEngagementButtonOnClick(ActionEvent event)     {
        
        
        try {           
            FXMLLoader loader = new FXMLLoader(getClass().getResource("StakeholderEngagement.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } 
        catch (IOException e) {
            e.printStackTrace();          
        }
    }

    @FXML
    private void SocialEventsSheduleButtonOnClick(ActionEvent event) {
        
        try {           
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SocialEventsSchedule.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } 
        catch (IOException e) {
            e.printStackTrace();          
        }
        
      
    }

    @FXML
    private void NewrecruitmentButtonOnClick(ActionEvent event) {
        
        try {           
            FXMLLoader loader = new FXMLLoader(getClass().getResource("NewRecruitment.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } 
        catch (IOException e) {
            e.printStackTrace();          
        }
        
    }

    @FXML
    private void TransferRequestsButtonOnClick(ActionEvent event) {
        
        try {           
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TransferRequests.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } 
        catch (IOException e) {
            e.printStackTrace();          
        }
        
    }

    @FXML
    private void BudgetandControlButtonOnClick(ActionEvent event) {
        
        try {           
            FXMLLoader loader = new FXMLLoader(getClass().getResource("BudgetandControl.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } 
        catch (IOException e) {
            e.printStackTrace();          
        }
        
    }

    @FXML
    private void TeamBuildingandDevelopmentButtonOnClick(ActionEvent event) {
        
        try {           
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TeamBuildingandDevelopment.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } 
        catch (IOException e) {
            e.printStackTrace();          
        }
        
    }

    @FXML
    private void ResourceMobilizationOnClick(ActionEvent event) {
        
        try {           
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ResourceMobilization.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } 
        catch (IOException e) {
            e.printStackTrace();          
        }
        
    }
    

    @FXML
    private void OfficialMeetsButtonOnClick(ActionEvent event) {
        
        try {           
            FXMLLoader loader = new FXMLLoader(getClass().getResource("OfficialMeets.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } 
        catch (IOException e) {
            e.printStackTrace();          
        }
        
    }
    
}
