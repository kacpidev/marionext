package Utilities;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import Model.DynamicGameObject;
import Model.GameObject;
import Model.Player;

/*
 * Klasa odpowiedzialna za przechowywanie danych o grze
 */
public class GameData {

	private Vector<GameObject> gameObjects = new Vector<GameObject>(); 
	private Vector<DynamicGameObject> dynamicGameObjects = new Vector<DynamicGameObject>();
	private Player player; 
	
	public GameData()
	{
	}
	
	public void loadGameObjects(Vector<GameObject> gameObjects)
	{
		this.gameObjects = gameObjects;
	}

	public void loadDynamicGameObjects(Vector<DynamicGameObject> dynamicGameObjects)
	{
		this.dynamicGameObjects = dynamicGameObjects;
	}
	
	public Map<Class<? extends GameObject>, Vector<Vector2>> getGameData(){
		Map<Class<? extends GameObject>, Vector<Vector2>> classBinding = new HashMap<Class<? extends GameObject>, Vector<Vector2>>();
		
		for(GameObject gameObject : gameObjects)
		{
			Vector<Vector2> positions;
			if (classBinding.get(gameObject.getClass()) == null)
			{
				positions = new Vector<Vector2>();
			}
			else
			{
				positions = classBinding.get(gameObject.getClass());
			}
			positions.add(gameObject.getPosition());
			classBinding.put(gameObject.getClass(), positions);
		}
		for(GameObject gameObject : dynamicGameObjects)
		{
			Vector<Vector2> positions;
			if (classBinding.get(gameObject.getClass()) == null)
			{
				positions = new Vector<Vector2>();
			}
			else
			{
				positions = classBinding.get(gameObject.getClass());
			}
			positions.add(gameObject.getPosition());
			classBinding.put(gameObject.getClass(), positions);		}
		
		return classBinding;
	}
	
	public void addGameObject(GameObject gameObject)
	{
		gameObjects.addElement(gameObject);
	}
	
	public void addGameObject(DynamicGameObject dynamicGameObject)
	{
		dynamicGameObjects.addElement(dynamicGameObject);
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public Player getPlayer()
	{
		return player;
	}

}
