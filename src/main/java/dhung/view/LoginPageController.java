package dhung.view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import dhung.controller.AccountManager;
import dhung.model.Account;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Scanner;

public class LoginPageController extends Page implements Initializable {

    @FXML
    TextField textField;
    @FXML
    PasswordField passwordField;
    @FXML
    JFXCheckBox checkBox;
    public LoginPageController() throws IOException {
        super(Type.LoginPage);
    }

    public void signIn() throws IOException {
        Account account = new Account(textField.getText(),passwordField.getText());
        if(AccountManager.getManager().checkExist(account)){
            ((MainViewController)getParent()).setAccount(account);
            if(checkBox.isSelected()){
                BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/save/account-save.txt"));
                writer.write(textField.getText()+'\n'+passwordField.getText());
                writer.close();
            }
            close();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/save/account-save.txt"));
            textField.setText(reader.readLine());
            passwordField.setText(reader.readLine());
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
