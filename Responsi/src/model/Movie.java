/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

/**
 *
 * @author shazi awaludin
 */
public class Movie extends Model{
    public Movie() {
       super();
    }
    
    public int getBanyakData(){
        try {
            int jmlData = 0;
            String query = "Select * from movie";
            stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);
            while(resultSet.next()){
                jmlData++;
            }
            return jmlData;
        } catch (SQLException e) {
            return 0;
        }
    }
    
    public String[][] getMovie(){
        try {
            int i = 0;
            String data[][] = new String[this.getBanyakData()][5];
            String query = "SELECT * FROM movie";
            
            ResultSet resultSet = stmt.executeQuery(query);
            
            while (resultSet.next()){
                data[i][0] = resultSet.getString("judul");
                data[i][1] = resultSet.getString("alur");
                data[i][2] = resultSet.getString("penokohan");
                data[i][3] = resultSet.getString("akting");
                data[i][4] = resultSet.getString("nilai");
                i++;
            }
            return data;
        } catch (Exception e) {
            return null;
        }
    }
    
    public String[] getMovieByJudul(String judul){
        String data[] = new String[5];
        try {
            String query = "SELECT * FROM movie WHERE judul ='"+judul+"'";
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            data[0] = rs.getString("judul");
            data[1] = rs.getString("alur");
            data[2] = rs.getString("penokohan");
            data[3] = rs.getString("akting");
            data[4] = rs.getString("nilai");
            return data;
        } catch (SQLException e) {
            return null;
        }
    }
    
    public void createMovie(String judul, double alur, double penokohan, double akting, double nilai){
        try{
            String query = "INSERT INTO movie VALUES ('"+judul
                    +"','"
                    +alur
                    +"','"
                    +penokohan
                    +"','"
                    +akting
                    +"','"
                    +nilai
                    +"')";
            stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil Dimasukkan");
        } catch (SQLException e ){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void updateMovie(String judul, double alur, double penokohan, double akting, double nilai){
        try {
            String query = "UPDATE movie SET judul = '"+judul+"'"
                    +", alur ="+alur 
                    +", penokohan = "+penokohan
                    +", akting = "+akting
                    +", nilai = "+nilai
                    +" WHERE judul = "
                    + "'"+judul+"'";
            stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil Diupdate");
        } catch (SQLException e ){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void deleteMovie(String judul){
        try {
            String query = "DELETE FROM movie WHERE judul = '"+judul+"'";
            stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
   
}
