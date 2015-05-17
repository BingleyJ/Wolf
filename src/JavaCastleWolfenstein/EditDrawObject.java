package JavaCastleWolfenstein;

public class EditDrawObject {
	private int objectType;
	private int X;
	private int Y;
	
	public EditDrawObject(int inObject, int inX, int inY){
		this.objectType = inObject;
		this.X = inX;
		this.Y = inY;
	}
	
	public int getX(){
		return X;
	}
	
	public int getY(){
		return Y;
	}
	public int getObjecttype(){
		return objectType;
	}
}
