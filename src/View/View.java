package View;
import Controller.*;
import Model.*;


public class View {
	
	private Board board;
	
	public View(Board board){
		this.board = board;
	}
	
	public void display(){
		int size = board.getSize();
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				Position pos = new Position(i, j);
				if(board.isEmptyPosition(pos)){
					System.out.print("#");
				}else {
					System.out.print(board.getPiece(pos).getChar());
				}
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	public void update(Board board){
		this.board = board;
	}
}
