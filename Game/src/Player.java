import javafx.scene.image.Image;

/**
 * 
 * Player Class
 * Stores and accsesses the information about the player
 * Created 10/20/18
 * 
 */

public class Player extends Move{
	private int xPos;
	private int yPos;
	private int speed;
	private int health;
	private Image image;
	private int score;
	
	public Player(int xPos, int yPos, int speed, int health, Image image) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.speed = speed;
		this.health = health;
		this.image = image;
		this.score = 0;
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
	
	public void increaseScore(int amount) {
		score += amount;
	}

	@Override
	public void moveUp() {
		yPos -= speed;
	}

	@Override
	public void moveDown() {
		yPos += speed;
	}

	@Override
	public void moveLeft() {
		xPos -= speed;
	}

	@Override
	public void moveRight() {
		xPos += speed;
	}

	@Override
	public boolean isTouching(int objOneXPos, int objOneYPos, int objOneXSize, int objOneYSize, int objTwoXPos,
			int objTwoYPos, int objTwoXSize, int objTwoYSize) {
		
		if(objOneXPos >= objTwoXPos && objOneXPos <= objTwoXPos + objTwoXSize && objOneYPos >= objTwoYPos && objOneYPos <= objTwoYPos + objTwoYSize) {
			if(objOneXPos + objOneXSize >= objTwoXPos && objOneXPos + objOneXSize <= objTwoXPos + objTwoXSize && objOneYPos + objOneYSize >= objTwoYPos && objOneYPos + objOneYSize <= objTwoYPos + objTwoYSize) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
}
