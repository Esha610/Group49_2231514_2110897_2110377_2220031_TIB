
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

/**
 * FXML Controller class
 *
 * @author mumta
 */
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
