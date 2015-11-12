package Model;

public abstract class Piece {
	
	private int type;
	private char display;
	
	public Piece(int type, char display){
		this.type = type;
		this.display = display;
	}
	
	public int getType(){
		return type;
	}
	
	public char getChar(){
		return display;
	}
}
