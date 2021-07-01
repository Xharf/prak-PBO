/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.PlayerController;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import model.Achievement;

/**
 *
 * @author shazi awaludin
 */
public class Board extends JPanel{
    private Dimension d;
    private Enemy enemy;
    private Player player;
    private PlayerController playerController;
    private Shot shot;
    private int direction = -1;
    private boolean inGame = true;
    private String explodedImg = "src/images/explosions.png";
    private String message = "Game Over";
    private int givenDmg=0;
    private Timer timer;
    String achievement[];
    String start;
    String end;
    SimpleDateFormat formatter;
    
    
    public Board() {
        formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
        Date date = new Date();
        start = formatter.format(date);
        
        Achievement acv = new Achievement();
        achievement = acv.getAchievement();
        
        addKeyListener(new TAdapter());
        setFocusable(true);
        d = new Dimension(Env.BOARD_WIDTH, Env.BOARD_HEIGHT);
        setBackground(Color.BLACK);
        
        timer = new Timer(Env.DELAY, new GameCycle());
        timer.start();
        
        enemy = new Enemy(Env.ENEMY_WIDTH+20, Env.ENEMY_HEIGHT + 20);
        player = new Player();
        playerController =  new PlayerController();
        shot = new Shot();
    }
    
    private void doGameCycle() {
        update();
        repaint();
    }
    
    private void drawEnemy(Graphics g){
        if(enemy.isVisible()){
            g.drawImage(enemy.getImage(), enemy.getX(), enemy.getY(), this);
        }
        if(enemy.isDying()){
           enemy.die();
        }
    }
    
    private void drawPlayer(Graphics g){
        if (player.isVisible()){
            g.drawImage(player.getImage(), player.getX(), player.getY(), this);
        }
        if(player.isDying()){
            player.die();
            inGame = false;
        }
    }
    
    private void drawShot(Graphics g) {
        if(shot.isVisible()){
            g.drawImage(shot.getImage(), shot.getX(), shot.getY(), this);
        }
    }
    
    private void drawMissile(Graphics g){
        for(int i=0; i<5;i++){
            g.drawImage(enemy.getMissile().getImage(),
                    enemy.getMissile().getX()+3*i, 
                    enemy.getMissile().getY(), this);
        }
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponents(g);
        doDrawing(g);
    }
    
    private void doDrawing(Graphics g){
       g.setColor(Color.black);
        g.fillRect(0, 0, d.width, d.height);
        g.setColor(Color.green);
        String str = "Sisa : " + (enemy.health - this.givenDmg);
        g.drawString(str, 10 ,20 );
        
        if(achievement[0]!= "belum ada data"){
            str = "Waktu tercepat: " + achievement[0] + " detik";
        }
        else 
            str = "Waktu tercepat: " + achievement[0];
        g.drawString(str, 10 ,35 );
        str = "Didapat pada tanggal: "  + achievement[1];
        g.drawString(str, 10 ,50 );
        if (inGame) {
            g.drawLine(0, Env.GROUND,
                    Env.BOARD_WIDTH, Env.GROUND);

            drawEnemy(g);
            drawPlayer(g);
            drawShot(g);
            drawMissile(g);

        } else {
            if (timer.isRunning()) {
                timer.stop();
            }
            gameOver(g);
        }
        Toolkit.getDefaultToolkit().sync();
    }
    
    private void gameOver(Graphics g){
        g.setColor(Color.black);
        g.fillRect(0, 0, Env.BOARD_WIDTH, Env.BOARD_HEIGHT);

        g.setColor(new Color(0, 32, 48));
        g.fillRect(50, Env.BOARD_WIDTH / 2 - 30, Env.BOARD_WIDTH - 100, 50);
        g.setColor(Color.white);
        g.drawRect(50, Env.BOARD_WIDTH / 2 - 30, Env.BOARD_WIDTH - 100, 50);

        var small = new Font("Helvetica", Font.BOLD, 14);
        var fontMetrics = this.getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(message, (Env.BOARD_WIDTH - fontMetrics.stringWidth(message)) / 2,
                Env.BOARD_WIDTH / 2);
    }
    
    private void update(){
        if(givenDmg >= enemy.health){
            inGame=false;
            timer.stop();
            message = "GAME WON!";
            Date date = new Date();
            end = formatter.format(date);
            Achievement acv = new Achievement();
            try {
                long differece = formatter.parse(end).getTime()
                    -formatter.parse(start).getTime();
            
                differece = TimeUnit.MILLISECONDS.toSeconds(differece);
                acv.createAchievement(differece, end);
            } catch (Exception e) {
            }
            
        }
        
        //player
        player.move();
        
        //shot
        if(shot.isVisible()){
            int shotX = shot.getX();
            int shotY = shot.getY();
            int enemyX = enemy.getX();
            int enemyY = enemy.getY();
            if(shotX >= (enemyX)
               && shotX <= (enemyX + Env.ENEMY_WIDTH)
               && shotY >= (enemyY)
               && shotY <= (enemyY + Env.ENEMY_HEIGHT)){
                
               this.givenDmg += player.dmg;
               if(givenDmg>=enemy.health){
                   var ii = new ImageIcon(explodedImg);
                   enemy.setImage(ii.getImage());
                   enemy.setDying(true);
               }
               shot.die();  
            }
        }
        
        int y = shot.getY();
        y -= 4;
        
        if(y < 0){
            shot.die();
        } else {
            shot.setY(y);
        }
        
        // enemy
        int x = enemy.getX();
        if(x>=Env.BOARD_WIDTH-Env.BORDER_RIGTH && direction != -1) {
            direction = -1;
            enemy.setY(enemy.getY()+Env.DOWN);
        }
        if(x <= Env.BORDER_LEFT && direction != 1) {
            direction = 1;
            enemy.setY(enemy.getY() + Env.DOWN);
        }
        
        if(enemy.isVisible()){
            int ey = enemy.getY();
            if(ey>Env.GROUND - Env.ENEMY_HEIGHT){
                inGame = false;
                message = "YOU DIE MANNN!!!!";
            }
            enemy.move(direction);
        }
        
        // missile
        Enemy.Missile missile = enemy.getMissile();
        if(missile.isDestroyed()){
            missile.setDestroyed(false);
            missile.setX(enemy.getX()+Env.ENEMY_WIDTH/2+3);
            missile.setY(enemy.getY()+Env.ENEMY_HEIGHT);
        }
        int missileX = missile.getX();
        int missileY = missile.getY();
        int playerX = player.getX();
        int playerY = player.getY();
        if(player.isVisible() && !missile.isDestroyed()){
            if(missileX >= playerX
               && missileX <= (playerX + Env.PLAYER_WIDTH)
               && missileY >= playerY
               && missileY <= (playerY + Env.PLAYER_HEIGHT)){
               var ii = new ImageIcon(explodedImg);
               player.setImage(ii.getImage());
               player.setDying(true);
               missile.setDestroyed(true);
            }
        }
        
        
        if(!missile.isDestroyed()){
            missile.setY(missile.getY()+6);
            if(missile.getY()>= Env.GROUND - Env.MISSILE_HEIGHT){
                missile.setDestroyed(true);
            }
        }
    }
    
    private class GameCycle implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            doGameCycle();
        }
    }

   private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {

            playerController.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {

            playerController.keyPressed(e);

            int x = player.getX();
            int y = player.getY();

            int key = e.getKeyCode();

            if (key == KeyEvent.VK_SPACE) {
                if (inGame) {
                    if (!shot.isVisible()) {
                        shot = new Shot(x, y);
                    }
                }
            }
        }
    }
}
