/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author shazi awaludin
 */
public class Achievement extends Model {

    public Achievement() {
        super();
    }

    public void createAchievement(long difference, String dt) {
        try {
            String query = "INSERT INTO achievement VALUES ('" + difference + "','" + dt + "')";

            stmt.executeUpdate(query);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public String[] getAchievement() {
        String data[] = new String[2];
        try {
            String query = "SELECT * FROM achievement ORDER BY time_score ASC LIMIT 1";
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            data[0] = rs.getString("time_score");
            java.sql.Date dtobject = rs.getDate("date");
            data[1] = dtobject.toString();
 
        } catch (SQLException e) {
            data[0] = "belum ada data";
            data[1] = "belum ada data";
            //JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return data;
    }
}
