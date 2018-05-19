package game;

/**
 * The Class Inventory.
 */
public class Inventory {

	/** The items. */
	private Item[] items;

	/**
	 * Gets the items.
	 *
	 * @return the items
	 */
	public Item[] getItems() {
		return items;
	}

	/**
	 * Gets a given item.
	 *
	 * @param i
	 *            the i
	 * @return the item
	 */
	public Item get(int i) {
		return items[i];
	}

	/**
	 * Instantiates a new inventory.
	 *
	 * @param max
	 *            the max
	 */
	public Inventory(int max) {
		items = new Item[max];
	}

	/**
	 * Adds the item to inventory.
	 *
	 * @param item
	 *            the item
	 */
	public void add(Item item) {
		for (int i = 0; i < items.length; i++) {
			if (items[i] == null) {
				items[i] = item;
				break;
			}
		}
	}

	/**
	 * Removes the item from inventory.
	 *
	 * @param item
	 *            the item
	 */
	public void remove(Item item) {
		for (int i = 0; i < items.length; i++) {
			if (items[i] == item) {
				items[i] = null;
				return;
			}
		}
	}

	/**
	 * Checks if inventory is full.
	 *
	 * @return true, if is full
	 */
	public boolean isFull() {
		int size = 0;
		for (int i = 0; i < items.length; i++) {
			if (items[i] != null) {
				size++;
			}
		}
		return size == items.length;
	}

	/**
	 * Checks if inventory contains a given item.
	 *
	 * @param item
	 *            the item
	 * @return true, if successful
	 */
	public boolean contains(Item item) {
		for (Item i : items) {
			if (i == item) {
				return true;
			}
		}
		return false;
	}
}
