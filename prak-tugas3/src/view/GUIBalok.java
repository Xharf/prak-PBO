package view;
import bangun.datar.*;
import bangun.ruang.*;
import math.obj.Bangun;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionListener;

/**
 *
 * @author shazi awaludin
 */
public class GUIBalok extends JFrame implements ActionListener{
    JLabel tHeader,
            tInput,
            tOutput,
            p,l,t,
            name, 
            lpersegi, 
            ksisi,
            volume,
            lpermukaan,
            titik1,
            titik2,
            titik3,
            titik4,
            titik5,
            hName,
            hlpersegi,
            hKs,
            hVolume,
            hlpermukaan,
            err1,
            err2,
            err3;
    
    
    JTextField ip = new JTextField(""),
               il = new JTextField(""),
               it = new JTextField("");
    
    JButton hitung = new JButton("Hitung"),
            reset = new JButton("Reset");
    
    public GUIBalok(){
        tHeader = new JLabel("KALKULATOR BALOK", JLabel.CENTER);
        tInput = new JLabel("====< BALOK >==== ", JLabel.CENTER);
        tOutput = new JLabel("==[ HASIL ]==", JLabel.CENTER);
        p = new JLabel("Panjang");
        l = new JLabel("Lebar");
        t = new JLabel("Tinggi");
        name = new JLabel("Nama Instance");
        lpersegi = new JLabel("Luas Persegi");
        ksisi = new JLabel("Keliling sisi");
        volume = new JLabel("Volume Balok");
        lpermukaan = new JLabel("Luas Permukaan");
        titik1 = new JLabel(":");
        titik2 = new JLabel(":");
        titik3 = new JLabel(":");
        titik4 = new JLabel(":");
        titik5 = new JLabel(":");
        hName = new JLabel("");
        hlpersegi =  new JLabel("");
        hKs =  new JLabel("");
        hVolume = new JLabel("");
        hlpermukaan =  new JLabel("");
        err1 = new JLabel();
        err2 = new JLabel();
        err3 = new JLabel();
        
        
        
        setTitle("Kalkulator Balok");
        int x = 360;
        int y = 480;
        setSize(x,y);
        setLayout(null);
        
        
        add(tHeader);
        add(tInput);
        add(tOutput);
        add(p);
        add(l);
        add(t);
        add(ip);
        add(il);
        add(it);
        add(name);
        add(lpersegi);
        add(ksisi);
        add(volume);
        add(lpermukaan);
        add(titik1);
        add(titik2);
        add(titik3);
        add(titik4);
        add(titik5);
        add(hitung);
        add(reset);
        add(err1);
        add(err2);
        add(err3);
        add(hName);
        add(hlpersegi);
        add(hKs);
        add(hVolume);
        add(hlpermukaan);
                
        tHeader.setBounds(0,30,x,20);
        p.setBounds(30,60,120,20);
        ip.setBounds(150,60,150,20);
        err1.setBounds(150,80,150,20);
        
        l.setBounds(30,110,120,20);
        il.setBounds(150,110,150,20);
        err2.setBounds(150,130,150,20);
        
        t.setBounds(30,160,120,20);
        it.setBounds(150,160,150,20);
        err3.setBounds(150,180,150,20);
        
        
        
        hitung.setBounds(50,210,100,20);
        reset.setBounds(180,210,100,20);
        
        tOutput.setBounds(0,250,x,20);
        name.setBounds(30,280,120,20);
        lpersegi.setBounds(30,310,120,20);
        ksisi.setBounds(30,340,120,20);
        volume.setBounds(30,370,120,20);
        lpermukaan.setBounds(30,400,120,20);
        titik1.setBounds(130,280,10,20);
        titik2.setBounds(130,310,10,20);
        titik3.setBounds(130,340,10,20);
        titik4.setBounds(130,370,10,20);
        titik5.setBounds(130,400,10,20);
        
        hName.setBounds(140,280,120,20);
        hlpersegi.setBounds(140,310,120,20);
        hKs.setBounds(140,340,120,20);
        hVolume.setBounds(140,370,120,20);
        hlpermukaan.setBounds(140,400,120,20);
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        hitung.addActionListener(this);
        reset.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        Balok balok;
        err1.setText("");
        err2.setText("");
        err3.setText("");
        if(e.getSource() == hitung)
        {
            float panjang=0, lebar=0, tinggi=0;
            
            if(!ip.getText().isEmpty() && !ip.getText().trim().isEmpty()){
                try {
                    panjang = Float.parseFloat(ip.getText());
                } catch (Exception ex) {
                  err1.setText("Must be Number!");
                }
                
            }
            else{
                err1.setText("Panjang Harus diisi");
            }
            if(!il.getText().isEmpty() && !il.getText().trim().isEmpty())
                try {
                    lebar = Float.parseFloat(il.getText());
                } catch (Exception ex) {
                  err2.setText("Must be Number!");
                }
            else
                err2.setText("Lebar Harus diisi");
            
            if(!it.getText().isEmpty() && !it.getText().trim().isEmpty())
                try {
                    tinggi = Float.parseFloat(it.getText());
                } catch (Exception ex) {
                  err3.setText("Must be Number!");
                }
                
            else
                err3.setText("Lebar Harus diisi");
                
            if(!ip.getText().isEmpty()&&
               !il.getText().isEmpty()&&
               !it.getText().isEmpty()){
                balok = new Balok(panjang,lebar,tinggi);
                hName.setText(balok.name);
                hlpersegi.setText(""+balok.getSisi().luas());
                hKs.setText(""+balok.getSisi().keliling());
                hVolume.setText(""+balok.volume());
                hlpermukaan.setText(""+balok.luasPermukaan());
            }
        }
        if(e.getSource() == reset){
            ip.setText("");
            il.setText("");
            it.setText("");
            err1.setText("");
            err2.setText("");
            err3.setText("");
            hName.setText("");
            hlpersegi.setText("");
            hKs.setText("");
            hVolume.setText("");
            hlpermukaan.setText("");
        }
        setVisible(true);
    }
}