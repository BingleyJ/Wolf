package JavaCastleWolfenstein;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Player{
	Image player;
	int playerX = 100;
	int playerY = 100;
	int maxPlayerX = 771;
	int maxPlayerY = 554;
	int minPlayerX = 0;
	int minPlayerY = 0;
	int playerSpeed = 1;
	

	public Player() throws SlickException {
		player = new Image("res/player.png");
	}
	
	public void update(){
		
	}

	public Image getplayer() {
		return player;
	}

	public int getPlayerX() {
		return playerX;
	}

	public void setPlayerX(int playerX) {
		this.playerX = playerX;
	}

	public int getPlayerY() {
		return playerY;
	}

	public void setPlayerY(int playerY) {
		this.playerY = playerY;
	}

	public int getMaxPlayerX() {
		return maxPlayerX;
	}

	public void setMaxPlayerX(int maxPlayerX) {
		this.maxPlayerX = maxPlayerX;
	}

	public int getMaxPlayerY() {
		return maxPlayerY;
	}

	public void setMaxPlayerY(int maxPlayerY) {
		this.maxPlayerY = maxPlayerY;
	}

	public int getMinPlayerX() {
		return minPlayerX;
	}

	public void setMinPlayerX(int minPlayerX) {
		this.minPlayerX = minPlayerX;
	}

	public int getMinPlayerY() {
		return minPlayerY;
	}

	public void setMinPlayerY(int minPlayerY) {
		this.minPlayerY = minPlayerY;
	}

	public int getPlayerSpeed() {
		return playerSpeed;
	}

	public void setPlayerSpeed(int playerSpeed) {
		this.playerSpeed = playerSpeed;
	}

}
