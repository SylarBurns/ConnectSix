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
	
public void checkrow(){
	
	for(int n=0;n<9;n++){
		if(Gomoku.board[(n*9)+0].BW!=N){
			if((Gomoku.board[(n*9)+0].BW==Gomoku.board[(n*9)+1].BW)&&(Gomoku.board[(n*9)+1].BW==Gomoku.board[(n*9)+2].BW)&&(Gomoku.board[(n*9)+2].BW==Gomoku.board[(n*9)+3].BW)&&(Gomoku.board[(n*9)+3].BW==Gomoku.board[(n*9)+4].BW))
			row = true;
		}
		if(Gomoku.board[(n*9)+1].BW!=N){
			if((Gomoku.board[(n*9)+1].BW==Gomoku.board[(n*9)+2].BW)&&(Gomoku.board[(n*9)+2].BW==Gomoku.board[(n*9)+3].BW)&&(Gomoku.board[(n*9)+3].BW==Gomoku.board[(n*9)+4].BW)&&(Gomoku.board[(n*9)+4].BW==Gomoku.board[(n*9)+5].BW))
			row = true;
		}
		if(Gomoku.board[(n*9)+2].BW!=N){
			if((Gomoku.board[(n*9)+2].BW==Gomoku.board[(n*9)+3].BW)&&(Gomoku.board[(n*9)+3].BW==Gomoku.board[(n*9)+4].BW)&&(Gomoku.board[(n*9)+4].BW==Gomoku.board[(n*9)+5].BW)&&(Gomoku.board[(n*9)+5].BW==Gomoku.board[(n*9)+6].BW))
			row = true;
		}
		if(Gomoku.board[(n*9)+3].BW!=N){
			if((Gomoku.board[(n*9)+3].BW==Gomoku.board[(n*9)+4].BW)&&(Gomoku.board[(n*9)+4].BW==Gomoku.board[(n*9)+5].BW)&&(Gomoku.board[(n*9)+5].BW==Gomoku.board[(n*9)+6].BW)&&(Gomoku.board[(n*9)+6].BW==Gomoku.board[(n*9)+7].BW))
			row = true;
		}
		if(Gomoku.board[(n*9)+4].BW!=N){
			if((Gomoku.board[(n*9)+4].BW==Gomoku.board[(n*9)+5].BW)&&(Gomoku.board[(n*9)+5].BW==Gomoku.board[(n*9)+6].BW)&&(Gomoku.board[(n*9)+6].BW==Gomoku.board[(n*9)+7].BW)&&(Gomoku.board[(n*9)+7].BW==Gomoku.board[(n*9)+8].BW))
			row = true;
		}
	}

}

public void checkcol(){

	for(int n=0;n<9;n++){
		if(Gomoku.board[n].BW!=N){
		if((Gomoku.board[n].BW==Gomoku.board[n+9].BW)&&(Gomoku.board[n+9].BW==Gomoku.board[n+18].BW)&&(Gomoku.board[n+18].BW==Gomoku.board[n+27].BW)&&(Gomoku.board[n+27].BW==Gomoku.board[n+36].BW))
		col = true;
		}
		if(Gomoku.board[n+9].BW!=N){
		if((Gomoku.board[n+9].BW==Gomoku.board[n+18].BW)&&(Gomoku.board[n+18].BW==Gomoku.board[n+27].BW)&&(Gomoku.board[n+27].BW==Gomoku.board[n+36].BW)&&(Gomoku.board[n+36].BW==Gomoku.board[n+45].BW))
		col = true;
		}
		if(Gomoku.board[n+18].BW!=N){
		if((Gomoku.board[n+18].BW==Gomoku.board[n+27].BW)&&(Gomoku.board[n+27].BW==Gomoku.board[n+36].BW)&&(Gomoku.board[n+36].BW==Gomoku.board[n+45].BW)&&(Gomoku.board[n+45].BW==Gomoku.board[n+54].BW))
		col = true;
		}
		if(Gomoku.board[n+27].BW!=N){
		if((Gomoku.board[n+27].BW==Gomoku.board[n+36].BW)&&(Gomoku.board[n+36].BW==Gomoku.board[n+45].BW)&&(Gomoku.board[n+45].BW==Gomoku.board[n+54].BW)&&(Gomoku.board[n+54].BW==Gomoku.board[n+63].BW))
		col = true;
		}
		if(Gomoku.board[n+36].BW!=N){
		if((Gomoku.board[n+36].BW==Gomoku.board[n+45].BW)&&(Gomoku.board[n+45].BW==Gomoku.board[n+54].BW)&&(Gomoku.board[n+54].BW==Gomoku.board[n+63].BW)&&(Gomoku.board[n+63].BW==Gomoku.board[n+72].BW))
		col = true;
		}
	}

}

public void checkSla(){
		
	for(int n=0;n<5;n++){
		if(Gomoku.board[n].BW!=N){
			if((Gomoku.board[n].BW==Gomoku.board[n+10].BW)&&(Gomoku.board[n+10].BW==Gomoku.board[n+20].BW)&&(Gomoku.board[n+20].BW==Gomoku.board[n+30].BW)&&(Gomoku.board[n+30].BW==Gomoku.board[n+40].BW))
			Sla = true;
		}
	}
	for(int n=9;n<14;n++){
		if(Gomoku.board[n].BW!=N){
			if((Gomoku.board[n].BW==Gomoku.board[n+10].BW)&&(Gomoku.board[n+10].BW==Gomoku.board[n+20].BW)&&(Gomoku.board[n+20].BW==Gomoku.board[n+30].BW)&&(Gomoku.board[n+30].BW==Gomoku.board[n+40].BW))
			Sla = true;
		}
	}
	
	for(int n=18;n<23;n++){
		if(Gomoku.board[n].BW!=N){
			if((Gomoku.board[n].BW==Gomoku.board[n+10].BW)&&(Gomoku.board[n+10].BW==Gomoku.board[n+20].BW)&&(Gomoku.board[n+20].BW==Gomoku.board[n+30].BW)&&(Gomoku.board[n+30].BW==Gomoku.board[n+40].BW))
			Sla = true;
		}
	}
	for(int n=27;n<32;n++){
		if(Gomoku.board[n].BW!=N){
			if((Gomoku.board[n].BW==Gomoku.board[n+10].BW)&&(Gomoku.board[n+10].BW==Gomoku.board[n+20].BW)&&(Gomoku.board[n+20].BW==Gomoku.board[n+30].BW)&&(Gomoku.board[n+30].BW==Gomoku.board[n+40].BW))
			Sla = true;
		}
	}
	for(int n=36;n<41;n++){
		if(Gomoku.board[n].BW!=N){
			if((Gomoku.board[n].BW==Gomoku.board[n+10].BW)&&(Gomoku.board[n+10].BW==Gomoku.board[n+20].BW)&&(Gomoku.board[n+20].BW==Gomoku.board[n+30].BW)&&(Gomoku.board[n+30].BW==Gomoku.board[n+40].BW))
			Sla = true;
		}
	}
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