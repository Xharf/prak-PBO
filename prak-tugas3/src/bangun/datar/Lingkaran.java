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
public class Lingkaran implements BangunDatar {
    public static final double PI =  3.14159265358979323846;
    private double r;
    
    /**
     *
     * @param r
     */
    public Lingkaran(double r){
        this.r = r;
    }
    
    public void setAttrib(double r){
        this.r = r;
    }
    
    public double getAttrib(){
        return r;
    }
    
    @Override
    public double luas(){
        return PI*r*r;
    }
   
    @Override
    public double keliling(){
        return 2*PI*r;
    }
}
