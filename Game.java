import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.text.*;


public class Game implements ActionListener{
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
		}


		panel[4].setLayout(new GridLayout(3,3));

		
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

		panel[1].add(label, BorderLayout.CENTER);
		for(int i=0; i<9; i++)
			frame.add(BorderLayout.CENTER, panel[i]);
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
			winner = "Player number one";
		else
			winner = "Player number two";


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
			label.setText(winner + " winner!");
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
		label.setText("No one!");
		this.endOfGame();

	}	
	
	public void actionPerformed(ActionEvent event){
		Object obj = event.getSource();
		JButton button;
		ImageIcon imgX = new ImageIcon("d://x.png");
		ImageIcon imgO = new ImageIcon("d://o.png");
		if(obj instanceof JButton){
			button = (JButton)obj;
			switch(state){
				case PLAYER_ONE:
					button.setIcon(imgX);
					button.setDisabledIcon(imgX);
					button.setEnabled(false);
					break;
				case PLAYER_TWO:
					button.setIcon(imgO);
					button.setDisabledIcon(imgO);
					button.setEnabled(false);
					break;
				default:
					System.out.println("Error! 404.");
					break;
			}
		}else{System.out.println("Wrong!.");}

		this.logicGame();
	}


	public void endOfGame(){
		JButton restartButton = new JButton("Restart");



		restartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event){
				for(int i=0; i<3; i++)
					for(int j=0; j<3; j++){
						map[i][j] = Map.NOTHING;
						buttons[i][j].setIcon(null);
						buttons[i][j].setDisabledIcon(null);
						buttons[i][j].setEnabled(true);
					}


				state = State.PLAYER_ONE;
				label.setText("");
				
			}

		});
	}
}	
