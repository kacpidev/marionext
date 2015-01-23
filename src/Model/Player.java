package Model;

public class Player extends DynamicGameObject {

	Boolean isJumping = false;
	
	public Player(int x, int y, int w, int h) {
		super(x,y,w,h);
	}

	public void update()
	{
		calculateVelocity();
		if (isJumping)
		{
			isJumping = false;
			deltaY = -10.0;
		}
		updatePosition();
	}

	public void jump() 
	{
		if(isGrounded)
		{
			isJumping = true;
			isGrounded = false;
		}
	}

	public int interact(DynamicGameObject dynamicGameObject) {
		
		double distX = Math.abs(position.getX() + size.getX()/2 - dynamicGameObject.getPosition().getX() - dynamicGameObject.getSize().getX() / 2);
		double distY = Math.abs(position.getY() + size.getY()/2 - dynamicGameObject.getPosition().getY() - dynamicGameObject.getSize().getY() / 2);

		if(dynamicGameObject instanceof Enemy)
		{
			if(deltaY > dynamicGameObject.deltaY)
			{
				return 1;
			}
		}
		else if (dynamicGameObject instanceof DestroyableBrick)
		{
			if(deltaY < dynamicGameObject.deltaY && distX <distY)
			{
				return 4;
			}
		}		
		return 0;
	}
}
