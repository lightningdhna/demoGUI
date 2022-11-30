package dhung.view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import dhung.controller.AccountManager;
import dhung.model.Account;
import javafx.application.Platform;
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
    SignUpPageController signUpPage;
    public LoginPageController() {
        super(Type.LoginPage);
    }

    public void exit(){
        ((MainViewController)getParent()).exit();
    }
    public void signIn() throws IOException {
        Account account = new Account(textField.getText(),passwordField.getText());
        if(AccountManager.getManager().checkExist(account)){
            Thread thread = new Thread(
                    () -> {
                        if(checkBox.isSelected()){
                            try {
                                BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/save/account-save.txt"));
                                writer.write(textField.getText()+'\n'+passwordField.getText());
                                writer.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
            );

            if(signUpPage!=null) signUpPage.close();
            ((MainViewController)getParent()).setAccount(account);
            ((MainViewController)getParent()).showIcon();
            ((MainViewController)getParent()).setHomePage();
            close();
        }
    }
    public void signUp() throws IOException {
        signUpPage= new SignUpPageController();
        getParent().add(signUpPage,550,0);
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
