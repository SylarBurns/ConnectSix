import java.util.* ;
import javax.swing.* ;
import java.awt.*;

class Board extends JPanel {
	
	private static final int B = 0;
	private static final int W = 1;
	private static final int N = -1;

	private static Location [] board = new Location[361];
	
	public static boolean win;

	public void paint(Graphics g) {

		int winner = N ;

		ck c1 = new ck();

		
		g.drawString("Up : w", 800, 25) ;
		g.drawString("Down : s", 800, 40) ;
		g.drawString("Left : a", 800, 55) ;
		g.drawString("Right : d\n", 800, 70) ;
		g.drawString("Stone Down : space\n", 800, 85) ;
		g.drawString((Gomoku.total_Score.get_first_where()%19+1)+", "+((Gomoku.total_Score.get_first_where())/19+1), 800, 100) ;

		for(int i=25; i<750; i=i+40){
			
		g.drawLine(25, i, 745, i);
		g.drawLine(i, 25, i, 745);
		
		}

		g.drawString("1", 760, 25);
		g.drawString("2", 760, 65);
		g.drawString("3", 760, 105);
		g.drawString("4", 760, 145);
		g.drawString("5", 760, 185);
		g.drawString("6", 760, 225);
		g.drawString("7", 760, 265);
		g.drawString("8", 760, 305);
		g.drawString("9", 760, 345);
		g.drawString("10", 760, 385);
		g.drawString("11", 760, 425);
		g.drawString("12", 760, 465);
		g.drawString("13", 760, 505);
		g.drawString("14", 760, 545);
		g.drawString("15", 760, 585);
		g.drawString("16", 760, 625);
		g.drawString("17", 760, 665);
		g.drawString("18", 760, 705);
		g.drawString("19", 760, 745);

		g.drawString("1", 25, 760);
		g.drawString("2", 65, 760);
		g.drawString("3", 105, 760);
		g.drawString("4", 145, 760);
		g.drawString("5", 185, 760);
		g.drawString("6", 225, 760);
		g.drawString("7", 265, 760);
		g.drawString("8", 305, 760);
		g.drawString("9", 345, 760);
		g.drawString("10", 385, 760);
		g.drawString("11", 425, 760);
		g.drawString("12", 465, 760);
		g.drawString("13", 505, 760);
		g.drawString("14", 545, 760);
		g.drawString("15", 585, 760);
		g.drawString("16", 625, 760);
		g.drawString("17", 665, 760);
		g.drawString("18", 705, 760);
		g.drawString("19", 745, 760);




		for(int i=0; i<361; i++)
			if(Gomoku.board[i].Getis()==true)
			{

				if(Gomoku.board[i].BW == B) g.setColor(new Color(0,0,0));
				else						g.setColor(new Color(255,255,255));
				
				g.fillOval(Gomoku.board[i].GetX()-5,Gomoku.board[i].GetY()-5,40,40);
				
			}
		

		int cr = c1.checkrow();
		int cc = c1.checkcol();
		int cs = c1.checkSla();
		int cbs = c1.checkBackSla();

		if(cr != N)  winner = cr;
		if(cc != N)  winner = cc;
		if(cs != N)  winner = cs;
		if(cbs != N) winner = cbs;

		c1.check();

		if(c1.checker == true)	win = true;
		

		if(win == true)
		{
			g.setColor(new Color(0,0,0));

			if(winner == B)		    	g.drawString("Black win", 800, 100);
			else if(winner == W)		g.drawString("White win", 800, 100);
			
		}
	
		g.setColor(new Color(255,0,0));
		g.fillRect(Gomoku.User.GetX()+2, Gomoku.User.GetY()+2,26,26);
		g.setColor(new Color(0,0,255));
		g.fillRect((Gomoku.total_Score.get_first_where()%19+1)*40-25, (Gomoku.total_Score.get_first_where()/19+1)*40-25, 20, 20);
		
		if(Gomoku.k==361)  g.drawString("Draw", 800, 100);
	}

}