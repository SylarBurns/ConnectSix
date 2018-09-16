package Connect6;


public class Board {
	public Coordinate[][] board = new Coordinate[19][19];	
public void initiateBoard() {
	  for(int i =0; i<19; i++) {
		  for(int j=0; j<19; j++) {
			  board[i][j]= new Coordinate(i,j,"BLK");
			  board[i][j].printAll();
		  }
		  System.out.println();
	  }
}
public void setStone(int x, int y, String S) {
	board[x][y].setState(S);
}
}

// My name is Su Hyun :)
