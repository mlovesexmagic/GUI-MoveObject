/*  Zhipeng (Adrian) Mei
    Oct 20, 2016
    Purpose: Using GUI to create moving object that increases speed when it is increased by 5
    Inputs: Mouse usage
    Output: When click the "Current Score" increases*/

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import java.util.Random; 

//image mover class uses JPanel as container and Mouse listener for action event
public class ImageMover extends JPanel implements MouseListener {

    //initialize speed, framesize, and click count
    int speed, frameRate, click;
    int x = 0;          // x coordinate
    int y = 0;          // y coordinate
    Random num;         // initialize randome number
    private Image img;  //  initialize an image

    // ImageMover constructor
    public ImageMover(int frameRate) {
        speed = 900;                //set speed
        num = new Random();         //assign the random number 
        this.frameRate = frameRate; //assign the framesize
        addMouseListener(this);     //add a mouse event listener 
    }

    public void moveIt() {
        //move the the object with random x,y coordinates
        x = num.nextInt(frameRate - 50) + 1;
        y = num.nextInt(frameRate - 150) +30;
    }

    public int getSpeed() {
        return speed;       //return the image moving speed
    }

    public int getFrame() {
        return frameRate;   //return the framesize 
    }

    public void setImage(Image x) {
        this.img = x;       //set the image
    }

    public Image getImage() {
        return img;         //return the image chosen by user
    }

    //paintComponent method Graphics parameter
    public void paintComponent(Graphics g) {  
        super.paintComponent(g);        //call the super class
        g.drawImage(img, x, y, this);   //draw the image to the container

        //dispay a string of current score with numbers of click count
        g.setFont(new Font("Arial", Font.PLAIN,25));
        g.drawString("Current Score: " + Integer.toString(click), 230,25);
    }

    //mouse is being pressed, release is ignore
    @Override
    public void mousePressed(MouseEvent e) {
        //obtaining the mouse pressed location within the frame screen
        Point mouseClick = e.getLocationOnScreen();

        int moX = (int) mouseClick.getX();  //getting the mouse pressed x-coordinate
        int moY = (int) mouseClick.getY();  //getting the mouse pressed y-coordinate

//        if(moX >= (x - 150) && moX <=(x + 150) && moY >= y && moY <=(y + 100)) {
        if(moX >= (x - 150) && moX <=(x + 200) && moY >= y && moY <=(y + 120)) {
            //after increase of any 5 increase speed such as 5-10-15-20...
            ++click;
            if(click % 5 == 0 && speed > 150)
                    speed = speed - 150;
            repaint();
        }
    }
    
    //have to have these to empty method because of mouselistener is used
    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}

}

