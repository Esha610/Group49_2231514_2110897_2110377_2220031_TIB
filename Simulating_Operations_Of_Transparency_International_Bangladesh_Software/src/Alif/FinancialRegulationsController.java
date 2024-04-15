
package Alif;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;



//asd

public class FinancialRegulationsController implements Initializable {

    @FXML
    private Button regulatoryMonitoring;
    @FXML
    private Button reportAssessment;
    @FXML
    private Button controlsDevelopment;
    @FXML
    private Button training;
    @FXML
    private Button documentation;
    @FXML
    private Button oversight;
    @FXML
    private Button theImprovement;
    @FXML
    private Button auditCoordination;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void regulatoryMonitoringButtonMouseOnClicked(ActionEvent event) {
    }

    @FXML
    private void reportAssessmentButtonMouseOnClicked(ActionEvent event) {
    }

    @FXML
    private void controlsDevelopmentButtonMouseOnClicked(ActionEvent event) {
    }

    @FXML
    private void trainingButtonMouseOnClicked(ActionEvent event) {
    }

    @FXML
    private void documentationButtonMouseOnClicked(ActionEvent event) {
    }

    @FXML
    private void oversightButtonMouseOnClicked(ActionEvent event) {
    }

    @FXML
    private void theImprovementButtonMouseOnClicked(ActionEvent event) {
        
    }

    @FXML
    private void auditCoordinationButtonMouseOnClicked(ActionEvent event) {
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
