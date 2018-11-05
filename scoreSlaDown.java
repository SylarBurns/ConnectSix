class scoreSlaDown{

	private static final int B = 0;  // color black : 0
	private static final int W = 1;  // color white : 1
	private static final int N = -1; // no stone    : -1

    int [] blackScore = new int[361] ;
    int [] whiteScore = new int[361] ;


    scoreSlaDown(){

        for(int i = 0; i<361; i++) blackScore[i] = 0 ;
        for(int i = 0; i<361; i++) whiteScore[i] = 0 ;
    }

    void sum(Location choice){

        int Lox = choice.GetX() ;
        int Loy = choice.GetY() ;

        int i = (Loy-10)/40 ;
        int j = (Lox-10)/40 ;
        int num = (i*19)+j  ;

        if(choice.BW == B)
        {

            if(blackScore[num]==0) blackScore[num] =  -1;
            else                   blackScore[num] *= -1;


            whiteScore[num] = 0 ;

            for(int point = 5, distance = 1; point > 0; point--, distance++)
                if((j-distance >= 0)&&(i+distance < 19)){        //change score at right

                    int d = 18*distance;
                    if(whiteScore[num+d] >= 0){

                        whiteScore[num+d] = 0;

                        if(blackScore[num+d]==0)       blackScore[num+d] += point;
                        else if(blackScore[num+d] > 0) blackScore[num+d] += point;

                    }
                    else if(whiteScore[num+d] < 0){

                        distance--;
                        for(;distance > 0;distance--){
                            blackScore[num+d] /= 2;
                            whiteScore[num+d] /= 2;
                        }
                        break;
                    }

                }
        }
        else if(choice.BW == W)
        {
            if(whiteScore[num]==0) whiteScore[num] = -1 ;
            else                   whiteScore[num] *= -1;

            blackScore[num] = 0 ;
    
            for(int point = 5, distance = 1; point > 0; point--, distance++)
                if((j-distance >= 0)&&(i+distance < 19)){        //change score at right

                    int d = 18*distance;
                    if(blackScore[num+d] >= 0){

                        blackScore[num+d] = 0;

                        if(whiteScore[num+d]==0)       whiteScore[num+d] += point;
                        else if(whiteScore[num+d] > 0) whiteScore[num+d] += point;

                    }
                    else if(blackScore[num+d] < 0){

                        distance--;
                        for(;distance > 0;distance--){
                            whiteScore[num+d] /= 2;
                            blackScore[num+d] /= 2;
                        }
                        break;
                    }

                }

        }
    }
}