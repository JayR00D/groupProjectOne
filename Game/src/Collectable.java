import javafx.scene.image.Image;

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
	private int xSize;
	private int ySize;
	private int score;
	private Image img;

	public Collectable(int xPos, int yPos, int xSize, int ySize, int score, Image img) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.xSize = xSize;
		this.ySize = ySize;
		this.score = score;
		this.img = img;
	}
}
