package Shanto;

import java.io.IOException;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BudgetAndControlController implements Initializable {

    @FXML private ListView<Budget> budgetListView;
    @FXML private ListView<Expense> expenseListView;
    @FXML private TextField newBudgetField;
    @FXML private TextField newExpenseField;

    private ObservableList<Budget> budgetItems = FXCollections.observableArrayList();
    private ObservableList<Expense> expenseItems = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        budgetListView.setItems(budgetItems);
        expenseListView.setItems(expenseItems);
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
    }

    @FXML
    private void addNewBudget(ActionEvent event) {
        String newName = newBudgetField.getText();
        if (!newName.isEmpty()) {
            budgetItems.add(new Budget(newName, 0));
            newBudgetField.clear();
        }
    }

    @FXML
    private void addNewExpense(ActionEvent event) {
        String newName = newExpenseField.getText();
        if (!newName.isEmpty()) {
            expenseItems.add(new Expense(newName, 0));
            newExpenseField.clear();
        }
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
}
