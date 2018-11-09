import java.util.* ;
import javax.swing.* ;
import java.awt.*;
import java.awt.event.KeyListener;

public class Gomoku{

   private static final int B = 0;     // color black : 0
   private static final int W = 1;     // color white : 1
   private static final int N = -1;    // no stone    : -1
 
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
      total_Score.display();

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


                  total_Score.display();
                  frame.repaint();
			if(Board.win) System.exit(0);

					 
                     break ;
                     default:
                     break;
               }
            }
            public void keyReleased(java.awt.event.KeyEvent e) {
                  

                  while(((userColor==B)&&(turnW>0))||((userColor==W)&&(turnB>0))) {
            		setboard[k].SetLocation((total_Score.get_first_where()%19+1)*40-30, (total_Score.get_first_where()/19+1)*40-30);
                    for(int i=0;i<361;i++)
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
                    total_Score.display();
                    frame.repaint();
					if(Board.win) System.exit(0);
            	}
            	
            }
            

            public void keyTyped(java.awt.event.KeyEvent e) {   
            }
         }   
         frame.setVisible(true);
         frame.addKeyListener(new Key());
         return ;
   }
}
