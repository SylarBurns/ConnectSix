import java.util.* ;
import javax.swing.* ;
import java.awt.*;

public class Gomoku{

	private static final int B = 0;  // color black : 0
	private static final int W = 1;  // color white : 1
	private static final int N = -1; // no stone    : -1
 
	public static Location [] board    = new Location[361]; //바둑판에 있는 돌
	public static Location [] setboard = new Location[361]; //게임할 때 놓은 돌

	public static int StoneX = 370; //cursur 처음 위치
	public static int StoneY = 370;

	public static boolean win = false ; //승패여부 저장

	public static int k = 1;   		// 유저가 놓은 돌 갯수 : 1인 이유는 검은색 돌 1개는 무조건 놓여있기 때문

	public static int turnW = 0;	//White turn
	public static int turnB = 0;	//Black turn

	public static int userColor = N;//store user's color 



	public static void main(String[] args){

		while(true){		//Select User's color not AI color
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
		frame.getContentPane().add(GB) ;
		
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE) ;
		frame.setSize(1100, 1100) ;
		frame.setVisible(true) ;
		


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
		
		Location User = new Location()  ; // Cursor를 위한 Location객체 만들어주기
		User.SetLocation(StoneX, StoneY);
		int keycode = 0 ;
		ck c1 = new ck();

		// scoreRow sr = new scoreRow();  testing
		// scoreCol sc = new scoreCol();
		totalScore total_Score = new totalScore();

		board[180].Setis(true) ; 		 // 검은색 돌은 처음에 가운데에 무조건 놓여있어야 한다. 
		board[180].BW = B ; 
		setboard[0] = board[180] ;
		// sr.sum(setboard[0]) ; 	testing
		// sc.sum(setboard[0]) ;
		total_Score.setTotal(setboard[0]);

		turnW = 2;  						// white has two turn in first


			while(win != true){

				// if(){



				// }
				// else if(){

				// }

				/* 커서 움직이기 하지만 개선이 되어야 한다!!! */
				Scanner s = new Scanner(System.in);

				keycode = s.next().charAt(0);

				switch(keycode){

					case 'w':
					if(StoneY > 10) StoneY = StoneY - 40;
					
					User.SetLocation(StoneX, StoneY);
					break;

					case 's':

					if(StoneY < 730) StoneY = StoneY + 40;
					
					User.SetLocation(StoneX, StoneY);
					break;

					case 'a':

					if(StoneX > 10) StoneX = StoneX - 40;
					
					User.SetLocation(StoneX, StoneY);
					break;

					case 'd':

					if(StoneX < 730) StoneX = StoneX + 40;
					
					User.SetLocation(StoneX, StoneY);
					break;

					case 'x': 

					setboard[k].SetLocation(User.GetX(),User.GetY()); // 놓은 돌의 위치를 setboard 배열에 계속 저장해준다.

					for(i=0;i<361;i++)
						if((setboard[k].GetX()==board[i].GetX())&&
						   (setboard[k].GetY()==board[i].GetY()))

							if(board[i].Getis() == false)
							{
								board[i].Setis(true);
								

								if(turnW > 0)
								{
									board[i].BW = W;
									// sr.sum(board[i]);	testing
									// sc.sum(board[i]);
									total_Score.setTotal(board[i]);
									turnW-- ;
									if(turnW == 0) turnB = 2;
								}
								else if(turnB > 0) 
								{
									board[i].BW = B;
									// sr.sum(board[i]);	testing
									// sc.sum(board[i]);
									total_Score.setTotal(board[i]);
									turnB-- ;
									if(turnB == 0) turnW = 2;
								}

								k++;
							}


					total_Score.display();
					
					break ;
				}
				
				frame.repaint();
				win = Board.win;

			}


			return ;
	}
}