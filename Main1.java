import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class Main1{
	public static void main(String[] args){
		Game1 game = new Game1();
		game.init();
	}

	 Image min;
	    
	    public Main1(){
	        min = new ImageIcon("025.jpg").getImage();
	    }
	    
	    public void paintComponent(Graphics g){
	         Graphics2D g2d=(Graphics2D)g;
	         g2d.drawImage(min,0,0,null);
	         ImagePanel pp = new ImagePanel();
	         pp.setLayout(new BorderLayout());
	         try {
	             pp.setImage(ImageIO.read(new File("f://025.jpg")));
	         } catch (IOException e) {
	             e.printStackTrace();
	         }
	         JFrame f = new JFrame();
	         f.setTitle("My Panel");
	         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	         JPanel panel = new JPanel();
	         panel.setLayout(new java.awt.GridLayout());
	         panel.setOpaque(false);
	         JLabel label = new JLabel();
	         label.setFont(new java.awt.Font("Tahoma", 0, 24));
	         label.setForeground(new java.awt.Color(255, 0, 0));
	         label.setText("\u042d\u0442\u043e JLabel");
	         panel.add(label);
	         
	         pp.setPreferredSize(new Dimension(10000, 10000));
	         f.add(new JScrollPane(pp));
	         f.pack();
	         f.setSize(800, 600);
	         f.setLocationRelativeTo(null);
	         f.setVisible(true);
	    }
	         }
