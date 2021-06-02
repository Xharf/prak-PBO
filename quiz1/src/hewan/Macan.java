/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hewan;

/**
 *
 * @author shazi awaludin
 */
public class Macan implements Animal{
    static int num=1;
    String nama = "m1", jenis = "macan";
    
    @Override
    public String getName(){
        return this.nama;
    }
    
    @Override
    public String getType(){
        return this.jenis;
    }
    
    @Override
    public void makeSound(){
        System.out.println("p".repeat(Macan.num));
        Macan.num++;
    }
}
