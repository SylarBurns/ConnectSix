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
	
<<<<<<< HEAD
	public void checkrow()
	{
		for(int n=0;n<19;n++)
		for(int i=0; i<15;i++) 
		if(Gomoku.board[(n*19)+i].BW!=N)
		if((Gomoku.board[((n*19)+i)+0].BW==Gomoku.board[((n*19)+i)+1].BW)&&
	       (Gomoku.board[((n*19)+i)+1].BW==Gomoku.board[((n*19)+i)+2].BW)&&
		   (Gomoku.board[((n*19)+i)+2].BW==Gomoku.board[((n*19)+i)+3].BW)&&
		   (Gomoku.board[((n*19)+i)+3].BW==Gomoku.board[((n*19)+i)+4].BW)&&
		   (Gomoku.board[((n*19)+i)+4].BW==Gomoku.board[((n*19)+i)+5].BW)) 
			row = true;

	}

=======
public void checkrow(){
	
	for(int n=0;n<19;n++){
		for(int i=0; i<15;i++) {
			if(Gomoku.board[(n*19)+i].BW!=N){
				if((Gomoku.board[(n*19)+0].BW==Gomoku.board[(n*19)+1].BW)&&(Gomoku.board[(n*19)+1].BW==Gomoku.board[(n*19)+2].BW)&&(Gomoku.board[(n*19)+2].BW==Gomoku.board[(n*19)+3].BW)&&(Gomoku.board[(n*19)+3].BW==Gomoku.board[(n*19)+4].BW&&(Gomoku.board[(n*19)+4].BW==Gomoku.board[(n*19)+5].BW)))
				row = true;
			}
		}
	}
}
>>>>>>> be0135e838e1edb1d57912a0357d8164e2b8fe3a
public void checkcol(){

	for(int n=0;n<19;n++){
		for(int i=0; i<=266;i+=i*9) {
		if(Gomoku.board[n+i].BW!=N){
		if((Gomoku.board[n+i].BW==Gomoku.board[n+i+9].BW)&&(Gomoku.board[n+i+9].BW==Gomoku.board[n+i+18].BW)&&(Gomoku.board[n+i+18].BW==Gomoku.board[n+i+27].BW)&&(Gomoku.board[n+i+27].BW==Gomoku.board[n+i+36].BW)&&(Gomoku.board[n+i+36].BW==Gomoku.board[n+i+45].BW))
		col = true;
		}
		}
	}
}

<<<<<<< HEAD
	public void checkSla()
	{
		for(int i=0;i<=266;i+=19)   
		for(int n=i;n<(i+15);n++) 
		if(Gomoku.board[n].BW!=N) 
		if((Gomoku.board[n].BW==Gomoku.board[n+10].BW)&&
		   (Gomoku.board[n+10].BW==Gomoku.board[n+20].BW)&&
		   (Gomoku.board[n+20].BW==Gomoku.board[n+30].BW)&&
		   (Gomoku.board[n+30].BW==Gomoku.board[n+40].BW)&&
		   (Gomoku.board[n+40].BW==Gomoku.board[n+50].BW))
		    Sla = true;

=======
public void checkSla(){
	for(int i=0;i<=266;i+=9) {	
	for(int n=i;n<(i+15);n++) {
		if(Gomoku.board[n].BW!=N) {
			if((Gomoku.board[n].BW==Gomoku.board[n+10].BW)&&(Gomoku.board[n+10].BW==Gomoku.board[n+20].BW)&&(Gomoku.board[n+20].BW==Gomoku.board[n+30].BW)&&(Gomoku.board[n+30].BW==Gomoku.board[n+40].BW)&&(Gomoku.board[n+40].BW==Gomoku.board[n+50].BW))
			Sla = true;
		}
	}
>>>>>>> be0135e838e1edb1d57912a0357d8164e2b8fe3a
	}

public void checkBackSla(){
	for(int n=4;n<9;n++){
		if(Gomoku.board[n].BW!=N){
			if((Gomoku.board[n].BW==Gomoku.board[n+8].BW)&&(Gomoku.board[n+8].BW==Gomoku.board[n+16].BW)&&(Gomoku.board[n+16].BW==Gomoku.board[n+24].BW)&&(Gomoku.board[n+24].BW==Gomoku.board[n+32].BW))
			BSla = true;
		}
	}
	for(int n=13;n<18;n++){
		if(Gomoku.board[n].BW!=N){
			if((Gomoku.board[n].BW==Gomoku.board[n+8].BW)&&(Gomoku.board[n+8].BW==Gomoku.board[n+16].BW)&&(Gomoku.board[n+16].BW==Gomoku.board[n+24].BW)&&(Gomoku.board[n+24].BW==Gomoku.board[n+32].BW))
			BSla = true;
		}
	}
	for(int n=22;n<27;n++){
		if(Gomoku.board[n].BW!=N){
			if((Gomoku.board[n].BW==Gomoku.board[n+8].BW)&&(Gomoku.board[n+8].BW==Gomoku.board[n+16].BW)&&(Gomoku.board[n+16].BW==Gomoku.board[n+24].BW)&&(Gomoku.board[n+24].BW==Gomoku.board[n+32].BW))
			BSla = true;
		}
	}
	for(int n=31;n<36;n++){
		if(Gomoku.board[n].BW!=N){
			if((Gomoku.board[n].BW==Gomoku.board[n+8].BW)&&(Gomoku.board[n+8].BW==Gomoku.board[n+16].BW)&&(Gomoku.board[n+16].BW==Gomoku.board[n+24].BW)&&(Gomoku.board[n+24].BW==Gomoku.board[n+32].BW))
			BSla = true;
		}
	}
	for(int n=40;n<45;n++){
		if(Gomoku.board[n].BW!=N){
			if((Gomoku.board[n].BW==Gomoku.board[n+8].BW)&&(Gomoku.board[n+8].BW==Gomoku.board[n+16].BW)&&(Gomoku.board[n+16].BW==Gomoku.board[n+24].BW)&&(Gomoku.board[n+24].BW==Gomoku.board[n+32].BW))
			BSla = true;
		}
	}
}

public void check(){
	// if((row==true)||(col==true)||(Sla==true)||(BSla==true))
	// checker = true;
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
