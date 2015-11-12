package Controller;

import java.util.Scanner;

public class Parser {
	private CommandWords commands;
	private Scanner scanner;
	
	public Parser(){
		commands = new CommandWords();
		scanner = new Scanner(System.in);
	}
	
	public Command getCommand(){
		String inputLine = "";
		String word1 = "";
		String word2 = "";
		String word3 = "";
		
		System.out.print(">");
		
		inputLine = scanner.nextLine();
		Scanner split = new Scanner(inputLine);
		if(split.hasNext()){
			word1 = split.next();
			if(split.hasNext()){
				word2 = split.next();
				if(split.hasNext()){
					word3 = split.next();
				}
			}
		}
		
		if(commands.isCommand(word1)) return new Command(word1, word2, word3);
		else {
			System.out.println("Invalid command.");
			return getCommand();
		}
		
	}

}
