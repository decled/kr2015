import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.event.*;
import java.awt.image.ImageObserver;

import javax.swing.text.*;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
 



import java.io.File;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
public class Game1 implements ActionListener{
	private JButton[][] buttons = new JButton[3][3];
	private JFrame frame;
	private JPanel[] panel = new JPanel[9];
	private enum State{PLAYER_ONE, PLAYER_TWO, WIN, STANDOFF}
	private State state;
	private enum Map{ONE,TWO,NOTHING}
	private Map[][] map = new Map[3][3];
	private JLabel label;
	private String winner;


	public void init(){
		state = State.PLAYER_ONE;
		for(int i=0; i<3; i++)
			for(int j=0; j<3; j++)
				map[i][j] = Map.NOTHING;

		label = new JLabel();

		frame = new JFrame();
		
		frame.setLayout(new GridLayout(3,3));
		for(int i=0; i<9; i++){
			panel[i] = new JPanel();
			Container fc = frame.getContentPane();
			fc.setSize(200, 300);
			fc.setLocation(100, 100);
			fc.setBackground(Color.green);
			fc.setForeground(Color.pink);
			fc.setVisible(true);
			}                                         

	
			


		panel[4].setLayout(new GridLayout(3,3));

		frame.setBackground(Color.RED);
		frame.setSize(800, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		for(int i=0; i<3; i++)
			for(int j=0; j<3; j++){
			buttons[i][j] = new JButton();
			buttons[i][j].addActionListener(this);
			buttons[i][j].setPreferredSize(new Dimension(50,50));
			panel[4].add(buttons[i][j]);
		}
		frame.setBackground(Color.RED);
		panel[1].add(label, BorderLayout.CENTER);
		for(int i=0; i<9; i++)
			frame.add(BorderLayout.CENTER, panel[i]);
	frame.setBackground(Color.RED);
	frame.getContentPane().setBackground(Color.BLACK);
		}
   

 

	 
	  public void paint(Graphics g) {
		  Image a = Toolkit.getDefaultToolkit().getImage("fon.jpg");
		  g.drawImage(a, 0, 0, 800,600, frame);
		  paint(g);
	  }
	



	public void logicGame(){
		
		for(int i=0; i<3; i++)
			for(int j=0;j<3; j++){
				if((map[i][j] == Map.NOTHING) && (buttons[i][j].getDisabledIcon() != null)){
					if(state == State.PLAYER_ONE)
						map[i][j] = Map.ONE;
					else
						map[i][j] = Map.TWO;
				}
			}

		if(state == State.PLAYER_ONE)
			winner = "Èãðîê îäèí";
		else
			winner = "Èãðîê äâà";


		if(map[0][0] != Map.NOTHING && map[0][0] == map[0][1] && map[0][0] == map[0][2]){
			state = State.WIN;
		}
		if(map[1][0] != Map.NOTHING && map[1][0] == map[1][1] && map[1][0] == map[1][2]){
			state = State.WIN;
		}
		if(map[2][0] != Map.NOTHING && map[2][0] == map[2][1] && map[2][0] == map[2][2]){
			state = State.WIN;
		}
		if(map[0][0] != Map.NOTHING && map[0][0] == map[1][0] && map[0][0] == map[2][0]){
			state = State.WIN;
		}
		if(map[0][1] != Map.NOTHING && map[0][1] == map[1][1] && map[0][1] == map[2][1]){
			state = State.WIN;
		}
		if(map[0][2] != Map.NOTHING && map[0][2] == map[1][2] && map[0][2] == map[2][2]){
			state = State.WIN;
		}
		if(map[0][0] != Map.NOTHING && map[0][0] == map[1][1] && map[0][0] == map[2][2]){
			state = State.WIN;
		}
		if(map[0][2] != Map.NOTHING && map[0][2] == map[1][1] && map[0][2] == map[2][0]){
			state = State.WIN;
		}


		if(state == State.WIN){
			for(int i=0; i<3; i++)
				for(int j=0;j<3; j++){
					buttons[i][j].setEnabled(false);
				}
			label.setText(winner + " ïîáåäèòåëü!");
			this.endOfGame();
		}



		if(state == State.PLAYER_ONE)
			state = State.PLAYER_TWO;
		else
			state = State.PLAYER_ONE;

		for(int i=0; i<3; i++)
			for(int j=0;j<3; j++){
				if(map[i][j] == Map.NOTHING)
					return;
			}

		state = State.STANDOFF;
		label.setText("Íè÷üÿ!");
		this.endOfGame();

	}	

	public void actionPerformed(ActionEvent event){
		Object obj = event.getSource();
		JButton button;
		ImageIcon imgX = new ImageIcon("pics/x.png");
		ImageIcon imgO = new ImageIcon("pics/o.png");
		ImageIcon imgAll3 = new ImageIcon ("pics/xod1.jpg");
		ImageIcon imgAll6 = new ImageIcon ("pics/xod2.jpg");
		if(obj instanceof JButton){
			button = (JButton)obj;
			switch(state){
				case PLAYER_ONE:
					button.setIcon(imgX);
					button.setDisabledIcon(imgX);
					button.setEnabled(false);
					label.setIcon(imgAll3);
					break;
				case PLAYER_TWO:
					button.setIcon(imgO);
					button.setDisabledIcon(imgO);
					button.setEnabled(false);
					label.setIcon(imgAll6);
					break;
				default:
					System.out.println("Error! Not found this state.");
					break;
			}
		}else{System.out.println("Error! It's not a button.");}

		this.logicGame();
	}


	public void endOfGame(){
		 final JButton restartButton = new JButton("Çàíîâî");


		restartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event){
				for(int i=0; i<3; i++)
					for(int j=0; j<3; j++){				
						label.setIcon(null);
						label.setText(null);
						map[i][j] = Map.NOTHING;
						buttons[i][j].setIcon(null);
						buttons[i][j].setDisabledIcon(null);
						buttons[i][j].setEnabled(true);
		
					}
				panel[7].remove(restartButton);
			}

		});


		panel[7].add(restartButton, BorderLayout.CENTER);

	}
}	
