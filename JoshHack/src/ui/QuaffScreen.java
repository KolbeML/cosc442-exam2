/*
 * 
 */
package ui;

import game.Creature;
import game.Item;

/**
 * The Class QuaffScreen.
 */
public class QuaffScreen extends InventoryBasedScreen {
	
	/**
	 * Instantiates a new quaff screen.
	 *
	 * @param player the player
	 */
	public QuaffScreen(Creature player) {
		super(player);
	}

	@Override
	protected String getVerb() {
		return "quaff";
	}

	@Override
	protected boolean isAcceptable(Item item) {
		return item.quaffEffect() != null;
	}

	@Override
	protected Screen use(Item item) {
		player.quaff(item);
		return null;
	}
}
