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



    int [] total = new int[361];


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


        checkRow();
        checkCol();
        checkSla();
        checkBackSla();

         
    }

    void display(){


        int first_score = 0;
        System.out.print("\nScore Board\n");

        for(int i = 0; i < 20; i++)     System.out.printf("%5d ", i);

        for(int i = 0; i<361; i++)
        {
            
            if(i%19 == 0) System.out.printf("\n%5d", i/19+1);
            if(total[i] > first_score) {

                first_score = total[i];
                first_where = i;
            }
            
            System.out.printf("%5d ", total[i]);
        }

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
            

            if((blackNum==4||whiteNum==4)&&(notNum==2))
            {
                if(Gomoku.board[num+0].BW==N) total[num+0] += 100;
                if(Gomoku.board[num+1].BW==N) total[num+1] += 100;
                if(Gomoku.board[num+2].BW==N) total[num+2] += 100;
                if(Gomoku.board[num+3].BW==N) total[num+3] += 100;
                if(Gomoku.board[num+4].BW==N) total[num+4] += 100;
                if(Gomoku.board[num+5].BW==N) total[num+5] += 100;
            }
            else if((blackNum>=4||whiteNum>=4)&&(notNum==1))
            {
                if(Gomoku.board[num+0].BW==N) total[num+0] += 100;
                if(Gomoku.board[num+1].BW==N) total[num+1] += 100;
                if(Gomoku.board[num+2].BW==N) total[num+2] += 100;
                if(Gomoku.board[num+3].BW==N) total[num+3] += 100;
                if(Gomoku.board[num+4].BW==N) total[num+4] += 100;
                if(Gomoku.board[num+5].BW==N) total[num+5] += 100;
			}
        }

    }
    void checkCol()
    {
		for(int n=0;n<19;n++)
		for(int i=0;i<=247;i+=19)
        {
            int blackNum = 0;
            int whiteNum = 0;
            int notNum   = 0;

            int num = n+i;

            for(int m=0;m<114;m+=19)
                if(Gomoku.board[num+m].BW==B) blackNum++;
                else if(Gomoku.board[num+m].BW==W) whiteNum++;
                else notNum++;
            
            if((blackNum==4||whiteNum==4)&&(notNum==2))
            {
                if(Gomoku.board[num+0].BW==N)  total[num+0]  += 100;
                if(Gomoku.board[num+19].BW==N) total[num+19] += 100;
                if(Gomoku.board[num+38].BW==N) total[num+38] += 100;
                if(Gomoku.board[num+57].BW==N) total[num+57] += 100;
                if(Gomoku.board[num+76].BW==N) total[num+76] += 100;
                if(Gomoku.board[num+95].BW==N) total[num+95] += 100;
            }
            else if((blackNum>=4||whiteNum>=4)&&(notNum==1))
            {
                if(Gomoku.board[num+0].BW==N)  total[num+0]  += 100;
                if(Gomoku.board[num+19].BW==N) total[num+19] += 100;
                if(Gomoku.board[num+38].BW==N) total[num+38] += 100;
                if(Gomoku.board[num+57].BW==N) total[num+57] += 100;
                if(Gomoku.board[num+76].BW==N) total[num+76] += 100;
                if(Gomoku.board[num+95].BW==N) total[num+95] += 100;
            }
            
          
        }
    }
    void checkSla()
    {
		for(int j=0;j<=247;j+= 19)
		for(int n=6+j;n<19+j;n++)
        {
            int blackNum = 0;
            int whiteNum = 0;
            int notNum   = 0;

            int num = n;

            for(int m=0;m<108;m+=18)
                if(Gomoku.board[num+m].BW==B) blackNum++;
                else if(Gomoku.board[num+m].BW==W) whiteNum++;
                else notNum++;

            if((blackNum==4||whiteNum==4)&&(notNum==2))
            {
                if(Gomoku.board[num+0].BW==N)  total[num+0]  += 100;
                if(Gomoku.board[num+18].BW==N) total[num+18] += 100;
                if(Gomoku.board[num+36].BW==N) total[num+36] += 100;
                if(Gomoku.board[num+54].BW==N) total[num+54] += 100;
                if(Gomoku.board[num+72].BW==N) total[num+72] += 100;
                if(Gomoku.board[num+90].BW==N) total[num+90] += 100;

            }
            else if((blackNum>=4||whiteNum>=4)&&(notNum==1))
            {
                if(Gomoku.board[num+0].BW ==N) total[num+0]  += 100;
                if(Gomoku.board[num+18].BW==N) total[num+18] += 100;
                if(Gomoku.board[num+36].BW==N) total[num+36] += 100;
                if(Gomoku.board[num+54].BW==N) total[num+54] += 100;
                if(Gomoku.board[num+72].BW==N) total[num+72] += 100;
                if(Gomoku.board[num+90].BW==N) total[num+90] += 100;
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

            if((blackNum==4||whiteNum==4)&&(notNum==2))
            {
                if(Gomoku.board[num+0].BW==N)   total[num+0]  += 100;
                if(Gomoku.board[num+20].BW==N)  total[num+20] += 100;
                if(Gomoku.board[num+40].BW==N)  total[num+40] += 100;
                if(Gomoku.board[num+60].BW==N)  total[num+60] += 100;
                if(Gomoku.board[num+80].BW==N)  total[num+80] += 100;
                if(Gomoku.board[num+100].BW==N) total[num+100]+= 100;
            }
            else if((blackNum>=4||whiteNum>=4)&&(notNum==1))
            {
                if(Gomoku.board[num+0].BW==N)   total[num+0]  += 100;
                if(Gomoku.board[num+20].BW==N)  total[num+20] += 100;
                if(Gomoku.board[num+40].BW==N)  total[num+40] += 100;
                if(Gomoku.board[num+60].BW==N)  total[num+60] += 100;
                if(Gomoku.board[num+80].BW==N)  total[num+80] += 100;
                if(Gomoku.board[num+100].BW==N) total[num+100]+= 100;
            }
        }
	}
    public int get_first_where() {
    	return first_where;
    }
}