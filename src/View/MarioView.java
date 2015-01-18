package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.util.concurrent.BlockingQueue;

import javax.swing.SwingUtilities;
import javax.swing.Timer;

import Event.MarioEvent;
import Event.TimerEvent;
import Model.GameObject;

/*
 * widok aplikacji
 * 
 * @author Kacper
 */

public class MarioView 
{

	/*
	 * klasa prywatna - listener zegara
	 * na wyst¹pienie eventu zegara tworzy event odpowiedzialny z zegar i wk³ada go do kolejki
	 * 
	 * @author Kacper
	 */
	private class TimerListener implements ActionListener
	{
		BlockingQueue<MarioEvent> eventQueue;

		/*
		 * konstruktor
		 * 
		 * @param eventQueue - kolejka zdarzeñ
		 */
		private TimerListener(final BlockingQueue<MarioEvent> eventQueue) {
			this.eventQueue = eventQueue;
		}
		
		/*
		 * W przypadku wyst¹pienia zdarzenia timera wrzuca zdarzenie 
		 * odpowiedzialne za timer do kolejki
		 */
		@Override
		public void actionPerformed(ActionEvent event) {
			try
			{
				eventQueue.put(new TimerEvent());
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}		
	}
	
	private final BlockingQueue<MarioEvent> eventQueue;
	private final Window window;
	private final TimerListener timerListener;
	private final Timer timer;
	private static int FPS = 60;
	/*
	 * konstruktor
	 * 
	 * @param eventQueue
	 */
	public MarioView(final BlockingQueue<MarioEvent> eventQueue)
	{
		this.eventQueue = eventQueue;
		window = new Window(eventQueue);
		window.setVisible(true);
		refresh();
		timerListener = new TimerListener(eventQueue);
		timer = new Timer(100, timerListener);
		timer.setRepeats(true);
		timer.start();				

	}
	
	public void refresh()
	{
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				window.draw();
			}
		});
	}
	
}
