package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Model.Brick;
import Model.GameObject;
import Utilities.Vector2;

/*
 * klasa przedstawiaj¹ca w widoku poziom
 */

public class GameScene extends JPanel {

	private static final long serialVersionUID = 3L;
	private Map<Class<? extends GameObject>, Vector2> gameObjects = new HashMap<Class<? extends GameObject>, Vector2>();
	private final Map<Class<? extends GameObject>, Image> drawBinding = new HashMap<Class<? extends GameObject>, Image>();
		
	/*
	 * Konstruktor
	 * 
	 * @author Kacper
	 */
	public GameScene()
	{
		Image image = new ImageIcon("C:\\_PROJECTS\\JAVA\\Mario\\src\\Brick.png").getImage();
		drawBinding.put(Brick.class, image);
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
		
	public void draw(final Map<Class<? extends GameObject>, Vector2> gameObjects)
	{
		this.gameObjects = gameObjects;
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
		for (Entry<Class<? extends GameObject>, Vector2> gameObject : gameObjects.entrySet())
		{
			Image image = drawBinding.get(gameObject.getKey());
			int x = gameObject.getValue().getX();
			int y = gameObject.getValue().getY();
			graphics.drawImage(image, x, y, null);
		}
    }
}
