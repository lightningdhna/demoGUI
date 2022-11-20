package dhung.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginPageController extends Page {

    @FXML
    TextField textField;
    @FXML
    PasswordField passwordField;
    public LoginPageController() throws IOException {
        super(Type.LoginPage);
    }

    public void signIn(){
        System.out.println(textField.getText());
        System.out.println(passwordField.getText());
        if(textField.getText().equals("ADMIN") && passwordField.getText().equals("123456"))
            close();
    }
}
