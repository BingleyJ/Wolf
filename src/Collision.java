import org.newdawn.slick.geom.Rectangle;


public class Collision {
	private int objectType;
	private float X1;
	private float X2;
	private float Y1;
	private float Y2;
	private Rectangle collRect; //_____| collision rectangle

	
	public Collision(int inObjectType, float inX, float inY){
		this.objectType = inObjectType;
		this.X1 = inX;
		this.Y1 = inY;
		getDimensions(objectType);
		collRect = new Rectangle(X1, Y1, X2-X1, Y2-Y1);
	}



	private void getDimensions(int inObjectType) {
		// _____| 0 Wall1
		// _____| 1 Wall2
		// _____| 2 Locked Door
		// _____| 3 Stairs
		// _____| 4 Closed Chest
		// _____| 5 Open Chest
		// _____| 6 Enemy
		switch (inObjectType) {
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
			X2 = X1 + 50;
			Y2 = Y1 + 70;
			break;
		case 4:
			X2 = X1 + 50;
			Y2 = Y1 + 30;
			break;
		}
	}
	
	
	

}	
