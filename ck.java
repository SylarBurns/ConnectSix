class ck {

	private static final int B = 0;
	private static final int W = 1;
	private static final int N = -1;


	boolean row;
	boolean col;
	boolean Sla;
	boolean BSla;
	boolean checker;

	public ck(){

		row = false;
		col = false;
		Sla = false;
		BSla = false;
		checker = false;
	}
		
	public int checkrow(){
	
		for(int n=0;n<19;n++)
		for(int i=0;i<14;i++)
		if(Gomoku.board[(n*19)+i].BW!=N)
		{
			
			if((Gomoku.board[((n*19)+i)+0].BW==Gomoku.board[((n*19)+i)+1].BW)&&
			(Gomoku.board[((n*19)+i)+1].BW==Gomoku.board[((n*19)+i)+2].BW)&&
			(Gomoku.board[((n*19)+i)+2].BW==Gomoku.board[((n*19)+i)+3].BW)&&
			(Gomoku.board[((n*19)+i)+3].BW==Gomoku.board[((n*19)+i)+4].BW)&&
			(Gomoku.board[((n*19)+i)+4].BW==Gomoku.board[((n*19)+i)+5].BW))
			{
				row = true;
				return Gomoku.board[(n*19)+i].BW ;
			}
		}
			return N ;
	}

	public int checkcol(){
	
		for(int n=0;n<19;n++)
		for(int i=0;i<=247;i+=19) 
		if(Gomoku.board[n+i].BW!=N)
		if((Gomoku.board[n+i].BW==Gomoku.board[n+i+19].BW)&&
		(Gomoku.board[n+i+19].BW==Gomoku.board[n+i+38].BW)&&
		(Gomoku.board[n+i+38].BW==Gomoku.board[n+i+57].BW)&&
		(Gomoku.board[n+i+57].BW==Gomoku.board[n+i+76].BW)&&
		(Gomoku.board[n+i+76].BW==Gomoku.board[n+i+95].BW))
		{
			col = true;
			return Gomoku.board[n+i].BW ;
		}
		return N ;
	}
	
	public int checkSla(){
		for(int j=0;j<=247;j+= 19)
		for(int n=5+j;n<19+j;n++)
		if(Gomoku.board[n].BW!=N)
		if((Gomoku.board[n].BW==Gomoku.board[n+18].BW)&&
		(Gomoku.board[n+18].BW==Gomoku.board[n+36].BW)&&
		(Gomoku.board[n+36].BW==Gomoku.board[n+54].BW)&&
		(Gomoku.board[n+54].BW==Gomoku.board[n+72].BW)&&
		(Gomoku.board[n+72].BW==Gomoku.board[n+90].BW))
		{
			BSla = true;
			return Gomoku.board[n].BW ;
		}
		return N ;
	}
	
	public int checkBackSla(){
		for(int i=0;i<=247;i+=19) 
		for(int n=i;n<(i+14);n++)
		if(Gomoku.board[n].BW!=N)
		if((Gomoku.board[n].BW==Gomoku.board[n+20].BW)&&
		(Gomoku.board[n+20].BW==Gomoku.board[n+40].BW)&&
		(Gomoku.board[n+40].BW==Gomoku.board[n+60].BW)&&
		(Gomoku.board[n+60].BW==Gomoku.board[n+80].BW)&&
		(Gomoku.board[n+80].BW==Gomoku.board[n+100].BW))
		{
			Sla = true;
			return Gomoku.board[n].BW ;
		}
		return N ;
	}

	public void check(){

		if(row==true)
		checker = true;
		if(col==true)
		checker = true;
		if(Sla==true)
		checker = true;
		if(BSla==true)
		checker = true;
	}
}