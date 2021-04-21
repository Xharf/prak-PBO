package latih;

//import java.awt.event.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author niagahoster
 */
public class Latih {
    public static void main(String[] args) {
        new GUI();
    }
}
    
class GUI extends JFrame implements ActionListener{
    JLabel lnama = new JLabel("Nama Lengkap");
    final JTextField fnama = new JTextField();
    
    JLabel ljeniskelamin = new JLabel("Jenis Kelamin");
    JRadioButton rblaki = new JRadioButton("Laki-laki");
    JRadioButton rbperempuan = new JRadioButton("Perempuan");
    
    JLabel lagama = new JLabel("Agama");
    String[] namaAgama = {"Islam", "Kristen", "Katolik", "Hindu", "Budha"};
    JComboBox cmagama = new JComboBox(namaAgama);
    
    JLabel lhobi = new JLabel("Hobi");
    JCheckBox cbsepakbola = new JCheckBox("Sepakbola");
    JCheckBox cbbasket = new JCheckBox("Basket");
    
    JButton bsave = new JButton("Save");
    
    ButtonGroup group = new ButtonGroup();
    public GUI() {
        setTitle("Aplikasi");
        setSize(350, 300);
        
        group.add(rblaki);
        group.add(rbperempuan);
        
        setLayout(null);
        add(lnama);
        add(fnama);
        add(ljeniskelamin);
        add(rblaki);
        add(rbperempuan);
        add(lagama);
        add(cmagama);
        add(lhobi);
        add(cbsepakbola);
        add(cbbasket);
        add(bsave);
        
        //set bounds(m,n,o,p)
        lnama.setBounds(10,10,120,20);
        fnama.setBounds(130,10,150,20);
        ljeniskelamin.setBounds(10,35,120,20);
        rblaki.setBounds(130,35,100,20);
        rbperempuan.setBounds(230,35,100,20);
        lagama.setBounds(10,60,150,20);
        cmagama.setBounds(130,60,150,20);
        lhobi.setBounds(130,60,150,20);
        cbsepakbola.setBounds(130,85,100,20);
        cbbasket.setBounds(230,85,100,20);
        bsave.setBounds(350/2-120/2,130,120,20);
        setVisible(true);
        
        bsave.addActionListener(this);
        cmagama.addActionListener(this);
        
//        cmagama.addActionListener(this);
//        bsave.addActionListener(this);
//        rblaki.addActionListener(this);
    }
    
//    public void actionPerformed(ActionEvent e)
//    {      
//        if(e.getSource() == rblaki)
//        {
//            System.out.println("anu");
//        }
//        
//        else if(e.getSource() == cmagama)
//        {
//            System.out.println("Agama Anda : "+cmagama.getSelectedItem());
//        }
//        
//        else if(e.getSource() == bsave)
//        {
//            System.out.println("Tombol save diklik");
//            System.out.println("Nama : "+fnama.getText());
//        }
//    }
    
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == bsave)
            {
                System.out.println("Tombol save diklik");
            }
            
            
            if(e.getSource() == cmagama)
            {
                System.out.println("Agama Anda : "+cmagama.getSelectedItem());
            }
        }
}