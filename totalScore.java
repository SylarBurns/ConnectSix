import java.util.* ;
import javax.swing.* ;
import java.awt.*;

class totalScore extends JPanel{

    private static final int B = 0;
	private static final int W = 1;
    private static final int N = -1;
    private static final int Row = 2 ;
	private static final int Col = 3 ;
	private static final int Sla = 4 ;
	private static final int Bsl = 5 ;
    
    public int first_where = 0;
    
    // scoreRowLeft  score_Row_L = new scoreRowLeft() ;
    // scoreRowRight score_Row_R = new scoreRowRight();
    // scoreColUp    score_Col_U = new scoreColUp()   ;
    // scoreColDown  score_Col_D = new scoreColDown() ;
    // scoreSlaUp    score_Sla_U = new scoreSlaUp()   ;
    // scoreSlaDown  score_Sla_D = new scoreSlaDown() ;
    // scoreBslUp    score_Bsl_U = new scoreBslUp()   ;
    // scoreBslDown  score_Bsl_D = new scoreBslDown() ;


    int [] total    = new int[361];

    // int [] totRowBlack = new int[361];
    // int [] totRowWhite = new int[361];
    // int [] totColBlack = new int[361];
    // int [] totColWhite = new int[361];
    // int [] totSlaBlack = new int[361];
    // int [] totSlaWhite = new int[361];
    // int [] totBslBlack = new int[361];
    // int [] totBslWhite = new int[361];


    totalScore(){

        for(int i = 0 ; i <361 ; i++)
        {    
            total[i] = 0;

            // totRowBlack[i] = 0 ;
            // totRowWhite[i] = 0 ;
            // totColBlack[i] = 0 ;
            // totColWhite[i] = 0 ;
            // totSlaBlack[i] = 0 ;
            // totSlaWhite[i] = 0 ;
            // totBslBlack[i] = 0 ;
            // totBslWhite[i] = 0 ;
        }
    }

    void setTotal(Location choice){

        
        choice.calculate();
        
        // score_Row_L.sum(choice);
        // score_Row_R.sum(choice);
        // score_Col_U.sum(choice);
        // score_Col_D.sum(choice);
        // score_Sla_U.sum(choice);
        // score_Sla_D.sum(choice);
        // score_Bsl_U.sum(choice);
        // score_Bsl_D.sum(choice);


        for(int i = 0; i < 361 ; i++)
        {
        //     total[i] = score_Row_L.blackScore[i]
        //              + score_Row_L.whiteScore[i]
        //              + score_Row_R.blackScore[i]
        //              + score_Row_R.whiteScore[i]
        //              + score_Col_U.blackScore[i]
        //              + score_Col_U.whiteScore[i]
        //              + score_Col_D.blackScore[i]
        //              + score_Col_D.whiteScore[i]
        //              + score_Sla_U.blackScore[i]
        //              + score_Sla_U.whiteScore[i]
        //              + score_Sla_D.blackScore[i]
        //              + score_Sla_D.whiteScore[i]
        //              + score_Bsl_U.blackScore[i]
        //              + score_Bsl_U.whiteScore[i]
        //              + score_Bsl_D.blackScore[i]
        //              + score_Bsl_D.whiteScore[i];

        //  totBlack[i] = score_Row_L.blackScore[i]
        //              + score_Row_R.blackScore[i]
        //              + score_Col_U.blackScore[i]
        //              + score_Col_D.blackScore[i]
        //              + score_Sla_U.blackScore[i]
        //              + score_Sla_D.blackScore[i]
        //              + score_Bsl_U.blackScore[i]
        //              + score_Bsl_D.blackScore[i];

        //  totWhite[i] = score_Row_L.whiteScore[i]
        //              + score_Row_R.whiteScore[i]
        //              + score_Col_U.whiteScore[i]
        //              + score_Col_D.whiteScore[i]
        //              + score_Sla_U.whiteScore[i]
        //              + score_Sla_D.whiteScore[i]
        //              + score_Bsl_U.whiteScore[i]
        //              + score_Bsl_D.whiteScore[i];
            Gomoku.board[i].calculate();
        }


        checkRow();
        checkCol();
        checkSla();
        checkBackSla();

    }

