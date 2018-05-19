package game;

import ui.InventoryBasedScreen;
import ui.Screen;

/**
 * The Class EatScreen.
 */
public class EatScreen extends InventoryBasedScreen {
	
	/**
	 * Instantiates a new eat screen.
	 *
	 * @param player the player
	 */
	public EatScreen(Creature player) {
		super(player);
	}

	@Override
	protected String getVerb() {
		return "eat";
	}

	@Override
	protected boolean isAcceptable(Item item) {
		return item.foodValue() != 0;
	}

	@Override
	protected Screen use(Item item) {
		player.eat(item);
		return null;
	}
}
