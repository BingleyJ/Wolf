package JavaCastleWolfenstein;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class Player {
	
	Image player;
	float playerX = 100;
	float playerX2 = 130;
	float playerXold;
	float playerY = 100;
	float playerY2 = 150;
	float playerYold;
	float maxPlayerX = 771;
	float maxPlayerY = 554;
	float minPlayerX = 0;
	float minPlayerY = 0;
	float playerSpeed = 1;
	
	int[] animationDuration = { 150, 100, 100 };	
	int[] animationDurationPimpWalk = {100, 500, 2000};
	int delta;
	Animation playerStandingStill;
	Animation playerWalkingRight;
	Animation playerWalkingLeft;
	Animation playerWalkingUp;
	Animation playerWalkingDown;
	Animation currentPlayer;
	
	Rectangle playerRect;
	
	boolean gameOn = false;
	
	public Player() throws SlickException {
		// player = new Image("res/player.png");
		Image[] playerStill = { new Image("res/player/playerfront30x50px.png"), new Image("res/player/playerfront30x50px.png"), new Image("res/player/playerfront30x50px.png") };
		Image[] walkRight = { new Image("res/player/playerright130x50px.png"), new Image("res/player/playerright230x50px.png"), new Image("res/player/playerright330x50px.png") };
		Image[] walkleft = { new Image("res/player/playerleft130x50px.png"), new Image("res/player/playerleft230x50px.png"), new Image("res/player/playerleft330x50px.png") };
		Image[] walkup = {  new Image("res/player/playerup130x50px.png"), new Image("res/player/playerback30x50px.png"), new Image("res/player/playerup230x50px.png") };
		Image[] walkdown = {  new Image("res/player/playerdown130x50px.png"), new Image("res/player/playerfront30x50px.png"), new Image("res/player/playerdown230x50px.png") };
		playerWalkingRight = new Animation(walkRight, animationDuration, false);
		playerStandingStill = new Animation(playerStill, animationDuration, false);
		playerWalkingLeft = new Animation(walkleft, animationDuration, false);
		playerWalkingDown = new Animation(walkdown, animationDuration, false);
		playerWalkingUp = new Animation(walkup, animationDuration, false);
		currentPlayer = playerStandingStill;
		playerRect = new Rectangle(playerX, playerY, playerX2-playerX, playerY2-playerY);
	}

	public void render(Graphics g) {
		currentPlayer.draw(100, Mouse.getY());
	}

	public void update(int inDelta) {
		this.delta = inDelta;
		currentPlayer.update(delta);
		playerRect = new Rectangle(playerX, playerY, playerX2-playerX, playerY2-playerY);
	}


	public void setCurrentAnimation(int inAnim) {
		switch (inAnim) {
		case 0: currentPlayer = playerStandingStill;
			break;
		case 1: currentPlayer = playerWalkingRight;
			break;
		case 2: currentPlayer = playerWalkingLeft;
			break;
		case 3: currentPlayer = playerWalkingUp;
			break;
		case 4: currentPlayer = playerWalkingDown;
			break;
		}
	}
	
	public Rectangle getCollisionRect(){
		return playerRect;
	}
	
	public Animation getplayer() {
		return currentPlayer;
	}

	public float getPlayerX() {
		return playerX;
	}

	public void setPlayerX(float inPlayerX) {
		this.playerXold = this.playerX;
		this.playerX2 = this.playerX + 30;
		this.playerX = inPlayerX;
	}

	public float getPlayerY() {
		return playerY;
	}

	public void setPlayerY(float playerY) {
		this.playerYold = this.playerY;
		this.playerY2 = this.playerY + 50;
		this.playerY = playerY;
	}

	public float getMaxPlayerX() {
		return maxPlayerX;
	}

	public void setMaxPlayerX(float maxPlayerX) {
		this.maxPlayerX = maxPlayerX;
	}

	public float getMaxPlayerY() {
		return maxPlayerY;
	}

	public void setMaxPlayerY(float maxPlayerY) {
		this.maxPlayerY = maxPlayerY;
	}

	public float getMinPlayerX() {
		return minPlayerX;
	}

	public void setMinPlayerX(float minPlayerX) {
		this.minPlayerX = minPlayerX;
	}

	public float getMinPlayerY() {
		return minPlayerY;
	}

	public void setMinPlayerY(float minPlayerY) {
		this.minPlayerY = minPlayerY;
	}

	public float getPlayerSpeed() {
		return playerSpeed;
	}

	public void setPlayerSpeed(float playerSpeed) {
		this.playerSpeed = playerSpeed;
	}


}
