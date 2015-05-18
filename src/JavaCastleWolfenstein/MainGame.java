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
		//_____|
		//_____| Draw Edit Warning and Hud
		//_____|
		if (editMode.getEditmode()) {
			g.drawString("Edit Mode ON", 350, 10);
			g.drawString("F2 -toggle hud", 350, 20);
			if(editMode.getHudView()){
				g.drawString(mouseLocation, 100, 10);
				g.drawString("             -[       ]-" , 500, 10);
				g.drawString("Current tile -[       ]-" , 500, 20);
				g.drawString("             -[       ]-" , 500, 30);

				g.drawString("+|-  : adj plr speed", 500, 80);
				g.drawString("F1   : toggle edit mode", 500, 90);
				g.drawString("Back : Pop last object", 500, 100);
				g.drawString("F11|F12 : last|next obj", 500, 110);
				g.drawString("Left Click : Place Object", 500, 120);
				g.drawString("S : SaveLevel", 500, 130);
				g.drawString("V : Insert Verticle Wall", 500, 140);
				g.drawString("H : Insert Horizont Wall", 500, 150);


				
			}
			editMode.drawLevel(g);
		}
		g.drawImage(player.getplayer(), player.getPlayerX(), player.getPlayerY());
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		Input input = gc.getInput();
		userinput.checkInput(input, player, editMode);
		if (input.isKeyPressed(Input.KEY_F1)){
			editMode.setEditmode(!editMode.getEditmode());
			editMode.setHudView(!editMode.getHudView());
		}
		if (editMode.getEditmode()){
		//_____| --> hor wall 1
		//_____| ---> WTF?
		}
		//info_| mouse X0,Y0 is bottom left,
		//_____| graphics X0,Y0 is top left.
		//_____| to marry : (600 - mouse y)
		if (editMode.getEditmode()) {
			int xMouseloc = Mouse.getX();
			int yMouseloc = 600 - Mouse.getY();
			mouseLocation = "Mouse @ x:" + xMouseloc + " y:" + yMouseloc;
			if (editMode.getObjectlistSize() > 2)
				editMode.deletemouseDuplicatesfromObjectist();
		}
		//_____| left mouse button
		//_____| X OFFset For Snap To Grid is 20
		//_____| Y OFFset For Snap To Grid is 10
		if (editMode.getEditmode() && Mouse.isButtonDown(0)  ){
			editMode.addObject(editMode.getCurrentobject(), editMode.roundDown20(Mouse.getX()), editMode.roundDown10(600 - Mouse.getY()));
		}
		
	}
	
	public int getID(){
		return 1;
	}

}
