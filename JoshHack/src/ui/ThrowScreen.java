/*
 * 
 */
package ui;

import game.Creature;
import game.Item;

/**
 * The Class ThrowScreen.
 */
public class ThrowScreen extends InventoryBasedScreen {

	/** The sx. */
	private int sx;

	/** The sy. */
	private int sy;

	/**
	 * Instantiates a new throw screen.
	 *
	 * @param player
	 *            the player
	 * @param sx
	 *            the sx
	 * @param sy
	 *            the sy
	 */
	public ThrowScreen(Creature player, int sx, int sy) {
		super(player);
		this.sx = sx;
		this.sy = sy;
	}

	@Override
	protected String getVerb() {
		return "throw";
	}

	@Override
	protected boolean isAcceptable(Item item) {
		return true;
	}

	@Override
	protected Screen use(Item item) {
		return new ThrowAtScreen(player, sx, sy, item);
	}
}
