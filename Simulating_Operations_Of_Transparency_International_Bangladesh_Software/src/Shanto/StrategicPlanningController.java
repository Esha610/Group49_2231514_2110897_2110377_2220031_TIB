package Shanto;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class StrategicPlanningController implements Initializable {

    @FXML    private TextField newStrategicGoalField;
    @FXML    private ListView<String> goalsListView;
    @FXML    private TextField newActionPlanField;
    @FXML    private ListView<String> actionsListView;

    private ObservableList<String> goalItems = FXCollections.observableArrayList();
    private ObservableList<String> actionPlans= FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        goalsListView.setItems(goalItems);
        actionsListView.setItems(actionPlans);  
    }

    @FXML
    private void exitApplication(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    private void viewGoals(ActionEvent event) {
        ArrayList<String> allGoals = new ArrayList<>();
        allGoals.add("Enhance healthcare services and infrastructure");
        allGoals.add("Promote sustainable urban development");
        allGoals.add("Combat climate change and promote environmental sustainability");
        allGoals.add("Strengthen governance and reduce corruption");
        allGoals.add("Improve infrastructure for economic growth and job creation");
        allGoals.add("Empower women and promote gender equality");
        allGoals.add("Enhance digital infrastructure and promote ICT development");
        allGoals.add("Protect human rights and ensure access to justice for all");
        allGoals.add("Foster innovation and entrepreneurship for economic development");
        allGoals.add("Ensure access to clean water and sanitation for all");

        goalItems.setAll(allGoals);
    }

    @FXML
    private void viewActionPlans(ActionEvent event) {
        ArrayList<String> allActionPlans = new ArrayList<>();

        String selectedGoal = goalsListView.getSelectionModel().getSelectedItem();

        if (selectedGoal != null) {
            switch (selectedGoal) {
                case "Enhance healthcare services and infrastructure":
                    allActionPlans.add("Upgrade hospitals and medical facilities across the country");
                    allActionPlans.add("Expand access to healthcare in rural and remote areas");
                    allActionPlans.add("Train and recruit more healthcare professionals");
                    break;
                case "Promote sustainable urban development":
                    allActionPlans.add("Implement waste management and recycling programs");
                    allActionPlans.add("Develop green spaces and parks in urban areas");
                    allActionPlans.add("Improve public transportation systems to reduce congestion");
                    break;
                case "Combat climate change and promote environmental sustainability":
                    allActionPlans.add("Invest in renewable energy sources such as solar and wind power");
                    allActionPlans.add("Enforce stricter regulations on industrial pollution and emissions");
                    allActionPlans.add("Promote afforestation and reforestation initiatives");
                    break;
                case "Strengthen governance and reduce corruption":
                    allActionPlans.add("Implement transparent procurement processes in government contracts");
                    allActionPlans.add("Strengthen anti-corruption agencies and law enforcement");
                    allActionPlans.add("Promote citizen participation and accountability mechanisms");
                    break;
                case "Improve infrastructure for economic growth and job creation":
                    allActionPlans.add("Invest in transportation infrastructure such as roads and bridges");
                    allActionPlans.add("Upgrade ports and logistics facilities to facilitate trade");
                    allActionPlans.add("Develop special economic zones to attract foreign investment");
                    break;
                case "Empower women and promote gender equality":
                    allActionPlans.add("Provide vocational training and entrepreneurial support for women");
                    allActionPlans.add("Implement policies to ensure equal pay and opportunities for women");
                    allActionPlans.add("Raise awareness and combat gender-based violence and discrimination");
                    break;
                case "Enhance digital infrastructure and promote ICT development":
                    allActionPlans.add("Expand access to high-speed internet in rural and remote areas");
                    allActionPlans.add("Promote digital literacy and skills development programs");
                    allActionPlans.add("Support the growth of the IT sector through incentives and investment");
                    break;
                case "Protect human rights and ensure access to justice for all":
                    allActionPlans.add("Strengthen legal aid services and support for marginalized communities");
                    allActionPlans.add("Combat human trafficking and ensure protection of vulnerable groups");
                    allActionPlans.add("Promote awareness and education on human rights and legal rights");
                    break;
                case "Foster innovation and entrepreneurship for economic development":
                    allActionPlans.add("Establish innovation hubs and startup incubators in key cities");
                    allActionPlans.add("Provide funding and support for research and development initiatives");
                    allActionPlans.add("Promote collaboration between academia, industry, and government");
                    break;
                case "Ensure access to clean water and sanitation for all":
                    allActionPlans.add("Invest in water treatment plants and infrastructure for clean water supply");
                    allActionPlans.add("Improve sanitation facilities and promote hygiene education");
                    allActionPlans.add("Address pollution and contamination of water sources");
                    break;
                    
                default:
          
                    break;
            }
        }

        actionPlans.setAll(allActionPlans);
    }

    
    
    @FXML
    private void addGoal(ActionEvent event) {
        String newGoal = newStrategicGoalField.getText();
        if (!newGoal.isEmpty()) {
            goalItems.add(newGoal);
            newStrategicGoalField.clear();
        }   
    }



    @FXML
    private void createPlan(ActionEvent event) {
        String newActionPlan = newActionPlanField.getText().trim();
        if (!newActionPlan.isEmpty()) {
            actionPlans.add(newActionPlan);
            newActionPlanField.clear();
        }
    }

    @FXML
    private void logout(ActionEvent event) {
        loadScene("/mainpkg/LoginSc.fxml", event);
    }

    @FXML
    private void goBack(ActionEvent event) {
        loadScene("/Shanto/SecretaryGeneral.fxml", event);
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
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
