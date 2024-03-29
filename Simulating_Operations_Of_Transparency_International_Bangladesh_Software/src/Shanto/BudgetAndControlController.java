package Shanto;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class BudgetAndControlController implements Initializable {

    @FXML
    private ListView<String> budgetListView;
    @FXML
    private ListView<String> expenseListView;
    @FXML
    private TextField newBudgetField;
    @FXML
    private TextField newExpenseField;

    // Initialize lists if needed
    ObservableList<String> budgetItems = FXCollections.observableArrayList();
    ObservableList<String> expenseItems = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize the lists here if needed
        budgetListView.setItems(budgetItems);
        expenseListView.setItems(expenseItems);
    }

    @FXML
    private void exitApplication(ActionEvent event) {
        // Exit the application
        Platform.exit();
    }


    @FXML
    private void viewAllBudgets(ActionEvent event) {
        // Implement code to view all budgets
        ArrayList<String> allBudgets = new ArrayList<>();
        allBudgets.add("Budget 1");
        allBudgets.add("Budget 2");
        allBudgets.add("Budget 3");
        budgetItems.setAll(allBudgets);
    }

    @FXML
    private void addNewBudget(ActionEvent event) {
        // Implement code to add a new budget
        String newBudget = newBudgetField.getText();
        if (!newBudget.isEmpty()) {
            budgetItems.add(newBudget);
            newBudgetField.clear();
        }
    }

    @FXML
    private void viewAllExpenses(ActionEvent event) {
        // Implement code to view all expenses
        ArrayList<String> allExpenses = new ArrayList<>();
        allExpenses.add("Expense 1");
        allExpenses.add("Expense 2");
        allExpenses.add("Expense 3");
        expenseItems.setAll(allExpenses);
    }

    @FXML
    private void addNewExpense(ActionEvent event) {
        // Implement code to add a new expense
        String newExpense = newExpenseField.getText();
        if (!newExpense.isEmpty()) {
            expenseItems.add(newExpense);
            newExpenseField.clear();
        }
    }

@FXML
private void refreshBudgetList(ActionEvent event) {
    budgetItems.clear();
    ArrayList<String> updatedBudgets = fetchUpdatedBudgets();    
    budgetItems.addAll(updatedBudgets);
}

@FXML
private void refreshExpenseList(ActionEvent event) {
    expenseItems.clear();
    ArrayList<String> updatedExpenses = fetchUpdatedExpenses();
    expenseItems.addAll(updatedExpenses);
}

    private ArrayList<String> fetchUpdatedBudgets() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    private ArrayList<String> fetchUpdatedExpenses() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

}
