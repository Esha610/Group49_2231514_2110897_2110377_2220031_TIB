package Shanto;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

public class StrategicPlanningController implements Initializable {

    @FXML private TextField newStrategicGoalField;
    @FXML private ListView<StrategicGoal> goalsListView;
    @FXML private TextField newActionPlanField;
    @FXML private ListView<ActionPlan> actionsListView;

    private ObservableList<StrategicGoal> goalItems = FXCollections.observableArrayList();
    private ObservableList<ActionPlan> actionPlans = FXCollections.observableArrayList();

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
        ArrayList<StrategicGoal> allGoals = new ArrayList<>();
        allGoals.add(new StrategicGoal("Enhance healthcare services and infrastructure"));
        allGoals.add(new StrategicGoal("Promote sustainable urban development"));
        allGoals.add(new StrategicGoal("Combat climate change and promote environmental sustainability"));
        allGoals.add(new StrategicGoal("Strengthen governance and reduce corruption"));
        allGoals.add(new StrategicGoal("Improve infrastructure for economic growth and job creation"));
        allGoals.add(new StrategicGoal("Empower women and promote gender equality"));
        allGoals.add(new StrategicGoal("Enhance digital infrastructure and promote ICT development"));
        allGoals.add(new StrategicGoal("Protect human rights and ensure access to justice for all"));
        allGoals.add(new StrategicGoal("Foster innovation and entrepreneurship for economic development"));
        allGoals.add(new StrategicGoal("Ensure access to clean water and sanitation for all"));

        goalItems.setAll(allGoals);
    }

    @FXML
    private void viewActionPlans(ActionEvent event) {
        ArrayList<ActionPlan> allActionPlans = new ArrayList<>();

        StrategicGoal selectedGoal = goalsListView.getSelectionModel().getSelectedItem();

        if (selectedGoal != null) {
            switch (selectedGoal.getName()) {
                case "Enhance healthcare services and infrastructure":
                    allActionPlans.add(new ActionPlan("Upgrade hospitals and medical facilities across the country"));
                    allActionPlans.add(new ActionPlan("Expand access to healthcare in rural and remote areas"));
                    allActionPlans.add(new ActionPlan("Train and recruit more healthcare professionals"));
                    break;
                case "Promote sustainable urban development":
                    allActionPlans.add(new ActionPlan("Implement waste management and recycling programs"));
                    allActionPlans.add(new ActionPlan("Develop green spaces and parks in urban areas"));
                    allActionPlans.add(new ActionPlan("Improve public transportation systems to reduce congestion"));
                    break;
                case "Combat climate change and promote environmental sustainability":
                    allActionPlans.add(new ActionPlan("Invest in renewable energy sources such as solar and wind power"));
                    allActionPlans.add(new ActionPlan("Enforce stricter regulations on industrial pollution and emissions"));
                    allActionPlans.add(new ActionPlan("Promote afforestation and reforestation initiatives"));
                    break;
                case "Strengthen governance and reduce corruption":
                    allActionPlans.add(new ActionPlan("Implement transparent procurement processes in government contracts"));
                    allActionPlans.add(new ActionPlan("Strengthen anti-corruption agencies and law enforcement"));
                    allActionPlans.add(new ActionPlan("Promote citizen participation and accountability mechanisms"));
                    break;
                case "Improve infrastructure for economic growth and job creation":
                    allActionPlans.add(new ActionPlan("Invest in transportation infrastructure such as roads and bridges"));
                    allActionPlans.add(new ActionPlan("Upgrade ports and logistics facilities to facilitate trade"));
                    allActionPlans.add(new ActionPlan("Develop special economic zones to attract foreign investment"));
                    break;
                case "Empower women and promote gender equality":
                    allActionPlans.add(new ActionPlan("Provide vocational training and entrepreneurial support for women"));
                    allActionPlans.add(new ActionPlan("Implement policies to ensure equal pay and opportunities for women"));
                    allActionPlans.add(new ActionPlan("Raise awareness and combat gender-based violence and discrimination"));
                    break;
                case "Enhance digital infrastructure and promote ICT development":
                    allActionPlans.add(new ActionPlan("Expand access to high-speed internet in rural and remote areas"));
                    allActionPlans.add(new ActionPlan("Promote digital literacy and skills development programs"));
                    allActionPlans.add(new ActionPlan("Support the growth of the IT sector through incentives and investment"));
                    break;
                case "Protect human rights and ensure access to justice for all":
                    allActionPlans.add(new ActionPlan("Strengthen legal aid services and support for marginalized communities"));
                    allActionPlans.add(new ActionPlan("Combat human trafficking and ensure protection of vulnerable groups"));
                    allActionPlans.add(new ActionPlan("Promote awareness and education on human rights and legal rights"));
                    break;
                case "Foster innovation and entrepreneurship for economic development":
                    allActionPlans.add(new ActionPlan("Establish innovation hubs and startup incubators in key cities"));
                    allActionPlans.add(new ActionPlan("Provide funding and support for research and development initiatives"));
                    allActionPlans.add(new ActionPlan("Promote collaboration between academia, industry, and government"));
                    break;
                case "Ensure access to clean water and sanitation for all":
                    allActionPlans.add(new ActionPlan("Invest in water treatment plants and infrastructure for clean water supply"));
                    allActionPlans.add(new ActionPlan("Improve sanitation facilities and promote hygiene education"));
                    allActionPlans.add(new ActionPlan("Address pollution and contamination of water sources"));
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
            goalItems.add(new StrategicGoal(newGoal));
            newStrategicGoalField.clear();
        }
    }

    @FXML
    private void createPlan(ActionEvent event) {
        String newActionPlan = newActionPlanField.getText().trim();
        if (!newActionPlan.isEmpty()) {
            actionPlans.add(new ActionPlan(newActionPlan));
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
