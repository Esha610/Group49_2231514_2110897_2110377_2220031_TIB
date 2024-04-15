package Shanto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
import javafx.scene.chart.PieChart;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class OperationalManagementController implements Initializable {

    @FXML    private TextField addEmployeeField;
    @FXML    private TextField addBudgetField;
    @FXML    private TextField addInventoryField;
    @FXML    private ListView<String> employeeListView;
    @FXML    private ListView<String> budgetListView;
    @FXML    private ListView<String> inventoryListView;
    @FXML    private PieChart operationalManagementPieChart;


    private ObservableList<String> employeeData = FXCollections.observableArrayList();
    private ObservableList<String> budgetData = FXCollections.observableArrayList();
    private ObservableList<String> inventoryData = FXCollections.observableArrayList();
    
    private static final String FILE_PATH = "operationalManagement_data.ser";

    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        employeeListView.setItems(employeeData);
        budgetListView.setItems(budgetData);
        inventoryListView.setItems(inventoryData);
        loadSavedData();
        updatePieChart();
    }    


    @FXML
    private void exitApplication(ActionEvent event) {
            Platform.exit();
    }

    @FXML
    private void viewEmployees(ActionEvent event) {
        ArrayList<String> allEmployees = new ArrayList<>();
        allEmployees.add("Mohammad Rahman - Manager");
        allEmployees.add("Fatima Akhter - Accountant");
        allEmployees.add("Abdul Aziz - Sales Associate");
        allEmployees.add("Aisha Begum - HR Coordinator");
        allEmployees.add("Nurul Islam - IT Specialist");
        allEmployees.add("Shamima Sultana - Marketing Manager");
        allEmployees.add("Rahim Mia - Operations Assistant");
        allEmployees.add("Nasreen Akter - Customer Service Representative");
        allEmployees.add("Kamal Hossain - Project Manager");
        allEmployees.add("Nadia Islam - Financial Analyst");
        employeeData.setAll(allEmployees);
        saveData();
    }


    @FXML
    private void addEmployee(ActionEvent event) {
        String newEmployeeCount = addEmployeeField.getText();
        if (!newEmployeeCount.isEmpty()) {
            employeeData.add(newEmployeeCount);
            addEmployeeField.clear();
            saveData();
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
        saveData();
    }
    
    @FXML
    private void addBudget(ActionEvent event) {
        String newBudget = addBudgetField.getText();
        if (!newBudget.isEmpty()) {
            budgetData.add(newBudget);
            addBudgetField.clear();
            saveData();
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
        saveData();
    }

    @FXML
    private void addInventory(ActionEvent event) {
        String newInventoryData = addInventoryField.getText();
        if (!newInventoryData.isEmpty()) {
            inventoryData.add(newInventoryData);
            addInventoryField.clear();
            saveData();
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
        loadScene("/Shanto/SecretaryGeneral.fxml", event);
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
    
        private void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(new ArrayList<>(employeeData));
            oos.writeObject(new ArrayList<>(budgetData));
            oos.writeObject(new ArrayList<>(inventoryData));
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadSavedData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            ArrayList<String> savedEmployee = (ArrayList<String>) ois.readObject();
            ArrayList<String> savedBudget = (ArrayList<String>) ois.readObject();
            ArrayList<String> savedInventory = (ArrayList<String>) ois.readObject();
            employeeData.setAll(savedEmployee);
            budgetData.setAll(savedBudget);
            inventoryData.setAll(savedInventory);

            System.out.println("Data loaded successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("No saved data found.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    
    
    
    @FXML
    private void generatePiChartOnCLick(ActionEvent event) {
         updatePieChart();
    }


    private void updatePieChart() {
        double totalEmployee = employeeData.size();
        double totalBudget = budgetData.size();
        double totalInventory = inventoryData.size();    

        PieChart.Data employeePieData = new PieChart.Data("Total Employee", totalEmployee);
        PieChart.Data budgetPieData = new PieChart.Data("Total Budget", totalBudget);
        PieChart.Data inventoryPieData = new PieChart.Data("Total Inventory", totalInventory);

        operationalManagementPieChart.setData(FXCollections.observableArrayList(employeePieData, budgetPieData, inventoryPieData));
    }



}
