
package Shanto;

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
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class SecretaryGeneralController implements Initializable {

    @FXML    private Button logout;
    @FXML    private Label secretaryGeneral;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void LogoutButtonOnClick(ActionEvent event) {
        try {          
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginSc.fxml"));
            Parent root = loader.load();          
            Scene scene = new Scene(root);           
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void OperationalManagementButtonOnClick(ActionEvent event) {
        
        try {           
            FXMLLoader loader = new FXMLLoader(getClass().getResource("OperationalManagement.fxml"));
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
    private void QualityAssuranceButtonOnClick(ActionEvent event) {
        
        try {           
            FXMLLoader loader = new FXMLLoader(getClass().getResource("QualityAssurance.fxml"));
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
    private void CrisisManagementButtonOnClick(ActionEvent event) {
        
        try {           
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CrisisManagement.fxml"));
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
    private void StrategicPlanningSupportButtonOnClick(ActionEvent event) {
        
        try {           
            FXMLLoader loader = new FXMLLoader(getClass().getResource("StrategicPlanning.fxml"));
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
    private void AdministrativeOversightButtonOnClick(ActionEvent event) {
        
        try {           
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AdministrativeOversight.fxml"));
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
    private void CapacityBuildingButtonOnClick(ActionEvent event) {
        
        try {           
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CapacityBuilding.fxml"));
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
    private void ResearchandPolicyAnalysisButtonOnClick(ActionEvent event) {
        
        try {           
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ResearchAndPolicyAnalysis.fxml"));
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
    private void RiskManagementButtonOnClick(ActionEvent event) {
        
        try {           
            FXMLLoader loader = new FXMLLoader(getClass().getResource("RiskManagement.fxml"));
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
