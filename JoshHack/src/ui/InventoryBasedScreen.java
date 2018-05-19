/*
 * 
 */
package ui;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import asciiPanel.AsciiPanel;
import game.Creature;
import game.Item;

/**
 * The Class InventoryBasedScreen.
 */
public abstract class InventoryBasedScreen implements Screen {

	/** The player. */
	protected Creature player;

	/** The letters. */
	private String letters;

	/**
	 * Gets the verb.
	 *
	 * @return the verb
	 */
	protected abstract String getVerb();

	/**
	 * Checks if is acceptable.
	 *
	 * @param item
	 *            the item
	 * @return true, if is acceptable
	 */
	protected abstract boolean isAcceptable(Item item);

	/**
	 * Use.
	 *
	 * @param item
	 *            the item
	 * @return the screen
	 */
	protected abstract Screen use(Item item);

	/**
	 * Instantiates a new inventory based screen.
	 *
	 * @param player
	 *            the player
	 */
	public InventoryBasedScreen(Creature player) {
		this.player = player;
		this.letters = "abcdefghijklmnopqrstuvwxyz";
	}

	/**
	 * Prints prompt when user commits an action.
	 */
	public void displayOutput(AsciiPanel terminal) {
		ArrayList<String> lines = getList();

		int y = 23 - lines.size();
		int x = 4;

		if (!lines.isEmpty()) {
			terminal.clear(' ', x, y, 20, lines.size());
		}

		for (String line : lines) {
			terminal.write(line, x, y++);
		}

		terminal.clear(' ', 0, 23, 80, 1);
		terminal.write("What would you like to " + getVerb() + "?", 2, 23);

		terminal.repaint();
	}

	/**
	 * Gets the inventory list.
	 *
	 * @return the list
	 */
	private ArrayList<String> getList() {
		ArrayList<String> lines = new ArrayList<>();
		Item[] inventory = player.inventory().getItems();
		int j = 0;
		for (int i = 0; i < inventory.length; i++) {
			Item item = inventory[i];

			if (item == null || !isAcceptable(item)) {
				continue;
			}

			String line = letters.charAt(j) + " - " + item.glyph() + " " + player.nameOf(item);
			
			j++;
			
			if (item == player.weapon() || item == player.armor()) {
				line += " (equipped)";
			}

			lines.add(line);
		}
		return lines;
	}

	/**
	 * Determines action on user input.
	 */
	public Screen respondToUserInput(KeyEvent key) {
		char c = key.getKeyChar();

		Item[] items = player.inventory().getItems();

		if (letters.indexOf(c) > -1 && items.length > letters.indexOf(c) && items[letters.indexOf(c)] != null
				&& isAcceptable(items[letters.indexOf(c)])) {
			return use(items[letters.indexOf(c)]);
		} else if (key.getKeyCode() == KeyEvent.VK_ESCAPE) {
			return null;
		} else {
			return this;
		}
	}
}
