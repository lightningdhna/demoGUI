package dhung.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController extends Page implements Initializable {
    @FXML AnchorPane root;
    LoginPageController loginPage ;
    public MainViewController() throws IOException {
//        super(Type.MainPage);
    }

    public void doSomething() throws IOException {
        loginPage= new LoginPageController();
        add(loginPage);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setRoot(root);
        try {
            loginPage=new LoginPageController();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        add(loginPage);
    }
}
