package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Model.Brick;
import Model.DestroyableBrick;
import Model.GameObject;
import Model.Mushroom;
import Model.Player;
import Utilities.GameData;
import Utilities.Vector2;

/*
 * klasa przedstawiaj¹ca w widoku poziom
 */

public class GameScene extends JPanel {

	private static final long serialVersionUID = 3L;
	private Map<Class<? extends GameObject>, Vector<Vector2>> gameObjects = new HashMap<Class<? extends GameObject>, Vector<Vector2>>();
	private final Map<Class<? extends GameObject>, Image> drawBinding = new HashMap<Class<? extends GameObject>, Image>();
	private Vector2 offset;
	/*
	 * Konstruktor
	 * 
	 * @author Kacper
	 */
	public GameScene()
	{
		drawBinding.put(DestroyableBrick.class, new ImageIcon("C:\\_PROJECTS\\JAVA\\Mario\\src\\View\\Resources\\DestroyableBrick.png").getImage());
		drawBinding.put(Player.class, new ImageIcon("C:\\_PROJECTS\\JAVA\\Mario\\src\\View\\Resources\\Mario.png").getImage());
		drawBinding.put(Mushroom.class, new ImageIcon("C:\\_PROJECTS\\JAVA\\Mario\\src\\View\\Resources\\Mushroom.png").getImage());
		drawBinding.put(Brick.class, new ImageIcon("C:\\_PROJECTS\\JAVA\\Mario\\src\\Brick.png").getImage());
	}
	
	/*
	 * funkcja rysuj¹ca t³o 
	 * 
	 */
	final private void drawBackground(final Graphics graphics)
	{
		graphics.setColor(new Color(240, 120, 120));
        graphics.fillRect(0, 0, 640, 480);
	}
		
	public void draw(final GameData gameData)
	{
		this.gameObjects = gameData.getGameData();
		offset = gameData.getPlayer().getPosition();
		repaint();
	}
	
	/*
	 * Rysujemy obiekty na scenie:
	 * 
	 */	
	public void paint(final Graphics graphics)
	{
		super.paintComponent(graphics);
		drawBackground(graphics);
		for (Entry<Class<? extends GameObject>, Vector<Vector2>> gameObject : gameObjects.entrySet())
		{
			Image image = drawBinding.get(gameObject.getKey());
			for (Vector2 position : gameObject.getValue())
			{
				int x = (int) position.getX();// + offset.getX();
				int y = (int) position.getY();
				graphics.drawImage(image, x, y, null);
			}
		}
	}
}
