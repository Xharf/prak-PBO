/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bangun.ruang;

//struktur kode yang ada di sini mungkin akan berbeda mas dengan
//apa yang dicontohkan. Tapi tenang, ini memang disengaja dibuat demikian.
//Mungkin yang dijadikan tugas itu harusnya implements MenghitungRuang ataupun
//MenghitungBidang dan bangun ruang extends bangun datar seperti misalnya
//balok yang extends persegiPanjang. 
//
//Saya sadar itu, tapi saya sadar ternyata
//mereka sebenarnya tidaklah memiliki hubungan inheritance 
//walau terlihat demikian. coz balok memang memiliki sisi berupa persegi panjang
//tapi tidak menjadikan rumus luas persegi panjang sebagai milik balok :)
//jadi mereka tidak saling menurunkan wkwk
//
//yeah it's just an academic way to see how it works.
//so, i think some changes here is an academic way too.
//to see how it works
//
//thx.

import math.obj.Bangun;
import bangun.datar.PersegiPanjang;
/**
 *
 * @author shazi awaludin
 */
public class Balok extends Bangun implements BangunRuang{
    private double t;
    private PersegiPanjang sisi;
    
    public Balok(double p, double l, double t){
        this.t = t;
        sisi = new PersegiPanjang(p,l);
        Bangun.number++;
        setName();
    }
    
    public Balok(double p, double l){
        this.t = 1;
        sisi = new PersegiPanjang(p,l);
        Bangun.number++;
        setName();
    }
    
    public Balok(double p){
        this.t = 1;
        sisi = new PersegiPanjang(p,1);
        Bangun.number++;
        setName();
    }
    
    @Override
    public void setName(){
        this.name = "Balok"+Bangun.number;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setAttrib(double p, double l, double t){
        this.t = t;
        sisi.setAttrib(p, l);
    }
    
    public void setAttrib(double p, double l){
        sisi.setAttrib(p, l);
    }
    
    public void setAttrib(double p){
        sisi.setAttrib(p);
    }
    
    public PersegiPanjang getSisi(){
        return sisi;
    }
    
    @Override
    public double volume(){
        return sisi.luas()*t;
    }
    
    @Override
    public double luasPermukaan(){
        return 2*sisi.luas()
                +2*sisi.p*t
                +2*sisi.l*t;
    }
}
