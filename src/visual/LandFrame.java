/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package visual;

import domain.Square;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import utility.Variables;

/**
 *
 * @author Fabian
 */
public class LandFrame extends JFrame{
    
    //variables
    public ArrayList<Square> mySquares;
     private Container container=getContentPane();
     BufferedImage img;

    //constructor
    public LandFrame(ArrayList<Square> mySquares) {
        super("Shape");
        
        try {
           img = ImageIO.read(getClass().getResourceAsStream("/assets/naveq.png"));
            this.mySquares = mySquares;
//        this.setSize(500, 500);
this.setVisible(true);
init();
        } catch (IOException ex) {
            Logger.getLogger(LandFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      private void init (){
        this.mySquares = mySquares;
        this.setSize(Variables.WIDTH,Variables.HEIGHT);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null); 
        
          JLabel jLabel =new JLabel();
          jLabel.setSize(Variables.HEIGHT,Variables.WIDTH);
          jLabel.setIcon(new ImageIcon(getClass().getResource("/assets/cortada.jpg"))); 
        
        container.setLayout(null);
        container.add(jLabel);
//        this.getContentPane().setBackground(setIconImage("/assets/galaxia.jp"));
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        for (Square mySquare : mySquares) {
        Toolkit t = Toolkit.getDefaultToolkit ();
        Image imagen = t.getImage ("naveq.jpg");
         g.drawImage (img, mySquare.getPointPosition().getX(), mySquare.getPointPosition().getY() , this);
        //iterate over all squares
//        
//            g.fillRect(mySquare.getPointPosition().getX(), mySquare.getPointPosition().getY(), mySquare.getSide(), mySquare.getSide());
        } //end for
    }

    public void paintAgain(){
        repaint();
    }

    

}
