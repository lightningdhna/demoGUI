package dhung.dbc;

import dhung.model.Account;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountTable {

    private static boolean hasTable = false;
    public static List<Account> castResultSet(ResultSet rs) throws SQLException {
        List<Account> accounts = new ArrayList<>();
        while(rs.next()){
            accounts.add(new Account(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4)));
        }
        return accounts;
    }
    public static void createTable() {
        if(hasTable)
           return;
        hasTable = true;
        String query= """
                create table account_table(
                id int identity(1,1),
                username varchar(100) not null,
                [password] varchar(100) not null,
                [access authority] varchar(20) not null default 'user')""";
        try {
            DatabaseConnection.execute(query);
        } catch (SQLException ignored) {

        }
    }
    public static List<Account> search(Account account){
        createTable();
        String query=String.format("""
                select id, username, password,[access authority]
                from account_table
                where username = '%s' and password = '%s2'""",account.getUsername(),account.getPassword());
        try {
            ResultSet rs = DatabaseConnection.executeQuery(query);
            return castResultSet(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
    public static boolean add(Account account)  {
        createTable();
        String query=String.format("""
                        insert into account_table(username,password)
                        values('%s','%s')
                        """,account.getUsername(),account.getPassword()
        );
        try {
            DatabaseConnection.execute(query);
            return true;
        } catch (SQLException e) {
//            e.printStackTrace();
            return false;
        }
    }
    public static List<Account> getAllAccount(){
        createTable();
        String query= "select id, username, password,[access authority]\n" +
                "from account_table";
        try {
            ResultSet rs = DatabaseConnection.executeQuery(query);
            return castResultSet(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
