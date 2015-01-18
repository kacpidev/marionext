package Model;

import java.util.Vector;

public class GameScene 
{

	private Vector<GameObject> gameObjects;
	
	public GameScene()
	{
		gameObjects = new Vector<GameObject>();
	}
	
	private void testScene(){
		gameObjects.add(new Brick(0,240));
	}

	public void update(float deltaTime){
		for(GameObject gameObject : gameObjects)
		{
			gameObject.update(deltaTime);
		}
	}
}
