package dhung.view;

import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginPageController extends Page {

    public LoginPageController() throws IOException {
        super(Type.LoginPage);
    }
    public void doSomething(){
        close();
    }
}
