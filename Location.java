class Location {

	private static final int B = 0   ;
	private static final int W = 1   ;
	private static final int N = -1  ;
	private static final int Row = 2 ;
	private static final int Col = 3 ;
	private static final int Sla = 4 ;
	private static final int Bsl = 5 ;
	
	
	int Lox;
	int Loy;
	int BW;
	boolean is;

	boolean blackRowFive;
    boolean blackRowFour;
    boolean blackRowThree;
    boolean blackRowTwo;
    boolean whiteRowFive;
    boolean whiteRowFour;
    boolean whiteRowThree;
	boolean whiteRowTwo;
	boolean blackRowOne;
	boolean whiteRowOne;

	boolean blackColFive;
    boolean blackColFour;
    boolean blackColThree;
    boolean blackColTwo;
    boolean whiteColFive;
    boolean whiteColFour;
    boolean whiteColThree;
	boolean whiteColTwo;
	boolean blackColOne;
	boolean whiteColOne;
	
	boolean blackSlaFive;
    boolean blackSlaFour;
    boolean blackSlaThree;
    boolean blackSlaTwo;
    boolean whiteSlaFive;
    boolean whiteSlaFour;
    boolean whiteSlaThree;
	boolean whiteSlaTwo;
	boolean blackSlaOne;
	boolean whiteSlaOne;

	boolean blackBslFive;
    boolean blackBslFour;
    boolean blackBslThree;
    boolean blackBslTwo;
    boolean whiteBslFive;
    boolean whiteBslFour;
    boolean whiteBslThree;
	boolean whiteBslTwo;
	boolean blackBslOne;
	boolean whiteBslOne;


	int black_Score;
	int white_Score;
    int total_Score;

	public Location(){
		Lox = 0;
		Loy = 0;
		BW = N;
		is = false;

		blackRowFive  = false;
        blackRowFour  = false;
        blackRowThree = false;
		blackRowTwo   = false;
		blackRowOne   = false;
        whiteRowFive  = false;
        whiteRowFour  = false;
        whiteRowThree = false;
		whiteRowTwo   = false;
		whiteRowOne   = false;

		blackColFive  = false;
        blackColFour  = false;
        blackColThree = false;
		blackColTwo   = false;
		blackColOne   = false;
        whiteColFive  = false;
        whiteColFour  = false;
        whiteColThree = false;
		whiteColTwo   = false;
		whiteColOne   = false;

		blackSlaFive  = false;
        blackSlaFour  = false;
        blackSlaThree = false;
		blackSlaTwo   = false;
		blackSlaOne   = false;
        whiteSlaFive  = false;
        whiteSlaFour  = false;
        whiteSlaThree = false;
		whiteSlaTwo   = false;
		whiteSlaOne   = false;

		blackBslFive  = false;
        blackBslFour  = false;
        blackBslThree = false;
		blackBslTwo   = false;
		blackBslOne   = false;
        whiteBslFive  = false;
        whiteBslFour  = false;
        whiteBslThree = false;
		whiteBslTwo   = false;
		whiteBslOne   = false;

		black_Score = 0 ;
		white_Score = 0 ; 
        total_Score = 0 ;
	}

	void turnOn(int num, int direction)
	{
		int now_turn = 0;
		if(Gomoku.turnB > 0)      now_turn = B;
		else if(Gomoku.turnW > 0) now_turn = W;

		switch(direction)
		{	
			case Row :

				if(now_turn == B)
				{
					if(num==5) blackRowFive  = true;
					if(num==4) blackRowFour  = true;
					if(num==3) blackRowThree = true;
					if(num==2) blackRowTwo   = true;
					if(num==1) blackRowOne   = true;
				}
				else if(now_turn == W)
				{
					if(num==5) whiteRowFive  = true;
					if(num==4) whiteRowFour  = true;
					if(num==3) whiteRowThree = true;
					if(num==2) whiteRowTwo   = true;
					if(num==1) whiteRowOne   = true;
				}

				// if(blackRowFive == true)
				// {
				// 	blackRowFour  = false;
				// 	blackRowThree = false;
				// 	blackRowTwo   = false;
				// 	blackRowOne   = false;
				// }
				// else if(blackRowFour == true)
				// {
				// 	blackRowThree = false;
				// 	blackRowTwo   = false;
				// 	blackRowOne   = false;
				// }
				// else if(blackRowThree == true)
				// {
				// 	blackRowTwo = false;
				// 	blackRowOne = false;
				// }
				// else if(blackRowTwo == true)
				// {
				// 	blackRowOne = false;
				// }

				// if(whiteRowFive == true)
				// {
				// 	whiteRowFour  = false;
				// 	whiteRowThree = false;
				// 	whiteRowTwo   = false;
				// 	whiteRowOne   = false;
				// }
				// else if(whiteRowFour == true)
				// {
				// 	whiteRowThree = false;
				// 	whiteRowTwo   = false;
				// 	whiteRowOne   = false;
				// }
				// else if(whiteRowThree == true)
				// {
				// 	whiteRowTwo = false;
				// 	whiteRowOne = false;
				// }
				// else if(whiteRowTwo == true)
				// {
				// 	whiteRowOne = false;
				// }
				break;
				


			case Col :

				if(now_turn == B)
				{
					if(num==5) blackColFive  = true;
					if(num==4) blackColFour  = true;
					if(num==3) blackColThree = true;
					if(num==2) blackColTwo   = true;
					if(num==1) blackColOne   = true;
				}
				else if(now_turn == W)
				{
					if(num==5) whiteColFive  = true;
					if(num==4) whiteColFour  = true;
					if(num==3) whiteColThree = true;
					if(num==2) whiteColTwo   = true;
					if(num==1) whiteColOne   = true;
				}


				// if(blackColFive == true)
				// {
				// 	blackColFour  = false;
				// 	blackColThree = false;
				// 	blackColTwo   = false;
				// 	blackColOne   = false;
				// }
				// else if(blackColFour == true)
				// {
				// 	blackColThree = false;
				// 	blackColTwo   = false;
				// 	blackColOne   = false;
				// }
				// else if(blackColThree == true)
				// {
				// 	blackColTwo = false;
				// 	blackColOne = false;
				// }
				// else if(blackColTwo == true)
				// {
				// 	blackColOne = false;
				// }


				// if(whiteColFive == true)
				// {
				// 	whiteColFour  = false;
				// 	whiteColThree = false;
				// 	whiteColTwo   = false;
				// 	whiteColOne   = false;
				// }
				// else if(whiteColFour == true)
				// {
				// 	whiteColThree = false;
				// 	whiteColTwo   = false;
				// 	whiteColOne   = false;
				// }
				// else if(whiteColThree == true)
				// {
				// 	whiteColTwo = false;
				// 	whiteColOne = false;
				// }
				// else if(whiteColTwo == true)
				// {
				// 	whiteColOne = false;
				// }
				break;

			case Sla :

				if(now_turn == B)
				{
					if(num==5) blackSlaFive  = true;
					if(num==4) blackSlaFour  = true;
					if(num==3) blackSlaThree = true;
					if(num==2) blackSlaTwo   = true;
					if(num==1) blackSlaOne   = true;
				}
				else if(now_turn == W)
				{
					if(num==5) whiteSlaFive  = true;
					if(num==4) whiteSlaFour  = true;
					if(num==3) whiteSlaThree = true;
					if(num==2) whiteSlaTwo   = true;
					if(num==1) whiteSlaOne   = true;
				}

				// if(blackSlaFive == true)
				// {
				// 	blackSlaFour  = false;
				// 	blackSlaThree = false;
				// 	blackSlaTwo   = false;
				// 	blackSlaOne   = false;
				// }
				// else if(blackSlaFour == true)
				// {
				// 	blackSlaThree = false;
				// 	blackSlaTwo   = false;
				// 	blackSlaOne   = false;
				// }
				// else if(blackSlaThree == true)
				// {
				// 	blackSlaTwo = false;
				// 	blackSlaOne = false;
				// }
				// else if(blackSlaTwo == true)
				// {
				// 	blackSlaOne = false;
				// }

				// if(whiteSlaFive == true)
				// {
				// 	whiteSlaFour  = false;
				// 	whiteSlaThree = false;
				// 	whiteSlaTwo   = false;
				// 	whiteSlaOne   = false;
				// }
				// else if(whiteSlaFour == true)
				// {
				// 	whiteSlaThree = false;
				// 	whiteSlaTwo   = false;
				// 	whiteSlaOne   = false;
				// }
				// else if(whiteSlaThree == true)
				// {
				// 	whiteSlaTwo = false;
				// 	whiteSlaOne = false;
				// }
				// else if(whiteSlaTwo == true)
				// {
				// 	whiteSlaOne = false;
				// }
				break;
			
			case Bsl :

				if(now_turn == B)
				{
					if(num==5) blackBslFive  = true;
					if(num==4) blackBslFour  = true;
					if(num==3) blackBslThree = true;
					if(num==2) blackBslTwo   = true;
					if(num==1) blackBslOne   = true;
				}
				else if(now_turn == W)
				{
					if(num==5) whiteBslFive  = true;
					if(num==4) whiteBslFour  = true;
					if(num==3) whiteBslThree = true;
					if(num==2) whiteBslTwo   = true;
					if(num==1) whiteBslOne   = true;
				}

				// if(blackBslFive == true)
				// {
				// 	blackBslFour  = false;
				// 	blackBslThree = false;
				// 	blackBslTwo   = false;
				// 	blackBslOne   = false;
				// }
				// else if(blackBslFour == true)
				// {
				// 	blackBslThree = false;
				// 	blackBslTwo   = false;
				// 	blackBslOne   = false;
				// }
				// else if(blackBslThree == true)
				// {
				// 	blackBslTwo = false;
				// 	blackBslOne = false;
				// }
				// else if(blackBslTwo == true)
				// {
				// 	blackBslOne = false;
				// }

				// if(whiteBslFive == true)
				// {
				// 	whiteBslFour  = false;
				// 	whiteBslThree = false;
				// 	whiteBslTwo   = false;
				// 	whiteBslOne   = false;
				// }
				// else if(whiteBslFour == true)
				// {
				// 	whiteBslThree = false;
				// 	whiteBslTwo   = false;
				// 	whiteBslOne   = false;
				// }
				// else if(whiteBslThree == true)
				// {
				// 	whiteBslTwo = false;
				// 	whiteBslOne = false;
				// }
				// else if(whiteBslTwo == true)
				// {
				// 	whiteBslOne = false;
				// }
				break;
		}
	}

	void calculate()
	{

			black_Score = 0;
			white_Score = 0;
			total_Score = 0;
		
        if(blackRowFive == true)       black_Score += 100000;
        else if(blackRowFour == true)  black_Score += 10000;
        else if(blackRowThree == true) black_Score += 100;
		else if(blackRowTwo == true)   black_Score += 10;
		else if(blackRowOne == true)   black_Score += 1;

        if(whiteRowFive == true)       white_Score += 100000;
        else if(whiteRowFour == true)  white_Score += 10000;
        else if(whiteRowThree == true) white_Score += 100;
		else if(whiteRowTwo == true)   white_Score += 10;
		else if(whiteRowOne == true)   white_Score += 1;

		if(blackColFive == true)       black_Score += 100000;
        else if(blackColFour == true)  black_Score += 10000;
        else if(blackColThree == true) black_Score += 100;
		else if(blackColTwo == true)   black_Score += 10;
		else if(blackColOne == true)   black_Score += 1;

        if(whiteColFive == true)       white_Score += 100000;
        else if(whiteColFour == true)  white_Score += 10000;
        else if(whiteColThree == true) white_Score += 100;
		else if(whiteColTwo == true)   white_Score += 10;
		else if(whiteColOne == true)   white_Score += 1;

		if(blackSlaFive == true)       black_Score += 100000;
        else if(blackSlaFour == true)  black_Score += 10000;
        else if(blackSlaThree == true) black_Score += 100;
		else if(blackSlaTwo == true)   black_Score += 10;
		else if(blackSlaOne == true)   black_Score += 1;

        if(whiteSlaFive == true)       white_Score += 100000;
        else if(whiteSlaFour == true)  white_Score += 10000;
        else if(whiteSlaThree == true) white_Score += 100;
		else if(whiteSlaTwo == true)   white_Score += 10;
		else if(whiteSlaOne == true)   white_Score += 1;

		if(blackBslFive == true)       black_Score += 100000;
        else if(blackBslFour == true)  black_Score += 10000;
        else if(blackBslThree == true) black_Score += 100;
		else if(blackBslTwo == true)   black_Score += 10;
		else if(blackBslOne == true)   black_Score += 1;

        if(whiteBslFive == true)       white_Score += 100000;
        else if(whiteBslFour == true)  white_Score += 10000;
        else if(whiteBslThree == true) white_Score += 100;
		else if(whiteBslTwo == true)   white_Score += 10;
		else if(whiteBslOne == true)   white_Score += 1;

		if(is == true)
		{
			black_Score *= -1 ;
			white_Score *= -1 ;
		}

		total_Score = black_Score + white_Score ;
    
    }

    void turnOff(){

        blackRowFive  = false;
        blackRowFour  = false;
        blackRowThree = false;
		blackRowTwo   = false;
		blackRowOne   = false;
        whiteRowFive  = false;
        whiteRowFour  = false;
        whiteRowThree = false;
        whiteRowTwo   = false;
		whiteRowOne   = false;

		blackColFive  = false;
        blackColFour  = false;
        blackColThree = false;
		blackColTwo   = false;
		blackColOne   = false;
        whiteColFive  = false;
        whiteColFour  = false;
        whiteColThree = false;
        whiteColTwo   = false;
		whiteColOne   = false;

		blackSlaFive  = false;
        blackSlaFour  = false;
        blackSlaThree = false;
		blackSlaTwo   = false;
		blackSlaOne   = false;
        whiteSlaFive  = false;
        whiteSlaFour  = false;
        whiteSlaThree = false;
        whiteSlaTwo   = false;
		whiteSlaOne   = false;

		blackBslFive  = false;
        blackBslFour  = false;
        blackBslThree = false;
		blackBslTwo   = false;
		blackBslOne   = false;
        whiteBslFive  = false;
        whiteBslFour  = false;
        whiteBslThree = false;
        whiteBslTwo   = false;
		whiteBslOne   = false;

	    black_Score = 0 ;
 	    white_Score = 0 ;
        total_Score = 0 ;
    }


	public void SetLocation(int x, int y){
		Lox = x;
		Loy = y;
	}

	public void Setis(boolean is){
		this.is = is;

	}

	public int GetX(){
		return Lox;
	}

	public int GetY(){
		return Loy;
	}

	public boolean Getis(){
		return is;
	}


}
