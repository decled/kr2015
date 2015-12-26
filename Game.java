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
			frame.setBackground(Color.RED);
			frame.setForeground(Color.RED);
		}


		panel[4].setLayout(new GridLayout(3,3));

		frame.setBackground(Color.RED);
		frame.setSize(800, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//protected void paintComponent(Graphics g) {
		//    if (point != null) {
		    //    Graphics2D g2d = (Graphics2D) g;
		    //    g2d.setRenderingHint(
		    //        RenderingHints.KEY_ANTIALIASING,
		    //        RenderingHints.VALUE_ANTIALIAS_ON);
		   //     g2d.setComposite(AlphaComposite.getInstance(
		   //         AlphaComposite.SRC_OVER, 0.3f));
		   //     g2d.setColor(Color.yellow);
		  //      g2d.fillOval(point.x, point.y, 120, 60);
		//    }
	//	}
		frame.setBackground(Color.RED);
		for(int i=0; i<3; i++)
			for(int j=0; j<3; j++){
			buttons[i][j] = new JButton();
			buttons[i][j].addActionListener(this);
			buttons[i][j].setPreferredSize(new Dimension(50,50));
			panel[4].add(buttons[i][j]);
		}
		frame.setBackground(Color.RED);
		panel[1].add(label, BorderLayout.CENTER);
	//	frame.getContentPane().setBackground(Color.BLACK);
		for(int i=0; i<9; i++)
			frame.add(BorderLayout.CENTER, panel[i]);
		
		//frame.getContentPane().setBackground(Color.BLACK); 
	frame.setBackground(Color.RED);

		}
	
	 
	  public void paint(Graphics g) {
		  Image a = Toolkit.getDefaultToolkit().getImage("d:\\025.jpg");
		  g.drawImage(a, 0, 0, 800,600, frame);
		  paint(g);
	  }
	// Image min;
	    
	  //  public Game1(){
//	        min = new ImageIcon("025.jpg").getImage();
	//    }
	//    public void paintComponent(Graphics g) {
	//        g.drawImage(min, 0, 0, null, f);
	    //    super.paintComponent(g);
//	}
	  //  public void paintComponent(Graphics g){
	   //      Graphics2D g2d=(Graphics2D)g;
	   //      g2d.drawImage(min,0,0,null);
	 //        }
	   // public Game1() {
	   //     initComponents();
	   // }
	    
	   //  private void initComponents() {
	   // 	 javax.swing.JFrame panel = new javax.swing.JFrame();//picturePanel1 = new PicturePanel();
	   //     jPanel1 = new javax.swing.JPanel();
	   //     jLabel1 = new javax.swing.JLabel();
	  //      jButton1 = new javax.swing.JButton();
	   //     setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	    //    panel.setLayout(new java.awt.BorderLayout());
	  //      panel.setImageFile(new java.io.File("F:\\025.jpg"));
	  /*      jPanel1.setLayout(new java.awt.GridLayout());
	        jPanel1.setOpaque(false);
	        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24));
	        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
	        jLabel1.setText("\u042d\u0442\u043e JLabel");
	        jPanel1.add(jLabel1);
	        jButton1.setText("\u0410 \u044d\u0442\u043e \u043a\u043d\u043e\u043f\u043a\u0430!");
	        jPanel1.add(jButton1);
	        panel.add(jPanel1, java.awt.BorderLayout.NORTH);
	        getContentPane().add(panel, java.awt.BorderLayout.CENTER);
	        pack();
	    }
	    
	    private Container getContentPane() {
			// TODO Auto-generated method stub
			return null;
		}


		private void pack() {
			// TODO Auto-generated method stub
			
		}


		private void setDefaultCloseOperation(int exitOnClose) {
			// TODO Auto-generated method stub
			
		}


		public static void main(String args[]) {
	        java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	             //   new PanelPictureFrame().setVisible(true);
	            }
	        });
	    }
	    private javax.swing.JButton jButton1;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JPanel jPanel1;
	  //  private PicturePanel picturePanel1;
	  Frame f=new Frame();
			
	                {
	                             setPreferredSize(new Dimension(0,0));
	                 }
	               public void paintComponent(Graphics g, Image img){
	          //     min = new ImageIcon("025.jpg").getImage();{
	                try {
	                    label.setIcon((Icon) ImageIO.read(this.getClass().getResourceAsStream("f://1.jpg")));
	                    label.setIcon((Icon) ImageIO.read(this.getClass().getResourceAsStream("f://2.jpg")));
	                    label.setIcon((Icon) ImageIO.read(this.getClass().getResourceAsStream("f://3.jpg")));
	                } catch (IOException e) {
	                    e.printStackTrace();
	                    System.out.println("HeT KAPTUHKU");
	           		 f.setVisible(false);
	           		 f.pack();
	           		 f.setVisible(true);
	                }     
	                }
//	    }
     
	private void setPreferredSize(Dimension dimension) {
					// TODO Auto-generated method stub
					
				}*/
	



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
		Byte b;
		b=1;
		ImageIcon imgX = new ImageIcon("d://x.png");
		ImageIcon imgO = new ImageIcon("d://o.png");
	//	ImageIcon imgAll = new ImageIcon ("d://11.jpg");
	//	ImageIcon imgAll1 = new ImageIcon ("d://12.jpg");
	//	ImageIcon imgAll2 = new ImageIcon ("d://13.jpg");
		ImageIcon imgAll3 = new ImageIcon ("d://14.jpg");
	//	ImageIcon imgAll4 = new ImageIcon ("d://15.jpg");
	//	ImageIcon imgAll5 = new ImageIcon ("d://21.jpg");
		ImageIcon imgAll6 = new ImageIcon ("d://22.jpg");
		//ImageIcon imgAll7 = new ImageIcon ("d://23.jpg");
	//	ImageIcon imgAll8 = new ImageIcon ("d://24.jpg");
		if(obj instanceof JButton){
			button = (JButton)obj;
			switch(state){
				case PLAYER_ONE:
					//label.setIcon(imgAll);
					button.setIcon(imgX);
					button.setDisabledIcon(imgX);
					button.setEnabled(false);
					frame.setBackground(Color.BLACK);
				//	label.setIcon(imgAll1);
				//	label.setIcon(imgAll2);
					label.setIcon(imgAll3);
				//	label.setIcon(imgAll4);
					break;
				case PLAYER_TWO:
				//	label.setIcon(imgAll5);
					button.setIcon(imgO);
					button.setDisabledIcon(imgO);
					button.setEnabled(false);
					frame.setBackground(Color.WHITE);
					label.setIcon(imgAll6);
				//	label.setIcon(imgAll7);
				//	label.setIcon(imgAll8);
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

			frame.setBackground(Color.RED);

		restartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event){
				for(int i=0; i<3; i++)
					for(int j=0; j<3; j++){
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
