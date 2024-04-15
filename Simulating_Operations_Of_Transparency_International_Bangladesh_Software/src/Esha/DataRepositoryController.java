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
      
        TreeItem<String> rootItem = new TreeItem<>("Data Repository");
        TreeItem<String> folder1 = new TreeItem<>("Folder 1");
        TreeItem<String> folder2 = new TreeItem<>("Folder 2");
        rootItem.getChildren().addAll(folder1, folder2);
        repositoryTreeView.setRoot(rootItem);
        
      
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
