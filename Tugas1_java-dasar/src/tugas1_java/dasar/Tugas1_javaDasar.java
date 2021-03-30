
package tugas1_java.dasar;
import java.util.Scanner;
/**
 *
 * @author shazi awaludin
 */

class Mahasiswa{
   private String name;
   private String nim;
   private int usia;
   private double uts;
   private double uas;
   
   Mahasiswa(String name, String nim, int usia, double uts, double uas){
       this.name = name;
       this.nim = nim;
       this.usia = usia;
       this.uts = uts;
       this.uas = uas;
   }
   
   public void show(){
       System.out.println("Name \t: " + this.name);
       System.out.println("NIM \t: " + this.nim);
       System.out.println("Usia \t: " + this.usia);
       System.out.println("UTS \t: " + this.uts);
       System.out.println("UAS \t: " + this.uas);
       System.out.println("Rerata \t: " + this.getRerata());
   }
   
   public String getNim(){
       return this.nim;
   }
  
   public double getRerata(){
       return (this.uts+this.uas)/2;
   }
   
   public void setName(String value){
       this.name = value;
   }
   
   public void setUts(double value){
       this.uts = value;
   }
   public void setUas(double value){
       this.uas = value;
   }
}

public class Tugas1_javaDasar {
    public static void main(String[] args) {
        char input;
        Scanner in = new Scanner(System.in);
        Mahasiswa []mhs;
        mhs = new Mahasiswa[1000];
        int count=0;
        
        do{
        System.out.println("=[ Menu Awal ]=");
        System.out.println("1. Input Data");
        System.out.println("2. Edit Data");
        System.out.println("3. Show All Data");
        input = in.next().charAt(0);
        
        switch (input){
            case '1' -> { 
                int banyak;
                System.out.println("Berapa jumlah input?:");
                banyak = in.nextInt();
                System.out.println("----------Input data----------");
                for(int i=0; i < banyak; i++){
                    in.nextLine(); // clearing new line input

                    System.out.println("data ke-" +(i+1));
                    System.out.print("Nama \t: ");
                    String name = in.nextLine();
                    System.out.print("NIM \t: ");
                    String nim = in.nextLine();
                    System.out.print("Usia \t: ");
                    int usia = in.nextInt();
                    System.out.print("UTS \t: ");
                    double uts = in.nextDouble();
                    System.out.print("UAS \t: ");
                    double uas = in.nextDouble();
                    System.out.print("\n");

                    mhs[count] = new Mahasiswa(name, nim, usia, uts,uas);
                    count++;
                }
            }
            case '2' -> {
                System.out.println("---------- Edit Data --------");    
                System.out.print("Masukkan NIM: ");
                in.nextLine();
                String nim = in.nextLine();
                int i;
                boolean found=false;
                if(mhs[0] != null){
                    for (i=0; i<count || found == false; i++){
                        if(mhs[i].getNim().equals(nim)){
                            char einput;
                            found = true;
                            do{
                                System.out.println("Data saat ini");
                                mhs[i].show();
                                System.out.println("1. Nama");
                                System.out.println("2. UTS");
                                System.out.println("3. UAS");
                                System.out.println("0. Selesai");
                                System.out.print("Yang akan diubah:");
                                einput = in.next().charAt(0);

                                switch(einput){
                                    case '1' -> { 
                                        System.out.print("Nama baru:");
                                        in.nextLine();
                                        String value = in.nextLine();
                                        mhs[i].setName(value);
                                    }
                                    case '2'->{
                                        System.out.print("Nilai UTS baru:");
                                        double value = in.nextDouble();
                                        mhs[i].setUts(value);
                                    }
                                    case '3'->{
                                        System.out.print("Nilai UAS baru:");
                                        double value = in.nextDouble();
                                        mhs[i].setUas(value);
                                    }
                                }
                                System.out.println("\n");
                            }while (einput != '0');
                        }
                    }

                    if(i == count && !found){
                        System.out.println("Data tidak ditemukan");
                    }
                }else{
                    System.out.println("Data Masih kosong");
                }
            }
            case '3' -> {
                if(mhs[0] != null){
                    for(int i =0; i<count;i++){
                        System.out.println("\nData Mahasiswa: \n");
                        mhs[i].show();
                    }
                }else{
                    System.out.println("Data Masih kosong");
                }
            }
        }
        
        System.out.println('\n');
        }while(input != '0');
    }
}
