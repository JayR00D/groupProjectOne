/*
 * 
 * Collectable Class
 * Store and run information about the collectables
 * Created 10/20/18
 * 
 */

public class Collectable {
	private int xPos;
	private int yPos;
	private int size;
	private int score;

	public Collectable(int xPos, int yPos, int size, int score) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.size = size;
		this.score = score;
	}
}
