package Actions;

import Event.MarioEvent;
import Model.MarioModel;
import Model.Player;
import Utilities.Vector2;
import View.MarioView;

public class MoveInputAction extends MarioAction {

	private Vector2 deltaPosition;
	
	public MoveInputAction(Vector2 deltaPosition)
	{
		this.deltaPosition = deltaPosition;
	}
	
	@Override
	public void work(MarioView view, MarioModel model, MarioEvent event) {
		Player player = model.getGameData().getPlayer();
		player.setDeltaPosition(deltaPosition);
	}

}
