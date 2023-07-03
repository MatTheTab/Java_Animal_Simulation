package Animals;

import java.util.Random;

import static Constants.Constants.*;
/**
 * LionCreator class used in Lion's Constructor
 */
public abstract class LionCreator {
    private static Random rand= new Random();
    /**
     * Returns a random int representing animal's strength specified according
     * to range of possible values for a Lion
     */
    static public int getStrength() {
        int lion_strength = rand.nextInt(LION_STRENGTH_RANGE) + LION_MIN_STRENGTH;
        return lion_strength;
    }
    /**
     * Returns a random int representing animal's speed specified according
     * to range of possible values for a Lion
     */
    static public int getSpeed() {
        int lion_speed = rand.nextInt(LION_SPEED_RANGE) + LION_MIN_SPEED;
        return lion_speed;
    }
    /**
     * Returns a random int representing animal's health specified according
     * to range of possible values for a Lion
     */
    static public int getHealth() {
        int lion_health = rand.nextInt(LION_HEALTH_RANGE) + LION_MIN_HEALTH;
        return lion_health;
    }
    /**
     * Returns a random int representing animal's prey sense specified according
     * to range of possible values for a Lion
     */
    static public int getPreySense() {
        int lion_prey_sense = rand.nextInt(LION_PREY_SENSE_RANGE) + LION_MIN_PREY_SENSE;
        return lion_prey_sense;
    }
    /**
     * Returns a random int representing animal's max relax level specified according
     * to range of possible values for a Lion
     */
    static public int getMaxRelaxLevel() {
        int lion_max_relax_level = rand.nextInt(LION_RELAX_LEVEL_RANGE) + LION_MIN_RELAX_LEVEL;
        return lion_max_relax_level;
    }
}
