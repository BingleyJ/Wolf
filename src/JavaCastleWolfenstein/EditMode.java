package JavaCastleWolfenstein;

import java.util.ArrayList;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class EditMode {

	private float currentObjectX;
	private float currentObjectY;
	private boolean editmode = true;
	private boolean hudView = false;
	public int currentObject;
	private int totalObj = 3; // CHANGE THIS WHEN ADDING A NEW OBJECT INT
	private int horizontalWall = 0;
	private int horizontalWall1 = 1;
	private int lockedDoor = 2;
	private int stairs = 3;

	private ArrayList<EditDrawObject> editObjects = new ArrayList<EditDrawObject>();

	Image horizonal_wall;
	Image horizonal_wall1;
	Image locked_door;
	Image stairs_;
	public String getCategory;

	public EditMode() throws SlickException {
		currentObjectX = 645;
		currentObjectY = 25;
		horizonal_wall = new Image("res/walls/horizontalwall20x10px.png");
		horizonal_wall1 = new Image("res/walls/horizontalwall120x10px.png");
		locked_door = new Image("res/walls/lockeddoor10x70px.png");
		stairs_ = new Image("res/walls/stairs50x70px.png");
	}

	public Image getImage(int inImageNumber) {
		if (inImageNumber == horizontalWall)
			return horizonal_wall;
		else if (inImageNumber == horizontalWall1)
			return horizonal_wall1;
		else if (inImageNumber == lockedDoor)
			return locked_door;
		else if (inImageNumber == stairs)
			return stairs_;
		return null;
	}

	public int roundDown5(int inNum) {
		int num = inNum;
		while (num % 5 != 0) {
			num--;
		}
		return num;
	}

	public int roundDown10(int inNum) {
		int num = inNum;
		while (num % 10 != 0) {
			num--;
		}
		return num;
	}

	public int roundDown20(int inNum) {
		int num = inNum;
		while (num % 20 != 0) {
			num--;
		}
		return num;
	}

	public void addObject(int inO, int inX, int inY) {
		EditDrawObject tempObject = new EditDrawObject(inO, inX, inY);
		tempObject.setCategory();
		editObjects.add(tempObject);
	}

	public void update() {

	}

	public void setCurrentobject(int inCurrentobject) {
		this.currentObject = inCurrentobject;
	}

	public int getCurrentobject() {
		return currentObject;
	}

	public boolean getEditmode() {
		return editmode;
	}

	public void setEditmode(boolean editmode) {
		this.editmode = editmode;
	}

	public int getObjectlistSize() {
		return editObjects.size();
	}

	public void saveLevel() {
		if (!editObjects.isEmpty()) {
			for (int i = editObjects.size() - 1; i > 0; i--) {
				// _____| Get Category For all Objects
				EditDrawObject tempObject;
				tempObject = editObjects.get(i);
				tempObject.setCategory();

				// _____| EXPORT AND SAVE THE LEVEL HERE
				//______|
			}
		}
	}

	private void saveCurrentObject() {
		// _____| Get Category For Current Object;
		EditDrawObject tempOject;
		tempOject = editObjects.get(editObjects.size() - 1);
		tempOject.setCategory();
		editObjects.set(editObjects.size() - 1, tempOject);
		// _____| SAVE THE OBJECT HERE
	}

	public void drawVertWall() {
		int counter = 0;
		for (int i = 2; i < 12; i++) {
			addObject(horizontalWall, roundDown20(Mouse.getX()), roundDown10(600 - Mouse.getY() + (counter)));
			addObject(horizontalWall1, roundDown20(Mouse.getX()), roundDown10(600 - Mouse.getY() + (counter + 10)));
			counter = counter + 20;
		}
	}
	
	public void drawHorWall() {
		int counter = 0;
		for (int i = 2; i < 12; i++) {
			addObject(horizontalWall, roundDown20(Mouse.getX() + counter), roundDown10(600 - Mouse.getY()));
			counter = counter + 20;
		}
	}

	public void drawLevel(Graphics g) {
		if (!editObjects.isEmpty()) {
			for (int i = editObjects.size(); i > 0; i--) {
				EditDrawObject tempObject;
				tempObject = editObjects.get(i - 1);
				g.drawImage(getImage(tempObject.getObjecttype()), tempObject.getX(), tempObject.getY());
				System.out.println("Object - #" + i + " [" + tempObject.getX() + " - " + tempObject.getY() + "]");
			}
		}
		if (getHudView()) {
			g.drawImage(getImage(getCurrentobject()), currentObjectX, currentObjectY);
		}
	}

	public void deletemouseDuplicatesfromObjectist() {
		for (int i = editObjects.size(); i > 0; i--) {
			EditDrawObject tempObject;
			EditDrawObject tempObject2;
			tempObject = editObjects.get(i - 1);
			//_____| THIS IS ONLY CHECKING LIST NEIGHBOURS FOR DUPLICATED. NEEDS OPTIMIZED
			if (i > 1) {
				tempObject2 = editObjects.get(i - 2);
				if (tempObject.getX() == tempObject2.getX() && tempObject.getY() == tempObject2.getY()) {
					editObjects.remove(i - 1);
				}
			}
		}
	}

	public boolean getHudView() {
		return hudView;
	}

	public void setHudView(boolean hudView) {
		this.hudView = hudView;
	}

	public void nextObj() {
		if (currentObject < totalObj)
			currentObject++;
		else
			currentObject = 0;
	}

	public void lastObj() {
		if (currentObject > 0)
			currentObject--;
		else
			currentObject = totalObj;
	}

	public void deleteLastObject() {
		if (!editObjects.isEmpty()) {
			int tempSize = editObjects.size() - 1;
			editObjects.remove(editObjects.size() - 1);
		}
	}

	public String getCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	// ** Snap to grid
	// ** 10 X 10 everything edit mode
	// ** save method

}