    void display(){


        int turn = N;
        if(Gomoku.turnB > 0)      turn = B;
        else if(Gomoku.turnW > 0) turn = W;

        int first_score =  0;
        int connectBlackFive = 0;
        int connectWhiteFive = 0;
        int connectBlackFour = 0;
        int connectWhiteFour = 0;
        int connectBlackOpenThree = 0;
        int connectWhiteOpenThree = 0;
        // int connectBlackClosedThree = 0;
        // int connectWhiteClosedThree = 0;
        int connectBlackOpenTwo = 0;
        int connectWhiteOpenTwo = 0;
        // int connectBlackClosedTwo = 0;
        // int connectWhiteClosedTwo = 0;

        System.out.print("\nScore Board\n");

        for(int i = 0; i < 20; i++)     System.out.printf("%5d ", i);

        for(int i = 0; i<361; i++)
        {
            if(Gomoku.board[i].blackRowFive==true)  connectBlackFive++ ;
            if(Gomoku.board[i].whiteRowFive==true)  connectWhiteFive++ ;
            if(Gomoku.board[i].blackRowFour==true)  connectBlackFour++ ;
            if(Gomoku.board[i].whiteRowFour==true)  connectWhiteFour++ ;
            if(Gomoku.board[i].blackRowThree==true) connectBlackOpenThree++ ;
            if(Gomoku.board[i].whiteRowThree==true) connectWhiteOpenThree++ ; 
            if(Gomoku.board[i].blackRowTwo==true)   connectBlackOpenTwo++;
            if(Gomoku.board[i].whiteRowTwo==true)   connectWhiteOpenTwo++;

            if(Gomoku.board[i].blackColFive==true)  connectBlackFive++ ;
            if(Gomoku.board[i].whiteColFive==true)  connectWhiteFive++ ;
            if(Gomoku.board[i].blackColFour==true)  connectBlackFour++ ;
            if(Gomoku.board[i].whiteColFour==true)  connectWhiteFour++ ;
            if(Gomoku.board[i].blackColThree==true) connectBlackOpenThree++ ;
            if(Gomoku.board[i].whiteColThree==true) connectWhiteOpenThree++ ; 
            if(Gomoku.board[i].blackColTwo==true)   connectBlackOpenTwo++;
            if(Gomoku.board[i].whiteColTwo==true)   connectWhiteOpenTwo++;

            if(Gomoku.board[i].blackSlaFive==true)  connectBlackFive++ ;
            if(Gomoku.board[i].whiteSlaFive==true)  connectWhiteFive++ ;
            if(Gomoku.board[i].blackSlaFour==true)  connectBlackFour++ ;
            if(Gomoku.board[i].whiteSlaFour==true)  connectWhiteFour++ ;
            if(Gomoku.board[i].blackSlaThree==true) connectBlackOpenThree++ ;
            if(Gomoku.board[i].whiteSlaThree==true) connectWhiteOpenThree++ ; 
            if(Gomoku.board[i].blackSlaTwo==true)   connectBlackOpenTwo++;
            if(Gomoku.board[i].whiteSlaTwo==true)   connectWhiteOpenTwo++;

            if(Gomoku.board[i].blackBslFive==true)  connectBlackFive++ ;
            if(Gomoku.board[i].whiteBslFive==true)  connectWhiteFive++ ;
            if(Gomoku.board[i].blackBslFour==true)  connectBlackFour++ ;
            if(Gomoku.board[i].whiteBslFour==true)  connectWhiteFour++ ;
            if(Gomoku.board[i].blackBslThree==true) connectBlackOpenThree++ ;
            if(Gomoku.board[i].whiteBslThree==true) connectWhiteOpenThree++ ; 
            if(Gomoku.board[i].blackBslTwo==true)   connectBlackOpenTwo++;
            if(Gomoku.board[i].whiteBslTwo==true)   connectWhiteOpenTwo++;

            // if((totBlack[i] >= 111)&&(totBlack[i] < 300)) connectBlackClosedThree++;
            // if((totWhite[i] >= 111)&&(totWhite[i] < 300)) connectWhiteClosedThree++;
            // if(Gomoku.board[i].blackTwo==true)   connectBlackOpenTwo++;
            // if(Gomoku.board[i].white==true)   connectWhiteOpenTwo++;
            // if((totBlack[i] >= 10)&&(totBlack[i] < 40))     connectBlackClosedTwo++;
            // if((totWhite[i] >= 10)&&(totWhite[i] < 40))     connectWhiteClosedTwo++;
        }

        // connectBlackClosedThree -= connectBlackOpenThree ;
        // connectWhiteClosedThree -= connectWhiteOpenThree ;




        if((turn==B)&&(connectBlackFive >= 1))
        {
            for(int i = 0; i<361; i++)
            {
                if(i%19 == 0) System.out.printf("\n\n%5d", i/19+1);

                if(Gomoku.board[i].black_Score > first_score)
                {
                    first_score = Gomoku.board[i].black_Score;
                    first_where = i;
                }
                System.out.printf("%5d ", Gomoku.board[i].black_Score);
            }
        }
        else if((turn==W)&&(connectWhiteFive >= 1))
        {
            for(int i = 0; i<361; i++)
            {
                if(i%19 == 0) System.out.printf("\n\n%5d", i/19+1); 
                
                if(Gomoku.board[i].white_Score > first_score)
                {
                    first_score = Gomoku.board[i].white_Score;
                    first_where = i;
                }
                System.out.printf("%5d ", Gomoku.board[i].white_Score);
            }
        }
        else if((turn==B)&&(connectBlackFour >= 2)&&Gomoku.turnB==2)
        {
            for(int i = 0; i<361; i++)
            {
                if(i%19 == 0) System.out.printf("\n\n%5d", i/19+1);

                if(Gomoku.board[i].black_Score > first_score)
                {
                    first_score = Gomoku.board[i].black_Score;
                    first_where = i;
                }
                System.out.printf("%5d ", Gomoku.board[i].black_Score);
            }
        }
        else if((turn==W)&&(connectWhiteFour >= 2)&&Gomoku.turnW==2)
        {
            for(int i = 0; i<361; i++)
            {
                if(i%19 == 0) System.out.printf("\n\n%5d", i/19+1); 
                
                if(Gomoku.board[i].white_Score > first_score)
                {
                    first_score = Gomoku.board[i].white_Score;
                    first_where = i;
                }
                System.out.printf("%5d ", Gomoku.board[i].white_Score);
            }
        }
        else if((turn==B)&&(connectBlackOpenThree >= 2)
                    //    &&(connectBlackClosedThree >= 1)
                       &&(connectWhiteFive==0)
                       &&(connectWhiteFour==0)
                       &&(Gomoku.turnB==2))
        {
            for(int i = 0; i<361; i++)
            {
                // if(totBlack[i] >= 10000) continue;
                 
                if(i%19 == 0) System.out.printf("\n\n%5d", i/19+1);

                if(Gomoku.board[i].black_Score > first_score)
                {
                    first_score = Gomoku.board[i].black_Score;
                    first_where = i;
                }
                System.out.printf("%5d ", Gomoku.board[i].black_Score);
            }
        }
        else if((turn==W)&&(connectWhiteOpenThree >= 2)
                    //    &&(connectWhiteClosedThree >= 1)
                       &&(connectBlackFive==0)
                       &&(connectBlackFour==0)
                       &&Gomoku.turnW==2)
        {
            for(int i = 0; i<361; i++)
            {
                // if(totWhite[i] >= 10000) continue;

                if(i%19 == 0) System.out.printf("\n\n%5d", i/19+1); 
                
                if(Gomoku.board[i].white_Score > first_score)
                {
                    first_score = Gomoku.board[i].white_Score;
                    first_where = i;
                }
                System.out.printf("%5d ", Gomoku.board[i].white_Score);
            }
        }
        else if((turn==B)
                        // &&(connectBlackClosedThree >= 1)
                         &&(connectWhiteFive==0)
                         &&(connectWhiteFour==0))
        {
            for(int i = 0; i<361; i++)
            {
                if(i%19 == 0) System.out.printf("\n\n%5d", i/19+1);

                if(Gomoku.board[i].black_Score > first_score)
                {
                    first_score = Gomoku.board[i].black_Score;
                    first_where = i;
                }
                System.out.printf("%5d ", Gomoku.board[i].black_Score);
            }
        }
        else if((turn==W)
                        // &&(connectWhiteClosedThree >= 1)
                         &&(connectBlackFive==0)
                         &&(connectBlackFour==0))
        {
            for(int i = 0; i<361; i++)
            {

                if(i%19 == 0) System.out.printf("\n\n%5d", i/19+1);
                
                if(Gomoku.board[i].white_Score > first_score)
                {
                    first_score = Gomoku.board[i].white_Score;
                    first_where = i;
                }
                System.out.printf("%5d ", Gomoku.board[i].white_Score);
            }
        }
        else 
        {
            for(int i = 0; i<361; i++)
            {
                if(i%19 == 0) System.out.printf("\n\n%5d", i/19+1);

                if(Gomoku.board[i].total_Score > first_score){

                    first_score = Gomoku.board[i].total_Score;
                    first_where = i;
                }
                System.out.printf("%5d ", Gomoku.board[i].total_Score);
            }
        }
    
        // if(turn==B){
        //     for(int i = 0; i<361; i++)
        //     {
        //         if(i%19 == 0) System.out.printf("\n\n%5d", i/19+1);
    
    
        //         if(totBlack[i] > first_score) {
    
        //             first_score = totBlack[i];
        //             first_where = i;
        //         }
        //         System.out.printf("%5d ", totBlack[i]);
        //     }
        // }
        // if(turn==W){
        //     for(int i = 0; i<361; i++)
        //     {
        //         if(i%19 == 0) System.out.printf("\n\n%5d", i/19+1);
    
    
        //         if(totWhite[i] > first_score) {
    
        //             first_score = totWhite[i];
        //             first_where = i;
        //         }
        //         System.out.printf("%5d ", totWhite[i]);
        //     }
        // }

        System.out.println();
        System.out.print(first_where%19+1);
        System.out.print(" , ");
        System.out.println(first_where/19+1);

        System.out.println("Black Five : " + connectBlackFive);
        System.out.println("White Five : " + connectWhiteFive);
        System.out.println("Black Four : " + connectBlackFour);
        System.out.println("WHite Four : " + connectWhiteFour);
        System.out.println("Black Open Three : " + connectBlackOpenThree);
        System.out.println("White Open Three : " + connectWhiteOpenThree);
        // System.out.println("Black Closed Three : " + connectBlackClosedThree);
        // System.out.println("White Closed Three : " + connectWhiteClosedThree);
        System.out.println("Black Open Two : " + connectBlackOpenTwo);
        System.out.println("White Open Two : " + connectWhiteOpenTwo);
        // System.out.println("Black Closed Two : " + connectBlackClosedTwo);
        // System.out.println("White Closed Two : " + connectWhiteClosedTwo);
        
    }
        



