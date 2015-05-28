package JavaCastleWolfenstein;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class IO {
	ArrayList<Object> level = new ArrayList<Object>();
	List<List<Object>> levelList = new ArrayList<List<Object>>();
	
	public IO(){
		
	}
	
	public void save(ArrayList<Object> inObjectList) throws IOException{
		String fileName = "levels.dat";
		FileOutputStream fos = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
	//	for (int i = 0; i < inObjectList.size(); i++){
		//	Object tempObject = inObjectList.get(i);
			oos.writeObject(inObjectList);
	//	}
		oos.close();
	}
	
	public ArrayList<Object> load() throws IOException, ClassNotFoundException {
		Object tempObject = null;
		String fileName = "levels.dat";
		ArrayList<Object> tempList = null;
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
		tempList = (ArrayList<Object>) ois.readObject();
	//	while ((tempObject = ois.readObject()) != null) {
		//	if (tempObject instanceof Object) {
			//	Object object = (Object) tempObject;
		//		tempList.add(object);
			//}
		//}
		System.out.println("Objects :");
		for (int i = 0; i < tempList.size(); i++){
			System.out.println(tempList.get(i).getCategory()+" X:"+ tempList.get(i).getX()+"  Y:"+tempList.get(i).getY());
		}
		return tempList;
	}
}
