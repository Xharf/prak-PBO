package hewan;

/**
 *
 * @author shazi awaludin
 */
public class Ayam implements Animal{
    String nama = "a", jenis = "ayam";
    
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
        System.out.println("a");
    }
}
