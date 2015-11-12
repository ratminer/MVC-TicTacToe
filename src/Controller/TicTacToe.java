package Controller;

import Model.*;
import View.*;

public class TicTacToe {
	
	private static final int SIZE = 3;
	private static final int O = 0;
	private static final int X = 1;
	
	private int turn;
	
	private Board board;
	private boolean running = true;
	
	private Parser parser;
	private View view;
	
	private CommandWords words;
	
	public TicTacToe(){
		System.out.println(turn);
		board = new Board(SIZE);
		view = new View(board);
		parser = new Parser();
		words = new CommandWords();
	}
	
	public int getTurn(){
		return turn;
	}
	
	public Position makeMove(int x, int y){
		return new Position(x, y);
	}
	
	public boolean validMove(Position pos){
		if(!board.withinBounds(pos)){
			return false;
		}
		if(!board.isEmptyPosition(pos)){
			return false;
		}
		return true;
	}
	
	public void play(int startingTurn){
		turn = startingTurn;
		switchTurns();
		while(running){
			switchTurns();
			Command command = parser.getCommand();
			running = processCommand(command);
		}
	}
	
	private boolean processCommand(Command command) {
		switch (command.getCommandWord()){
			case "quit":
				System.out.println("Thank you for playing!");
				return false;
			case "help":
				System.out.println(words.getCommands());
				return true;
			case "place":
				return place(command);
		}
		
		return true;
	}

	private boolean place(Command command){
		
		if(!command.hasSecondWord() || !command.hasThirdWord()){
			System.out.println("Please enter a valid position");
			return true;
		}
		
		int x = Integer.parseInt(command.getSecondWord());
		int y = Integer.parseInt(command.getThirdWord());
		Position pos = new Position(x, y);
		
		Piece piece = null;
		if(validMove(pos)){
			if(turn == X){
				piece = new X();
			}else if(turn == O){
				piece = new O();
			}
			board.addPiece(pos, piece);

			view.update(board);
			view.display();
			return checkGameStatus(pos);
		}else{
			System.out.println("Invalid Position");
			return place(parser.getCommand());
		}
	}
	
	private boolean checkGameStatus(Position pos){
		
		Piece[][] grid = board.getCurrentBoard();
		int row = 0, column = 0, diagonal = 0, antiDiagonal = 0;
		int size = board.getSize();
		int x = pos.getX();
		int y = pos.getY();
		for(int i = 0; i < size; i++){
			if(!board.isEmptyPosition(new Position(x, i)) && board.getPiece(new Position(x, i)).getType() == turn) column++;
			if(!board.isEmptyPosition(new Position(i, y)) && board.getPiece(new Position(i, y)).getType() == turn) row++;
			if(!board.isEmptyPosition(new Position(i, i)) && board.getPiece(new Position(i, i)).getType() == turn) diagonal++;
			if(!board.isEmptyPosition(new Position(i, size - 1 - i)) && board.getPiece(new Position(i, size - 1 - i)).getType() == turn) antiDiagonal++;
			
			
		}
		System.out.print(row + " " + column + " " + diagonal + " " + antiDiagonal + "\n");
		if(column == size || row == size || diagonal == size || antiDiagonal == size){
			if(turn == X){
				System.out.println("Player X has won!");
			}else if(turn == O){
				System.out.println("Player O has won!");
			}
			return false;
		}
		return true;
	}
	
	private void switchTurns(){
		if(turn == X){
			turn = O;
		}else if(turn == O){
			turn = X;
		}
	}
	
	public Board getBoard(){
		return board;
	}
	
	public static void main(String[] args){
		TicTacToe game = new TicTacToe();
		game.play(X);
	}
	
}
