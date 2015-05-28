package JavaCastleWolfenstein;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

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
	private int totalObj = 4; // CHANGE THIS WHEN ADDING A NEW OBJECT INT
	private int horizontalWall = 0;
	private int horizontalWall1 = 1;
	private int lockedDoor = 2;
	private int stairs = 3;
	private int chest = 4;
	private IO io;

	private ArrayList<Object> gameObjectsList = new ArrayList<Object>();

	Image horizonal_wall;
	Image horizonal_wall1;
	Image locked_door;
	Image stairs_;
	Image closedChest;
	public String getCategory;

	public EditMode() throws SlickException {
		io = new IO();
		currentObjectX = 645;
		currentObjectY = 25;
		horizonal_wall = new Image("res/walls/horizontalwall20x10px.png");
		horizonal_wall1 = new Image("res/walls/horizontalwall120x10px.png");
		locked_door = new Image("res/walls/lockeddoor10x70px.png");
		stairs_ = new Image("res/walls/stairs50x70px.png");
		closedChest = new Image("res/objects/closedchest50x30px.png");
	}
	
	public ArrayList<Object> getObjectList(){
		return gameObjectsList;
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
		else if (inImageNumber == chest)
			return closedChest;
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
		Object tempObject = new Object(inO, inX, inY);
		tempObject.setCategory();
		gameObjectsList.add(tempObject);
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
		return gameObjectsList.size();
	}

	public void saveLevel() throws IOException {
		if (!gameObjectsList.isEmpty()) {
			deleteDuplicatesFromList();
			for (int i = gameObjectsList.size() - 1; i > 0; i--) {
				// _____| Get Category For all Objects
				Object tempObject;
				tempObject = gameObjectsList.get(i);
				tempObject.setCategory();

				// _____| EXPORT AND SAVE THE LEVEL HERE, VERN!
				//______|
				io.save(gameObjectsList);
			}
		}
	}
	
	public void loadLevel() throws ClassNotFoundException, IOException{
		io.load();
	}

	private void saveCurrentObject() {
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
		if (!gameObjectsList.isEmpty()) {
			for (int i = gameObjectsList.size(); i > 0; i--) {
				Object tempObject;
				tempObject = gameObjectsList.get(i - 1);
				g.drawImage(getImage(tempObject.getObjecttype()), tempObject.getX(), tempObject.getY());
				//System.out.println("Object - #" + i + " [" + tempObject.getX() + " - " + tempObject.getY() + "]");
			}
		}
		if (getHudView()) {
			g.drawImage(getImage(getCurrentobject()), currentObjectX, currentObjectY);
		}
	}
	
	//____| Quicksort buy X value
	public void sortObjectList(){
		int counter = gameObjectsList.size() - 1;
		if (gameObjectsList == null || gameObjectsList.size() == 0){
			return;
		}
		quicksort(0, counter);
	}
	
	//____| Quicksort by Object.X value
	private void quicksort(int inLow, int inHigh) {
		int i = inLow; int j = inHigh;
		//____| Get Pivot from middle.
		float pivot = gameObjectsList.get(inLow + (inHigh - inLow)/2).getX();
		//____| Divide List
		while (i <= j){
			while(gameObjectsList.get(i).getX() < pivot){
				i++;
			}
			while(gameObjectsList.get(j).getX() > pivot){
				j--;
			}
			if (i<=j){
				Collections.swap(gameObjectsList, i, j);
				i++;
				j--;
			}
		}
		if (inLow < j)
			quicksort(inLow, j);
		if (i < inHigh)
			quicksort(i, inHigh);
	}
	
	//_____| Print Object list to console
	public void printObjectList(){
		for (int i = 0; i < gameObjectsList.size(); i++){
			System.out.println(i + ", " + gameObjectsList.get(i).getCategory() + " : Type:" + gameObjectsList.get(i).getObjecttype() + " X:" + gameObjectsList.get(i).getX() + " Y:" + gameObjectsList.get(i).getY());
		}
	}
	
	//_____| BROOOOOOOKEN!!!! DOH!
	public void deleteDuplicatesFromList() {
		for (int i = gameObjectsList.size(); i > 0; i--) {
			Object tempObject;
			Object tempObject2;
			tempObject = gameObjectsList.get(i - 1);
			//_____| THIS IS ONLY CHECKING LIST NEIGHBOURS FOR DUPLICATED. NEEDS OPTIMIZED
			if (i > 1) {
				tempObject2 = gameObjectsList.get(i - 2);
				if (tempObject.getX() == tempObject2.getX() && tempObject.getY() == tempObject2.getY()) {
					gameObjectsList.remove(i - 1);
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
		if (!gameObjectsList.isEmpty()) {
			int tempSize = gameObjectsList.size() - 1;
			gameObjectsList.remove(gameObjectsList.size() - 1);
		}
	}

	public String getCategory() {
		// TODO Auto-generated method stub
		return null;
	}
}
