
package Shanto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
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
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AddBudgetandControlController implements Initializable {

    @FXML
    private TextField newBudgetField;
    @FXML
    private TextField newExpenseField;
 
    
    private ObservableList<Budget> budgetItems = FXCollections.observableArrayList();
    private ObservableList<Expense> expenseItems = FXCollections.observableArrayList();

    private static final String FILE_PATH = "budget_data.ser";
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
 
        loadSavedData();
    }    
    
    @FXML
    private void exitApplication(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    private void addNewBudget(ActionEvent event) {
        String newName = newBudgetField.getText();
        if (!newName.isEmpty()) {

            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Enter Amount");
            dialog.setHeaderText(null);
            dialog.setContentText("Please enter the amount for " + newName + ":");

            Optional<String> result = dialog.showAndWait();
            if (result.isPresent()) {
                    int amount = Integer.parseInt(result.get());
                    budgetItems.add(new Budget(newName, amount));
                    newBudgetField.clear();
                    saveData();
                    showAlert("Budget Item Added", "New budget item added: " + newName + " with amount: " + amount);
                }    
        }
    }

    @FXML
    private void addNewExpense(ActionEvent event) {
        String newName = newExpenseField.getText();
        if (!newName.isEmpty()) {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Enter Amount");
            dialog.setHeaderText(null);
            dialog.setContentText("Please enter the amount for " + newName + ":");

            Optional<String> result = dialog.showAndWait();
            if (result.isPresent()) {
                    int amount = Integer.parseInt(result.get());
                    expenseItems.add(new Expense(newName, amount));
                    newExpenseField.clear();
                    saveData();
                    showAlert("Expense Item Added", "New expense item added: " + newName + " with amount: " + amount);
              
                
            }
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
    
    private void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(new ArrayList<>(budgetItems));
            oos.writeObject(new ArrayList<>(expenseItems));
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Failed to save data.");
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
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
