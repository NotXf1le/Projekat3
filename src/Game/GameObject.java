package Game;

public class GameObject {
	private int x;
	private int y;
	private int width;
	private int height;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public static boolean intersects(GameObject first, GameObject seconds)
	{
		return (first.getX() == seconds.getX() && first.getY() == seconds.getY());

	}
}
