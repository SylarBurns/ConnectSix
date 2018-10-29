class scoreColUp{

	private static final int B = 0;  // color black : 0
	private static final int W = 1;  // color white : 1
	private static final int N = -1; // no stone    : -1

    int [] blackScore = new int[361];
    int [] whiteScore = new int[361];


    scoreColUp(){

        for(int i = 0; i<361; i++) blackScore[i] = 0;
        for(int i = 0; i<361; i++) whiteScore[i] = 0;
    }

    void sum(Location choice){

        int Lox = choice.GetX();
        int Loy = choice.GetY();

        int i = (Loy-10)/40;
        int j = (Lox-10)/40;
        int num = (i*19)+j ;

        if(choice.BW == B)
        {

            if(blackScore[num]==0) blackScore[num] = -1 ;
            else                   blackScore[num] *= -1;


            whiteScore[num] = 0 ;

            for(int point = 5, distance = 1; point > 0; point--, distance++)
                if(i-distance >= 0){         //change score at left

                    if(whiteScore[num-(19*distance)] >= 0)
                    {
                        whiteScore[num-(19*distance)] = 0;
                        if(blackScore[num-(19*distance)]==0) blackScore[num-(19*distance)] += point;
                        else blackScore[num-(19*distance)] *= point;

                    }
                    else if(whiteScore[num-(19*distance)] < 0)
                    {
                        break;
                    }                 

                }

        }
        else if(choice.BW == W)
        {
            if(whiteScore[num]==0) whiteScore[num] = -1 ;
            else                   whiteScore[num] *= -1;

            blackScore[num] = 0;
    
            for(int point = 5, distance = 1; point > 0; point--, distance++)
                if(i-distance >= 0){         //change score at left

                    if(blackScore[num-(19*distance)] >= 0)
                    {
                        blackScore[num-(19*distance)] = 0;
                        if(whiteScore[num-(19*distance)]==0) whiteScore[num-(19*distance)] += point;
                        else whiteScore[num-(19*distance)] *= point;

                    }
                    else if(blackScore[num-(19*distance)] < 0)
                    {
                        break;
                    }                 

                }

        }

    }
}