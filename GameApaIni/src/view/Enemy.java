/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.ImageIcon;

/**
 *
 * @author shazi awaludin
 */
public class Enemy extends View{
    private Missile missile;
    public int health = 100;
    public Enemy(int x, int y) {
        this.x = x;
        this.y = y;

        this.missile = new Missile(x, y);

        var enemyi = "src/images/enemy.png";
        var ii = new ImageIcon(enemyi);

        setImage(ii.getImage());
    }
    
    public void move(int direction) {
        this.x += direction;
    }
    
    public Missile getMissile() {
        return missile;
    }
    
    public class Missile extends View {
        private boolean destroyed;
        public Missile(int x, int y) {
            setDestroyed(true);

            this.x = x;
            this.y = y;

            var bombImg = "src/images/missile.png";
            var ii = new ImageIcon(bombImg);
            setImage(ii.getImage());
        }
        
         public void setDestroyed(boolean destroyed) {
            this.destroyed = destroyed;
        }

        public boolean isDestroyed() {
            return destroyed;
        }
    }
}
