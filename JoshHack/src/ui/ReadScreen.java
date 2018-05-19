/*
 * 
 */
package ui;

import game.Creature;
import game.Item;

/**
 * The Class ReadScreen.
 */
public class ReadScreen extends InventoryBasedScreen {
	
	/** The screen width. */
	private int sx;
	
	/** The screen height. */
	private int sy;
	
	/**
	 * Instantiates a new read screen.
	 *
	 * @param player the player
	 * @param sx the sx
	 * @param sy the sy
	 */
	public ReadScreen(Creature player, int sx, int sy) {
		super(player);
		this.sx = sx;
		this.sy = sy;
	}

	@Override
	protected String getVerb() {
		return "read";
	}

	@Override
	protected boolean isAcceptable(Item item) {
		return !item.writtenSpells().isEmpty();
	}

	@Override
	protected Screen use(Item item) {
		return new ReadSpellScreen(player, sx, sy, item);
	}
}
