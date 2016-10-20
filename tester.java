/*  Zhipeng (Adrian) Mei
    Oct 20, 2016
    Purpose: Using GUI to create moving object that increases speed when it is increased by 5
    Inputs: Mouse usage
    Output: When click the "Current Score" increases*/

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JFrame;

public class tester extends JFrame {
    
    static ImageMover mover = new ImageMover(700);

    public tester() {
        createMenuBar();
    }
    
    private void createMenuBar() {

        JMenuBar menubar = new JMenuBar();        

        JMenu file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);


        JMenuItem flag1 = new JMenuItem("China", new ImageIcon("image/flagIcon2.gif"));
        flag1.setMnemonic(KeyEvent.VK_E);
        flag1.setToolTipText("Choose China Flag");
        flag1.addActionListener((ActionEvent event) -> {
            Image img = getToolkit().getImage("image/china.jpg");
            mover.setImage(img);
        });
        
        
        JMenuItem flag2 = new JMenuItem("Germany", new ImageIcon("image/germanyIcon.gif"));        flag1.setMnemonic(KeyEvent.VK_E);
        flag2.setToolTipText("Choose China Flag");
        flag2.addActionListener((ActionEvent event) -> {
            Image img = getToolkit().getImage("image/germany.gif");
            mover.setImage(img);

        });
        
        
        JMenuItem flag3 = new JMenuItem("India", new ImageIcon("image/flagIcon3.gif"));
        flag3.setToolTipText("Choose China Flag");
        flag3.addActionListener((ActionEvent event) -> {
            Image img = getToolkit().getImage("image/india.gif");
            mover.setImage(img);
        });
        
        
        JMenuItem flag4 = new JMenuItem("UK", new ImageIcon("image/flagIcon5.gif"));
        flag4.setToolTipText("Choose China Flag");
        flag4.addActionListener((ActionEvent event) -> {
            Image img = getToolkit().getImage("image/uk.gif");
            mover.setImage(img);
        });
        
        
        JMenuItem flag5 = new JMenuItem("Canada", new ImageIcon("image/caIcon.gif"));
        flag5.setToolTipText("Choose China Flag");
        flag5.addActionListener((ActionEvent event) -> {
            Image img = getToolkit().getImage("image/ca.gif");
            mover.setImage(img);
        });

        JMenuItem eMenuItem = new JMenuItem("Exist");
        eMenuItem.setMnemonic(KeyEvent.VK_E);
        eMenuItem.setToolTipText("Exit application");
        eMenuItem.addActionListener((ActionEvent event) -> {
            System.exit(0);
        });

        file.add(flag1);
        file.add(flag2);
        file.add(flag3);
        file.add(flag4);
        file.add(flag5);
        file.add(eMenuItem);

        menubar.add(file);

        setJMenuBar(menubar);
    }
    
    
    public static void main(String[] args)throws InterruptedException {
                  
        tester frame = new tester();
        frame.add(mover);
        frame.setTitle("ScoreBoard");
        frame.setSize(mover.getFrame(), mover.getFrame());
        frame.setResizable(true);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while(true) {
            mover.moveIt();
            mover.repaint();
            Thread.sleep(mover.getSpeed());
        }
    }
}
