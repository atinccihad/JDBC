package jdbcPractice;

import org.w3c.dom.ls.LSOutput;

import static jdbcPractice.DatabaseUtility.*;

public class Query06 {
    public static void main(String[] args) {
        createConnection();

        String query = "select * from ogrenciler";
        System.out.println("Sutun isimleri: "+getColumnNames(query));

        System.out.println("Okul No = " + getColumnData(query,"okul_no"));
        System.out.println("Ogrenci Ismi = " + getColumnData(query,"ogrenci_ismi"));
        System.out.println("Sinif = " + getColumnData(query,"sinif"));
        System.out.println("Cinsiyet = " + getColumnData(query,"cinsiyet"));
        
    }

}
