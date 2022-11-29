package dhung.view;

import dhung.model.Account;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController extends Page implements Initializable {
    @FXML AnchorPane root, functionAnchorPane, taskBar;
    private Account account;
    LoginPageController loginPage ;
    ShowAccountPageController showAccountPage;
    HomePageController homePage;
    AccountPageController accountPage;
    RegisterPageController registerPage;
    VerifyPageController verifyPage;
    ManagerPageController managerPage;
    StatisticPageController statisticPage;


    public void setHomePage(){
        if(homePage==null) {
            homePage = new HomePageController();
            add(homePage,50,50);
        }
        else
            homePage.toFront();
    }
    public void setAccountPage(){

        if(accountPage==null) {
            accountPage = new AccountPageController();
            add(accountPage,50,50);
        }
        else
            accountPage.toFront();
    }
    public void setRegisterPage(){

        if(registerPage==null) {
            registerPage = new RegisterPageController();
            add(registerPage,50,50);
        }
        else
            registerPage.toFront();
    }
    public void setVerifyPage(){

        if(verifyPage==null) {
            verifyPage = new VerifyPageController();
            add(verifyPage,50,50);
        }
        else
            verifyPage.toFront();
    }
    public void setManagerPage(){

        if(managerPage==null) {
            managerPage = new ManagerPageController();
            add(managerPage,50,50);
        }
        else
            managerPage.toFront();
    }
    public void setStatisticPage(){

        if(statisticPage==null) {
            statisticPage = new StatisticPageController();
            add(statisticPage,50,50);
        }
        else
            statisticPage.toFront();
    }
    public void showFunction(){
        functionAnchorPane.toFront();
    }
    public void showIcon(){
        taskBar.toFront();
        functionAnchorPane.toBack();
    }
    public void setAccount(Account account){
        this.account = account;
    }
    public Account getAccount() {return this.account;};
    public void setPage1() throws IOException {
        if(!account.getAccessAuthority().equals("admin"))
            return;
        if(showAccountPage == null) {
            showAccountPage = new ShowAccountPageController();
            add(showAccountPage, 350, 50);
        }
        showAccountPage.toFront();
        showAccountPage.showAccounts();
    }

    public void exit() {
        ((Stage)getRoot().getScene().getWindow()).close();
    }
    public void logOut() throws IOException {
        Stage stage = ((Stage)getRoot().getScene().getWindow());
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setRoot(root);
        loginPage=new LoginPageController();
        add(loginPage);
    }
}
