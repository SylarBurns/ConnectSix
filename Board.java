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

class Board extends JPanel {
	
	private static final int B = 0;
	private static final int W = 1;
	private static final int N = -1;
	private static Location [] board = new Location[361];
	public static boolean win;

	public void paint(Graphics g) {


		int StoneX =Gomoku.StoneX; 
		int StoneY =Gomoku.StoneY; 

		int k;
		

		k = Gomoku.k;

		ck c1 = new ck();

		for(int i=0;i<361;i++){

			board[i] = new Location()  ;
			board[i] = Gomoku.board[i] ;
		}
		
		g.drawString("Up : w", 760, 25) ;
		g.drawString("Down : s", 760, 40) ;
		g.drawString("Left : a", 760, 55) ;
		g.drawString("Right : d\n", 760, 70) ;
		g.drawString("Stone Down : space\n", 760, 85) ;

			for(int i=25; i<750; i=i+40){
				
			g.drawLine(25, i, 745, i);
			g.drawLine(i, 25, i, 745);

			}


			for(int i=0; i<361; i++){

				if(board[i].Getis()==true)
				{

					if(board[i].BW == B)		g.setColor(new Color(0,0,0));
					else						g.setColor(new Color(255,255,255));
					
					g.fillOval(board[i].GetX()-5,board[i].GetY()-5,40,40);
					
				}
			}
		c1.checkrow();
		c1.checkcol();
		c1.checkSla();
		c1.checkBackSla();
		c1.check();

		// if(c1.checker == true)	win = true;
		

		if(win == true)
		{
			g.setColor(new Color(0,0,0));

			if(k%2==1)	g.drawString("Black win",760, 100);
			else		g.drawString("White win", 760, 100);
			
		}
	
		g.setColor(new Color(255,0,0));
		g.fillRect(StoneX+2,StoneY+2,26,26);
			
		if(k==81)		g.drawString("Draw", 760, 100);
			

	}

}