package dhung.dbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class DatabaseConnection {
    private static Connection conn = null;

    private static void createConnection() throws SQLException {
        try {
            String dbURL = "jdbc:sqlserver://DESKTOP-9UGDV8N\\SQLEXPRESS;"+
                            "databaseName=demoGUI;"+
                            "encrypt=true; trustServerCertificate=true;"+
                            "sslProtocol=TLSv1.2";
            String user  =  "sa";
            String pass  =  "Na01639931063184";

            conn = DriverManager.getConnection(dbURL, user, pass);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static Connection getConnection() {
        if(conn==null) {
            try {
                createConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
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

}
