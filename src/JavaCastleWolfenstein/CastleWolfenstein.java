package JavaCastleWolfenstein;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;



public class CastleWolfenstein extends StateBasedGame{

	public static final String gamename = "Castle Wolfenstein";
	public static final int menu = 0;
	public static final int play = 1;
	public static final int goodbye = 2;
	public static final int sht = 3736;
	
	public CastleWolfenstein (String gamename){
		super(gamename);
		//define states
		this.addState(new SplashIntro(menu));
		this.addState(new MainGame(play));
		this.addState(new Goodbye(goodbye));
	}
	
	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		//Initialize states and enter menu state
		this.getState(menu).init(gc, this);
		this.getState(play).init(gc, this);
		this.getState(goodbye).init(gc, this);
		this.enterState(menu);
	}
	
	public static void main(String[] args) {
		//create game window
		AppGameContainer appgc;
		try{
			//create game window
			appgc = new AppGameContainer(new CastleWolfenstein(gamename));
			//adjust window dimensions(w, h, full-screen?)
			appgc.setDisplayMode(800, 600, false);
			//paint window to screen
			appgc.start();
		}catch(SlickException e){
			e.printStackTrace();
		}

	}

}
