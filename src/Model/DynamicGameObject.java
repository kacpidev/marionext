package Model;

import Utilities.Vector2;

public class DynamicGameObject extends GameObject {

	protected Boolean isDynamic = true;
	protected Boolean isGrounded = false;
	private final double gravity = 0.3;
	
	protected double deltaX;
	protected double deltaY;
	
	public DynamicGameObject()
	{
		
	}
	
	public DynamicGameObject(int x, int y) 
	{
		super(x,y);
	}

	public DynamicGameObject(int x, int y, int w, int h) 
	{
		super(x,y,w,h);
	}

	protected void calculateVelocity()
	{
		if(!isGrounded)
		{
			deltaY += gravity;
		}
		else
		{
			deltaY = 0.0;
		}
	}
	
	protected void updatePosition()
	{
		if(isDynamic)
		{
			position.add(new Vector2(deltaX, deltaY));
		}
	}
	
	public void update()
	{
		calculateVelocity();
		updatePosition();
	}

	public double getDeltaX()
	{
		return deltaX;
	}
	
	public double getDeltaY()
	{
		return deltaY;
	}
	
	public void setDeltaX(double deltaX)
	{
		this.deltaX = deltaX;
	}
	
	public void setDeltaY(double deltaY)
	{
		this.deltaY = deltaY;
	}
	
	public void setGrounded(Boolean isGrounded)
	{
		this.isGrounded = isGrounded;
	}

	public void correctPosition(GameObject gameObject) {
		Vector2 p = new Vector2(position.getX(), position.getY());
		
		double distX = Math.abs(position.getX() + size.getX()/2 - gameObject.getPosition().getX() - gameObject.getSize().getX() / 2);
		double distY = Math.abs(position.getY() + size.getY()/2 - gameObject.getPosition().getY() - gameObject.getSize().getY() / 2);
				
		if(distX < distY)
		{
			if(position.getY() < gameObject.getPosition().getY())
			{			
				isGrounded = true;
				p.setY(gameObject.getPosition().getY() - size.getY());
			}
			else if (position.getY() + size.getY() > gameObject.getPosition().getY() + gameObject.getPosition().getY())
			{
				p.setY(gameObject.getPosition().getY() + gameObject.getPosition().getY());
			}
		}
		else
		{
			if(position.getX() < gameObject.getPosition().getX())
			{
				p.setX(gameObject.getPosition().getX() - size.getX());
			}
			else if (position.getX() + size.getX() > gameObject.getPosition().getX() + gameObject.getPosition().getX())
			{
				p.setX(gameObject.getPosition().getX() + gameObject.getSize().getX());
			}
		}
		setPosition(p);
	}
}
