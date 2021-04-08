/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prak.tugas3;
import bangun.datar.*;
import bangun.ruang.*;
import math.obj.Bangun;
import java.util.Scanner;
/**
 *
 * @author shazi awaludin
 */
public class PrakTugas3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        char input;
        Scanner in = new Scanner(System.in);
        
        do{
        System.out.println("INPUT");
        System.out.println("1.Balok");
        System.out.println("2.Kerucut");
        System.out.println("3.Exit");
        System.out.println("Pilih: ");
//        in.nextLine();
        input = in.next().charAt(0);
        System.out.println("");
        switch(input){
            case '1' ->{
                double p,l,t;
                System.out.println("====< BALOK >==== ");
                System.out.print("Panjang\t= ");
                p = in.nextDouble();
                System.out.print("Lebar\t= ");
                l = in.nextDouble();
                System.out.print("Tinggi\t= ");
                t = in.nextDouble();
                
                Balok balok = new Balok(p,l,t);
                System.out.println("");
                System.out.println("_____< OUTPUT >_____");
                System.out.println("Nama instance : " + balok.name);
                System.out.println("Luas Persegi \t: " + balok.getSisi().luas());
                System.out.println("Keliling sisi\t: " + balok.getSisi().keliling());
                System.out.println("Volume Balok\t: " + balok.volume());
                System.out.println("Luas Permukaan\t: " + balok.luasPermukaan());
                System.out.println("");
            }
            case '2' ->{
                double r,t;
                System.out.println("====< Kerucut >==== ");
                System.out.print("Jejari\t= ");
                r = in.nextDouble();
                System.out.print("Tinggi\t= ");
                t = in.nextDouble();
                
                Kerucut kerucut = new Kerucut(r, t);
                System.out.println("");
                System.out.println("_____< OUTPUT >_____");
                System.out.println("Nama instance : " + kerucut.name);
                System.out.println("Luas Alas \t: " + kerucut.getAlas().luas());
                System.out.println("Keliling Alas\t: " + kerucut.getAlas().keliling());
                System.out.println("Volume Kerucut\t: " + kerucut.volume());
                System.out.println("Luas Permukaan\t: " + kerucut.luasPermukaan());
                System.out.println("");
            }
            case '3' ->{
                System.exit(0);
            }
        }
        }while(input != '3');
    }
    
}
