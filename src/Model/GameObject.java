package Model;

import java.awt.Image;

/*
 * klasa reprezentuj�ca obiekt gry - sprite'a - przechowuje informacje o obrazku, jego po�o�eniu 
 * i posiada metody s�u��ce jego poruszaniu
 */

abstract public class GameObject {
	
	protected Image image;
	
	protected int x;
	protected int y;
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	/*
	 * position setter
	 * 
	 * @author Kacper
	 */
	public void setPosition(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	/*
	 * image getter 
	 * 
	 * @author Kacper
	 */
	public Image getImage()
	{
		return image;
	}
}
