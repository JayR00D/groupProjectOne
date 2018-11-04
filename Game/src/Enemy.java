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
		if(yPos < 0) { yPos = 0; }
	}

	@Override
	public void moveDown() {
		yPos += speed;
		if(yPos > 500) { yPos = 500; }
	}

	@Override
	public void moveLeft() {
		xPos -= speed;
		if(xPos < 0) { xPos = 0; }
	}

	@Override
	public void moveRight() {
		xPos += speed;
		if(yPos > 600) { yPos = 600; }
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
		
		double[] dist2 = dist;
		Arrays.sort(dist2);
		
		if(dist2[0] == dist[0]) {
			moveUp();
		}else if(dist2[0] == dist[1]) {
			moveDown();
		}else if(dist2[0] == dist[2]) {
			moveRight();
		}else {
			moveLeft();
		}
		
	}
	
	private double calcDistance(int playerX, int playerY, int changeX, int changeY) {
		return Math.abs((Math.sqrt(Math.pow(playerY - yPos + changeY, 2) + Math.pow(playerX - xPos + changeX, 2))));
	}
	
}
