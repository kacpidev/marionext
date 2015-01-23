package Model;

public class DestroyableBrick extends DynamicGameObject {
	
	public DestroyableBrick(int x, int y, int w, int h) {
		super(x,y,w,h);
		isDynamic = false;
	}

}
