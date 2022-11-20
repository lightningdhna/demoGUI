package dhung.controller;

import dhung.dbc.AccountTable;
import dhung.model.Account;

public class AccountManager {

    private static final AccountManager manager = new AccountManager();
    private AccountManager(){

    }
    public static AccountManager getManager(){
        return manager;
    }
    public boolean checkExist(Account account){
        return AccountTable.searchAccount(account).size()==1;
    }

    public String canAdd(Account account){
        return "";
    }



}
