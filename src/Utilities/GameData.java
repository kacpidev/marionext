package Utilities;

import java.util.HashMap;
import java.util.Map;

import Model.GameObject;

/*
 * Klasa odpowiedzialna za przechowywanie danych o grze
 */
public class GameData {

	private final Map<Class<? extends GameObject>, Vector2> gameObjects;

	public GameData()
	{
		gameObjects = new HashMap<Class<? extends GameObject>, Vector2>();
	}
	
	public Map<Class<? extends GameObject>, Vector2> getGameData(){
		return gameObjects;
	}
	
	public void addGameObject(GameObject gameObject)
	{
		gameObjects.put(gameObject.getClass(), gameObject.getPosition());
	}
}
