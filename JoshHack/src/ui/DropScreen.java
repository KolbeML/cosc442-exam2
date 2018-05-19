/*
 * 
 */
package ui;

import game.Creature;
import game.Item;

/**
 * The Class DropScreen.
 */
public class DropScreen extends InventoryBasedScreen {

	/**
	 * Instantiates a new drop screen.
	 *
	 * @param player
	 *            the player
	 */
	public DropScreen(Creature player) {
		super(player);
	}

	/**
	 * Tells game to drop
	 */
	@Override
	protected String getVerb() {
		return "drop";
	}

	/**
	 * Always returns acceptable
	 */
	@Override
	protected boolean isAcceptable(Item item) {
		return true;
	}

	/**
	 * Drops item
	 */
	@Override
	protected Screen use(Item item) {
		player.drop(item);
		return null;
	}
}
