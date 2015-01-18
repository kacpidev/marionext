package Model;

import java.awt.Image;

import Utilities.Vector2;

/*
 * klasa reprezentuj¹ca obiekt gry - sprite'a - przechowuje informacje o obrazku, jego po³o¿eniu 
 * i posiada metody s³u¿¹ce jego poruszaniu
 */

abstract public class GameObject {
	
	protected Image image;
	
	protected Vector2 position;
	
	public Vector2 getPosition()
	{
		return position;
	}
	
	/*
	 * position setter
	 * 
	 * @author Kacper
	 */
	public void setPosition(Vector2 position)
	{
		this.position = position;
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

	public void update(float deltaTime) 
	{
	}
}
