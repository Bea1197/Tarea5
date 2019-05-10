/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package threadsandgraphics;

import com.sun.org.apache.xpath.internal.operations.Variable;
import visual.LandFrame;
import threads.RepaintLandThread;
import threads.SquareThread;
import domain.Point;
import domain.Square;
import java.util.ArrayList;
import javax.swing.JFrame;
import utility.Variables;

/**
 *
 * @author root
 */
public class ThreadsAndGraphics {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create the domain squares
        Square square1 = new Square("Thread-1", new Point(10, 95), 75);//80,80
        Square square2 = new Square("Thread-2", new Point(10, 300), 75);//10,10
        Square square3 = new Square("Thread-3", new Point(10, 400), 75);//10,151
        Square square4 = new Square("Thread-4", new Point(10, 500), 75);
        //create the array list for the frame to paint
        ArrayList<Square> squareList = new ArrayList<>();
        squareList.add(square1);
        squareList.add(square2);
        squareList.add(square3);
        squareList.add(square4);
        //create the new frame and send the square list
        LandFrame myLand = new LandFrame(squareList);
        myLand.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //thread for repainting
        RepaintLandThread repaintThread = new RepaintLandThread(myLand, 100);//bajarle aqui para que noparpadee
        repaintThread.start();
        
        //thread for controlling the movement of the squares
        SquareThread squareThread1 = new SquareThread(square1, Variables.QUICK);
        SquareThread squareThread2 = new SquareThread(square2, Variables.MEDIUM);
        SquareThread squareThread3 = new SquareThread(square3, Variables.SlOW);
         SquareThread squareThread4 = new SquareThread(square4, Variables.SlOW);
        squareThread1.start();
        squareThread2.start();
        squareThread3.start(); 
        squareThread4.start();
    }//end main
}
