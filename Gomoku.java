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


	private static final int B = 0;
	private static final int W = 1;
	private static final int N = -1;

	public static Location [] board    = new Location[361];
	public static Location [] setboard = new Location[361];

	public static String message = "" ;
	public static boolean win = false;
	public static int StoneX = 370;
	public static int StoneY = 370;
	public static int k = 1;
	public static int turnW = 0;//White turn
	public static int turnB = 0;//Black turn

	public static void main(String[] args){

		JFrame frame = new JFrame("Gomoku") ;
		Board GB = new Board();
		frame.getContentPane().add(GB) ;
		
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE) ;
		frame.setSize(1100, 1100) ;
		frame.setVisible(true) ;
		
		int num=0;
		int numx=0;
		int numy=0;
		int i,j;
		win = Board.win;

		for(i=0; i<19; i++){
			for(j=0; j<19; j++){

				num = (i*19) + j;
				numx = 10 +(40*j);
				numy = 10 +(40*i);
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

		setboard[0].SetLocation(370, 370) ;
		board[180].Setis(true) ;
		board[180].BW = B ; 
		turnW = 2;  // white has two turn in first

		do{

			Scanner s = new Scanner(System.in);
			win = Board.win;

			if(win == false)  keycode = s.next().charAt(0);

			switch(keycode){

				case 'w':
				if(StoneY > 10){
					StoneY = StoneY - 40;
				}
				User.SetLocation(StoneX, StoneY);
				break;

				case 's':

				if(StoneY < 730){
					StoneY = StoneY + 40;
				}
				User.SetLocation(StoneX, StoneY);
				break;

				case 'a':

				if(StoneX > 10){
					StoneX = StoneX - 40;
				}
				User.SetLocation(StoneX, StoneY);
				break;

				case 'd':

				if(StoneX < 730){
					StoneX = StoneX + 40;
				}
				User.SetLocation(StoneX, StoneY);
				break;

				case 'x': 

				setboard[k].SetLocation(User.GetX(),User.GetY());
				for(i=1;i<361;i++){
					if((setboard[k].GetX()==board[i].GetX())&&(setboard[k].GetY()==board[i].GetY()))
					{

						if(board[i].Getis() == false)
						{

							board[i].Setis(true);
							if(turnW > 0)
							{
								board[i].BW = W;
								turnW-- ;
								if(turnW == 0) turnB = 2;
							}
							else if(turnB > 0) 
							{
								board[i].BW = B;
								turnB-- ;
								if(turnB == 0) turnW = 2;
							}
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


