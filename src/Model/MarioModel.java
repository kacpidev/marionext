package Model;

import java.util.Vector;

import Utilities.GameData;
import View.GameScene;

public class MarioModel {

	private final GameData gameData;
	
	public MarioModel()
	{
		gameData = new GameData();
		
		gameData.addGameObject(new Brick());
	}
	
	public GameData getGameData()
	{
		return gameData;
	}
	
	public void update()
	{

	}	
}
