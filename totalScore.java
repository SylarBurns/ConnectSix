import java.util.* ;
import javax.swing.* ;
import java.awt.*;

class totalScore extends JPanel{

    private static final int B = 0;
	private static final int W = 1;
    private static final int N = -1;
    
    public int first_where = 0;
    
    scoreRowLeft  score_Row_L = new scoreRowLeft() ;
    scoreRowRight score_Row_R = new scoreRowRight();
    scoreColUp    score_Col_U = new scoreColUp()   ;
    scoreColDown  score_Col_D = new scoreColDown() ;
    scoreSlaUp    score_Sla_U = new scoreSlaUp()   ;
    scoreSlaDown  score_Sla_D = new scoreSlaDown() ;
    scoreBslUp    score_Bsl_U = new scoreBslUp()   ;
    scoreBslDown  score_Bsl_D = new scoreBslDown() ;



    int [] total    = new int[361];
    int [] totBlack = new int[361];
    int [] totWhite = new int[361];



    totalScore(){

        for(int i = 0 ; i <361 ; i++) total[i] = 0;

    }

    void setTotal(Location choice){

        score_Row_L.sum(choice);
        score_Row_R.sum(choice);
        score_Col_U.sum(choice);
        score_Col_D.sum(choice);
        score_Sla_U.sum(choice);
        score_Sla_D.sum(choice);
        score_Bsl_U.sum(choice);
        score_Bsl_D.sum(choice);



        for(int i = 0; i < 361 ; i++)
        {
            total[i] = score_Row_L.blackScore[i]
                     + score_Row_L.whiteScore[i]
                     + score_Row_R.blackScore[i]
                     + score_Row_R.whiteScore[i]
                     + score_Col_U.blackScore[i]
                     + score_Col_U.whiteScore[i]
                     + score_Col_D.blackScore[i]
                     + score_Col_D.whiteScore[i]
                     + score_Sla_U.blackScore[i]
                     + score_Sla_U.whiteScore[i]
                     + score_Sla_D.blackScore[i]
                     + score_Sla_D.whiteScore[i]
                     + score_Bsl_U.blackScore[i]
                     + score_Bsl_U.whiteScore[i]
                     + score_Bsl_D.blackScore[i]
                     + score_Bsl_D.whiteScore[i];

         totBlack[i] = score_Row_L.blackScore[i]
                     + score_Row_R.blackScore[i]
                     + score_Col_U.blackScore[i]
                     + score_Col_D.blackScore[i]
                     + score_Sla_U.blackScore[i]
                     + score_Sla_D.blackScore[i]
                     + score_Bsl_U.blackScore[i]
                     + score_Bsl_D.blackScore[i];


         totWhite[i] = score_Row_L.whiteScore[i]
                     + score_Row_R.whiteScore[i]
                     + score_Col_U.whiteScore[i]
                     + score_Col_D.whiteScore[i]
                     + score_Sla_U.whiteScore[i]
                     + score_Sla_D.whiteScore[i]
                     + score_Bsl_U.whiteScore[i]
                     + score_Bsl_D.whiteScore[i];
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
        int connectBlackThree = 0;
        int connectWhiteThree = 0;

        System.out.print("\nScore Board\n");

        for(int i = 0; i < 20; i++)     System.out.printf("%5d ", i);



        for(int i = 0; i<361; i++)
        {
            if(totBlack[i] >= 1000) connectBlackFive++;
            if(totWhite[i] >= 1000) connectWhiteFive++;
            if(totBlack[i] >= 400)  connectBlackFour++;
            if(totWhite[i] >= 400)  connectWhiteFour++;
            if(totBlack[i] >= 120)  connectBlackThree++;
            if(totWhite[i] >= 120)  connectWhiteThree++;
        }



        if((turn==B)&&(connectBlackFive >= 1))
        {
            for(int i = 0; i<361; i++)
            {
                if(i%19 == 0) System.out.printf("\n\n%5d", i/19+1);
    
    
                if(totBlack[i] > first_score) {
    
                    first_score = totBlack[i];
                    first_where = i;
                }
                System.out.printf("%5d ", totBlack[i]);
            }
        }
        else if((turn==W)&&(connectWhiteFive >= 1))
        {
            for(int i = 0; i<361; i++)
            {
                if(i%19 == 0) System.out.printf("\n\n%5d", i/19+1);
    
    
                if(totWhite[i] > first_score) {
    
                    first_score = totWhite[i];
                    first_where = i;
                }
                System.out.printf("%5d ", totWhite[i]);
            }
        }
        else if((turn==B)&&(connectBlackFour >= 2))
        {
            for(int i = 0; i<361; i++)
            {
                if(i%19 == 0) System.out.printf("\n\n%5d", i/19+1);
    
    
                if(totBlack[i] > first_score) {
    
                    first_score = totBlack[i];
                    first_where = i;
                }
                System.out.printf("%5d ", totBlack[i]);
            }
        }
        else if((turn==W)&&(connectWhiteFour >= 2))
        {
            for(int i = 0; i<361; i++)
            {
                if(i%19 == 0) System.out.printf("\n\n%5d", i/19+1);
    
    
                if(totWhite[i] > first_score) {
    
                    first_score = totWhite[i];
                    first_where = i;
                }
                System.out.printf("%5d ", totWhite[i]);
            }
        }
        else if((turn==B)&&(connectBlackThree > connectWhiteThree)&&(connectWhiteFive==0)&&(connectWhiteFour==0))
        {            
            for(int i = 0; i<361; i++)
            {
                if(i%19 == 0) System.out.printf("\n\n%5d", i/19+1);
    
    
                if(totBlack[i] > first_score) {
    
                    first_score = totBlack[i];
                    first_where = i;
                }
                System.out.printf("%5d ", totBlack[i]);
            }
        }
        else if((turn==W)&&(connectWhiteThree > connectBlackThree)&&(connectBlackFive==0)&&(connectBlackFour==0))
        {
            for(int i = 0; i<361; i++)
            {
                if(i%19 == 0) System.out.printf("\n\n%5d", i/19+1);
    
    
                if(totWhite[i] > first_score) {
    
                    first_score = totWhite[i];
                    first_where = i;
                }
                System.out.printf("%5d ", totWhite[i]);
            }
        }
        else 
        {
            for(int i = 0; i<361; i++)
            {
            if(i%19 == 0) System.out.printf("\n\n%5d", i/19+1);

            if(total[i] > first_score) {

                first_score = total[i];
                first_where = i;
            }
            System.out.printf("%5d ", total[i]);
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
                    if(Gomoku.board[num+a].BW==N){
                        total[num+a]    += 1000;
                        totBlack[num+a] += 1000;
                    }
                }
            }
            else if((blackNum==4)&&(notNum==2)&&(Gomoku.turnB!=1))
            {
                for(int a = 0; a < 6; a++){
                    if(Gomoku.board[num+a].BW==N){
                        total[num+a]    += 400;
                        totBlack[num+a] += 400;
                    }
                }
            }
            else if((blackNum==3)&&(notNum==3))
            {
                for(int a = 0; a < 6; a++){
                    if(Gomoku.board[num+a].BW==N){
                        total[num+a]    += 40;
                        totBlack[num+a] += 40;
                    }
                }
            }
            else if((blackNum==2)&&(notNum==4))
            {
                for(int a = 0; a < 6; a++){
                    if(Gomoku.board[num+a].BW==N){
                        total[num+a]    += 10;
                        totBlack[num+a] += 10;
                    }
                }
            }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            
            if((whiteNum==5)&&(notNum==1))
            {
                for(int a = 0; a < 6; a++){
                    if(Gomoku.board[num+a].BW==N){
                        total[num+a]    += 1000;
                        totWhite[num+a] += 1000;
                    }
                }
            }
            else if((whiteNum==4)&&(notNum==2)&&(Gomoku.turnW!=1))
            {
                for(int a = 0; a < 6; a++){
                    if(Gomoku.board[num+a].BW==N){
                        total[num+a]    += 400;
                        totWhite[num+a] += 400;
                    }
                }
            }
            else if((whiteNum==3)&&(notNum==3))
            {
                for(int a = 0; a < 6; a++){
                    if(Gomoku.board[num+a].BW==N){
                        total[num+a]    += 40;
                        totWhite[num+a] += 40;
                    }
                }
            }
            else if((whiteNum==2)&&(notNum==4))
            {
                for(int a = 0; a < 6; a++){
                    if(Gomoku.board[num+a].BW==N){
                        total[num+a]    += 10;
                        totWhite[num+a] += 10;
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
                    if(Gomoku.board[num+a].BW==N){
                        total[num+a]    += 1000;
                        totBlack[num+a] += 1000;
                    }
                }
            }
            else if((blackNum==4)&&(notNum==2)&&(Gomoku.turnB!=1)){
                for(int a = 0; a  < 114; a += 19){
                    if(Gomoku.board[num+a].BW==N){
                        total[num+a]    += 400;
                        totBlack[num+a] += 400;
                    }   
                }
            }
            else if((blackNum==3)&&(notNum==3))
            {
                for(int a = 0; a  < 114; a += 19){
                    if(Gomoku.board[num+a].BW==N){
                        total[num+a]    += 40;
                        totBlack[num+a] += 40;
                    }   
                }
            }
            else if((blackNum==2)&&(notNum==4))
            {
                for(int a = 0; a  < 114; a += 19){
                    if(Gomoku.board[num+a].BW==N){
                        total[num+a]    += 10;
                        totBlack[num+a] += 10;
                    }   
                }
            }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            if((whiteNum==5)&&(notNum==1))
            {
                for(int a = 0; a  < 114; a += 19){
                    if(Gomoku.board[num+a].BW==N){
                        total[num+a]    += 1000;
                        totWhite[num+a] += 1000;
                    }
                }
            }
            else if((whiteNum==4)&&(notNum==2)&&(Gomoku.turnW!=1)){
                for(int a = 0; a  < 114; a += 19){
                    if(Gomoku.board[num+a].BW==N){
                        total[num+a]    += 400;
                        totWhite[num+a] += 400;
                    }   
                }
            }
            else if((whiteNum==3)&&(notNum==3))
            {
                for(int a = 0; a  < 114; a += 19){
                    if(Gomoku.board[num+a].BW==N){
                        total[num+a]    += 40;
                        totWhite[num+a] += 40;
                    }   
                }
            }
            else if((whiteNum==2)&&(notNum==4))
            {
                for(int a = 0; a  < 114; a += 19){
                    if(Gomoku.board[num+a].BW==N){
                        total[num+a]    += 10;
                        totWhite[num+a] += 10;
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
                    if(Gomoku.board[num+a].BW ==N){
                         total[num+a]   += 1000;
                         totBlack[num+a]+= 1000;
                    }
                }
            }
            else if((blackNum==4)&&(notNum==2)&&(Gomoku.turnB!=1)){
                for(int a = 0; a < 108 ; a += 18){
                    if(Gomoku.board[num+a].BW ==N){
                        total[num+a]   += 400;
                        totBlack[num+a]+= 400;
                    }
                }
            }
            else if((blackNum==3)&&(notNum==3))
            {
                for(int a = 0; a < 108 ; a += 18){
                    if(Gomoku.board[num+a].BW ==N){
                        total[num+a]   += 40;
                        totBlack[num+a]+= 40;
                    }
                }
            }
            else if((blackNum==2)&&(notNum==4))
            {
                for(int a = 0; a < 108 ; a += 18){
                    if(Gomoku.board[num+a].BW ==N){
                        total[num+a]   += 10;
                        totBlack[num+a]+= 10;
                    }
                }
            }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            if((whiteNum==5)&&(notNum==1))
            {
                for(int a = 0; a < 108 ; a += 18){
                    if(Gomoku.board[num+a].BW ==N){
                         total[num+a]   += 1000;
                         totWhite[num+a]+= 1000;
                    }
                }
            }
            else if((whiteNum==4)&&(notNum==2)&&(Gomoku.turnW!=1)){
                for(int a = 0; a < 108 ; a += 18){
                    if(Gomoku.board[num+a].BW ==N){
                        total[num+a]   += 400;
                        totWhite[num+a]+= 400;
                    }
                }
            }
            else if((whiteNum==3)&&(notNum==3))
            {
                for(int a = 0; a < 108 ; a += 18){
                    if(Gomoku.board[num+a].BW ==N){
                        total[num+a]   += 40;
                        totWhite[num+a]+= 40;
                    }
                }
            }
            else if((whiteNum==2)&&(notNum==4))
            {
                for(int a = 0; a < 108 ; a += 18){
                    if(Gomoku.board[num+a].BW ==N){
                        total[num+a]   += 10;
                        totWhite[num+a]+= 10;
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
                    if(Gomoku.board[num+a].BW==N){
                        total[num+a]    += 1000;
                        totBlack[num+a] += 1000;
                    }
                }
            }
            else if((blackNum==4)&&(notNum==2)&&(Gomoku.turnB!=1)){

                for(int a = 0; a < 120; a += 20){
                    if(Gomoku.board[num+a].BW==N){
                        total[num+a]    += 400;
                        totBlack[num+a] += 400;
                    }
                }
            }
            else if((blackNum==3)&&(notNum==3))
            {
                for(int a = 0; a < 120; a += 20){
                    if(Gomoku.board[num+a].BW==N){
                        total[num+a]    += 40;
                        totBlack[num+a] += 40;
                    }
                }
            }
            else if((blackNum==2)&&(notNum==4))
            {
                for(int a = 0; a < 120; a += 20){
                    if(Gomoku.board[num+a].BW==N){
                        total[num+a]    += 10;
                        totBlack[num+a] += 10;
                    }
                }
            }    
            
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            if((whiteNum==5)&&(notNum==1))
            {
                for(int a = 0; a < 120; a += 20){
                    if(Gomoku.board[num+a].BW==N){
                        total[num+a]    += 1000;
                        totWhite[num+a] += 1000;
                    }
                }
            }
            else if((whiteNum==4)&&(notNum==2)&&(Gomoku.turnW!=1)){

                for(int a = 0; a < 120; a += 20){
                    if(Gomoku.board[num+a].BW==N){
                        total[num+a]    += 400;
                        totWhite[num+a] += 400;
                    }
                }
            }
            else if((whiteNum==3)&&(notNum==3))
            {
                for(int a = 0; a < 120; a += 20){
                    if(Gomoku.board[num+a].BW==N){
                        total[num+a]    += 40;
                        totWhite[num+a] += 40;
                    }
                }
            }
            else if((whiteNum==2)&&(notNum==4))
            {
                for(int a = 0; a < 120; a += 20){
                    if(Gomoku.board[num+a].BW==N){
                        total[num+a]    += 10;
                        totWhite[num+a] += 10;
                    }
                }
            }    
        }
	}
    public int get_first_where() {
    	return first_where;
    }
}