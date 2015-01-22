package Utilities;

/*
 * klasa reprezentuj¹ca punkt/wektor w przestrzeni 2d
 * 
 * @author Kacper
 */

public class Vector2 {
	private int x;
	private int y;
	
	public Vector2()
	{
		this.x = 0;
		this.y = 0;
	}
	
	public Vector2(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}
	
	public void add(Vector2 second)
	{
		this.x += second.x;
		this.y += second.y;
	}
	
	public void multiply(float m)
	{
		this.x *= m;
		this.y *= m;
	}
	
	public int getLength()
	{
		return x^2 + y^2;
	}
	
	public void normalize()
	{
		int length = getLength();
		if(length != 0){
			x /= length;
			y /= length;
		}
	}	
}
