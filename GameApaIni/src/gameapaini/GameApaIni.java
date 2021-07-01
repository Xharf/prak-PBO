/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameapaini;
import view.Env;
import view.Board;
import java.awt.EventQueue;
import javax.swing.JFrame;

public class GameApaIni extends JFrame{
    public GameApaIni(){
        add(new Board());
        setTitle("AWAS ADA MONSTER");
        setSize(Env.BOARD_WIDTH, Env.BOARD_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var execute = new GameApaIni();
            execute.setVisible(true);
        });
    }
}
