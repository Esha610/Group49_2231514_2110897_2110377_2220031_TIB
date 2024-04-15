package Esha;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;

public class ContactUsController implements Initializable {

    @FXML
    private TextArea messageTextArea;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        messageTextArea.setText("Enter your message here...");

    
        messageTextArea.requestFocus();
    }

    @FXML
    private void goBack(ActionEvent event) {
     
        System.out.println("Going back...");
    }

    @FXML
    private void exitApplication(ActionEvent event) {
    
        System.exit(0);
    }

    @FXML
    private void sendMessage(ActionEvent event) {
       
        String message = messageTextArea.getText();
        if (!message.isEmpty()) {
          
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Message Sent");
            alert.setHeaderText(null);
            alert.setContentText("Your message has been sent successfully!");
            alert.showAndWait();

           
            messageTextArea.clear();
        } else {
           
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Empty Message");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a message before sending.");
            alert.showAndWait();
        }
    } 
}
