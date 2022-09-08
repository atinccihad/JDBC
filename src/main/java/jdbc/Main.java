package jdbc;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        // DBWork objesini olustur.
        DBWork db = new DBWork();

        // Connection methodunu databaseden cagirdik.
        Connection con = db.connect_to_db("techproed", "postgres", "password");

        // Yeni table olusturma methodunu cagir.
        db.createTable(con,"employees");

    }
}