    void checkRow()
    {
        for(int n=0;n<19;n++)
		for(int i=0;i<14;i++)
		{
            int blackNum = 0;
            int whiteNum = 0;
            int notNum   = 0;

            int num = (n*19)+i ;

            for(int m=0;m<6;m++)
                if(Gomoku.board[num+m].BW==B) blackNum++;
                else if(Gomoku.board[num+m].BW==W) whiteNum++;
                else notNum++;

            
            if((blackNum==5)&&(notNum==1))
            {
                for(int a = 0; a < 6; a++){
                    if(Gomoku.board[num+a].BW==N)
                    {
                        Gomoku.board[num+a].turnOn(5, Row);
                        // totRowBlack[num+a] += 100000;
                    }
                }
            }
            else if((blackNum==4)&&(notNum==2)&&(Gomoku.turnB!=1))
            {
                for(int a = 0; a < 6; a++){
                    if(Gomoku.board[num+a].BW==N)
                    {
                        Gomoku.board[num+a].turnOn(4, Row);
                        // totRowBlack[num+a] += 10000;
                    }
                }
            }
            else if((blackNum==3)&&(notNum==3))
            {
                for(int a = 0; a < 6; a++){
                    if(Gomoku.board[num+a].BW==N)
                    {
                        Gomoku.board[num+a].turnOn(3, Row);
                        // totRowBlack[num+a] += 100;
                    }
                }
            }
            else if((blackNum==2)&&(notNum==4))
            {
                for(int a = 0; a < 6; a++){
                    if(Gomoku.board[num+a].BW==N)
                    {
                        Gomoku.board[num+a].turnOn(2, Row);
                        // totRowBlack[num+a] += 10;
                    }
                }
            }
            else if((blackNum==1)&&(notNum==5))
            {
                for(int a = 0; a < 6; a++){
                    if(Gomoku.board[num+a].BW==N)
                    {
                        Gomoku.board[num+a].turnOn(1, Row);
                        // totRowlack[num+a] += 1;
                    }
                }
            }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            
            if((whiteNum==5)&&(notNum==1))
            {
                for(int a = 0; a < 6; a++){
                    if(Gomoku.board[num+a].BW==N)
                    {
                        Gomoku.board[num+a].turnOn(5, Row);
                        // totRowWhite[num+a] += 100000;
                    }
                }
            }
            else if((whiteNum==4)&&(notNum==2)&&(Gomoku.turnW!=1))
            {
                for(int a = 0; a < 6; a++){
                    if(Gomoku.board[num+a].BW==N)
                    {
                        Gomoku.board[num+a].turnOn(4, Row);
                        // totRowWhite[num+a] += 10000;
                    }
                }
            }
            else if((whiteNum==3)&&(notNum==3))
            {
                for(int a = 0; a < 6; a++){
                    if(Gomoku.board[num+a].BW==N)
                    {
                        Gomoku.board[num+a].turnOn(3, Row);
                        // totRowWhite[num+a] += 100;
                    }
                }
            }
            else if((whiteNum==2)&&(notNum==4))
            {
                for(int a = 0; a < 6; a++){
                    if(Gomoku.board[num+a].BW==N)
                    {
                        Gomoku.board[num+a].turnOn(2, Row);    
                        // totRowWhite[num+a] += 10;
                    }
                }
            }
            else if((whiteNum==1)&&(notNum==5))
            {
                for(int a = 0; a < 6; a++){
                    if(Gomoku.board[num+a].BW==N)
                    {
                        Gomoku.board[num+a].turnOn(1, Row);
                        // totRowWhite[num+a] += 1;
                    }
                }
            }
        }
    }

