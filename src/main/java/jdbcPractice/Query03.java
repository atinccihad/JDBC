package jdbcPractice;

import java.sql.*;

public class Query03 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, SQLException {

        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                "postgres",
                "password");
        //Statement st = con.createStatement();

        PreparedStatement ps = con.prepareStatement("select * from ogrenciler");

        ResultSet rs = ps.executeQuery();

        ResultSetMetaData rsmd = rs.getMetaData();

        System.out.println("Sutun Sayısı: " + rsmd.getColumnCount());

        System.out.println("1. Sutunun ismi: " + rsmd.getColumnName(1));
        System.out.println("2. Sutunun ismi: " + rsmd.getColumnName(2));
        System.out.println("3. Sutunun ismi: " + rsmd.getColumnName(3));
        System.out.println("4. Sutunun ismi: " + rsmd.getColumnName(4));

        System.out.println("1. Sutunun Data Tipi: " + rsmd.getColumnTypeName(1));
        System.out.println("2. Sutunun Data Tipi: " + rsmd.getColumnTypeName(2));
        System.out.println("3. Sutunun Data Tipi: " + rsmd.getColumnTypeName(3));
        System.out.println("4. Sutunun Data Tipi: " + rsmd.getColumnTypeName(4));

        System.out.println("Tablo İsmi: " + rsmd.getTableName(2));
    }
}
