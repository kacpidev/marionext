package Utilities;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import Model.GameObject;

/*
 * Klasa odpowiedzialna za przechowywanie danych o grze
 */
public class GameData {

	private final Vector<GameObject> gameObjects = new Vector<GameObject>(); 
	
	public GameData()
	{
		
	}
	
	public Map<Class<? extends GameObject>, Vector2> getGameData(){
		Map<Class<? extends GameObject>, Vector2> classBinding = new HashMap<Class<? extends GameObject>, Vector2>();
		
		for(GameObject gameObject : gameObjects)
		{
			classBinding.put(gameObject.getClass(), gameObject.getPosition());
		}
				
		return classBinding;
	}
	
	public void addGameObject(GameObject gameObject)
	{
		gameObjects.addElement(gameObject);
	}
}
