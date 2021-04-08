/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bangun.ruang;

import math.obj.Bangun;
import bangun.datar.Lingkaran;

/**
 *
 * @author shazi awaludin
 */
public class Kerucut extends Bangun implements BangunRuang {
    
    private double t;
    private Lingkaran alas;
    
    public Kerucut(double r, double t){
        Bangun.number++;
        alas = new Lingkaran(r);
        this.t = t;
        this.setName();
    }
    
    public Kerucut(double r){
        Bangun.number++;
        alas = new Lingkaran(r);
        this.t = 1;
        this.setName();
    }
   
    @Override
    public void setName(){
        this.name = "Kerucut"+Bangun.number;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setAttrib(double r, double t){
        alas = new Lingkaran(r);
        this.t = t;
    }
    
    public void setAttrib(double r){
        alas = new Lingkaran(r);
        this.t = 1;
    }
    
    public Lingkaran getAlas(){
        return alas;
    }
    
    public double luasSelimut(){
        return Lingkaran.PI
                *alas.getAttrib()
                *Math.sqrt(
                        (t*t) 
                         +(alas.getAttrib()
                           *alas.getAttrib()
                           )
                );
    } 
            
    @Override
    public double volume(){
        return (alas.luas()*t)/3;
    }
    
    @Override
    public double luasPermukaan(){
        return this.luasSelimut()+alas.luas();
    }
}
