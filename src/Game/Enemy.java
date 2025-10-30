package Game;

public class Enemy extends GameObject{	
	private String type;
	private int damage;
	private int health;
	
	public Enemy(String type, int x, int y, int width, int heigth, int damage) {
		setType(type.trim());
        setDamage( Integer.parseInt(parts[4]));

				
	}
	public Enemy(String pars)
	{
        String[] parts = pars.split(";");
		
        setType(parts[0]);
        setX(parts[1]);
        setY(parts[2]);
        String[] sizeParts = parts[3].split("x");
        setWidth(sizeParts[0]);
        setHeight(sizeParts[1]);
        setDamage( Integer.parseInt(parts[4]));
        
	}
	public String getType() {
		return type;
	}
	
	public void setType(String tip) {
	     if (tip.isEmpty())
	     {
	    	 throw new IllegalArgumentException("Tip neprijatelja ne smije biti prazan!");
	     }
	     this.type = tip.trim();
	}
	
	
	public int getHealth() { return health; }
	public void setHealth(int health) { this.health = Math.min(100, Math.max(0, health)); }
				
	public int getDamage() { return damage; }	
	public void setDamage(int damage) { this.damage = Math.min(100, Math.max(0, damage));}
	
	
	public String toString() {
		return String.format("Enemy(%s) @ (%d %d) %dx%d DMG=%d",
				getType(), getX(), getY(), getWidth(), getHeigth(), getDamage());
	}
}
