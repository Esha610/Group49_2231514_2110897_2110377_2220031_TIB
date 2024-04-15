package Esha;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class EvaluationOfWorkshopController implements Initializable {

    @FXML
    private ListView<String> criteriaListView;
    @FXML
    private TextArea resultsTextArea;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Example: Set initial values for the criteria list view
        ObservableList<String> criteria = FXCollections.observableArrayList(
            "Criteria 1", "Criteria 2", "Criteria 3");
        criteriaListView.setItems(criteria);

        // Example: Load initial evaluation results
        loadInitialEvaluationResults();
    }

    private void loadInitialEvaluationResults() {
        
        List<String> initialResults = Arrays.asList(
            "Criteria 1: 80%", "Criteria 2: 75%", "Criteria 3: 90%");

       
        StringBuilder sb = new StringBuilder();
        for (String result : initialResults) {
            sb.append(result).append("\n");
        }
        resultsTextArea.setText(sb.toString());
    }

    @FXML
    private void goBack(ActionEvent event) {
       
        loadScene("/Esha/Researcher.fxml", event);
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
    

    @FXML
    private void exitApplication(ActionEvent event) {
       
        System.exit(0);
    }

    @FXML
    private void evaluateCampaign(ActionEvent event) {
       
        String selectedCriteria = criteriaListView.getSelectionModel().getSelectedItem().toString();
        
        String evaluationResults = "Results for " + selectedCriteria + ": Sample evaluation results";
        resultsTextArea.setText(evaluationResults);
    }

    @FXML
    private void clearEvaluation(ActionEvent event) {
      
        resultsTextArea.clear();
    }
}
