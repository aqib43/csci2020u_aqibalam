
package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Controller {
    @FXML
    private TextField userName;
    @FXML
    public PasswordField passwordField;
    @FXML
    public TextField fullName;
    @FXML
    public TextField email;
    @FXML
    public TextField phoneNumber;
    @FXML
    public Text actiontarget;
    public void handleRegisterButtonAction(ActionEvent actionEvent) {
        System.out.printf("Username: %s\n", userName.getText());
        System.out.printf("Password: %s\n", userName.getText());
        System.out.printf("Full Name: %s\n", fullName.getText());
        System.out.printf("Phone #: %s\n",phoneNumber.getText());
        System.out.printf("E-mail: %s",email.getText());
        System.out.printf("Phone number: %s\n", userName.getText());
        System.out.printf("Date of birth: %s\n", userName.getText());

        actiontarget.setText("Registration complete.");
    }
}
