import java.util.* ;
import javax.swing.* ;
import java.awt.*;
import java.awt.event.KeyListener;

public class Gomoku{

   private static final int B = 0;     // color black : 0
   private static final int W = 1;     // color white : 1
   private static final int N = -1;    // no stone    : -1
 
   public static Location [] board    = new Location[361]; //諛붾몣�뙋�뿉 �엳�뒗 �룎
   public static Location [] setboard = new Location[361]; //寃뚯엫�븷 �븣 �넃�� �룎

   public static boolean win = false ; //�듅�뙣�뿬遺� ���옣

   public static int k = 1;            // �쑀��媛� �넃�� �룎 媛��닔 : 1�씤 �씠�쑀�뒗 寃����깋 �룎 1媛쒕뒗 臾댁“嫄� �넃�뿬�엳湲� �븣臾�

   public static int turnW = 0;      //White turn
   public static int turnB = 0;      //Black turn
   public static Location User = new Location()  ; // Cursor瑜� �쐞�븳 Location媛앹껜 留뚮뱾�뼱二쇨린

   public static int userColor = N;   //store user's color 
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

      for(i=0; i<19; i++) //紐⑤뱺 Location�뿉 X,Y媛� 遺��뿬
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

    

      board[180].Setis(true) ;        // 寃����깋 �룎�� 泥섏쓬�뿉 媛��슫�뜲�뿉 臾댁“嫄� �넃�뿬�엳�뼱�빞 �븳�떎.  
      board[180].BW = B ; 
      setboard[0] = board[180] ;

      total_Score.setTotal(setboard[0]);
      total_Score.display();

      turnW = 2;                    // white has two turn in first
      System.out.println("Check");
         class Key implements KeyListener {
            public void keyPressed(java.awt.event.KeyEvent e) {
                  int code=e.getKeyCode();
                  switch(code){

                     case 38:
                     if(User.GetY() > 10) User.SetLocation(User.GetX(), User.GetY()-40);
                     frame.repaint();
                     win = Board.win;
                     break;

                     case 40:
                     if(User.GetY() < 730) User.SetLocation(User.GetX(), User.GetY()+40);
                     frame.repaint();
                     win = Board.win;
                     break;

                     case 37:
                     if(User.GetX() > 10) User.SetLocation(User.GetX()-40, User.GetY());
                     frame.repaint();
                     win = Board.win;
                     break;

                     case 39:
                     if(User.GetX() < 730) User.SetLocation(User.GetX()+40, User.GetY());
                     frame.repaint();
                     win = Board.win;
                     break;

                     case 32: 
                     setboard[k].SetLocation(User.GetX(),User.GetY()); // �넃�� �룎�쓽 �쐞移섎�� setboard 諛곗뿴�뿉 怨꾩냽 ���옣�빐以��떎.
                     for(int i=0;i<361;i++)
                        if((setboard[k].GetX()==board[i].GetX())&&
                           (setboard[k].GetY()==board[i].GetY()))

                           if(board[i].Getis() == false)
                           {
                              board[i].Setis(true);
                              

                              if(turnW > 0)
                              {
                                 board[i].BW = W;
                                 total_Score.setTotal(board[i]);
                                 turnW-- ;
                                 if(turnW == 0) turnB = 2;
                              }
                              else if(turnB > 0) 
                              {
                                 board[i].BW = B;
                                 total_Score.setTotal(board[i]);
                                 turnB-- ;
                                 if(turnB == 0) turnW = 2;
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
            	
            }
            

            public void keyTyped(java.awt.event.KeyEvent e) {   
            }
         }   
         frame.setVisible(true);
         frame.addKeyListener(new Key());
         return ;
   }
}
