public class Coordinate {
	private int X_Cor;
	private int Y_Cor;
	private String Stone;
	
	public Coordinate(){
	}
	public Coordinate(int X, int Y, String newStone){
		setX(X);
		setY(Y);
		setState(newStone);
	}
	public void setX(int X) {
		X_Cor= X;
	}
	public void setY(int Y) {
		Y_Cor=Y;
	}
	public void setState(String State) {
		Stone = State;
	}
	public int getX() {
		return X_Cor;
	}
	public int getY() {
		return Y_Cor;
	}
	public String getState() {
		return Stone;
	}
	public void printAll() {
		System.out.print("("+X_Cor+", "+Y_Cor+", "+Stone+")");
	}
}