package Esha;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class WorkshopRegistrationController implements Initializable {

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField mobileTextField;
    @FXML
    private RadioButton virtualRadioButton;
    @FXML
    private RadioButton inPersonRadioButton;
    
    private static final String FILE_PATH = "workshop_data.ser";
    @FXML
    private ChoiceBox<String> areaChoiceBox;
    @FXML
    private ChoiceBox<String> placeChoiceBox;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        areaChoiceBox.getItems().addAll(
            "Urban Development",
            "Rural Empowerment",
            "Healthcare Access",
            "Environmental Sustainability",
            "Education Reform"
        );

        placeChoiceBox.getItems().addAll(
            "Local Community Center",
            "Public Hospital",
            "City Park",
            "School Campus",
            "Wildlife Sanctuary"
        );

        loadSavedData();
    }

    @FXML
    private void submitForm(ActionEvent event) {
       
        String name = nameTextField.getText();
        String email = emailTextField.getText();
        String mobile = mobileTextField.getText();
        String joinMethod = virtualRadioButton.isSelected() ? "Virtual" : "In Person";
        
        // Save the data
        saveData(name, email, mobile, joinMethod);
        
        // Display alert or perform further actions
        System.out.println("Form submitted successfully.");
    }
    
    private void saveData(String name, String email, String mobile, String joinMethod) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(new WorkshopRegistrationData(name, email, mobile, joinMethod));
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void loadSavedData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            WorkshopRegistrationData data = (WorkshopRegistrationData) ois.readObject();
            nameTextField.setText(data.getName());
            emailTextField.setText(data.getEmail());
            mobileTextField.setText(data.getMobile());
            if (data.getJoinMethod().equals("Virtual")) {
                virtualRadioButton.setSelected(true);
            } else {
                inPersonRadioButton.setSelected(true);
            }
            System.out.println("Data loaded successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("No saved data found.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void goBack(ActionEvent event) {
    }

    @FXML
    private void logOut(ActionEvent event) {
    }
}
