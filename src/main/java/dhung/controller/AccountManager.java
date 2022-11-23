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
        List<Account> resultSearch=AccountTable.search(account);
         if(resultSearch.size()==1){
             account.assign(resultSearch.get(0));
             return true;
         }
         else return false;
    }

    public boolean add(Account account){
        if(AccountTable.add(account)){
            accounts.add(account);
            return true;
        }
        return false;
    }


}
