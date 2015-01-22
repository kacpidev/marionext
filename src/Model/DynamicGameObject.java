package Model;

import Utilities.Vector2;

public class DynamicGameObject extends GameObject {

	protected Vector2 deltaPosition = new Vector2();
	
	public DynamicGameObject()
	{
		
	}
	
	public DynamicGameObject(int i, int j) {
		super(i,j);
	}

	public void update()
	{
		position.add(deltaPosition);
		System.out.printf("PosX: %d DeltaPosX: %d \n", position.getX(), deltaPosition.getX());
	}
	
	public Vector2 getDeltaPosition()
	{
		return deltaPosition;
	}
	
	public void setDeltaPosition(Vector2 deltaPosition)
	{
		this.deltaPosition = deltaPosition;
	}
	
}
