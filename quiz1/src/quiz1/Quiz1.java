/*
 * Soalnya kemungkinan akan membuat beberapa orang
 * akan memiliki codingan yang sama walau tanpa saling
 * bekerja sama. Karena ya cara paling simple yang dipikirin
 * dan sesuai dengan ketentuan adalah demikian
 */
package quiz1;

import hewan.*;

/**
 *
 * @author shazi awaludin
 */
public class Quiz1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Macan macan1 = new Macan();
       Macan macan2 = new Macan();
       Kambing kambing = new Kambing();
       Ayam ayam = new Ayam();
       
       printAnimal(macan1);
       printAnimal(macan2);
       printAnimal(kambing);
       printAnimal(ayam);
    }
    
    public static void printAnimal(Animal animal){
        System.out.print( animal.getName() + " adalah " + animal.getType() + " dengan bunyi ");
        animal.makeSound();
    }
}
