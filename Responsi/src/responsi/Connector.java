/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi;

import java.sql.*;

/**
 *
 * @author shazi awaludin
 */
public class Connector {
    String DBurl = "jdbc:mysql://localhost/javagame?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String DBusername = "root";
    String DBpassword = "";
    public Connection conn;
    public Statement stmt;
    public Connector() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(DBurl,DBusername,DBpassword);
        } catch (Exception e) {
            System.out.println("Koneksi gagal" + e.getMessage());
        }
    }
}
