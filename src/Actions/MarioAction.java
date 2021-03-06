package Actions;

import Event.MarioEvent;
import Model.MarioModel;
import View.MarioView;

/*
 * Abstrakcyjna klasa po której dziedziczą wszystkie klasy 
 * implmentujące reakcje na wystąpnienie eventu
 * 
 * @author Kacper
 */

public abstract class MarioAction {

	/*
	 * funkcja abstrakcyjna, wymusz działanie aplikacji w wyniku eventu
	 * 
	 * @param widok - widok aplikacji
	 * @param model - model aplikacji
	 * @param event - obsługiwany event
	 */
	public abstract void work(final MarioView view, final MarioModel model, final MarioEvent event);
	
}
