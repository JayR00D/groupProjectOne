import javafx.scene.image.Image;

/*
 * 
 * Player Class
 * Stores and accsesses the information about the player
 * Created 10/20/18
 * 
 */

public class Player extends Move{
	private int xPos;
	private int yPos;
	private int speed
	private int health;
	private Image image;
	
	public Player(int xPos, int yPos, int speed, int health, Image image) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.speed = speed;
		this.health = health;
		this.image = image;
	}
	
	public int getX() {
		return xPos;
	}
	
	public int getY() {
		return yPos;
	}
	
	public Image getImg() {
		return image;
	}

	@Override
	public void moveUp() {
		xPos -= 5;
	}

	@Override
	public void moveDown() {
		xPos += 5;
	}

	@Override
	public void moveLeft() {
		yPos -= 5;
	}

	@Override
	public void moveRight() {
		yPos += 5;
	}
}
