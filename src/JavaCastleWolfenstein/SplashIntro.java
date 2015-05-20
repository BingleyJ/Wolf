package JavaCastleWolfenstein;

//this shits ugly!!!! Splash intro HACK!
import java.util.ArrayList;


import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class SplashIntro extends BasicGameState{
	
	public int counter = 0;
	public int runBlinkcounter = 2;
	public ArrayList<Image> splashScreen = new ArrayList<Image>();
	
	public boolean switchBlink = false;
	
	
	public SplashIntro(int state) {
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		//sbg.enterState(1);
		String c64screen = "res/splash/c64screen";
		for (int i = 0; i < 26; i++){
			Image temp = new Image(c64screen + i + ".png");
			splashScreen.add(temp);
		}
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		Input input = gc.getInput();
		if (input.isKeyPressed(Input.KEY_ENTER))
			sbg.enterState(1);
		if (counter < 20) {
			if (!switchBlink)
				g.drawImage(splashScreen.get(0), 0, 0);
			else
				g.drawImage(splashScreen.get(1), 0, 0);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			switchBlink = !switchBlink;
		}//39 is before title screen
		else if (counter > 19 && counter < 50) {
			g.drawImage(splashScreen.get(runBlinkcounter), 0, 0);
			runBlinkcounter++;
			if (runBlinkcounter == 21) {
				runBlinkcounter = 19;
			}
			if (counter < 49) {
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (counter == 49)
				runBlinkcounter = 20;
		}
		else {
			System.out.print(runBlinkcounter);
			runBlinkcounter++;
			g.drawImage(splashScreen.get(runBlinkcounter), 0, 0);
			try {
				Thread.sleep(5500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		counter++;
		if (runBlinkcounter == 27)
			sbg.enterState(1);
		
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		
	}
	
	public int getID(){
		return 0;
	}

}
