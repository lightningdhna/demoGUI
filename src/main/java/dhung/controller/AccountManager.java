package dhung.controller;

import dhung.dbc.AccountTable;
import dhung.model.Account;

import java.util.List;

public class AccountManager {

    private static List<Account> accounts;
    private static final AccountManager manager = new AccountManager();
    private AccountManager(){
        accounts=AccountTable.getAllAccount();
    }

    public List<Account> getAllAccount(){
        return accounts;
    }
    public static AccountManager getManager(){
        return manager;
    }
    public boolean checkExist(Account account){
        return AccountTable.search(account).size()==1;
    }

    public boolean add(Account account){
        return AccountTable.add(account);
    }


}
