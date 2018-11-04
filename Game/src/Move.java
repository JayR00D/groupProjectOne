
public abstract class Move {
	
	public abstract void moveUp();
	public abstract void moveDown();
	public abstract void moveLeft();
	public abstract void moveRight();
	public abstract boolean isTouching(int objOneXPos, int objOneYPos, int objOneXSize, int objOneYSize, int objTwoXPos, int objTwoYPos, int objTwoXSize, int objTwoYSize);
}
