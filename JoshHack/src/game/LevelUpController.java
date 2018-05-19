package game;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class LevelUpController.
 */
public class LevelUpController {

	/**
	 * Contains all options a user is given when levelling up; they may choose only
	 * one per level.
	 */
	private static LevelUpOption[] options = new LevelUpOption[] { new LevelUpOption("Increased hit points") {
		public void invoke(Creature creature) {
			creature.modifyMaxHp(10);
			creature.modifyHp(10, "Died from increaced hp level-up bonus?");
			creature.doAction("look a lot healthier");
		}
	}, new LevelUpOption("Increased mana") {
		public void invoke(Creature creature) {
			creature.modifyMaxMana(5);
			creature.modifyMana(5);
			creature.doAction("look more magical");
		}
	}, new LevelUpOption("Increased attack value") {
		public void invoke(Creature creature) {
			creature.modifyAttackValue(2);
			creature.doAction("look stronger");
		}
	}, new LevelUpOption("Increased defense value") {
		public void invoke(Creature creature) {
			creature.modifyDefenseValue(1);
			creature.doAction("look a little tougher");
		}
	}, new LevelUpOption("Increased vision") {
		public void invoke(Creature creature) {
			creature.modifyVisionRadius(1);
			creature.doAction("look a little more aware");
		}
	}, new LevelUpOption("Increased hp regeneration") {
		public void invoke(Creature creature) {
			creature.modifyRegenHpPer1000(10);
			creature.doAction("look a little less bruised");
		}
	}, new LevelUpOption("Increased mana regeneration") {
		public void invoke(Creature creature) {
			creature.modifyRegenManaPer1000(10);
			creature.doAction("look a little less tired");
		}
	} };

	/**
	 * Auto level up, for non-player creatures.
	 *
	 * @param creature
	 *            the creature
	 */
	public void autoLevelUp(Creature creature) {
		options[(int) (Math.random() * options.length)].invoke(creature);
	}

	/**
	 * Gets the level up options.
	 *
	 * @return the level up options
	 */
	public List<String> getLevelUpOptions() {
		List<String> names = new ArrayList<>();
		for (LevelUpOption option : options) {
			names.add(option.name());
		}
		return names;
	}

	/**
	 * Gets the level up option.
	 *
	 * @param name
	 *            the name
	 * @return the level up option
	 */
	public LevelUpOption getLevelUpOption(String name) {
		for (LevelUpOption option : options) {
			if (option.name().equals(name)) {
				return option;
			}
		}
		return null;
	}
}
