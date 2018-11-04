import java.util.Arrays;

import javafx.scene.image.Image;

/**
 * 
 * Enemy Class
 * Stores and runs information about the enemies
 * Created 10/20/18
 * 
 */

public class Enemy extends Move{
	private int xPos;
	private int yPos;
	private int speed;
	private int xSize;
	private int ySize;
	private Image image;
	
	public Enemy(int xPos, int yPos, int xSize, int ySize, int speed, Image image) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.xSize = xSize;
		this.ySize = ySize;
		this.speed = speed;
		this.image = image;
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
	public int getX() {
		return xPos;
	}
	
	public int getY() {
		return yPos;
	}
	
	public void calcDirection(int playerX, int playerY) {
		double[] dist = new double[4];
		
		dist[0] = calcDistance(playerX, playerY, 0, -1);
		dist[1] = calcDistance(playerX, playerY, 0, 1);
		dist[2] = calcDistance(playerX, playerY, 1, 0);
		dist[3] = calcDistance(playerX, playerY, -1, 0);
		
		double[] dist2 = new double[4];
		for(int i = 0; i < dist.length; i++) {
			dist2[i] = dist[i];
		}
		
		Arrays.sort(dist2);
		
		if(dist2[0] == dist[0]) {
			moveDown();
		}else if(dist2[0] == dist[1]) {
			moveUp();
		}else if(dist2[0] == dist[2]) {
			moveLeft();
		}else {
			moveRight();
		}
		
	}
	
	private double calcDistance(int playerX, int playerY, int changeX, int changeY) {
		return Math.abs((Math.sqrt(Math.pow(playerY - yPos + changeY, 2) + Math.pow(playerX - xPos + changeX, 2))));
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
