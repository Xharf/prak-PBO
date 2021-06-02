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
public class Kambing implements Animal{
    String nama = "k", jenis = "kambing";
    
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
        System.out.println("k");
    }
}
