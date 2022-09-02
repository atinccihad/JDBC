package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBWork {

    // PostgreSQL baglantisi methodu.
    public Connection connect_to_db(String dbName, String user, String password){
        Connection con=null;
        try {
            Class.forName("org.postgresql.Driver");
             con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+dbName,user,password);
            if (con != null){
                System.out.println("Baglanti saglandi");
            }else {
                System.out.println("Baglanti saglanamadi");
            }
        }catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

    // Yeni table olusturma methodu
    public void createTable(Connection con, String tableName){
        // Statement objesi olustur
        Statement statement;

        try {
            String query = "CREATE TABLE "+tableName+"(empId SERIAL, name VARCHAR(200), email VARCHAR(200), salary INTEGER, PRIMARY KEY(empId))";
            statement = con.createStatement();

            statement.executeUpdate(query);
            System.out.println("Table olusturuldu.");

        }catch (Exception e){
            System.out.println(e);
        }

    }




}
