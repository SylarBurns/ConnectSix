import java.util.* ;
import javax.swing.* ;
import javax.swing.event.*;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.*;
import java.awt.event.*;
import java.awt.Frame;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.List;
import java.util.Scanner;

public class Gomoku{


	private static final int B = -1;
	private static final int W = 1;
	private static final int N = 0;

	public static Location [] board = new Location[81];
	public static Location [] setboard = new Location[81];

	public static String message = "" ;
	public static boolean win = false;
	public static int StoneX = 210;
	public static int StoneY = 210;
	public static int k = 0;

	public static void main(String[] args){

		JFrame frame = new JFrame("Gomoku") ;
		GomokuBoard GB = new GomokuBoard();
		frame.getContentPane().add(GB) ;
		
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE) ;
		frame.setSize(500, 700) ;
		frame.setVisible(true) ;
		
		int num=0;
		int numx=0;
		int numy=0;
		int i,j;
		win = GomokuBoard.win;
		
		// Implement Here

		for(i=0; i<9; i++){
			for(j=0; j<9; j++){

				num = (i*9) + j;
				numx = 10 +(50*j);
				numy = 10 +(50*i);
				board[num] = new Location();
				board[num].SetLocation(numx, numy);
				board[num].Setis(false);
				setboard[num] = new Location();
				setboard[num].Setis(false);

			}
		}

		Boolean StoneState = false;

		Location User = new Location();
		User.SetLocation(StoneX, StoneY);
		int keycode = 0;
		ck c1 = new ck();
		do{

			Scanner s = new Scanner(System.in);
			win = GomokuBoard.win;
			if(win == false){
			keycode = s.next().charAt(0);
			}
		switch(keycode){

			case 'w':
			if(StoneY > 10){
				StoneY = StoneY - 50;
			}
			User.SetLocation(StoneX, StoneY);
			break;

			case 's':

			if(StoneY < 410){
				StoneY = StoneY + 50;
			}
			User.SetLocation(StoneX, StoneY);
			break;

			case 'a':

			if(StoneX > 10){
				StoneX = StoneX - 50;
			}
			User.SetLocation(StoneX, StoneY);
			break;

			case 'd':

			if(StoneX < 410){
				StoneX = StoneX + 50;
			}
			User.SetLocation(StoneX, StoneY);
			break;

			case 'x': 

			setboard[k].SetLocation(User.GetX(),User.GetY());
			for(i=0;i<81;i++){
				if((setboard[k].GetX()==board[i].GetX())&&(setboard[k].GetY()==board[i].GetY())){
					if(board[i].Getis() == false){
						board[i].Setis(true);
						board[i].BW = k%2;
						k++;

					}
				}
				
			}
			

			break;

		}
		
		frame.repaint();
		
	}while(keycode != 'q');
	
		 
		 
	}
}


