package Shanto;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class OperationalManagementController implements Initializable {

    @FXML    private TextField addEmployeeField;
    @FXML    private TextField addBudgetField;
    @FXML    private TextField addInventoryField;
    @FXML    private ListView<String> employeeListView;
    @FXML    private ListView<String> budgetListView;
    @FXML    private ListView<String> inventoryListView;

    private ObservableList<String> employeeData;
    private ObservableList<String> budgetData;
    private ObservableList<String> inventoryData;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        employeeData = FXCollections.observableArrayList();
        budgetData = FXCollections.observableArrayList();
        inventoryData = FXCollections.observableArrayList();

        employeeListView.setItems(employeeData);
        budgetListView.setItems(budgetData);
        inventoryListView.setItems(inventoryData);
    }    


    @FXML
    private void exitApplication(ActionEvent event) {
            Platform.exit();
    }

    @FXML
    private void viewEmployees(ActionEvent event) {
        ArrayList<String> allEmployees = new ArrayList<>();
        allEmployees.add("John Doe - Manager");
        allEmployees.add("Jane Smith - Accountant");
        allEmployees.add("Michael Johnson - Sales Associate");
        allEmployees.add("Emily Brown - HR Coordinator");
        allEmployees.add("David Wilson - IT Specialist");
        allEmployees.add("Sarah Lee - Marketing Manager");
        allEmployees.add("Alex Turner - Operations Assistant");
        allEmployees.add("Rachel Miller - Customer Service Representative");
        allEmployees.add("Chris Evans - Project Manager");
        allEmployees.add("Emma Garcia - Financial Analyst");
        employeeData.setAll(allEmployees);
    }

    @FXML
    private void addEmployee(ActionEvent event) {
        String newEmployeeCount = addEmployeeField.getText();
        if (!newEmployeeCount.isEmpty()) {
            employeeData.add(newEmployeeCount);
            addEmployeeField.clear();
        } else {
            showAlert("Error", "Please enter a value for the new employee count.");
        }
    }
    
    @FXML
    private void viewBudgetDetails(ActionEvent event) {
        ArrayList<String> allBudgets = new ArrayList<>();
        allBudgets.add("Monthly Rent - $1200");
        allBudgets.add("Groceries - $300");
        allBudgets.add("Utilities - $200");
        allBudgets.add("Transportation - $150");
        allBudgets.add("Entertainment - $100");
        allBudgets.add("Healthcare - $50");
        allBudgets.add("Education - $200");
        allBudgets.add("Savings - $500");
        allBudgets.add("Insurance - $100");
        allBudgets.add("Debt Repayment - $200");
        budgetData.setAll(allBudgets);
    }
    
    @FXML
    private void addBudget(ActionEvent event) {
        String newBudget = addBudgetField.getText();
        if (!newBudget.isEmpty()) {
            budgetData.add(newBudget);
            addBudgetField.clear();
        } else {
            showAlert("Error", "Please enter a value for the new budget.");
        }
    }

    @FXML
    private void viewInventory(ActionEvent event) {       
        ArrayList<String> allInventory = new ArrayList<>();
        allInventory.add("Laptops - 50");
        allInventory.add("Printers - 20");
        allInventory.add("Office Chairs - 100");
        allInventory.add("Office Desks - 75");
        allInventory.add("Stationery Supplies - 500");
        inventoryData.setAll(allInventory);
    }

    @FXML
    private void addInventory(ActionEvent event) {
        String newInventoryData = addInventoryField.getText();
        if (!newInventoryData.isEmpty()) {
            inventoryData.add(newInventoryData);
            addInventoryField.clear();
        } else {
            showAlert("Error", "Please enter a value for the new inventory data.");
        }
    }

    private void saveChanges(ActionEvent event) {
        showAlert("Save Changes", "Functionality to save changes will be implemented here.");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    
    @FXML
    private void goBack(ActionEvent event) {
        loadScene("OperationalManagement.fxml", event);
    }
    

    @FXML
    private void logout(ActionEvent event) {
        loadScene("/mainpkg/LoginSc.fxml", event);
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
