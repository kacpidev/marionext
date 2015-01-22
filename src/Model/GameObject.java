package Model;

import java.awt.Image;

import Utilities.Vector2;

/*
 * klasa reprezentująca obiekt gry - sprite'a - przechowuje informacje o obrazku, jego położeniu 
 * i posiada metody służące jego poruszaniu
 */

public class GameObject {
	

	protected Vector2 position;
	
	public GameObject()
	{
		this.position = new Vector2();
	}
	
	public GameObject(Vector2 position)
	{
		this.position = position;
	}
	
	public GameObject(int x, int y)
	{
		this.position = new Vector2(x,y);
	}
	
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

	public void update(float deltaTime) 
	{
	}
}