    void checkCol()
    {
		for(int n=0;n<19;n++)
		for(int i=0;i<14;i++)
        {
            int blackNum = 0;
            int whiteNum = 0;
            int notNum   = 0;

            int num = n+(19*i);

            for(int m=0;m<114;m+=19)
                if(Gomoku.board[num+m].BW==B) blackNum++;
                else if(Gomoku.board[num+m].BW==W) whiteNum++;
                else notNum++;

            if((blackNum==5)&&(notNum==1))
            {
                for(int a = 0; a  < 114; a += 19){
                    if(Gomoku.board[num+a].BW==N)
                    {
                        Gomoku.board[num+a].turnOn(5, Col);
                        // totColBlack[num+a] += 100000;
                    }
                }
            }
            else if((blackNum==4)&&(notNum==2)&&(Gomoku.turnB!=1))
            {
                for(int a = 0; a  < 114; a += 19){
                    if(Gomoku.board[num+a].BW==N)
                    {
                        Gomoku.board[num+a].turnOn(4, Col);    
                        // totColBlack[num+a] += 10000;
                    }   
                }
            }
            else if((blackNum==3)&&(notNum==3))
            {
                for(int a = 0; a  < 114; a += 19){
                    if(Gomoku.board[num+a].BW==N)
                    {
                        Gomoku.board[num+a].turnOn(3, Col);         
                        // totColBlack[num+a] += 100;
                    }   
                }
            }
            else if((blackNum==2)&&(notNum==4))
            {
                for(int a = 0; a  < 114; a += 19){
                    if(Gomoku.board[num+a].BW==N)
                    {
                        Gomoku.board[num+a].turnOn(2, Col);   
                        //totColBlack[num+a] += 10;
                    }   
                }
            }
            else if((blackNum==1)&&(notNum==5))
            {
                for(int a = 0; a  < 114; a += 19){
                    if(Gomoku.board[num+a].BW==N)
                    {
                        Gomoku.board[num+a].turnOn(1, Col);   
                        //totColBlack[num+a] += 1;
                    }   
                }
            }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            if((whiteNum==5)&&(notNum==1))
            {
                for(int a = 0; a  < 114; a += 19){
                    if(Gomoku.board[num+a].BW==N)
                    {
                        Gomoku.board[num+a].turnOn(5, Col);   
                        //totColWhite[num+a] += 100000;
                    }
                }
            }
            else if((whiteNum==4)&&(notNum==2)&&(Gomoku.turnW!=1))
            {
                for(int a = 0; a  < 114; a += 19){
                    if(Gomoku.board[num+a].BW==N)
                    {
                        Gomoku.board[num+a].turnOn(4, Col);   
                        //totColWhite[num+a] += 10000;
                    }   
                }
            }
            else if((whiteNum==3)&&(notNum==3))
            {
                for(int a = 0; a  < 114; a += 19){
                    if(Gomoku.board[num+a].BW==N)
                    {
                        Gomoku.board[num+a].turnOn(3, Col);   
                        //totColWhite[num+a] += 100;
                    }   
                }
            }
            else if((whiteNum==2)&&(notNum==4))
            {
                for(int a = 0; a  < 114; a += 19){
                    if(Gomoku.board[num+a].BW==N)
                    {
                        Gomoku.board[num+a].turnOn(2, Col);   
                        //totColWhite[num+a] += 10;
                    }
                }
            }
            else if((whiteNum==1)&&(notNum==5))
            {
                for(int a = 0; a  < 114; a += 19){  
                    if(Gomoku.board[num+a].BW==N)
                    {
                        Gomoku.board[num+a].turnOn(1, Col);   
                        //totColWhite[num+a] += 1;
                    }
                }
            }
        }
    }

