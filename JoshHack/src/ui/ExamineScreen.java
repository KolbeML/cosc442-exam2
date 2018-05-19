/*
 * 
 */
package ui;

import game.Creature;
import game.Item;

/**
 * The Class ExamineScreen.
 */
public class ExamineScreen extends InventoryBasedScreen {
	
	/**
	 * Instantiates a new examine screen.
	 *
	 * @param player the player
	 */
	public ExamineScreen(Creature player) {
		super(player);
	}

	/**
	 * Returns screen type
	 */
	@Override
	protected String getVerb() {
		return "examine";
	}

	/**
	 * Always acceptable!
	 */
	@Override
	protected boolean isAcceptable(Item item) {
		return true;
	}

	/**
	 * Returns item details in a full sentence.
	 */
	@Override
	protected Screen use(Item item) {
		String article = "aeiou".contains(player.nameOf(item).subSequence(0, 1)) ? "an " : "a ";
		player.notify("It's " + article + player.nameOf(item) + "." + item.details());
		return null;
	}
}
