package game;

/**
 * The Class BatAi.
 */
public class BatAi extends CreatureAi {

	/**
	 * Instantiates a new bat ai.
	 *
	 * @param creature
	 *            the bat creature
	 */
	public BatAi(Creature creature) {
		super(creature);
	}

	public void onUpdate() {
		wander();
		wander();
	}
}
