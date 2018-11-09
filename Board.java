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
		g.drawString("W: "+Gomoku.turnW+"/nB: "+Gomoku.turnB, 800, 115);
		for(int i=25; i<750; i=i+40){
			
		g.drawLine(25, i, 745, i);
		g.drawLine(i, 25, i, 745);
		
		}

		for(int i = 0 ; i < 19; i++)
		{
			String s = new String(Integer.toString(i+1));
			g.drawString(s, 760, 25 + (i*40));
			g.drawString(s, 25 + (i*40), 760);
		}


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

			if(winner == B)		    	g.drawString("Black win", 800, 130);
			else if(winner == W)		g.drawString("White win", 800, 130);
			
		}
	
		g.setColor(new Color(255,0,0));
		g.fillRect(Gomoku.User.GetX()+2, Gomoku.User.GetY()+2,26,26);

		if(Gomoku.turnW>0) {
			g.setColor(new Color(0,255,255));
			g.fillRect((Gomoku.total_Score.get_first_where()%19+1)*40-25, (Gomoku.total_Score.get_first_where()/19+1)*40-25, 20, 20);
		}
		else if(Gomoku.turnB>0) {
			g.setColor(new Color(075,0,130));
			g.fillRect((Gomoku.total_Score.get_first_where()%19+1)*40-25, (Gomoku.total_Score.get_first_where()/19+1)*40-25, 20, 20);
		}
		if(Gomoku.k==361)  g.drawString("Draw", 800, 100);
	}

}