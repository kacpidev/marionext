package Mario;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import Controller.MarioController;
import Event.MarioEvent;
import Model.MarioModel;
import View.MarioView;

/*
 * Mario to klasa g³ówna uruchamiaj¹ca wszystkie procesy aplikacji,
 * tworzy klasy odpowiadaj¹ce za wicok, model i kontroler oraz kolejkê eventów
 * 
 * @author Kacper
 */


public class Mario {

	public static void main (String[] args)
	{
		try
		{
			final MarioModel model = new MarioModel();
			final BlockingQueue<MarioEvent> eventQueue = new LinkedBlockingQueue<MarioEvent>();
			final MarioView view = new MarioView(eventQueue);
			final MarioController controller = new MarioController(model, view, eventQueue);
			controller.control();		
		}
		catch(RuntimeException e)
		{
			e.printStackTrace();
			System.exit(1);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
			System.exit(1);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.exit(2);
		}
	}
}
