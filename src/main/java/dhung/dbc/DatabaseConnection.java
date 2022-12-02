package dhung.dbc;

import java.sql.*;

public class DatabaseConnection {
    private static Connection conn = null;
    private static Statement statement = null;

    private static void createConnection() throws SQLException {
        try {
            String dbURL = "jdbc:sqlserver://DESKTOP-2021EYY;"+
                    "databaseName=ch3b1;"+
                    "encrypt=true; trustServerCertificate=true;"+
                    "sslProtocol=TLSv1.2";
            String user  =  "sa";
            String pass  =  "kimhung29042002";

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
    public static void execute(String query) throws SQLException {
        if(conn==null||conn.isClosed())
            createConnection();
        statement.execute(query);
    }
}
