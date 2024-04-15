package Kazi;

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


public class CitizensController implements Initializable {

    @FXML
    private Button logout;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @FXML
    private void LogoutButtonOnClick(ActionEvent event) {
          loadScene("/mainpkg/LoginSc.fxml", event);
    }

    @FXML
    private void TransparencyReports(ActionEvent event) {
        
        loadScene("/Kazi/TransparencyReports.fxml", event);
    }
    
    @FXML
    private void AdvocacyCampaigns(ActionEvent event) {
        
        loadScene("/Kazi/AdvocacyCampaigns.fxml", event);

        
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
