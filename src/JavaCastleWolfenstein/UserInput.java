package JavaCastleWolfenstein;

import org.newdawn.slick.Input;

public class UserInput {
	boolean editMode;

	public UserInput() {
		editMode = true;
	}
	//_____| Player Movement
	public void checkInput(Input input, Player player, EditMode inEditMode) {
		if (input.isKeyDown(Input.KEY_UP) && player.getPlayerY() > player.getMinPlayerY())
			player.setPlayerY(player.getPlayerY() - player.getPlayerSpeed());
		if (input.isKeyDown(Input.KEY_DOWN) && player.getPlayerY() < player.getMaxPlayerY())
			player.setPlayerY(player.getPlayerY() + player.getPlayerSpeed());		
		if (input.isKeyDown(Input.KEY_LEFT) && player.getPlayerX() > player.getMinPlayerX())
			player.setPlayerX(player.getPlayerX() - player.getPlayerSpeed());
		if (input.isKeyDown(Input.KEY_RIGHT) && player.getPlayerX() < player.getMaxPlayerX())
			player.setPlayerX(player.getPlayerX() + player.getPlayerSpeed());
		
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
