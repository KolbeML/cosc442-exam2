/*
 * 
 */
package ui;

import game.Creature;
import game.Item;

/**
 * The Class EquipScreen.
 */
public class EquipScreen extends InventoryBasedScreen {
	
	/**
	 * Instantiates a new equip screen.
	 *
	 * @param player the player
	 */
	public EquipScreen(Creature player) {
		super(player);
	}

	/**
	 * Returns options
	 */
	protected String getVerb() {
		return "wear or wield";
	}

	/**
	 * Determines if item has attack or defense value
	 */
	protected boolean isAcceptable(Item item) {
		return item.attackValue() > 0 || item.defenseValue() > 0;
	}

	/**
	 * Uses item
	 */
	protected Screen use(Item item) {
		player.equip(item);
		return null;
	}
}
