class Location {

	private static final int B = 0;
	private static final int W = 1;
	private static final int N = -1;
	
	int Lox;
	int Loy;
	int BW;
	boolean is;
	int undo_location;

	


	public Location(){
		Lox = 0;
		Loy = 0;
		BW = N;
		is = false;
		undo_location = -1;
	}

	public Location(Location obj, int index){
		Lox = obj.Lox;
		Loy = obj.Loy;
		BW = obj.BW;
		is = obj.is;
		undo_location = index;
	}

	public Location(Location obj){
		Lox = obj.Lox;
		Loy = obj.Loy;
		BW = obj.BW;
		is = obj.is;
		undo_location = obj.undo_location;
	}

	public int getUndoLocation(){
		return undo_location;
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