    void checkSla()
    {
		for(int j=0;j<=247;j+=19)
		for(int n=5+j;n<19+j;n++)
        {
            int blackNum = 0;
            int whiteNum = 0;
            int notNum   = 0;

            int num = n;

            for(int m=0;m<108;m+=18)
                if(Gomoku.board[num+m].BW==B) blackNum++;
                else if(Gomoku.board[num+m].BW==W) whiteNum++;
                else notNum++;

            if((blackNum==5)&&(notNum==1))
            {
                for(int a = 0; a < 108 ; a += 18){
                    if(Gomoku.board[num+a].BW ==N)
                    {
                        Gomoku.board[num+a].turnOn(5, Sla);   
                        //totSlaBlack[num+a]+= 100000;
                    }
                }
            }
            else if((blackNum==4)&&(notNum==2)&&(Gomoku.turnB!=1))
            {
                for(int a = 0; a < 108 ; a += 18){
                    if(Gomoku.board[num+a].BW ==N)
                    {
                        Gomoku.board[num+a].turnOn(4, Sla);   
                        //totSlaBlack[num+a]+= 10000;
                    }
                }
            }
            else if((blackNum==3)&&(notNum==3))
            {
                for(int a = 0; a < 108 ; a += 18){
                    if(Gomoku.board[num+a].BW ==N)
                    {
                        Gomoku.board[num+a].turnOn(3, Sla);   
                        //totSlaBlack[num+a]+= 100;
                    }
                }
            }
            else if((blackNum==2)&&(notNum==4))
            {
                for(int a = 0; a < 108 ; a += 18){
                    if(Gomoku.board[num+a].BW ==N)
                    {
                        Gomoku.board[num+a].turnOn(2, Sla);   
                        //totSlaBlack[num+a]+= 10;
                    }
                }
            }
            else if((blackNum==1)&&(notNum==5))
            {
                for(int a = 0; a < 108 ; a += 18){
                    if(Gomoku.board[num+a].BW ==N)
                    {
                        Gomoku.board[num+a].turnOn(1, Sla);   
                        //totSlaBlack[num+a]+= 1;
                    }
                }
            }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            if((whiteNum==5)&&(notNum==1))
            {
                for(int a = 0; a < 108 ; a += 18){
                    if(Gomoku.board[num+a].BW ==N)
                    {
                        Gomoku.board[num+a].turnOn(5, Sla);   
                        //totSlaWhite[num+a]+= 100000;
                    }
                }
            }
            else if((whiteNum==4)&&(notNum==2)&&(Gomoku.turnW!=1))
            {
                for(int a = 0; a < 108 ; a += 18){
                    if(Gomoku.board[num+a].BW ==N)
                    {
                        Gomoku.board[num+a].turnOn(4, Sla);   
                        //totSlaWhite[num+a]+= 10000;
                    }
                }
            }
            else if((whiteNum==3)&&(notNum==3))
            {
                for(int a = 0; a < 108 ; a += 18){
                    if(Gomoku.board[num+a].BW ==N)
                    {
                        Gomoku.board[num+a].turnOn(3, Sla);   
                        //totSlaWhite[num+a]+= 100;
                    }
                }
            }
            else if((whiteNum==2)&&(notNum==4))
            {
                for(int a = 0; a < 108 ; a += 18){
                    if(Gomoku.board[num+a].BW ==N)
                    {
                        Gomoku.board[num+a].turnOn(2, Sla);   
                        //totSlaWhite[num+a]+= 10;
                    }
                }
            }
            else if((whiteNum==1)&&(notNum==5))
            {
                for(int a = 0; a < 108 ; a += 18){
                    if(Gomoku.board[num+a].BW ==N)
                    {
                        Gomoku.board[num+a].turnOn(1, Sla);   
                        //totSlaWhite[num+a]+= 1;
                    }
                }
            }
        }
    }


