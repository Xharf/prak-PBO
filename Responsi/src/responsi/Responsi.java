/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi;

import view.*;
import javax.swing.UIManager;
import javax.swing.SwingUtilities;
import model.Movie;
import controller.*;

/**
 *
 * @author shazi awaludin
 */
public class Responsi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Movie movie = new Movie();
        View view = new View();
        MovieController controller = new MovieController(movie, view);
    }

}
