/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bangun.datar;

/**
 *
 * @author shazi awaludin
 */
public class PersegiPanjang implements BangunDatar{
    public double p;
    public double l;
    
    public PersegiPanjang(double p, double l){
        this.p = p;
        this.l = l;
    }
    
    public void setAttrib(double p, double l){
        this.l = l;
        this.p = p;
    }
    
    public void setAttrib(double p){
        this.l = 1;
        this.p = p;
    }
    
    @Override
    public double luas(){
        return p*l;
    }
   
    @Override
    public double keliling(){
        return 2*(p+l);
    }
}
