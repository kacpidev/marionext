package Model;

import java.util.Vector;

import View.GameScene;

public class MarioModel {

	private Vector<GameObject> gameObjects;
	
	public MarioModel()
	{
	}
	
	public void setGameScene(Vector<GameObject> gameObjects)
	{
		this.gameObjects = gameObjects;
	}
	
	public Vector<GameObject> getGameObjects()
	{
		return gameObjects;
	}

	public void update()
	{
		for(GameObject gameObject : gameObjects)
		{
			gameObject.update(1/60);
		}
	}	
}
