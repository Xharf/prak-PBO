/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.Player;
import java.awt.event.KeyEvent;

/**
 *
 * @author shazi awaludin
 */
public class PlayerController {
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            Player.setdx(-2);
        }
        if (key == KeyEvent.VK_RIGHT) {
            Player.setdx(2);
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            Player.setdx(0);
        }

        if (key == KeyEvent.VK_RIGHT) {
            Player.setdx(0);
        }
    }
}
