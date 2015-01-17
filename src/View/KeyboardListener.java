package View;

import java.awt.event.*;
import java.util.concurrent.BlockingQueue;

import Event.DownKeyEvent;
import Event.JumpKeyEvent;
import Event.LeftKeyEvent;
import Event.MarioEvent;
import Event.RightKeyEvent;
import Event.ShootKeyEvent;

/*
 * klasa s³uchaj¹ca aktywnoœci myszy w ich wyniku 
 * tworzy odpowiednie eventy umieszczane w kolejce eventów
 * 
 * @author Kacper
 */
public class KeyboardListener extends KeyAdapter {

	
	private final BlockingQueue<MarioEvent> eventQueue;
	
	/*
	 * 
	 * konstruktor 
	 * 
	 * @param eventQueueu - kolejka eventów
	 */
	public KeyboardListener(final BlockingQueue<MarioEvent> eventQueue)
	{
		super();
		this.eventQueue = eventQueue;
	}
	
	public void keyPressed(final KeyEvent event)
	{
		try
		{
			if(event.getKeyCode() == KeyEvent.VK_LEFT)
			{
				eventQueue.put(new LeftKeyEvent());
			}
			if(event.getKeyCode() == KeyEvent.VK_RIGHT)
			{
				eventQueue.put(new RightKeyEvent());
			}
			if(event.getKeyCode() == KeyEvent.VK_UP)
			{
				eventQueue.put(new JumpKeyEvent());
			}
			if(event.getKeyCode() == KeyEvent.VK_DOWN)
			{
				eventQueue.put(new DownKeyEvent());
			}
			if(event.getKeyCode() == KeyEvent.VK_SPACE)
			{
				eventQueue.put(new ShootKeyEvent());
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
