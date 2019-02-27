package Homework02;
//Jake Powers
public class player {
	private String playerName;
	
	public player() {
		this.playerName = "empty Player";
	}
	public player(String xPlayerName) {
		setPlayerName(xPlayerName);
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public void print() {
		System.out.println("Player Name: "+this.playerName);
	}
}
