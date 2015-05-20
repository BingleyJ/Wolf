package JavaCastleWolfenstein;

public class Object {
	
	private String Category;
	private int objectId;
	private int X;
	private int Y;
	
	
	
	public Object(int inObject, int inX, int inY){
		this.objectId = inObject;
		this.X = inX;
		this.Y = inY;
	}
	public String getCategory() {
		return Category;
	}

	public void setCategory() {
		// _____| 0 - 1 are walls
		// _____| 1 - ? are doors
		// _____| ? - ? are chests
		if (objectId < 2)
			Category = "Wall";
		else if (objectId < 3)
			Category = "Door";
		else if (objectId < 4)
			Category = "chest";
	}
		
	public int getX(){
		return X;
	}
	public int getY(){
		return Y;
	}
	public int getObjecttype(){
		return objectId;
	}
}