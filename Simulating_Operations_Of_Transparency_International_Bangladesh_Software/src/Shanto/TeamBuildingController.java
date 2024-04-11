package Shanto;

import java.io.IOException;
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
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TeamBuildingController implements Initializable {

    @FXML
    private ListView<String> teamListView;
    @FXML
    private TextField newTeamField;
    @FXML
    private ListView<String> memberListView;
    @FXML
    private TextField newMembersField;
    @FXML
    private ListView<String> actionsListView;
    @FXML
    private TextField newActionPlanField;

    private ObservableList<String> teamItems = FXCollections.observableArrayList();
    private ObservableList<String> memberItems = FXCollections.observableArrayList();
    private ObservableList<String> actionItems = FXCollections.observableArrayList();
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        teamListView.setItems(teamItems);
        memberListView.setItems(memberItems);
        actionsListView.setItems(actionItems);
    }

    @FXML
    private void exitApplication(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    private void viewAllTeams(ActionEvent event) {
        ArrayList<String> allTeams = new ArrayList<>();
        allTeams.add("Development Team");
        allTeams.add("Marketing Team");
        allTeams.add("Sales Team");
        allTeams.add("Customer Support Team");
        allTeams.add("Finance Team");
        allTeams.add("Human Resources Team");
        teamItems.setAll(allTeams);
    }

    @FXML
    private void addNewTeam(ActionEvent event) {
        String newTeam = newTeamField.getText();
        if (!newTeam.isEmpty()) {
            teamItems.add(newTeam);
            newTeamField.clear();
        } else {
            showAlert(Alert.AlertType.ERROR, "Error", "Please enter a new team name.");
        }
    }

    @FXML
    private void viewAllMembers(ActionEvent event) {
        ArrayList<String> allMembers = new ArrayList<>();
        allMembers.add("John Doe");
        allMembers.add("Jane Smith");
        allMembers.add("David Johnson");
        allMembers.add("Emily Brown");
        allMembers.add("Michael Wilson");
        allMembers.add("Emma Davis");
        memberItems.setAll(allMembers);
    }

    @FXML
    private void addNewMember(ActionEvent event) {
        String newMember = newMembersField.getText();
        if (!newMember.isEmpty()) {
            memberItems.add(newMember);
            newMembersField.clear();
        } else {
            showAlert(Alert.AlertType.ERROR, "Error", "Please enter a new member name.");
        }
    }

    @FXML
    private void viewTeamActionPlans(ActionEvent event) {
        ArrayList<String> allActionPlans = new ArrayList<>();

        String selectedTeam = teamListView.getSelectionModel().getSelectedItem();

        if (selectedTeam != null) {
            switch (selectedTeam) {
                case "Development Team":
                    allActionPlans.add("Develop new software features and enhancements");
                    allActionPlans.add("Conduct code reviews and implement best practices");
                    allActionPlans.add("Collaborate with product managers to define project scope");
                    break;
                case "Marketing Team":
                    allActionPlans.add("Launch new marketing campaigns across social media platforms");
                    allActionPlans.add("Analyze market trends and conduct competitor analysis");
                    allActionPlans.add("Optimize website content and SEO strategies");
                    break;
                case "Sales Team":
                    allActionPlans.add("Identify and pursue new leads and opportunities");
                    allActionPlans.add("Deliver product demonstrations and presentations to prospects");
                    allActionPlans.add("Negotiate contracts and close deals with clients");
                    break;
                case "Customer Support Team":
                    allActionPlans.add("Provide timely responses to customer inquiries and issues");
                    allActionPlans.add("Offer personalized support and solutions to resolve customer problems");
                    allActionPlans.add("Gather feedback and insights to improve product and service offerings");
                    break;
                case "Finance Team":
                    allActionPlans.add("Manage company finances and budget allocations");
                    allActionPlans.add("Prepare financial statements and reports for stakeholders");
                    allActionPlans.add("Conduct financial analysis and forecasting to support decision-making");
                    break;
                case "Human Resources Team":
                    allActionPlans.add("Recruit and onboard new employees");
                    allActionPlans.add("Develop training programs and performance management systems");
                    allActionPlans.add("Handle employee relations and conflict resolution");
                    break;
                default:
                    break;
            }
        }

        actionItems.setAll(allActionPlans);
    }

    @FXML
    private void createTeamActionPlans(ActionEvent event) {
        String newActionPlan = newActionPlanField.getText().trim();
        if (!newActionPlan.isEmpty()) {
            actionItems.add(newActionPlan);
            newActionPlanField.clear();
        }
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
