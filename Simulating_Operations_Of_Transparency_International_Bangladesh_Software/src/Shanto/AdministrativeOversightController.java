package Shanto;

import java.io.IOException;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AdministrativeOversightController implements Initializable {

    @FXML    private TableView<String> budgetTableView;
    @FXML    private TableView<String> complianceTableView;
    @FXML    private TableColumn<String, String> budgetColumn;
    @FXML    private TableColumn<String, String> complianceColumn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        budgetColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()));
        complianceColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()));

        budgetTableView.getItems().addAll(
                "Salaries", "Utilities", "Office Supplies", "Marketing Expenses", "Travel Expenses",
                "Rent", "Training", "Equipment Purchases", "Consulting Fees", "Advertising Costs"
        );
        complianceTableView.getItems().addAll(
                "Regulatory Compliance", "Environmental Compliance", "Financial Reporting Compliance",
                "Health and Safety Compliance", "Privacy Compliance", "Quality Standards Compliance",
                "Data Protection Compliance", "Ethical Compliance", "Tax Compliance", "Labor Law Compliance"
        );

        System.out.println("Administrative Oversight Platform initialized.");
    }

    @FXML
    private void exitApplication(ActionEvent event) {
    
        System.exit(0);
    }



    @FXML
    private void viewBudgetDetails(ActionEvent event) {
        String selectedBudget = budgetTableView.getSelectionModel().getSelectedItem();
        if (selectedBudget != null) {
            String details = getBudgetDetails(selectedBudget);
            displayDetails("Budget Details", details);
        } else {
            displayNoSelectionAlert("Budget Details");
        }
    }

    @FXML
    private void viewComplianceDetails(ActionEvent event) {
        String selectedCompliance = complianceTableView.getSelectionModel().getSelectedItem();
        if (selectedCompliance != null) {
            String details = getComplianceDetails(selectedCompliance);
            displayDetails("Compliance Details", details);
        } else {
            displayNoSelectionAlert("Compliance Details");
        }
    }

    private String getBudgetDetails(String budget) {
        return "Budget: " + budget + "\n"
             + "Amount: $100,000\n"
             + "Department: Finance\n"
             + "Year: 2023";
    }

    private String getComplianceDetails(String compliance) {
 
        return "Compliance: " + compliance + "\n"
             + "Status: Pending\n"
             + "Action Required: Review\n"
             + "Deadline: 01/31/2024";
    }

    private void displayDetails(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void displayNoSelectionAlert(String title) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText("Please select a row to view details.");
        alert.showAndWait();
    }
    
    @FXML
    private void logout(ActionEvent event) {
        System.out.println("User logged out.");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
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
    private void goBack(ActionEvent event) {
         System.out.println("Going back...");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ExecutiveDirector.fxml"));
        try {
            AnchorPane root = loader.load();
            Scene scene = new Scene(root);

            // Get the Stage from the ActionEvent
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Set the Scene on the Stage
            stage.setScene(scene);

            // Show the Stage
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
  
    
}
