
package Esha;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;


public class HostingworkshopsController implements Initializable {

    @FXML
    private Button submitButton;
    @FXML
    private Button backButton;
    @FXML
    private Button logoutButton;
    @FXML
    private RadioButton virtualRadioButton;
    @FXML
    private RadioButton inPersonRadioButton;
    @FXML
    private TextField topicTextField;
    @FXML
    private ChoiceBox<?> locationChoiceBox;
    @FXML
    private TextField topicTextField1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @FXML
    private void submitForm(ActionEvent event) {
    }

    @FXML
    private void goBack(ActionEvent event) {
    }

    @FXML
    private void logOut(ActionEvent event) {
    }
    
}
