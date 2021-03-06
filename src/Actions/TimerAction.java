package Actions;

import Event.MarioEvent;
import Model.MarioModel;
import View.MarioView;

public class TimerAction extends MarioAction {

	@Override
	public void work(MarioView view, MarioModel model, MarioEvent event) {
		model.update();
		view.refresh(model.getGameData());
	}
}
