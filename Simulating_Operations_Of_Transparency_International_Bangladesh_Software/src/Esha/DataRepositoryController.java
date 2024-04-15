package Esha;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.stage.Stage;

public class DataRepositoryController implements Initializable {

    @FXML
    private TreeView<String> repositoryTreeView;
    @FXML
    private TextArea fileDetailsTextArea;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Root item
        TreeItem<String> rootItem = new TreeItem<>("Data Repository");

        // Finance department
        TreeItem<String> financeFolder = new TreeItem<>("Finance");
        financeFolder.getChildren().addAll(
            new TreeItem<>("Financial Statements.xlsx"),
            new TreeItem<>("Budget2024.xlsx"),
            new TreeItem<>("Expense Reports")
        );

        // Marketing department
        TreeItem<String> marketingFolder = new TreeItem<>("Marketing");
        marketingFolder.getChildren().addAll(
            new TreeItem<>("Campaigns"),
            new TreeItem<>("Market Research"),
            new TreeItem<>("Ads")
        );

        // HR department
        TreeItem<String> hrFolder = new TreeItem<>("HR");
        hrFolder.getChildren().addAll(
            new TreeItem<>("Employee Handbook.pdf"),
            new TreeItem<>("Training Materials"),
            new TreeItem<>("Recruitment")
        );

        // Sales department
        TreeItem<String> salesFolder = new TreeItem<>("Sales");
        salesFolder.getChildren().addAll(
            new TreeItem<>("Sales Reports"),
            new TreeItem<>("Client Contracts"),
            new TreeItem<>("Sales Presentations")
        );

        // Product department
        TreeItem<String> productFolder = new TreeItem<>("Product");
        productFolder.getChildren().addAll(
            new TreeItem<>("Product Specifications"),
            new TreeItem<>("Design Mockups"),
            new TreeItem<>("User Manuals")
        );

        // IT department
        TreeItem<String> itFolder = new TreeItem<>("IT");
        itFolder.getChildren().addAll(
            new TreeItem<>("Software"),
            new TreeItem<>("Hardware"),
            new TreeItem<>("Network")
        );

        // Add folders to the root item
        rootItem.getChildren().addAll(
            financeFolder, marketingFolder, hrFolder, 
            salesFolder, productFolder, itFolder
        );

        // Set the root item to the TreeView
        repositoryTreeView.setRoot(rootItem);

        // Listener for selecting items in the TreeView
        repositoryTreeView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null && !newValue.isLeaf()) {
                fileDetailsTextArea.clear();
            }
        });
    }


   @FXML
    private void goBack(ActionEvent event) {
      
        ((Stage) repositoryTreeView.getScene().getWindow()).close();
    }

    @FXML
    private void exitApplication(ActionEvent event) {
       
        Platform.exit();
    }

    @FXML
    private void viewFile(ActionEvent event) {
     
        TreeItem<String> selectedItem = repositoryTreeView.getSelectionModel().getSelectedItem();
        if (selectedItem != null && selectedItem.isLeaf()) {
            String fileName = selectedItem.getValue();
            
            fileDetailsTextArea.setText("Viewing file: " + fileName);
        }
    }

    @FXML
    private void downloadFile(ActionEvent event) {
       
        TreeItem<String> selectedItem = repositoryTreeView.getSelectionModel().getSelectedItem();
        if (selectedItem != null && selectedItem.isLeaf()) {
            String fileName = selectedItem.getValue();
          
            System.out.println("Downloading file: " + fileName);
        }
    }

    }
