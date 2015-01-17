package View;

import java.awt.*;
import java.util.concurrent.BlockingQueue;
import javax.swing.*;

import Event.MarioEvent;

public class Window extends JFrame {
	
	/* automatycznie wygenerowany serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	private final GameScene gameScene; 
	
	public Window(final BlockingQueue<MarioEvent> eventQueue)
	{
		super("Mario neXt");
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		Dimension minimumSize = new Dimension();
		minimumSize.setSize(640, 480);
		setMinimumSize(minimumSize);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		setLayout(new BorderLayout());
	
		gameScene = new GameScene();
		gameScene.addKeyListener(new KeyboardListener(eventQueue));
		add(gameScene, BorderLayout.CENTER);
	}

	public void draw() {
		System.out.println("draw");
		gameScene.repaint();
	}
}
