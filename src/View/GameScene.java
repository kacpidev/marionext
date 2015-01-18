package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Vector;

import javax.swing.*;

import Model.Brick;
import Model.GameObject;

/*
 * klasa przedstawiaj¹ca w widoku poziom
 */

public class GameScene extends JPanel {

	private static final long serialVersionUID = 3L;
	private Vector<GameObject> gameObjects;
	
	/*
	 * Konstruktor
	 * 
	 * @author Kacper
	 */
	public GameScene()
	{
		gameObjects = new Vector<GameObject>();
		setBounds(0,0,1,1);
		for (int i = 0; i < 10; ++i){
			gameObjects.add(new Brick(i*64,240));
		}
	}
	
	/*
	 * rysowanie poziomu
	 */
	
	final private void drawBackground(final Graphics graphics)
	{
		graphics.setColor(new Color(240, 120, 120));
        graphics.fillRect(0, 0, 640, 480);
	}
	
	public void paint(final Graphics graphics)
	{
		super.paintComponent(graphics);
		drawBackground(graphics);
		
		for (GameObject gameObject : gameObjects)
		{
			Image image = gameObject.getImage();
			int x = gameObject.getX();
			int y = gameObject.getY();
			graphics.drawImage(image, x, y, null);
		}
    }
}
