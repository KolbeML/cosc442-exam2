package game;

/**
 * The Class FungusAi.
 */
public class FungusAi extends CreatureAi {
	
	/** The factory. */
	private StuffFactory factory;
	
	/** The spreadcount. */
	private int spreadcount;
	
	/**
	 * Instantiates a new fungus ai.
	 *
	 * @param creature the creature
	 * @param factory the factory
	 */
	public FungusAi(Creature creature, StuffFactory factory) {
		super(creature);
		this.factory = factory;
	}

	/** 
	 * Checks fungal spread on update.
	 */
	public void onUpdate(){
		if (spreadcount < 5 && Math.random() < 0.01) {
			spread();
		}
	}
	
	/**
	 * The fungal 'spread' action.
	 */
	private void spread(){
		int x = creature.x + (int)(Math.random() * 11) - 5;
		int y = creature.y + (int)(Math.random() * 11) - 5;
		
		if (!creature.canEnter(x, y, creature.z)) {
			return;
		}
		
		creature.doAction("spawn a child");
		
		Creature child = factory.newFungus(creature.z);
		child.x = x;
		child.y = y;
		child.z = creature.z;
		spreadcount++;
	}
}
