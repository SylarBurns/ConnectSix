import java.util.* ;
import javax.swing.* ;
import java.awt.*;
import java.awt.event.KeyListener;

public class Gomoku{

   private static final int B = 0;     // color black : 0
   private static final int W = 1;     // color white : 1
   private static final int N = -1;    // no stone    : -1
   private static final int Row = 2 ;
   private static final int Col = 3 ;
   private static final int Sla = 4 ;
   private static final int Bsl = 5 ;
       
   public int first_where = 0;

   public static Location [] board    = new Location[361]; //바둑판에 있는 돌
   public static Location [] setboard = new Location[361]; //게임할 때 놓은 돌

   public static boolean win = false ; //승패여부 저장

   public static int k = 1;            // 유저가 놓은 돌 갯수 : 1인 이유는 검은색 돌 1개는 무조건 놓여있기 때문

   public static int turnW = 2;      //White turn
   public static int turnB = 0;      //Black turn

   public static Location User = new Location()  ; //  Cursor를 위한 Location객체 만들어주기

   public static int userColor = N;   //store user's color 
   public static int AIColor = N ;
   static totalScore total_Score = new totalScore();


   public static void main(String[] args){

      while(true){      //Select User's color not AI color
         System.out.println("\nSelect Your color(B or W) : ");
         Scanner t = new Scanner(System.in);

         char stoneColor = t.next().charAt(0) ;
         if(stoneColor == 'B')      
         {
            userColor = B ;
            System.out.println("Black") ;
            break;
         }
         else if(stoneColor == 'W')
         {
            userColor = W ;
            System.out.println("White") ;
            break;
         }else{
            System.out.println("Wrong Input. Enter Again!");
         }
      }

 

      if(userColor == B) AIColor = W;
      else               AIColor = B;



      JFrame frame = new JFrame("Gomoku") ;
      Board GB = new Board();
      frame.add(GB);
      frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE) ;
      
      frame.setSize(1100, 1100) ;
      frame.setFocusable(true);
      
      int num  = 0 ;
      int numx = 0 ;
      int numy = 0 ;
      int i,j ;

      for(i=0; i<19; i++) //모든 Location에 X,Y값 부여
         for(j=0; j<19; j++){

            num = (i*19) + j  ;
            numx = 10 +(40*j) ;
            numy = 10 +(40*i) ;

            board[num] = new Location() ;
            board[num].SetLocation(numx, numy) ;
            board[num].Setis(false) ;

            setboard[num] = new Location() ;
            setboard[num].Setis(false) ;
         }
      
      User.SetLocation(370, 370);
      int keycode = 0 ;
      ck c1 = new ck();

    

      board[180].Setis(true) ;        // 검은색 돌은 처음에 가운데에 무조건 놓여있어야 한다.    
      board[180].BW = B ; 
      setboard[0] = board[180] ;
      total_Score.setTotal(setboard[0]);
      checkRow();
      checkCol();
      checkSla();
      checkBackSla();
      calculate();

      total_Score.display();
      if(AIColor == W)
      {
            board[178].Setis(true) ;
            board[178].BW = W ;
            setboard[1] = board[178] ;
            turnW-- ;
            k++ ;
            total_Score.setTotal(setboard[1]) ;
            total_Score.display() ;
            board[160].Setis(true) ;
            board[160].BW = W ;
            setboard[2] = board[160] ;
            turnW-- ;
            k++ ;
            total_Score.setTotal(setboard[2]) ;
            total_Score.display() ;
            turnB += 2 ;
            checkRow();
            checkCol();
            checkSla();
            checkBackSla();
            calculate();
      }



      System.out.println("Check");
      


         class Key implements KeyListener {

