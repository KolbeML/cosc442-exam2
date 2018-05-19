/*
 * 
 */
package ui;

import game.Creature;
import game.Item;
import game.Line;
import game.Point;

/**
 * The Class ThrowAtScreen.
 */
public class ThrowAtScreen extends TargetBasedScreen {

	/** The item. */
	private Item item;

	/**
	 * Instantiates a new throw at screen.
	 *
	 * @param player
	 *            the player
	 * @param sx
	 *            the sx
	 * @param sy
	 *            the sy
	 * @param item
	 *            the item
	 */
	public ThrowAtScreen(Creature player, int sx, int sy, Item item) {
		super(player, "Throw " + player.nameOf(item) + " at?", sx, sy);
		this.item = item;
	}

	public boolean isAcceptable(int x, int y) {
		if (!player.canSee(x, y, player.z)) {
			return false;
		}

		for (Point p : new Line(player.x, player.y, x, y)) {
			if (!player.realTile(p.x, p.y, player.z).isGround()) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Throws item to given coordinate.
	 */
	public void selectWorldCoordinate(int x, int y, int screenX, int screenY) {
		player.throwItem(item, x, y, player.z);
	}
}
