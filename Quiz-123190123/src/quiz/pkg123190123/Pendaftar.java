/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz.pkg123190123;

/**
 *
 * @author shazi awaludin
 */
public class Pendaftar extends Bobot{
    String nik, nama, status, divisi;
    double ncoding, ntulis, nwawancara, total;

    public Pendaftar(char mode) {
        if (mode == '1') {
            super.tulis = 0.2;
            super.coding =  0.5;
            super.wawancara = 0.3;
            this.divisi = "Android";
        } else {
            super.tulis = 0.4;
            super.coding =  0.35;
            super.wawancara = 0.25;
            this.divisi = "Web";
        }
    }

    public void edit(String nik,
            String nama,
            double coding,
            double tulis,
            double wawancara) {
        this.nik = nik;
        this.nama = nama;
        this.ncoding = coding;
        this.ntulis = tulis;
        this.nwawancara = wawancara;
    }

    public void cek() {
        this.total = ntulis * this.tulis
                + ncoding * this.coding
                + nwawancara * this.wawancara;
        if ( total < 85) {
            this.status = "GAGAL\nmohon maaf "
                    + nama
                    + ", Anda belum bisa masuk ke divisi "
                    + divisi;
        } else {
            this.status = "SELAMAT\n"
                    + nama
                    + " Kamu telah diterima di divisi "
                    + divisi
                    + "!";
        }
    }
}