            public void keyPressed(java.awt.event.KeyEvent e) {
                  int code=e.getKeyCode();
                  switch(code){

                  
                  //    case 88 :
                  //       if(AIColor == B){

                  //             if(turnB>0){
                  //                   total_Score.setTotal(AI.turn(k, total_Score.first_where));
                  //                   turnB-- ;
                  //                   if(turnB == 0) turnW = 2;
                  //                   k++;
                  //                   total_Score.display();
                  //                   frame.repaint();
                  //                   if(Board.win) System.exit(0);
                  //             }

                  //       }else{

                  //             if(turnW>0){
                  //                   total_Score.setTotal(AI.turn(k, total_Score.first_where));
                  //                   turnW-- ;
                  //                   if(turnW == 0) turnB = 2;
                  //                   k++;
                  //                   total_Score.display();
                  //                   frame.repaint();
                  //                   if(Board.win) System.exit(0);
                  //             }    

                  //       }

                  //    break;

                        case 38 :
                        if(User.GetY() > 10) User.SetLocation(User.GetX(), User.GetY()-40);
                        frame.repaint();
                        win = Board.win;
                        break;

                        case 40 :
                        if(User.GetY() < 730) User.SetLocation(User.GetX(), User.GetY()+40);
                        frame.repaint();
                        win = Board.win;
                        break;

                        case 37 :
                        if(User.GetX() > 10) User.SetLocation(User.GetX()-40, User.GetY());
                        frame.repaint();
                        win = Board.win;
                        break;

                        case 39 :
                        if(User.GetX() < 730) User.SetLocation(User.GetX()+40, User.GetY());
                        frame.repaint();
                        win = Board.win;
                        break;

                        case 32 : 
                        setboard[k].SetLocation(User.GetX(),User.GetY()); // 놓은 돌의 위치를 setboard 배열에 계속 저장해준다.
                        for(int i=0;i<361;i++)
                        { 
                        if((setboard[k].GetX()==board[i].GetX())&&
                              (setboard[k].GetY()==board[i].GetY()))

                              if(board[i].Getis() == false)
                              {
                                    board[i].Setis(true);
                              
                                    if(turnW > 0)
                                    {
                                          board[i].BW = W;
                                          turnW-- ;
                                          if(turnW == 0) turnB = 2;
                                          total_Score.setTotal(board[i]);
                                    }
                                    else if(turnB > 0) 
                                    {
                                          board[i].BW = B;
                                          turnB-- ;
                                          if(turnB == 0) turnW = 2;
                                          total_Score.setTotal(board[i]);
                                    }

                                    k++;
                              }
                        }

                        turnOff();
                        checkRow();
                        checkCol();
                        checkSla();
                        checkBackSla();
                        calculate();


                  total_Score.display();
                  frame.repaint();
			if(Board.win) System.exit(0);

					 
                     break ;
                     default:
                     break;
               }
            }
            public void keyReleased(java.awt.event.KeyEvent e) {
                  

                  // while(((userColor==B)&&(turnW>0))||((userColor==W)&&(turnB>0))) {
            	// 	setboard[k].SetLocation((total_Score.get_first_where()%19+1)*40-30, (total_Score.get_first_where()/19+1)*40-30);
                  //   for(int i=0;i<361;i++)
                  //       if((setboard[k].GetX()==board[i].GetX())&&
                  //          (setboard[k].GetY()==board[i].GetY()))
                  //           if(board[i].Getis() == false)
                  //           {
                  //              board[i].Setis(true);
                               
                  //               if(turnW > 0)
                  //              {
                  //                 board[i].BW = W;
                  //                 turnW-- ;
                  //                 if(turnW == 0) turnB = 2;
                  //                 total_Score.setTotal(board[i]);
                  //              }
                  //              else if(turnB > 0) 
                  //              {
                  //                 board[i].BW = B;
                  //                 turnB-- ;
                  //                 if(turnB == 0) turnW = 2;
                  //                 total_Score.setTotal(board[i]);
                  //              }
                  //               k++;
                  //           }
                  //   total_Score.display();
                  //   frame.repaint();
			// 		if(Board.win) System.exit(0);
            	// }
            	
            }
            

