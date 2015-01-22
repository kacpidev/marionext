package View;

import java.awt.event.*;
import java.util.concurrent.BlockingQueue;

import Event.JumpKeyDownEvent;
import Event.LeftKeyDownEvent;
import Event.LeftKeyUpEvent;
import Event.MarioEvent;
import Event.RightKeyDownEvent;
import Event.RightKeyUpEvent;

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
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
