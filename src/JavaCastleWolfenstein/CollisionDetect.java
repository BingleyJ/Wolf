package JavaCastleWolfenstein;
import java.util.ArrayList;


public class CollisionDetect {
	private Player player;
	private ArrayList<GameObject> objectList;
	
	public CollisionDetect(Player inPlayer, ArrayList<GameObject> inObjectList){
		this.player = inPlayer;
		this.objectList = inObjectList;
	}
	
	public boolean isCollision(){
		boolean collide = false;
		for (int i = 0; i < objectList.size(); i++){
			if (objectList.get(i).getCollisionRect().intersects(player.getCollisionRect())){
				System.out.println("_____| Collision Detected from Within CollisionDetect Class");
				player.setPlayerX(player.getPlayerXOlder());
				player.setPlayerY(player.getPlayerYOlder());
				return true;
			}
		}
		return collide;
	}
	
	public void update(Player inPlayer){
		this.player = inPlayer;
	}
}
