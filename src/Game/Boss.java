package Game;

public class Boss extends Enemy{
	
	public Boss(String type, int x, int y, int width, int heigth, int damage) {
		super(type,x,y,width,heigth,damage);
	}
	public Boss(String pars)
	{
        super(pars);
	}
	
	@Override
	public int getDamage()
	{
		return super.getDamage() * 2;
	}
	
	
}

