package Model;

import java.util.Vector;

import Utilities.GameData;
import Utilities.Vector2;

public class MarioModel {

	private final GameData gameData;
	private final Vector<DynamicGameObject> dynamicGameObjects = new Vector<DynamicGameObject>(); 
	Vector<GameObject> gameObjects = new Vector<GameObject>();
	private Player player = new Player(80,20,32,32);
	
	
	public MarioModel()
	{
		gameData = new GameData();
		
		gameObjects.add(new Brick(0, 320, 64, 64));
		gameObjects.add(new Brick(64, 382, 64, 64));

		gameData.loadGameObjects(gameObjects);
		
		dynamicGameObjects.add(player);
		dynamicGameObjects.addElement(new Mushroom(20,20,32,32));
		dynamicGameObjects.add(new DestroyableBrick(0, 320, 64, 64));
		dynamicGameObjects.add(new DestroyableBrick(64, 382, 64, 64));
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
		Vector<DynamicGameObject> removingObjects = new Vector<DynamicGameObject>();

		for(DynamicGameObject dynamicGameObject : dynamicGameObjects)
		{
			tryUpdate(dynamicGameObject);
			if(player != dynamicGameObject && player.collide(dynamicGameObject))
			{
				int key = player.interact(dynamicGameObject);
				if (key !=0 )
				{
					removingObjects.add(dynamicGameObject);
				}
			}
		}
		
		for(DynamicGameObject removingObject : removingObjects)
		{
			dynamicGameObjects.remove(removingObject);
		}
		
		removingObjects.clear();
		
		gameData.loadDynamicGameObjects(dynamicGameObjects);
	}

	private void tryUpdate(DynamicGameObject dynamicGameObject) {
		dynamicGameObject.update();
		for(GameObject gameObject : gameObjects)
		{
			Boolean reverse = true;
			if(gameObject.collide(dynamicGameObject))
			{
				dynamicGameObject.setGrounded(false);
				dynamicGameObject.correctPosition(gameObject);
			}
		}
	}
}