package JavaCastleWolfenstein;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class MainGame extends BasicGameState {
	boolean editMode = true;
	boolean mouseTracking = false;
	String mouseLocation = "NULL";

	Player player;
	UserInput userinput;
	
	public MainGame(int state) {
		System.out.print("PLAY");
		
	}

	public void init(GameContainer gc, StateBasedGame sbg)throws SlickException {
		player = new Player();
		userinput = new UserInput();
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		// drawing 0,0 is top right
		if (mouseTracking || editMode) {
			g.drawString(mouseLocation, 100, 10);
			g.drawString("Edit Mode ON", 500, 10);
		}
		g.drawImage(player.getplayer(), player.getPlayerX(), player.getPlayerY());
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		Input input = gc.getInput();
		userinput.checkInput(input, player);
		editMode = userinput.getEditMode();
		
		// mouse 0,0 is bottom left
		if (mouseTracking || editMode) {
			int xMouseloc = Mouse.getX();
			int yMouseloc = Mouse.getY();
			mouseLocation = "Mouse @ x:" + xMouseloc + " y:" + yMouseloc;
		}
	}
	
	public int getID(){
		return 1;
	}

}
