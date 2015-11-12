package Controller;

import java.util.*;

public class CommandWords {
	private List<String> commands;
	
	public CommandWords(){
		commands = new ArrayList<>();
		commands.add("place");
		commands.add("quit");
		commands.add("help");
	}
	
	public boolean isCommand(String s){
		if(commands.contains(s)) return true;
		else return false;
	}
	
	public String getCommands(){
		String string = "";
		for(String s : commands){
			string += s + " ";
		}
				
		return string;
	}
}
