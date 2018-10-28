import java.util.* ;
import javax.swing.* ;
import java.awt.*;

public class Gomoku{

	private static final int B = 0;  // color black : 0
	private static final int W = 1;  // color white : 1
	private static final int N = -1; // no stone    : -1
 
	public static Location [] board    = new Location[361]; //바둑판에 있는 돌
	public static Location [] setboard = new Location[361]; //유저가 놓은 돌

	public static boolean win = false; //게임 끝났는지 안끝났는지 확인

	public static int StoneX = 370; //cursur 처음 위치
	public static int StoneY = 370;

	public static int k = 1;   		// 유저가 놓은 돌 갯수 : 1인 이유는 검은색 돌 1개는 무조건 놓여있기 때문

	public static int turnW = 0;	//White turn
	public static int turnB = 0;	//Black turn
	
	public static int userColor = N;//store user's color 



	public static void main(String[] args){

		System.out.println("\nSelect Your color(B or W) : ");
		Scanner t = new Scanner(System.in);

		if(t.next().charAt(0) == 'B')      
		{
			userColor = B ;
			System.out.println("Black") ;
		}
		else if(t.next().charAt(0) == 'W') 
		{
			userColor = W ;
			System.out.println("White") ;
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
		win = Board.win ;

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
		
		Location User = new Location()  ;
		User.SetLocation(StoneX, StoneY);
		int keycode = 0 ;
		ck c1 = new ck();

		setboard[0].SetLocation(370, 370) ; // 검은색 돌은 처음에 가운데에 무조건 놓여있어야 한다. 
		board[180].Setis(true) ; 
		board[180].BW = B ; 
		turnW = 2;  						// white has two turn in first


			do{

				Scanner s = new Scanner(System.in);
				win = Board.win;

				if(win == false)  keycode = s.next().charAt(0);

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

					setboard[k].SetLocation(User.GetX(),User.GetY());
					for(i=1;i<361;i++)
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
								}
								else if(turnB > 0) 
								{
									board[i].BW = B;
									turnB-- ;
									if(turnB == 0) turnW = 2;
								}
								k++;

							}
					
					break ;
				}
				
				frame.repaint();
			
			}while(keycode != 'q');
	}
}