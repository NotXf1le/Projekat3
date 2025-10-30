package game;

import java.util.ArrayList;

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
	private boolean checkCollision(Player p, Enemy e)
	{
		return (p.getX() == e.getX() && p.getY() == e.getY());

	}
	private void decreaseHealth(Player p, Enemy e)
	{
		int startHealth = p.getHealth();
		int newHealth = p.getHealth() - e.getHealth();
		
		p.setHealth(newHealth >= 0 ? newHealth : 0);
		
	}
	private void addEnemy(Enemy e)
	{
	Enemy.add(e);
		
		
	}
	private ArrayList<Enemy> findByType(String query)
	{
		ArrayList<Enemy> findedEnemies = new ArrayList<>();
		query = query.toLowerCase();
		
		for (Enemy e: Enemy)
		{
			if(e.getType() == query)
				findedEnemies.add(e);
			
		}
		
		return findedEnemies;
			
	}
	private ArrayList<Enemy> collidingWithPlayer()
	{
		ArrayList<Enemy> findedEnemies = new ArrayList<>();

		for (Enemy e: enemies)
		{
			if(checkCollision(player, e))
				findedEnemies.add(e);

			
		}
		return findedEnemies;
	}

}
