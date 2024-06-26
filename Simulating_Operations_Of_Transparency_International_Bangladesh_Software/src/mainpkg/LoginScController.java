package mainpkg;

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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginScController implements Initializable {

    @FXML    private TextField userIdTextField;
    @FXML    private TextField passwordTextField;
    @FXML    private ComboBox<String> userTypeComboBox;
    @FXML    private Button login;
    @FXML    private Button signupButton;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userTypeComboBox.getItems().addAll(
                 "Student"
                ,"Researcher"
                ,"Executive Director"
                ,"Secretary General"
                ,"Program Manager"
                ,"Finance and Administration Manager"
                ,"Citizen"
                ,"Legal Advisor");
 
        login.setCursor(Cursor.HAND);
        signupButton.setCursor(Cursor.HAND);

        
        userIdTextField.setText("");
        passwordTextField.setText("");
    }

    @FXML
    private void forgotPasswordButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void loginButtonOnClick(ActionEvent event) throws IOException {
        String userType = userTypeComboBox.getValue();
        if (userType == null) {
            showErrorAlert("Error", "Please select a user type.");
            return;
        }

        String username = userIdTextField.getText();
        String password = passwordTextField.getText();

        boolean isValidLogin = SignUpFile.SignUpFileRead(userType, username, password);

        if (isValidLogin) {

            String userFullName = SignUpFile.FileRead_forUserName(userType, username, password);

            
            Stage currentStage = (Stage) login.getScene().getWindow();
            if (userType.equals("Student")) {                
                loadScene("/Esha/Student.fxml", event);
            }
            
            
            if (userType.equals("Researcher")) {                
                loadScene("/Esha/Researcher.fxml", event);               
            }
            
            
            if (userType.equals("Executive Director")) {
                loadScene("/Shanto/ExecutiveDirector.fxml", event);              
            }
            
            
            if (userType.equals("Secretary General")) {
                loadScene("/Shanto/SecretaryGeneral.fxml", event);
            }
            
            
            if (userType.equals("Program Manager")) {
                loadScene("/Alif/Program Manager.fxml", event);
            }
            
            
            if (userType.equals("Finance and Administration Manager")) {
                loadScene("/Alif/FinanceAndAdministrationManager", event);
            }
            
            
            if (userType.equals("Citizen")) {
                loadScene("/Kazi/Citizen.fxml", event);         
            }
            
            
            if (userType.equals("Legal Advisor")) {
                loadScene("/Kazi/LegalAdvisor", event);
            }
            
           
        } else {

            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("Unable to Login");
            a.setContentText("UserID and Password is Invalid");
            a.showAndWait();

        }
    }
        //---------------------------------------------------------------------------------------------------------------
        @FXML
        private void signUpButtonOnClick(ActionEvent event) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Sign Up.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage currentStage = (Stage) signupButton.getScene().getWindow();
                currentStage.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void showErrorAlert(String title, String message) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(title);
            alert.setHeaderText(null);
            alert.setContentText(message);
            alert.showAndWait();
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
