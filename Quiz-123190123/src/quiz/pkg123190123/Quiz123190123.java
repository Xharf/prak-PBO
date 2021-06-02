/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz.pkg123190123;

import java.util.Scanner;

/**
 *
 * @author shazi awaludin
 */
public class Quiz123190123 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char menu, menu2;
        String nik, nama;
        double tulis, coding, wawancara;
        do {
            System.out.println("FORM PENDAFTARAN PT.AWAL");
            System.out.println("1. Adroid Dev");
            System.out.println("2. Web Dev");
            System.out.println("0. exit");
            System.out.print("Pilih jenis FOrm: ");

            menu = in.next().charAt(0);
            if (menu == '0') {
                System.exit(0);
            }
            Pendaftar pendaftar = null;
            if (menu == '1') {
                pendaftar = new Pendaftar(menu);
            } else if (menu == '2') {
                pendaftar = new Pendaftar(menu);
            }

            System.out.println("");
            System.out.println("FORM INPUT DATA");
            System.out.println("");

            System.out.print("NIK: ");
            nik = in.next();
            System.out.print("Nama: ");
            in.nextLine();
            nama = in.nextLine();
            System.out.print("Nilai tes Tulis: ");
            tulis = in.nextDouble();
            System.out.print("Nilai tes Coding: ");
            coding = in.nextDouble();
            System.out.print("Nilai tes Wawancara: ");
            wawancara = in.nextDouble();

            pendaftar.edit(nik, nama, coding, tulis, wawancara);

            if (menu == '1') {
                pendaftar.cek();
            } else if (menu == '2') {
                pendaftar.cek();
            }
            do {
                System.out.println("\n\nYou get some treasure!");
                System.out.println("1. Edit");
                System.out.println("2. Tampil");
                System.out.println("0. Exit");
                System.out.print("Pilih : ");
                menu2 = in.next().charAt(0);
                
                if (menu2 == '1') {
                    System.out.println("");
                    System.out.println("FORM INPUT DATA");
                    System.out.println("");

                    System.out.print("NIK: ");

                    nik = in.next();
                    System.out.print("Nama: ");
                    nama = in.next();
                    System.out.print("Nilai tes Tulis: ");
                    tulis = in.nextDouble();
                    System.out.print("Nilai tes Coding: ");
                    coding = in.nextDouble();
                    System.out.print("Nilai tes Wawancara: ");
                    wawancara = in.nextDouble();
                    in.nextLine();

                    pendaftar.edit(nik, nama, coding, tulis, wawancara);

                    if (menu == '1') {
                        pendaftar.cek();
                    } else if (menu == '2') {
                        pendaftar.cek();
                    }
                } else if (menu2 == '2') {
                    System.out.println("\nNilai akhir: " + pendaftar.total);
                    System.out.println("KETERANGAN : " + pendaftar.status + "\n");
                }
            } while (menu2 != '0');
            System.out.println("");
        } while (menu != '0');
        System.out.println("");
    }

}
