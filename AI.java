class AI{  // the new score system for win
	private static final int B = 0;
	private static final int W = 1;
    private static final int N = -1;
    
    boolean blackFive;
    boolean blackFour;
    boolean blackThree;
    boolean blackTwo;
    boolean whiteFive;
    boolean whiteFour;
    boolean whiteThree;
    boolean whiteTwo;

    int Score;
    

    AI(){

        blackFive  = false;
        blackFour  = false;
        blackThree = false;
        blackTwo   = false;
        whiteFive  = false;
        whiteFour  = false;
        whiteThree = false;
        whiteTwo   = false;

        Score = 0;
    }

    void turnOn(int num, int color){

        if(color == B){

            if(num==5) blackFive  = true;
            if(num==4) blackFour  = true;
            if(num==3) blackThree = true;
            if(num==2) blackTwo   = true;

        }else if(color == W){

            if(num==5) whiteFive  = true;
            if(num==4) whiteFour  = true;
            if(num==3) whiteThree = true;
            if(num==2) whiteTwo   = true;

        }

        if(blackFive == true){

            blackFour  = false;
            blackThree = false;
            blackTwo   = false;
        }else if(blackFour == true){

            blackThree = false;
            blackTwo   = false;
        }else if(blackThree == true){

            blackTwo = false;
        }

        if(whiteFive == true){

            whiteFour  = false;
            whiteThree = false;
            whiteTwo   = false;
        }else if(whiteFour == true){

            whiteThree = false;
            whiteTwo   = false;
        }else if(whiteThree == true){

            whiteTwo = false;
        }
    }

    void calculate(){

        if(blackFive == true)       Score += 1000;
        else if(blackFour == true)  Score += 400;
        else if(blackThree == true) Score += 40;
        else if(blackTwo == true)   Score += 10;

        if(whiteFive == true)       Score += 1000;
        else if(whiteFour == true)  Score += 400;
        else if(whiteThree == true) Score += 40;
        else if(whiteTwo == true)   Score += 10;

        
    }

    void turnOff(){

        blackFive  = false;
        blackFour  = false;
        blackThree = false;
        blackTwo   = false;
        whiteFive  = false;
        whiteFour  = false;
        whiteThree = false;
        whiteTwo   = false;

        Score = 0;
    }


	
}