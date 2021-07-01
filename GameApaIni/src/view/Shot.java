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
public class Shot extends View{
    public Shot() {
    }
    public Shot(int x, int y){
        var shotImg = "src/images/shot.png";
        var ii = new ImageIcon(shotImg);
        setImage(ii.getImage());
        
        int H_space = 5;
        setX(x+H_space);
        int V_space = 1;
        setY(y-V_space);
    }
}
