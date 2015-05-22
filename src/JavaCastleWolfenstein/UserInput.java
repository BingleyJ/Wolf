package JavaCastleWolfenstein;

import org.newdawn.slick.Input;

public class UserInput {
	boolean editMode;
	int still = 0;
	int right = 1;
	int left = 2;
	int up = 3;
	int down = 4;

	public UserInput() {
		editMode = true;
	}
	//_____| Player Movement
	public void checkInput(Input input, Player player, EditMode inEditMode) {
		if (input.isKeyPressed(Input.KEY_Z)){
		inEditMode.sortObjectList();
		}
		if (input.isKeyPressed(Input.KEY_X)){
			inEditMode.printObjectList();
			}
		
		if (input.isKeyDown(Input.KEY_UP) && player.getPlayerY() > player.getMinPlayerY()){
			//_____| Move Player
			player.setPlayerY(player.getPlayerY() - player.getPlayerSpeed());
			player.setCurrentAnimation(up);
		}
		else
			player.setCurrentAnimation(still);
		if (input.isKeyDown(Input.KEY_DOWN) && player.getPlayerY() < player.getMaxPlayerY()){
			//_____| Move Player
			player.setPlayerY(player.getPlayerY() + player.getPlayerSpeed());	
			player.setCurrentAnimation(down);
		}
		if (input.isKeyDown(Input.KEY_LEFT) && player.getPlayerX() > player.getMinPlayerX()){
			//_____| Move Player
			player.setPlayerX(player.getPlayerX() - player.getPlayerSpeed());
			player.setCurrentAnimation(left);
		}
		if (input.isKeyDown(Input.KEY_RIGHT) && player.getPlayerX() < player.getMaxPlayerX()){
			//_____| Move Player
			player.setPlayerX(player.getPlayerX() + player.getPlayerSpeed());
			player.setCurrentAnimation(right);
		}
		
		//_____| Toggle Edit Mode
		if (input.isKeyPressed(Input.KEY_F1))
			inEditMode.setEditmode(!inEditMode.getEditmode());
		//_____| EDIT MODE
		if (inEditMode.getEditmode()) {
			if (input.isKeyPressed(Input.KEY_F2))
				inEditMode.setHudView(!inEditMode.getHudView());
			if (input.isKeyPressed(Input.KEY_V)) {
				inEditMode.drawVertWall();
			}
			if (input.isKeyPressed(Input.KEY_H)) {
				inEditMode.drawHorWall();
			}		
			if (input.isKeyPressed(Input.KEY_BACK)) {
				inEditMode.deleteLastObject();
			}
			if (input.isKeyPressed(Input.KEY_F12)) {
				inEditMode.nextObj();
			}
			if (input.isKeyPressed(Input.KEY_F11)) {
				inEditMode.lastObj();
			}
			if (input.isKeyPressed(Input.KEY_S)) {
				inEditMode.saveLevel();
			}
			if (input.isKeyDown(Input.KEY_ADD) && editMode)
				player.setPlayerSpeed(player.getPlayerSpeed() + 1);
			if (input.isKeyDown(Input.KEY_SUBTRACT) && editMode)
				player.setPlayerSpeed(player.getPlayerSpeed() - 1);
			if (player.getPlayerSpeed() <= 0)
				player.setPlayerSpeed(1);
			if (player.getPlayerSpeed() >= 10)
				player.setPlayerSpeed(10);
		}
	}
	
	public boolean getEditMode() {
		return editMode;
	}

	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}

}
