package game;

public class Boss extence Enemy{

		private String type;
		private int damage;
		private int health;
		
		public Boss(String type, int x, int y, int width, int heigth, int damage) {
			setType(type.trim());
	        setDamage(damage);

					
		}
		public Boss(String pars)
		{
	        String[] parts = pars.split(";");
			
	        setType(parts[0]);
	        setX(Integer.parseInt(parts[1]));
	        setY(Integer.parseInt(parts[2]));
	        String[] sizeParts = parts[3].split("x");
	        setWidth(Integer.parseInt(sizeParts[0]));
	        setHeight(Integer.parseInt(sizeParts[1]));
	        setDamage( Integer.parseInt(parts[4]));
		}
		
		
	}
}