            public void keyTyped(java.awt.event.KeyEvent e) {   
            }
         }   
         frame.setVisible(true);
         frame.addKeyListener(new Key());
         return ;
   }

   public static void calculate(){
         for(int i = 0; i < 361; i++) board[i].calculate();
   }

   public static void turnOff(){
      for(int i = 0; i < 361; i++) board[i].turnOff();
   }
   public static void checkRow()
   {
       for(int n=0;n<19;n++)
           for(int i=0;i<14;i++)
           {
           int blackNum = 0;
           int whiteNum = 0;
           int notNum   = 0;

           int num = (n*19)+i ;

           for(int m=0;m<6;m++)
               if(board[num+m].BW==B) blackNum++;
               else if(board[num+m].BW==W) whiteNum++;
               else notNum++;

           
           if((blackNum==5)&&(notNum==1))
           {
               for(int a = 0; a < 6; a++){
                   if(board[num+a].BW==N)
                   {
                       board[num+a].turnOn(5, Row);
                       // totRowBlack[num+a] += 100000;
                   }
               }
           }
           else if((blackNum==4)&&(notNum==2)&&(Gomoku.turnB!=1))
           {
               for(int a = 0; a < 6; a++){
                   if(board[num+a].BW==N)
                   {
                       board[num+a].turnOn(4, Row);
                       // totRowBlack[num+a] += 10000;
                   }
               }
           }
           else if((blackNum==3)&&(notNum==3))
           {
               for(int a = 0; a < 6; a++){
                   if(board[num+a].BW==N)
                   {
                       board[num+a].turnOn(3, Row);
                       // totRowBlack[num+a] += 100;
                   }
               }
           }
           else if((blackNum==2)&&(notNum==4))
           {
               for(int a = 0; a < 6; a++){
                   if(board[num+a].BW==N)
                   {
                       board[num+a].turnOn(2, Row);
                       // totRowBlack[num+a] += 10;
                   }
               }
           }
           else if((blackNum==1)&&(notNum==5))
           {
               for(int a = 0; a < 6; a++){
                   if(board[num+a].BW==N)
                   {
                       board[num+a].turnOn(1, Row);
                       // totRowlack[num+a] += 1;
                   }
               }
           }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
           
           if((whiteNum==5)&&(notNum==1))
           {
               for(int a = 0; a < 6; a++){
                   if(board[num+a].BW==N)
                   {
                       board[num+a].turnOn(5, Row);
                       // totRowWhite[num+a] += 100000;
                   }
               }
           }
           else if((whiteNum==4)&&(notNum==2)&&(Gomoku.turnW!=1))
           {
               for(int a = 0; a < 6; a++){
                   if(board[num+a].BW==N)
                   {
                       board[num+a].turnOn(4, Row);
                       // totRowWhite[num+a] += 10000;
                   }
               }
           }
           else if((whiteNum==3)&&(notNum==3))
           {
               for(int a = 0; a < 6; a++){
                   if(board[num+a].BW==N)
                   {
                       board[num+a].turnOn(3, Row);
                       // totRowWhite[num+a] += 100;
                   }
               }
           }
           else if((whiteNum==2)&&(notNum==4))
           {
               for(int a = 0; a < 6; a++){
                   if(board[num+a].BW==N)
                   {
                       board[num+a].turnOn(2, Row);    
                       // totRowWhite[num+a] += 10;
                   }
               }
           }
           else if((whiteNum==1)&&(notNum==5))
           {
               for(int a = 0; a < 6; a++){
                   if(board[num+a].BW==N)
                   {
                       board[num+a].turnOn(1, Row);
                       // totRowWhite[num+a] += 1;
                   }
               }
           }
       }
   }

   public static void checkCol()
   {
           for(int n=0;n<19;n++)
           for(int i=0;i<14;i++)
       {
           int blackNum = 0;
           int whiteNum = 0;
           int notNum   = 0;

           int num = n+(19*i);

           for(int m=0;m<114;m+=19)
               if(board[num+m].BW==B) blackNum++;
               else if(board[num+m].BW==W) whiteNum++;
               else notNum++;

           if((blackNum==5)&&(notNum==1))
           {
               for(int a = 0; a  < 114; a += 19){
                   if(board[num+a].BW==N)
                   {
                       board[num+a].turnOn(5, Col);
                       // totColBlack[num+a] += 100000;
                   }
               }
           }
           else if((blackNum==4)&&(notNum==2)&&(Gomoku.turnB!=1))
           {
               for(int a = 0; a  < 114; a += 19){
                   if(board[num+a].BW==N)
                   {
                       board[num+a].turnOn(4, Col);    
                       // totColBlack[num+a] += 10000;
                   }   
               }
           }
           else if((blackNum==3)&&(notNum==3))
           {
               for(int a = 0; a  < 114; a += 19){
                   if(board[num+a].BW==N)
                   {
                       board[num+a].turnOn(3, Col);         
                       // totColBlack[num+a] += 100;
                   }   
               }
           }
           else if((blackNum==2)&&(notNum==4))
           {
               for(int a = 0; a  < 114; a += 19){
                   if(board[num+a].BW==N)
                   {
                       board[num+a].turnOn(2, Col);   
                       //totColBlack[num+a] += 10;
                   }   
               }
           }
           else if((blackNum==1)&&(notNum==5))
           {
               for(int a = 0; a  < 114; a += 19){
                   if(board[num+a].BW==N)
                   {
                       board[num+a].turnOn(1, Col);   
                       //totColBlack[num+a] += 1;
                   }   
               }
           }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

           if((whiteNum==5)&&(notNum==1))
           {
               for(int a = 0; a  < 114; a += 19){
                   if(board[num+a].BW==N)
                   {
                       board[num+a].turnOn(5, Col);   
                       //totColWhite[num+a] += 100000;
                   }
               }
           }
           else if((whiteNum==4)&&(notNum==2)&&(Gomoku.turnW!=1))
           {
               for(int a = 0; a  < 114; a += 19){
                   if(board[num+a].BW==N)
                   {
                       board[num+a].turnOn(4, Col);   
                       //totColWhite[num+a] += 10000;
                   }   
               }
           }
           else if((whiteNum==3)&&(notNum==3))
           {
               for(int a = 0; a  < 114; a += 19){
                   if(board[num+a].BW==N)
                   {
                       board[num+a].turnOn(3, Col);   
                       //totColWhite[num+a] += 100;
                   }   
               }
           }
           else if((whiteNum==2)&&(notNum==4))
           {
               for(int a = 0; a  < 114; a += 19){
                   if(board[num+a].BW==N)
                   {
                       board[num+a].turnOn(2, Col);   
                       //totColWhite[num+a] += 10;
                   }
               }
           }
           else if((whiteNum==1)&&(notNum==5))
           {
               for(int a = 0; a  < 114; a += 19){  
                   if(board[num+a].BW==N)
                   {
                       board[num+a].turnOn(1, Col);   
                       //totColWhite[num+a] += 1;
                   }
               }
           }
       }
   }

   public static void checkSla()
   {
           for(int j=0;j<=247;j+=19)
           for(int n=5+j;n<19+j;n++)
       {
           int blackNum = 0;
           int whiteNum = 0;
           int notNum   = 0;

           int num = n;

           for(int m=0;m<108;m+=18)
               if(board[num+m].BW==B) blackNum++;
               else if(board[num+m].BW==W) whiteNum++;
               else notNum++;

           if((blackNum==5)&&(notNum==1))
           {
               for(int a = 0; a < 108 ; a += 18){
                   if(board[num+a].BW ==N)
                   {
                       board[num+a].turnOn(5, Sla);   
                       //totSlaBlack[num+a]+= 100000;
                   }
               }
           }
           else if((blackNum==4)&&(notNum==2)&&(Gomoku.turnB!=1))
           {
               for(int a = 0; a < 108 ; a += 18){
                   if(board[num+a].BW ==N)
                   {
                       board[num+a].turnOn(4, Sla);   
                       //totSlaBlack[num+a]+= 10000;
                   }
               }
           }
           else if((blackNum==3)&&(notNum==3))
           {
               for(int a = 0; a < 108 ; a += 18){
                   if(board[num+a].BW ==N)
                   {
                       board[num+a].turnOn(3, Sla);   
                       //totSlaBlack[num+a]+= 100;
                   }
               }
           }
           else if((blackNum==2)&&(notNum==4))
           {
               for(int a = 0; a < 108 ; a += 18){
                   if(board[num+a].BW ==N)
                   {
                       board[num+a].turnOn(2, Sla);   
                       //totSlaBlack[num+a]+= 10;
                   }
               }
           }
           else if((blackNum==1)&&(notNum==5))
           {
               for(int a = 0; a < 108 ; a += 18){
                   if(board[num+a].BW ==N)
                   {
                       board[num+a].turnOn(1, Sla);   
                       //totSlaBlack[num+a]+= 1;
                   }
               }
           }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

           if((whiteNum==5)&&(notNum==1))
           {
               for(int a = 0; a < 108 ; a += 18){
                   if(board[num+a].BW ==N)
                   {
                       board[num+a].turnOn(5, Sla);   
                       //totSlaWhite[num+a]+= 100000;
                   }
               }
           }
           else if((whiteNum==4)&&(notNum==2)&&(Gomoku.turnW!=1))
           {
               for(int a = 0; a < 108 ; a += 18){
                   if(board[num+a].BW ==N)
                   {
                       board[num+a].turnOn(4, Sla);   
                       //totSlaWhite[num+a]+= 10000;
                   }
               }
           }
           else if((whiteNum==3)&&(notNum==3))
           {
               for(int a = 0; a < 108 ; a += 18){
                   if(board[num+a].BW ==N)
                   {
                       board[num+a].turnOn(3, Sla);   
                       //totSlaWhite[num+a]+= 100;
                   }
               }
           }
           else if((whiteNum==2)&&(notNum==4))
           {
               for(int a = 0; a < 108 ; a += 18){
                   if(board[num+a].BW ==N)
                   {
                       board[num+a].turnOn(2, Sla);   
                       //totSlaWhite[num+a]+= 10;
                   }
               }
           }
           else if((whiteNum==1)&&(notNum==5))
           {
               for(int a = 0; a < 108 ; a += 18){
                   if(board[num+a].BW ==N)
                   {
                       board[num+a].turnOn(1, Sla);   
                       //totSlaWhite[num+a]+= 1;
                   }
               }
           }
       }
   }


   public static void checkBackSla()
   {
           for(int i=0;i<=247;i+=19) 
           for(int n=i;n<(i+14);n++)
       {

           int blackNum = 0;
           int whiteNum = 0;
           int notNum   = 0;

           int num = n;
           
           for(int m=0;m<120;m+=20)
               if(board[num+m].BW==B) blackNum++;
               else if(board[num+m].BW==W) whiteNum++;
               else notNum++;
               


           
           if((blackNum==5)&&(notNum==1))
           {
               for(int a = 0; a < 120; a += 20){
                   if(board[num+a].BW==N)
                   {
                       board[num+a].turnOn(5, Bsl);   
                       //totBslBlack[num+a] += 100000;
                   }
               }
           }
           else if((blackNum==4)&&(notNum==2)&&(Gomoku.turnB!=1))
           {
               for(int a = 0; a < 120; a += 20){
                   if(board[num+a].BW==N)
                   {
                       board[num+a].turnOn(4, Bsl);
                       //totBslBlack[num+a] += 10000;
                   }
               }
           }
           else if((blackNum==3)&&(notNum==3))
           {
               for(int a = 0; a < 120; a += 20){
                   if(board[num+a].BW==N)
                   {
                       board[num+a].turnOn(3, Bsl);
                       //totBslBlack[num+a] += 100;
                   }
               }
           }
           else if((blackNum==2)&&(notNum==4))
           {
               for(int a = 0; a < 120; a += 20){
                   if(board[num+a].BW==N)
                   {
                       board[num+a].turnOn(2, Bsl);
                       //totBslBlack[num+a] += 10;
                   }
               }
           }    
           else if((blackNum==1)&&(notNum==5))
           {
               for(int a = 0; a < 120; a += 20){
                   if(board[num+a].BW==N)
                   {
                       board[num+a].turnOn(1, Bsl);
                       //totBslBlack[num+a] += 1;
                   }
               }
           }    
           
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

           if((whiteNum==5)&&(notNum==1))
           {
               for(int a = 0; a < 120; a += 20){
                   if(board[num+a].BW==N)
                   {
                       board[num+a].turnOn(5, Bsl);
                       //totBslWhite[num+a] += 100000;
                   }
               }
           }
           else if((whiteNum==4)&&(notNum==2)&&(Gomoku.turnW!=1))
           {
               for(int a = 0; a < 120; a += 20){
                   if(board[num+a].BW==N)
                   {
                       board[num+a].turnOn(4, Bsl);
                       //totBslWhite[num+a] += 10000;
                   }
               }
           }
           else if((whiteNum==3)&&(notNum==3))
           {
               for(int a = 0; a < 120; a += 20){
                   if(board[num+a].BW==N)
                   {
                       board[num+a].turnOn(3, Bsl);
                       //totBslWhite[num+a] += 100;
                   }
               }
           }
           else if((whiteNum==2)&&(notNum==4))
           {
               for(int a = 0; a < 120; a += 20){
                   if(board[num+a].BW==N)
                   {
                       board[num+a].turnOn(2, Bsl); 
                       //totBslWhite[num+a] += 10;
                   }
               }
           }    
           else if((whiteNum==1)&&(notNum==5))
           {
               for(int a = 0; a < 120; a += 20){
                   if(board[num+a].BW==N)
                   {
                       board[num+a].turnOn(1, Bsl);
                       //totBslWhite[num+a] += 1;
                   }
               }
           }
       }
     }

   public int get_first_where() 
   {
         return first_where;
   }



}
