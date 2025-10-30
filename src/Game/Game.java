package Game;

import java.util.ArrayList;

public class Game {

	private Player player;
	private ArrayList<Enemy> enemies = new ArrayList<>();
	private ArrayList<String> eventLog = new ArrayList<>();
	
	public Game(Player player, ArrayList<Enemy> enemies,  ArrayList<String>eventLog)
	{
		this.player = player;
		this.enemies = enemies;
		this.eventLog = eventLog;
	}
	
	public static void main(String[] args) {
		Player newPlayer = new Player("bo b", 1, 1);
		
		ArrayList<Enemy> enemies = new ArrayList<>();
		
		enemies.add(new Enemy("Goblin", 1,1,10,15,25));
		enemies.add(new MeleeEnemy("Goblin;12;5;16x16;20"));
		enemies.add(new Boss("Goblin;1;1;16x16;4;boss"));

		Game game = new Game(newPlayer, enemies, new ArrayList<>());
		game.resolveCollsions();
		game.printEventLog();
		for(Enemy e : findByType("gob", enemies))
		{
			System.out.println(e);
			
		}
	}
	
	private boolean checkCollision(Player p, Enemy e) { return GameObject.intersects(e, p); }

	
	private void decreaseHealth(Player p, Enemy e)
	{
		int startHealth = p.getHealth();
		int newHealth = p.getHealth() - (e.getDamage() *( e instanceof Boss ? 2 : 1));
		p.setHealth(newHealth >= 0 ? newHealth : 0);
		eventLog.add("Hit:Player by " + e.getType() + " for " +  e.getDamage() + " -> HP " + startHealth + "->" + p.getHealth());
		
	}
	private void addEnemy(Enemy e)
	{
		enemies.add(e);
		eventLog.add("New enemy: " + e.getType());
		
	}
	private static ArrayList<Enemy> findByType(String query, ArrayList<Enemy> enemies)
	{
		ArrayList<Enemy> findedEnemies = new ArrayList<>();
		query = query.toLowerCase();
		
		for (Enemy e: enemies)
		{
			if(e.getType().toLowerCase().contains(query))
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
	public void resolveCollsions()
	{
		for (Enemy e: collidingWithPlayer())
		{
			decreaseHealth(player, e);
		}
	}
	public void printEventLog()
	{
		for(String s: eventLog)
		{
			System.out.println(s);

		}
	}

}
