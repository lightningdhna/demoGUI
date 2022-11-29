package dhung.view;

import dhung.controller.AccountManager;
import dhung.model.Account;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class SignUpPageController extends Page{
    public SignUpPageController() {
        super(Type.SignUpPage);
    }

    @FXML
    TextField textField,passwordField;
    @FXML
    Label failLabel, successLabel;

    private void showInSecond(Label label, int n) {
        Thread thread = new Thread(
                () -> {
                    Platform.runLater(
                            label::toFront
                    );
                    try {
                        Thread.sleep(n* 1000L);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    Platform.runLater(
                            label::toBack
                    );
                }
        );
        thread.start();
//        Platform.runLater(
//                ()->{
//                    label.toFront();
//
//                    label.toBack();
//                }
//        );
    }

    public void signUp() {
        Account account = new Account(textField.getText(),passwordField.getText());
        if(AccountManager.getManager().add(account)){

            System.out.println("sign up success");
            showInSecond(successLabel,2);
            close();
        }
        else {
            showInSecond(failLabel,5);
        }
    }
}
