package dhung.dbc;

import java.sql.*;

public class DatabaseConnection {
    private static Connection conn = null;
    private static Statement statement = null;

    private static void createConnection() throws SQLException {
        try {
            String dbURL = "jdbc:sqlserver://DESKTOP-9UGDV8N\\SQLEXPRESS;"+
                            "databaseName=demoGUI;"+
                            "encrypt=true; trustServerCertificate=true;"+
                            "sslProtocol=TLSv1.2";
            String user  =  "sa";
            String pass  =  "Na01639931063184";

            conn = DriverManager.getConnection(dbURL, user, pass);
            statement=conn.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void startConnecting() {
        if(conn==null) {
            try {
                createConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static Connection getConnection() throws SQLException {
        if(conn==null||conn.isClosed())
            startConnecting();
        return conn;
    }

    public static void closeConnection(){
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static ResultSet executeQuery(String query) throws SQLException {
        if(conn==null||conn.isClosed())
                createConnection();
        return statement.executeQuery(query);
    }
    public static boolean execute(String query) throws SQLException {
        if(conn==null||conn.isClosed())
            createConnection();
        return statement.execute(query);
    }
}
