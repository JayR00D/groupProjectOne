/*
 * 
 * Player Class
 * Stores and accsesses the information about the player
 * Created 10/20/18
 * 
 */

public class Player {
	private int xPos;
	private int yPos;
	private int size;
	private int score;
	
	public Player(int xPos, int yPos, int size, int score) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.size = size;
		this.score = score;
	}
	
	public void moveUp(int amount) {
		yPos -= amount;
		
		if(yPos < 0) {
			yPos = 0;
		}
	}
	
	public void moveDown(int amount) {
		
	}
	
	public void moveRight(int amount) {
		
	}
	
	public void moveLeft(int amount) {
		
	}
}
