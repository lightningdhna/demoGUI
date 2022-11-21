package dhung.view;

import dhung.model.Account;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController extends Page implements Initializable {
    @FXML AnchorPane root;

    private Account account;
    LoginPageController loginPage ;
    ShowAccountPageController showAccountPage;

    public MainViewController() throws IOException {
    }


    public void setAccount(Account account){
        this.account = account;
    }
    public void setPage1() throws IOException {
        showAccountPage = new ShowAccountPageController();
        add(showAccountPage,50,0);
    }

    public void exit() {
        ((Stage)getRoot().getScene().getWindow()).close();
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
