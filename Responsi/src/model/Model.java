package model;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author shazi awaludin
 */
public class Model {

    String DBurl;
    String DBusername = "root";
    String DBpassword = "";
    String DBname = "movie_db";
    public Connection conn;
    public Statement stmt;
    String table;
    String primaryKey = "id";

    public Model() {
        this.DBurl = "jdbc:mysql://localhost/"
                + DBname
                + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        
        System.out.println(this.DBurl);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(DBurl, DBusername, DBpassword);
            stmt = conn.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
