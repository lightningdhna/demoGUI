package dhung.dbc;

import dhung.model.Account;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountTable {

    private static boolean hasTable = false;
    private static final Connection conn = DatabaseConnection.getConnection();

    public static List<Account> castResultSet(ResultSet rs) throws SQLException {
        List<Account> accounts = new ArrayList<>();
        while(rs.next()){
            accounts.add(new Account(rs.getInt(1),
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
        String query=   "create table account_table( "+
                        "id int identity(1,1)," +
                        "username varchar(100) not null,"+
                        "[password] varchar(100) not null,"+
                        "[access authority] varchar(20) not null default'user'"+
                        ")";
        Connection conn = DatabaseConnection.getConnection();
        try {
            Statement statement = conn.createStatement();
            statement.execute(query);
        } catch (SQLException ignored) {

        }
    }
    public static List<Account> searchAccount(Account account){
        createTable();
        String query= "select id, username, password,[access authority]\n" +
                "from account_table\n" +
                "where "+
                "username = " +"'"+account.getUsername()+"'"+
                " and "+
                "password = " +"'"+account.getPassword()+"'";
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            return castResultSet(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
    public static List<Account> getAllAccount(){
        createTable();
        String query= "select id, username, password,[access authority]\n" +
                "from account_table";
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            return castResultSet(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

}