    void checkBackSla()
    {
		for(int i=0;i<=247;i+=19) 
		for(int n=i;n<(i+14);n++)
        {

            int blackNum = 0;
            int whiteNum = 0;
            int notNum   = 0;

            int num = n;
            
            for(int m=0;m<120;m+=20)
                if(Gomoku.board[num+m].BW==B) blackNum++;
                else if(Gomoku.board[num+m].BW==W) whiteNum++;
                else notNum++;
                


            
            if((blackNum==5)&&(notNum==1))
            {
                for(int a = 0; a < 120; a += 20){
                    if(Gomoku.board[num+a].BW==N)
                    {
                        Gomoku.board[num+a].turnOn(5, Bsl);   
                        //totBslBlack[num+a] += 100000;
                    }
                }
            }
            else if((blackNum==4)&&(notNum==2)&&(Gomoku.turnB!=1))
            {
                for(int a = 0; a < 120; a += 20){
                    if(Gomoku.board[num+a].BW==N)
                    {
                        Gomoku.board[num+a].turnOn(4, Bsl);
                        //totBslBlack[num+a] += 10000;
                    }
                }
            }
            else if((blackNum==3)&&(notNum==3))
            {
                for(int a = 0; a < 120; a += 20){
                    if(Gomoku.board[num+a].BW==N)
                    {
                        Gomoku.board[num+a].turnOn(3, Bsl);
                        //totBslBlack[num+a] += 100;
                    }
                }
            }
            else if((blackNum==2)&&(notNum==4))
            {
                for(int a = 0; a < 120; a += 20){
                    if(Gomoku.board[num+a].BW==N)
                    {
                        Gomoku.board[num+a].turnOn(2, Bsl);
                        //totBslBlack[num+a] += 10;
                    }
                }
            }    
            else if((blackNum==1)&&(notNum==5))
            {
                for(int a = 0; a < 120; a += 20){
                    if(Gomoku.board[num+a].BW==N)
                    {
                        Gomoku.board[num+a].turnOn(1, Bsl);
                        //totBslBlack[num+a] += 1;
                    }
                }
            }    
            
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            if((whiteNum==5)&&(notNum==1))
            {
                for(int a = 0; a < 120; a += 20){
                    if(Gomoku.board[num+a].BW==N)
                    {
                        Gomoku.board[num+a].turnOn(5, Bsl);
                        //totBslWhite[num+a] += 100000;
                    }
                }
            }
            else if((whiteNum==4)&&(notNum==2)&&(Gomoku.turnW!=1))
            {
                for(int a = 0; a < 120; a += 20){
                    if(Gomoku.board[num+a].BW==N)
                    {
                        Gomoku.board[num+a].turnOn(4, Bsl);
                        //totBslWhite[num+a] += 10000;
                    }
                }
            }
            else if((whiteNum==3)&&(notNum==3))
            {
                for(int a = 0; a < 120; a += 20){
                    if(Gomoku.board[num+a].BW==N)
                    {
                        Gomoku.board[num+a].turnOn(3, Bsl);
                        //totBslWhite[num+a] += 100;
                    }
                }
            }
            else if((whiteNum==2)&&(notNum==4))
            {
                for(int a = 0; a < 120; a += 20){
                    if(Gomoku.board[num+a].BW==N)
                    {
                        Gomoku.board[num+a].turnOn(2, Bsl); 
                        //totBslWhite[num+a] += 10;
                    }
                }
            }    
            else if((whiteNum==1)&&(notNum==5))
            {
                for(int a = 0; a < 120; a += 20){
                    if(Gomoku.board[num+a].BW==N)
                    {
                        Gomoku.board[num+a].turnOn(1, Bsl);
                        //totBslWhite[num+a] += 1;
                    }
                }
            }
        }
	}
    public int get_first_where() {
    	return first_where;
    }
}