
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewBudgetandControlController implements Initializable {

    @FXML
    private ListView<Budget> budgetListView;
    @FXML
    private ListView<Expense> expenseListView;

    private ObservableList<Budget> budgetItems = FXCollections.observableArrayList();
    private ObservableList<Expense> expenseItems = FXCollections.observableArrayList();

    private static final String FILE_PATH = "budget_data.ser";
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
         budgetListView.setItems(budgetItems);
        expenseListView.setItems(expenseItems);
        loadSavedData();
    }    

    @FXML
    private void exitApplication(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    private void viewAllBudgets(ActionEvent event) {
        ArrayList<Budget> allBudgets = new ArrayList<>();
        allBudgets.add(new Budget("Monthly Rent", 1200));
        allBudgets.add(new Budget("Groceries", 300));
        allBudgets.add(new Budget("Utilities", 200));
        allBudgets.add(new Budget("Transportation", 150));
        allBudgets.add(new Budget("Entertainment", 100));
        allBudgets.add(new Budget("Healthcare", 50));
        allBudgets.add(new Budget("Education", 200));
        allBudgets.add(new Budget("Savings", 500));
        allBudgets.add(new Budget("Insurance", 100));
        allBudgets.add(new Budget("Debt Repayment", 200));
        budgetItems.setAll(allBudgets);
        saveData();
    }

    @FXML
    private void viewAllExpenses(ActionEvent event) {
        ArrayList<Expense> allExpenses = new ArrayList<>();
        allExpenses.add(new Expense("Rent/Mortgage Payment", 1200));
        allExpenses.add(new Expense("Food and Dining", 250));
        allExpenses.add(new Expense("Utility Bills", 150));
        allExpenses.add(new Expense("Transportation Costs", 100));
        allExpenses.add(new Expense("Entertainment Expenses", 150));
        allExpenses.add(new Expense("Healthcare Expenses", 50));
        allExpenses.add(new Expense("Education Expenses", 100));
        allExpenses.add(new Expense("Savings Contributions", 200));
        allExpenses.add(new Expense("Insurance Premiums", 100));
        allExpenses.add(new Expense("Loan Payments", 300));
        expenseItems.setAll(allExpenses);
        saveData();
    }

    @FXML
    private void logout(ActionEvent event) {
        loadScene("/mainpkg/LoginSc.fxml", event);
    }

    @FXML
    private void goBack(ActionEvent event) {
        loadScene("/Shanto/ExecutiveDirector.fxml", event);
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
            oos.writeObject(new ArrayList<>(budgetItems));
            oos.writeObject(new ArrayList<>(expenseItems));
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadSavedData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            ArrayList<Budget> savedBudgets = (ArrayList<Budget>) ois.readObject();
            ArrayList<Expense> savedExpenses = (ArrayList<Expense>) ois.readObject();
            budgetItems.setAll(savedBudgets);
            expenseItems.setAll(savedExpenses);
            System.out.println("Data loaded successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("No saved data found.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
}

