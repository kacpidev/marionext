package Actions;

import Event.MarioEvent;
import Model.MarioModel;
import Model.Player;
import Utilities.Vector2;
import View.MarioView;

public class MoveInputAction extends MarioAction {

	private double deltaX;
	
	public MoveInputAction(double deltaX)
	{
		this.deltaX = deltaX;
	}
	
	public MoveInputAction()
	{
		this.deltaX = 0.0;
	}
	
	@Override
	public void work(MarioView view, MarioModel model, MarioEvent event) {
		Player player = model.getGameData().getPlayer();
		player.setDeltaX(deltaX);
	}

}
