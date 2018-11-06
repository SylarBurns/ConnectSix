class scoreRowRight{

	private static final int B = 0;  // color black : 0
	private static final int W = 1;  // color white : 1
	private static final int N = -1; // no stone    : -1

    int [] blackScore = new int[361];
    int [] whiteScore = new int[361];


    scoreRowRight(){

        for(int i = 0; i<361; i++) blackScore[i] = 0;
        for(int i = 0; i<361; i++) whiteScore[i] = 0;
    }

    void sum(Location choice){

        int Lox = choice.GetX();
        int Loy = choice.GetY();

        int i = (Loy-10)/40;
        int j = (Lox-10)/40;
        int num = (i*19)+j ;
        int position;

        if(choice.BW == B)
        {
            /* 돌이 놓였을 때 row의 점수를 계산하는데, 돌 양 옆으로 1. 총 5개의 빈 공간이 있는지, 2. 그 5개의 공간에 적의 돌이 있는지 없는지 체크. */
            /* 만약에 두 조건이 모두 만족하지 못한다면 그 사이의 점수들은 0점 또는 매우 낮게 매겨져야한다. (row만 고려했을 때 -> col이나 대각선이 고려되면 달라져야함) */
            
            //position = num % 19; // 0 ~ 18 사이 숫자로 만듬
            /* 1번 조건 체크 */
            
            
            if(blackScore[num]==0) blackScore[num] =  -2 ;
            else                   blackScore[num] *= -1 ;


            whiteScore[num] = 0 ;
            int distance = 1;
            // for(int point = 5, distance = 1; point > 0; point--, distance++)
                if(j+distance < 19){        //change score at right

                    int d = 1*distance;
                    if(whiteScore[num+d] >= 0){

                        // whiteScore[num+d] = 0;
                        
                        // if(blackScore[num+d]==0)        blackScore[num+d] += point;
                        // else if(blackScore[num+d] > 0) blackScore[num+d] += point;
                        blackScore[num+d] += 1;

                    }
                    else if(whiteScore[num+d] < 0){

                        // distance--;
                        // for(;distance > 0;distance--){
                        //     d = 1*distance;
                        //     blackScore[num+d] = 0;
                        //     whiteScore[num+d] = 0;
                        // }
                        // break;
                    }

                }

        }
        else if(choice.BW == W)
        {
            if(whiteScore[num]==0) whiteScore[num] =  -2;
            else                   whiteScore[num] *= -1;

            blackScore[num] = 0;
            int distance = 1;
            // for(int point = 5, distance = 1; point > 0; point--, distance++)
                if(j+distance < 19){        //change score at right

                    int d = 1*distance;
                    if(blackScore[num+d] >= 0){

                        // blackScore[num+d] = 0;

                        // if(whiteScore[num+d]==0)       whiteScore[num+d] += point;
                        // else if(whiteScore[num+d] > 0) whiteScore[num+d] += point;
                        whiteScore[num+d] += 1;

                    }
                    else if(blackScore[num+d] < 0){

                        // distance--;
                        // for(;distance > 0;distance--){
                        //     d = 1*distance;
                        //     whiteScore[num+d] = 0;
                        //     blackScore[num+d] = 0;
                        // }
                        // break;
                    }

                }

        }
    }
}