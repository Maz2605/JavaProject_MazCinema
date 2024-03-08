package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnection {
    public static Connection getConnection(){
        final String user = "sa";
        final String password = "123456";
        String url = "jdbc:sqlserver://localhost:1433;databaseName=mazCinema;user="+user+";password="+password;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void closeConnection(Connection connection){
        try{
            if(connection!= null){
                connection.close();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
