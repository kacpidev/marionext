package Model;

import java.awt.Image;

import Utilities.Vector2;

/*
 * klasa reprezentuj¹ca obiekt gry - sprite'a - przechowuje informacje o obrazku, jego po³o¿eniu 
 * i posiada metody s³u¿¹ce jego poruszaniu
 */

public class GameObject {
	
	protected Vector2 position;
	protected Vector2 size;
	
	public GameObject()
	{
		this.position = new Vector2();
		this.size = new Vector2();
	}
	
	public GameObject(Vector2 position)
	{
		this.position = position;
	}
	
	public GameObject(Vector2 position, Vector2 size)
	{
		this.position = position;
		this.size = size;
	}
	
	public GameObject(double x, double y)
	{
		this.position = new Vector2(x,y);
	}
	
	public GameObject(double x, double y, int w, int h)
	{
		this.position = new Vector2(x,y);
		this.size = new Vector2(w,h);
	}
	
	public Vector2 getPosition()
	{
		return position;
	}
	
	public Vector2 getSize()
	{
		return size;
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
	
	public void setSize(Vector2 size)
	{
		this.size = size;
	}

	public Boolean collide(GameObject gameObject)
	{
		if (position.getX() + size.getX() >= gameObject.getPosition().getX() && 
			position.getX() <= gameObject.getPosition().getX() + gameObject.getSize().getX() && 
			position.getY() + size.getY() >= gameObject.getPosition().getY() && 
			position.getY() <= gameObject.getPosition().getY() + gameObject.getSize().getY())
		{
			return true;
		}
		
		return false;
	}
}
