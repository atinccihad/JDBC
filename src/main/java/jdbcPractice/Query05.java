package jdbcPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Query05 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed",
                "postgres",
                "atinccihadGmail");

        Statement st = con.createStatement();

        // Soru: Ogrenciler tablosuna yeni bir kayit ekleyin (300, 'Sena Can', 12, 'K')

        // int s1 = st.executeUpdate("insert into ogrenciler values (301, 'Sena Can', 12, 'K')");
        // System.out.println(s1+" satir database'e eklendi.");

        // Soru: Ogrenciler tablosuna birden fazla veri ekleyin
        // (400, 'Sena Can', 12, 'K'), (401, 'Sena Can', 12, 'K'), (402, 'Sena Can', 12, 'K')
       /* String[]veri =  {"insert into ogrenciler values (401, 'Sena Can', 12, 'K')",
                         "insert into ogrenciler values (402, 'Sena Can', 12, 'K')",
                         "insert into ogrenciler values (402, 'Sena Can', 12, 'K')"};
        int count=0;
        for (String each:veri){
            st.executeUpdate(each);
            count = count+ st.executeUpdate(each);
        }
        System.out.println(count +" satir eklendi.");
        */
        // 2.yol
        String[]veri2 =  {"insert into ogrenciler values (501, 'Sena Can', 12, 'K')",
                "insert into ogrenciler values (502, 'Sena Can', 12, 'K')",
                "insert into ogrenciler values (502, 'Sena Can', 12, 'K')"};

        for (String each:veri2){
            st.addBatch(each); // yukaridaki datalarin hepsini birlestiriyor
        }
        st.executeBatch(); // datalari tek seferde gonderiyor.
        System.out.println("datalar eklendi.");


    }
}
