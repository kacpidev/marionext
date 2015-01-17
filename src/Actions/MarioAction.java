package Actions;

import Event.MarioEvent;
import Model.MarioModel;
import View.MarioView;

/*
 * Abstrakcyjna klasa po której dziedzicz¹ wszystkie klasy 
 * implmentuj¹ce reakcje na wyst¹pnienie eventu
 * 
 * @author Kacper
 */

public abstract class MarioAction {

	/*
	 * funkcja abstrakcyjna, wymusz dzia³anie aplikacji w wyniku eventu
	 * 
	 * @param widok - widok aplikacji
	 * @param model - model aplikacji
	 * @param event - obs³ugiwany event
	 */
	public abstract void work(final MarioView view, final MarioModel model, final MarioEvent event);
	
}
