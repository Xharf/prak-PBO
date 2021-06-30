package controller;


import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.awt.event.*;
import model.*;
import view.*;
/**
 *
 * @author shazi awaludin
 */
public class MovieController implements ActionListener{
    Movie movie;
    View view;
    
    public MovieController(Movie movie, View view){
        this.movie = movie;
        this.view = view;
        if (movie.getBanyakData() != 0){
            String data[][] = movie.getMovie();
            System.out.println(data);
            view.table.setModel(new JTable(data, view.colName).getModel());
        } else {
            JOptionPane.showMessageDialog(null, "Data Masih Kosong");
        }
        
        view.Btambah.addActionListener(this);
        view.Bupdate.addActionListener(this);
        view.Bdelete.addActionListener(this);
        view.Bclear.addActionListener(this);
        
        view.table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int baris = view.table.getSelectedRow();
                int kolom = view.table.getSelectedColumn();

                view.Tjudul.setText(view.table.getValueAt(baris, 0).toString());
                view.Talur.setText(view.table.getValueAt(baris, 1).toString());
                view.Tpenokohan.setText(view.table.getValueAt(baris, 2).toString());
                view.Takting.setText(view.table.getValueAt(baris, 3).toString());
                view.Tnilai.setText(view.table.getValueAt(baris, 4).toString());
            }
        });
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == view.Btambah) {
            String judul = view.getJudul();
            double alur = view.getAlur();
            double penokohan = view.getPenokohan();
            double akting = view.getAkting();
            double nilai = view.getNilai();
            
            if(judul.equals("")){
                JOptionPane.showMessageDialog(null, "Judul Tidak Boleh Kosong");
            } else if(alur==0){
                JOptionPane.showMessageDialog(null, "Alur Tidak Boleh Nol atau Huruf");
            } else if(penokohan == 0){
                JOptionPane.showMessageDialog(null, "Penokohan Tidak Boleh Nol atau Huruf");
            } else if(akting==0){
                JOptionPane.showMessageDialog(null, "Akting Tidak Boleh Nol atau Huruf");
            } else if(nilai==0){
                JOptionPane.showMessageDialog(null, "Nilai Tidak Boleh Nol atau Huruf");
            } else{
                movie.createMovie(judul, alur, penokohan, akting, nilai);
                String newData[][] = movie.getMovie();
                System.out.println(newData);
                view.table.setModel(new JTable(newData, view.colName).getModel());
            }
            
        } else if(e.getSource() == view.Bclear){
            view.Tjudul.setText("");
            view.Talur.setText("");
            view.Tpenokohan.setText("");
            view.Takting.setText("");
            view.Tnilai.setText("");
        } else if (e.getSource() == view.Bupdate){
            String judul = view.getJudul();
            double alur = view.getAlur();
            double penokohan = view.getPenokohan();
            double akting = view.getAkting();
            double nilai = view.getNilai();
            
            if(judul.equals("")){
                JOptionPane.showMessageDialog(null, "Judul Tidak Boleh Kosong");
            } else if(alur==0){
                JOptionPane.showMessageDialog(null, "Alur Tidak Boleh Nol");
            } else if(penokohan == 0){
                JOptionPane.showMessageDialog(null, "Penokohan Tidak Boleh Nol");
            } else if(akting==0){
                JOptionPane.showMessageDialog(null, "Akting Tidak Boleh Nol");
            } else if(nilai==0){
                JOptionPane.showMessageDialog(null, "Nilai Tidak Boleh Nol");
            } else{
                movie.updateMovie(judul, alur, penokohan, akting, nilai);
                String newData[][] = movie.getMovie();
                view.table.setModel(new JTable(newData, view.colName).getModel());
            }
        } else if(e.getSource() == view.Bdelete){
            String judul = view.getJudul();
            if(judul.equals("")){
                JOptionPane.showMessageDialog(null, "Judul Tidak Boleh Kosong");
            } else{
                movie.deleteMovie(judul);
                String newData[][] = movie.getMovie();
                view.table.setModel(new JTable(newData, view.colName).getModel());
            }
        }
    }
}
