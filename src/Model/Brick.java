package Model;

import javax.swing.ImageIcon;

import Utilities.Vector2;

public class Brick extends GameObject {

	public Brick(Vector2 position)
	{
		image = new ImageIcon(this.getClass().getResource("Brick.png")).getImage();
		this.position = position;
	}
}
