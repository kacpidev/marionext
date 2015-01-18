package View;

import java.awt.event.*;
import java.util.concurrent.BlockingQueue;

import Event.DownKeyDownEvent;
import Event.DownKeyUpEvent;
import Event.JumpKeyDownEvent;
import Event.JumpKeyUpEvent;
import Event.LeftKeyDownEvent;
import Event.LeftKeyUpEvent;
import Event.MarioEvent;
import Event.RightKeyDownEvent;
import Event.RightKeyUpEvent;
import Event.ShootKeyDownEvent;
import Event.ShootKeyUpEvent;

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
				eventQueue.put(new LeftKeyDownEvent());
			}
			if(event.getKeyCode() == KeyEvent.VK_RIGHT)
			{
				eventQueue.put(new RightKeyDownEvent());
			}
			if(event.getKeyCode() == KeyEvent.VK_UP)
			{
				eventQueue.put(new JumpKeyDownEvent());
			}
			if(event.getKeyCode() == KeyEvent.VK_DOWN)
			{
				eventQueue.put(new DownKeyDownEvent());
			}
			if(event.getKeyCode() == KeyEvent.VK_SPACE)
			{
				eventQueue.put(new ShootKeyDownEvent());
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public void keyReleased(final KeyEvent event)
	{
		try
		{
			if(event.getKeyCode() == KeyEvent.VK_LEFT)
			{
				eventQueue.put(new LeftKeyUpEvent());
			}
			if(event.getKeyCode() == KeyEvent.VK_RIGHT)
			{
				eventQueue.put(new RightKeyUpEvent());
			}
			if(event.getKeyCode() == KeyEvent.VK_UP)
			{
				eventQueue.put(new JumpKeyUpEvent());
			}
			if(event.getKeyCode() == KeyEvent.VK_DOWN)
			{
				eventQueue.put(new DownKeyUpEvent());
			}
			if(event.getKeyCode() == KeyEvent.VK_SPACE)
			{
				eventQueue.put(new ShootKeyUpEvent());
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
