package dhung.view;

import dhung.controller.AccountManager;
import dhung.model.Account;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.List;

public class ShowAccountPageController extends Page{
    @FXML
    TableView tableView;
    @FXML
    TableColumn usernameColumn,passwordColumn;

    public void exit(){
        ((MainViewController)this.getParent()).exit();
    }

    public void showAccounts(){
        tableView.getItems().clear();
        List<Account> accounts = AccountManager.getManager().getAllAccount();
        ObservableList<Account> accountsShow = FXCollections.observableArrayList();
        accountsShow.addAll(accounts);
        usernameColumn.setCellValueFactory(new PropertyValueFactory<Account,String>("username"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<Account,String>("password"));

        tableView.setItems(accountsShow);
    }
    public ShowAccountPageController() throws IOException {
        super(Type.ShowAccounts);
        showAccounts();
    }
}
