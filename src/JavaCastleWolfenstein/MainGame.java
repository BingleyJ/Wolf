package JavaCastleWolfenstein;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.XRandR.Screen;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class MainGame extends BasicGameState {
	//boolean editMode = true;
	boolean mouseTracking = false;
	String mouseLocation = "NULL";
	
	EditMode editMode;

	Player player;
	UserInput userinput;
	
	public MainGame(int state) {
		//System.out.print("PLAY");
		
	}

	public void init(GameContainer gc, StateBasedGame sbg)throws SlickException {
		player = new Player();
		userinput = new UserInput();
		editMode = new EditMode();
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		// drawing 0,0 is top right
		if (editMode.getEditmode()) {
			g.drawString("Edit Mode ON", 350, 10);
			g.drawString("F2 -toggle hud", 350, 20);
			if(editMode.getHudView()){
				g.drawString(mouseLocation, 100, 10);
				g.drawString("             -[    ]-" , 500, 10);
				g.drawString("Current tile -[    ]-" , 500, 20);
				g.drawString("             -[    ]-" , 500, 30);

				g.drawString("+|-  : adj plr speed", 500, 60);
				g.drawString("F1   : toggle edit mode", 500, 70);
				g.drawString("Back : Pop last object", 500, 80);
				g.drawString("F11|F12 : last|next obj", 500, 90);
				g.drawString("Left Click : Place Object", 500, 100);


				

			}
			editMode.drawscene(g);
		}
		g.drawImage(player.getplayer(), player.getPlayerX(), player.getPlayerY());
		//System.out.println("Player is at " + player.getPlayerX() + " - " +  player.getPlayerY());
		
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		Input input = gc.getInput();
		userinput.checkInput(input, player, editMode);
		if (input.isKeyPressed(Input.KEY_F1)){
			editMode.setEditmode(!editMode.getEditmode());
			editMode.setHudView(!editMode.getHudView());
		}
		if (editMode.getEditmode()){
			//hor wall 1
			
					
		}
		
		// mouse 0,0 is bottom left
		// graphics 0,0 is top left
		// (600 - mouse y) will match graphics and mouse coordinates.
		if (editMode.getEditmode()) {
			int xMouseloc = Mouse.getX();
			int yMouseloc = 600 - Mouse.getY();
			mouseLocation = "Mouse @ x:" + xMouseloc + " y:" + yMouseloc;
			if (editMode.getObjectlistSize() > 2)
				editMode.deletemouseDuplicatesfromObjectist();
		}
		
		//left button
		if (editMode.getEditmode() && Mouse.isButtonDown(0)  ){
			editMode.addObject(editMode.getCurrentobject(), editMode.roundDown10(Mouse.getX()), editMode.roundDown10(600 - Mouse.getY()));
		}
		
	}
	
	public int getID(){
		return 1;
	}

}
