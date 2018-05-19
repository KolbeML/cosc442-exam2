package game;

import java.util.List;

/**
 * The Class PlayerAi.
 */
public class PlayerAi extends CreatureAi {
	
	/** The messages. */
	private List<String> messages;
	
	/** The fov. */
	private FieldOfView fov;
	
	/**
	 * Instantiates a new player ai.
	 *
	 * @param creature the creature
	 * @param messages the messages
	 * @param fov the fov
	 */
	public PlayerAi(Creature creature, List<String> messages, FieldOfView fov) {
		super(creature);
		this.messages = messages;
		this.fov = fov;
	}

	/**
	 * Determines action when player enters a tile.
	 */
	public void onEnter(int x, int y, int z, Tile tile){
		if (tile.isGround()){
			creature.x = x;
			creature.y = y;
			creature.z = z;
			
			Item item = creature.item(creature.x, creature.y, creature.z);
			if (item != null) {
				creature.notify("There's a " + creature.nameOf(item) + " here.");
			}
		} else if (tile.isDiggable()) {
			creature.dig(x, y, z);
		}
	}
	
	/**
	 * Add message to messages.
	 */
	public void onNotify(String message){
		messages.add(message);
	}
	
	/* Checks what the player can see
	 */
	public boolean canSee(int wx, int wy, int wz) {
		return fov.isVisible(wx, wy, wz);
	}
	
	/* ?
	 */
	public void onGainLevel(){
	}

	/* Returns remembered tile.
	 */
	public Tile rememberedTile(int wx, int wy, int wz) {
		return fov.tile(wx, wy, wz);
	}
}
