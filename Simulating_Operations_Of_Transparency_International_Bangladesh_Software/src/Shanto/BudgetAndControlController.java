package Shanto;

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

public class BudgetAndControlController implements Initializable {

    @FXML    private ListView<String> budgetListView;    
    @FXML    private ListView<String> expenseListView;    
    @FXML    private TextField newBudgetField;    
    @FXML    private TextField newExpenseField;

    private ObservableList<String> budgetItems;
    private ObservableList<String> expenseItems;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize ObservableLists
        budgetItems = FXCollections.observableArrayList();
        expenseItems = FXCollections.observableArrayList();
        
        // Set ListView items
        budgetListView.setItems(budgetItems);
        expenseListView.setItems(expenseItems);
    }

    @FXML
    private void exitApplication(ActionEvent event) {
       
        Platform.exit();
    }


@FXML
private void viewAllBudgets(ActionEvent event) {
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
    budgetItems.setAll(allBudgets);
}

@FXML
private void viewAllExpenses(ActionEvent event) {
    ArrayList<String> allExpenses = new ArrayList<>();
    allExpenses.add("Rent/Mortgage Payment - $1200");
    allExpenses.add("Food and Dining - $250");
    allExpenses.add("Utility Bills - $150");
    allExpenses.add("Transportation Costs - $100");
    allExpenses.add("Entertainment Expenses - $150");
    allExpenses.add("Healthcare Expenses - $50");
    allExpenses.add("Education Expenses - $100");
    allExpenses.add("Savings Contributions - $200");
    allExpenses.add("Insurance Premiums - $100");
    allExpenses.add("Loan Payments - $300");
    expenseItems.setAll(allExpenses);
}

    
    
    // Add New Budget method
    @FXML
    private void addNewBudget(ActionEvent event) {
        String newBudget = newBudgetField.getText();
        if (!newBudget.isEmpty()) {
            budgetItems.add(newBudget);
            newBudgetField.clear();
        }
    }

    // Add New Expense method
    @FXML
    private void addNewExpense(ActionEvent event) {
        String newExpense = newExpenseField.getText();
        if (!newExpense.isEmpty()) {
            expenseItems.add(newExpense);
            newExpenseField.clear();
        }
    }
    
    





    @FXML
    private void logoutAction(ActionEvent event) {
    }

    @FXML
    private void backAction(ActionEvent event) {
    }

}
