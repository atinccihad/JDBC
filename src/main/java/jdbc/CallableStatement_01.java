package jdbc;

import java.sql.*;

public class CallableStatement01 {
    /*
    Java'da methodlar return type sahibi olsa da,
    void  olsada method olarak adlandirilir
    SQL'de ise data return ediyorsa buna biz "function" diyoruz,
    Return yapmiyorsa "procedure" diye adlandirilir
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed", "postgres", "atinccihadGmail");
        Statement st = con.createStatement();

        // 1. Örnek: İki parametre ile çalışıp bu parametreleri toplayarak return yapan bir fonksiyon oluşturun.

          // 1. Adim: fonksiyon kodunu yaz
          String sql1 = "create or replace function toplamaF(x NUMERIC, y NUMERIC)\n" +
                  "returns NUMERIC\n" +
                  "LANGUAGE plpgsql\n" +
                  "AS \n" +
                  "$$\n" +
                  "BEGIN\n" +
                  "\n" +
                  "RETURN x+y;\n" +
                  "\n" +
                  "END\n" +
                  "$$";

          // 2.Adim: Fonksiyonu calistir
          st.execute(sql1);

          // 3.Adim: Fonksiyonu cagir.
          CallableStatement cst1 = con.prepareCall("{? = call toplamaF(?, ?)}");

          // 4.Adim: Return icin registerOutParameter() methodunu, parametreler icin set() methodlarindan uygun olanlari kullan.
          cst1.registerOutParameter(1,Types.NUMERIC);
          cst1.setInt(2,15);
          cst1.setInt(3,25);

          // 5.Adim: Calistirmak icin execute()  kullan.
          cst1.execute();

          // 6.Adim: Sonucu cagirmak icin reyurn data tipine gore "get" methodlarindan uygun olani kullan.
          System.out.println(cst1.getBigDecimal(1));


        // 2. Örnek: Koninin hacmini hesaplayan bir function yazın.
        String sql2 = "create or replace function koniHacmi(r NUMERIC, h NUMERIC)\n" +
                "returns NUMERIC\n" +
                "LANGUAGE plpgsql\n" +
                "AS \n" +
                "$$\n" +
                "BEGIN\n" +
                "\n" +
                "RETURN 3.14 * r * r * h /3;\n" +
                "\n" +
                "END\n" +
                "$$";

        // 2.Adim: Fonksiyonu calistir
        st.execute(sql2);

        // 3.Adim: Fonksiyonu cagir.
        CallableStatement cst2 = con.prepareCall("{? = call koniHacmi(?, ?)}");

        // 4.Adim: Return icin registerOutParameter() methodunu, parametreler icin set() methodlarindan uygun olanlari kullan.
        cst2.registerOutParameter(1,Types.NUMERIC);
        cst2.setInt(2,3);
        cst2.setInt(3,5);

        // 5.Adim: Calistirmak icin execute()  kullan.
        cst2.execute();

        // 6.Adim: Sonucu cagirmak icin reyurn data tipine gore "get" methodlarindan uygun olani kullan.
        System.out.println(cst2.getBigDecimal(1));


    }
}
