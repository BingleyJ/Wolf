package JavaCastleWolfenstein;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class LoadSave {
	ArrayList<GameObject> level = new ArrayList<GameObject>();
	List<List<GameObject>> levelList = new ArrayList<List<GameObject>>();
	
	public LoadSave(){
	}
	
	public void save(ArrayList<GameObject> inObjectList) throws IOException {
		String fileName = "levels.dat";
		FileOutputStream fos = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(inObjectList);
		oos.close();
	}
	
	public ArrayList<GameObject> load() throws IOException, ClassNotFoundException {
		GameObject tempObject = null;
		String fileName = "levels.dat";
		ArrayList<GameObject> tempList = null;
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
		tempList = (ArrayList<GameObject>) ois.readObject();
		System.out.println("Objects :");
		for (int i = 0; i < tempList.size(); i++){
			System.out.println(tempList.get(i).getCategory()+" X:"+ tempList.get(i).getX()+"  Y:"+tempList.get(i).getY());
		}
		return tempList;
	}
}
