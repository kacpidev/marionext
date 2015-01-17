package Model;

import javax.swing.ImageIcon;

public class Brick extends GameObject {

	public Brick(int x, int y)
	{
		image = new ImageIcon(this.getClass().getResource("Brick.png")).getImage();
		this.x = x;
		this.y = y;
	}
}
