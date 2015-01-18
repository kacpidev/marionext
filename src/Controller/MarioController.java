package Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

import Event.MarioEvent;
import Event.TimerEvent;
import Model.MarioModel;
import View.MarioView;
import Actions.MarioAction;
import Actions.TimerAction;
/*
 * kontroler aplikacji
 * s³u¿y do komunikacji z widokiem i modelem
 * 
 * @author Kacper
 */

public class MarioController 
{

	private final MarioModel model;
	private final MarioView view;
	private final BlockingQueue<MarioEvent> eventQueue;
	private final Map<Class<? extends MarioEvent>, MarioAction> eventAction = new HashMap<Class<? extends MarioEvent>, MarioAction>();
	
	
	/*
	 * konstruktor
	 * 
	 * @param model - model aplikacji
	 * @param view - widok aplikacji
	 * @param eventQueue - kolejka eventów aplikacji
	 */
	public MarioController(final MarioModel model, final MarioView view, final BlockingQueue<MarioEvent> eventQueue)
	{
		this.model = model;
		this.view = view;
		this.eventQueue = eventQueue;
		connectEventsWithActions();
	}
	
	/*
	 * funkcja ³¹cz¹ca eventy z akcjami
	 * 
	 * @author Kacper
	 */
	private void connectEventsWithActions()
	{
		eventAction.put(TimerEvent.class, new TimerAction());
	}
	
	public void control() throws RuntimeException, InterruptedException
	{
		while(true)
		{
			try
			{
				MarioEvent marioEvent = this.eventQueue.take();
				MarioAction marioAction = eventAction.get(marioEvent.getClass());
				marioAction.work(view, model, marioEvent);
			}
			catch(RuntimeException e)
			{
				e.printStackTrace();
				throw new RuntimeException(e);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
				throw new InterruptedException();
			}
		}
	}
}
