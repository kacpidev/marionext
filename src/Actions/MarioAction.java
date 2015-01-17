package Actions;

import Event.MarioEvent;
import Model.MarioModel;
import View.MarioView;

/*
 * Abstrakcyjna klasa po kt�rej dziedzicz� wszystkie klasy 
 * implmentuj�ce reakcje na wyst�pnienie eventu
 * 
 * @author Kacper
 */

public abstract class MarioAction {

	/*
	 * funkcja abstrakcyjna, wymusz dzia�anie aplikacji w wyniku eventu
	 * 
	 * @param widok - widok aplikacji
	 * @param model - model aplikacji
	 * @param event - obs�ugiwany event
	 */
	public abstract void work(final MarioView view, final MarioModel model, final MarioEvent event);
	
}
