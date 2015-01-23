package Utilities;

/*
 * klasa reprezentuj¹ca punkt/wektor w przestrzeni 2d
 * 
 * @author Kacper
 */

public class Vector2 {
	private double x;
	private double y;
	
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

	public Vector2(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX()
	{
		return x;
	}

	public double getY()
	{
		return y;
	}
	
	public void setX(double x)
	{
		this.x = x;
	}
	
	public void setY(double y)
	{
		this.y = y;
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
	
	public double getLength()
	{
		return x*x + y*y;
	}
	
	public void normalize()
	{
		double length = getLength();
		if(length != 0){
			x /= length;
			y /= length;
		}
	}	
}
