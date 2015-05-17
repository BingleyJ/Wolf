package JavaCastleWolfenstein;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class EditMode {
	
	
	private float currentObjectX;
	private float currentObjectY;
	private boolean editmode = true;
	private boolean hudView = false;
	private int totalObj = 1; // starting from 0
	private int horizontalWall = 0;
	private int horizontalWall1 = 1;
	

	public int currentObject;
	
	private ArrayList<EditDrawObject> editObjects = new ArrayList<EditDrawObject>();
	
	Image horizonal_wall;
	Image horizonal_wall1;

	
	public EditMode() throws SlickException{
		currentObjectX = 645;
		currentObjectY = 25;
		horizonal_wall = new Image("res/walls/horizontalwall.png");
		horizonal_wall1 = new Image("res/walls/horizontalwall1.png");
	}
	
	public Image getImage(int inImageNumber){
		if (inImageNumber == horizontalWall)
			return horizonal_wall;
		if (inImageNumber == horizontalWall1)
			return horizonal_wall1;
		return null;
	}
	
	public int roundDown5(int inNum){
		int num = inNum;
		while (num%5 != 0){
			num--;
		}
		return num;
	}
	
	public int roundDown10(int inNum){
		int num = inNum;
		while (num%10 != 0){
			num--;
		}
		return num;
	}
	
	public void addObject(int inO, int inX, int inY){
		editObjects.add(new EditDrawObject(inO, inX, inY));
	}
	
	public void update(){
		
	}
	
	public void setCurrentobject(int inCurrentobject){
		this.currentObject = inCurrentobject;
	}
	
	public int getCurrentobject(){
		return currentObject;
	}
	
	public boolean getEditmode() {
		return editmode;
	}

	public void setEditmode(boolean editmode) {
		this.editmode = editmode;
	}
	
	public int getObjectlistSize(){
		return editObjects.size();
	}

	public void drawscene(Graphics g) {
		int counter = editObjects.size();
		if (!editObjects.isEmpty()){
			for(int i = editObjects.size();i > 0; i--){
				EditDrawObject tempObject;
				tempObject = editObjects.get(i - 1);
				g.drawImage(getImage(tempObject.getObjecttype()), tempObject.getX(), tempObject.getY());
				System.out.println("Object - #" + i + " [" + tempObject.getX() + " - " + tempObject.getY() + "]");
			}
		}
		if (getHudView()){
			g.drawImage(getImage(getCurrentobject()), currentObjectX, currentObjectY);
		}
	}
		
	
	public void deletemouseDuplicatesfromObjectist(){
		for(int i = editObjects.size();i > 0; i--){
			EditDrawObject tempObject;
			EditDrawObject tempObject2;
			tempObject = editObjects.get(i - 1);

			if (i > 1){
				tempObject2 = editObjects.get(i - 2);
				if (tempObject.getX() == tempObject2.getX() && tempObject.getY() == tempObject2.getY()){
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

	public void nextObj(){
		if (currentObject < totalObj)
			currentObject++;
		else currentObject = 0;
	}
	public void lastObj(){
		if (currentObject > 0)
			currentObject--;
		else currentObject = totalObj;
	}

	public void deleteLastObject() {
		int tempSize = editObjects.size() - 1;
		editObjects.remove(editObjects.size() - 1);
	}
	
//** Snap to grid
//** 10 X 10 everything edit mode
//** save method
//** Save levels as chaotic linked lists?

}
