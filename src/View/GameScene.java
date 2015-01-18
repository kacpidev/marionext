package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Vector;

import javax.swing.JPanel;

import Model.Brick;
import Model.GameObject;
import Utilities.Vector2;

/*
 * klasa przedstawiaj¹ca w widoku poziom
 */

public class GameScene extends JPanel {

	private static final long serialVersionUID = 3L;
	private Vector<GameObject> staticGameObjects;
	private Vector<GameObject> dynamicGameObjects;
	
	/*
	 * Konstruktor
	 * 
	 * @author Kacper
	 */
	public GameScene()
	{
		staticGameObjects = new Vector<GameObject>();
		dynamicGameObjects = new Vector<GameObject>();
		staticGameObjects.addElement(new Brick(new Vector2(0,240)));
	}
	
	/*
	 * rysowanie poziomu
	 */
	
	final private void drawBackground(final Graphics graphics)
	{
		graphics.setColor(new Color(240, 120, 120));
        graphics.fillRect(0, 0, 640, 480);
	}
	
	public void update(){
		for (GameObject gameObject : dynamicGameObjects)
		{
			gameObject.update(0.01f);
		}
	}
	
	public void paint(final Graphics graphics)
	{
		super.paintComponent(graphics);
		drawBackground(graphics);
		drawObjects(staticGameObjects, graphics);
		drawObjects(dynamicGameObjects, graphics);
    }
	
	public void drawObjects(Vector<GameObject> gameObjects, Graphics graphics)
	{
		for (GameObject gameObject : gameObjects)
		{
			Image image = gameObject.getImage();
			int x = gameObject.getPosition().getX();
			int y = gameObject.getPosition().getY();
			graphics.drawImage(image, x, y, null);
		}	
	}
}
