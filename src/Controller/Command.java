package Controller;

public class Command {
	
	private String commandWord;
	private String secondWord;
	private String thirdWord;
	
	public Command(String command, String secondWord, String thirdWord){
		this.commandWord = command;
		this.secondWord = secondWord;
		this.thirdWord = thirdWord;
	}
	
	public String getCommandWord(){
		return commandWord;
	}
	
	public String getSecondWord(){
		return secondWord;
	}
	
	public String getThirdWord(){
		return thirdWord;
	}
	
	public boolean hasSecondWord(){
		return secondWord != "";
	}

	public boolean hasThirdWord() {
		return thirdWord != "";
	}
}
