package icu.nothingless.ysd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "9520");
            ResultSet rs = conn.prepareStatement(" SHOW TABLES; ").executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
