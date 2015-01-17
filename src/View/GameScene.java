package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Vector;

import javax.swing.*;

import Model.Brick;

/*
 * klasa przedstawiaj¹ca w widoku poziom
 */

public class GameScene extends JPanel {

	private static final long serialVersionUID = 3L;
	private Vector<Brick> gameObjects;
	
	/*
	 * Konstruktor
	 * 
	 * @author Kacper
	 */
	public GameScene()
	{
		gameObjects = new Vector<Brick>();
		setBounds(0,0,1,1);
		gameObjects.add(new Brick(10,10));
	}
	
	/*
	 * rysowanie poziomu
	 */
	
	final private void drawBackground(final Graphics graphics)
	{
		graphics.setColor(new Color(240, 120, 120));
        graphics.fillRect(0, 0, 640, 480);
	}
	
	@Override
	public void paint(final Graphics graphics)
	{
		System.out.println("painting");
		super.paintComponent(graphics);
		drawBackground(graphics);
		
		for (Brick gameObject : gameObjects)
		{
			Image image = gameObject.getImage();
			int x = gameObject.getX();
			int y = gameObject.getY();
			graphics.drawImage(image, x, y, null);
		}
    }
}
