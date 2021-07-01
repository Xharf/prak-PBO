/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author shazi awaludin
 */
import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;

public class Player extends View {

    private int width;
    public int dmg = 10;

    public Player() {
        var playerImg = "src/images/player.png";
        var ii = new ImageIcon(playerImg);

        width = ii.getImage().getWidth(null);
        setImage(ii.getImage());

        int START_X = 250;
        setX(START_X);

        int START_Y = 420;
        setY(START_Y);
    }

    public void move() {
        x += dx;
        if (x <= 2) {
            x = 2;
        }

        if (x >= Env.BOARD_WIDTH - (2 * width)) {
            x = Env.BOARD_WIDTH - (2 * width);
        }
    }
    
    public static void setdx(int dx){
        View.dx = dx;
    }
}
