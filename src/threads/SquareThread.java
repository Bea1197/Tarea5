/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package threads;

import domain.Point;
import domain.Square;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import utility.Variables;

/**
 *
 * @author Fabian
 */
public class SquareThread extends Thread{
    
    //variables
    private Square mySquare;
    private int delayTime;

    public SquareThread(Square mySquare, int delayTime) {
        super(mySquare.identification);
        this.mySquare = mySquare;
        this.delayTime = delayTime;
    }
    
    
    @Override
    public void run() {
        boolean bandera=true;
        while(bandera){
        try {
            //sleep for the animation
            sleep(delayTime);
            
            //move the object
            
            int newX = mySquare.getPointPosition().getX();
             if (newX>=520) {
                    bandera=false;
                }else{
                    newX+=10;
                }
            
            mySquare.setPointPosition(new Point(newX, mySquare.getPointPosition().getY()));
            
            
                        
        } catch (InterruptedException ex) {
            Logger.getLogger(SquareThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        }//End while
    }//end run

    
}
