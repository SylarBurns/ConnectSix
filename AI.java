class AI{  // 컴퓨터가 계산해서 최적의 위치를 반환하는 class를 구현

	private static final int B = 0;
	private static final int W = 1;
    private static final int N = -1;
    
    private static int color;
    

    AI(int color){

        this.color = color ;

    }
    static Location turn(int k, int where){

        Gomoku.board[where].Setis(true) ;        // 검은색 돌은 처음에 가운데에 무조건 놓여있어야 한다.    
        Gomoku.board[where].BW = color ; 
        Gomoku.setboard[k] = Gomoku.board[where] ;

        return Gomoku.setboard[k];
    }
	
}