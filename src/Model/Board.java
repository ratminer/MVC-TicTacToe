package Model;

public class Board {
	
	private Piece[][] grid;
	private int size;
	
	public Board(int size){
		grid = new Piece[size][size];
		this.size = size;
	}
	
	public void addPiece(Position pos, Piece piece){
		grid[pos.getX()][pos.getY()] = piece;
	}
	
	public Piece[][] getCurrentBoard(){
		return grid;
	}
	
	public boolean isEmptyPosition(Position pos){
		if(getPiece(pos) == null) return true;
		else return false;
		
	}
	
	public int getSize(){
		return size;
	}
	
	public void clearBoard(){
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				grid[i][j] = null;
			}
		}
	}
	
	public boolean withinBounds(Position pos){
		if(pos.getX() < size && pos.getY() < size) return true;
		return false;
	}
	
	public Piece getPiece(Position pos){
		return grid[pos.getX()][pos.getY()];
	}
}
