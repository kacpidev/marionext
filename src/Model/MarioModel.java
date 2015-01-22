package Model;

import java.util.Vector;

import Utilities.GameData;

public class MarioModel {

	private final GameData gameData;
	private final Vector<DynamicGameObject> dynamicGameObjects = new Vector<DynamicGameObject>(); 
	private Player player = new Player();
	
	public MarioModel()
	{
		Vector<GameObject> gameObjects = new Vector<GameObject>();
		gameData = new GameData();
		gameObjects.add(new Brick(100,100));
		
		gameData.loadGameObjects(gameObjects);
		
		dynamicGameObjects.add(player);
		gameData.setPlayer(player);
		gameData.loadDynamicGameObjects(dynamicGameObjects);
	}
	
	public GameData getGameData()
	{
		gameData.loadDynamicGameObjects(dynamicGameObjects);
		return gameData;
	}
	
	public void update()
	{
		for(DynamicGameObject dynamicGameObject : dynamicGameObjects)
		{
			dynamicGameObject.update();
		}
		gameData.loadDynamicGameObjects(dynamicGameObjects);
	}
}