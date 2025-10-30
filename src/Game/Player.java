package Game;

public class Player extends GameObject {
    private String name;
    private int health;

   
    public Player(String name, int x, int y, int width, int height, int health) {
    	setName(name);
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
        setHealth(health);
    }

   
    public Player() {
        this("Unknown", 0, 0);
    }

    
    public Player(String name, int x, int y) {
        this(name, x, y, 50, 50, 100);
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
        	name = "Unknown";
        	
        }
        else
        {
            name = name.trim();
            name = name.substring(0, 1).toUpperCase() + name.substring(1);
            
        }

    }

    public String getName() { return name; }

    @Override
    public String toString() {
        return "Player{name='" + name + "', x=" + getX() + ", y=" + getY() +
               ", width=" + getWidth() + ", height=" + getHeight() + ", health=" + health + "}";
    }
    
    public int getHealth() { return health; }
    public void setHealth(int health) { this.health = Math.min(100, Math.max(0,health));}
}
