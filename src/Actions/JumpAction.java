package Actions;

import Event.MarioEvent;
import Model.MarioModel;
import View.MarioView;

public class JumpAction extends MarioAction {

	@Override
	public void work(MarioView view, MarioModel model, MarioEvent event) {
		model.getGameData().getPlayer().jump();
	}

}
