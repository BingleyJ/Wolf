package JavaCastleWolfenstein;

import java.io.Serializable;

import org.newdawn.slick.geom.Rectangle;

public class GameObject implements Serializable{
	
	private String Category;
	private int objectId;
	private float X1;
	private float Y1;
	private float X2;
	private float Y2;
	
	private Rectangle collRect;

	public GameObject(int inObject, int inX, int inY){
		this.objectId = inObject;
		this.X1 = inX;
		this.Y1 = inY;
		setCategory();
		getDimensions();
		setCollisionRectangle();
		//Collision collision = new Collision(inObject, this.X, this.Y);		
	}
	private void setCollisionRectangle() {
		collRect = new Rectangle(X1, Y1, X2-X1, Y2-Y1);
	}
	private void getDimensions() {
		// _____| 0 Wall1
		// _____| 1 Wall2
		// _____| 2 Locked Door
		// _____| 3 Stairs
		// _____| 4 Closed Chest
		// _____| 5 Open Chest
		// _____| 6 Enemy
		switch (objectId) {
		case 0:
			X2 = X1 + 20;
			Y2 = Y1 + 10;
			break;
		case 1:
			X2 = X1 + 20;
			Y2 = Y1 + 10;
			break;
		case 2:
			X2 = X1 + 10;
			Y2 = Y1 + 70;
			break;
		case 3: 
			X2 = X1 + 60;
			Y2 = Y1 + 70;
			break;
		case 4:
			X2 = X1 + 50;
			Y2 = Y1 + 30;
			break;
		}
	}
	public String getCategory() {
		return Category;
	}

	public void setCategory() {
		// _____| 0 - 1 are walls
		// _____| 2 - 2 are doors
		//______| 3 - 3 are stairs
		// _____| 4 - 4 are chests
		if (objectId < 2)
			Category = "Wall";
		else if (objectId < 3)
			Category = "Door";
		else if (objectId < 4)
			Category = "Stairs";
		else if (objectId < 5)
			Category = "Chest";
		else Category = "No Name";
	}
		
	public float getX(){
		return X1;
	}
	public float getY(){
		return Y1;
	}
	public int getObjecttype(){
		return objectId;
	}

	public Rectangle getCollisionRect(){
		return collRect;
	}
}
