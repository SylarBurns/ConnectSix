class Location {

	private static final int B = 0;
	private static final int W = 1;
	private static final int N = -1;
	
	int Lox;
	int Loy;
	int BW;
	boolean is;

	


	public Location(){
		Lox = 0;
		Loy = 0;
		BW = N;
		is = false;
	}

	public void SetLocation(int x, int y){
		Lox = x;
		Loy = y;
	}

	public void Setis(boolean is){
		this.is = is;

	}

	public int GetX(){
		return Lox;
	}

	public int GetY(){
		return Loy;
	}

	public boolean Getis(){
		return is;
	}


}
