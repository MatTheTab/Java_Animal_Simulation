package Animals;

import java.util.Random;

import static Constants.Constants.*;
/**
 * HawkCreator class used in Hawk's Constructor
 */
public abstract class HawkCreator {
    /**
     * Returns a random int representing animal's strength specified according
     * to range of possible values for a Hawk
     */
    private static Random rand= new Random();
    static public int getStrength() {
        int hawk_strength = rand.nextInt(HAWK_STRENGTH_RANGE) + HAWK_MIN_STRENGTH;
        return hawk_strength;
    }
    /**
     * Returns a random int representing animal's speed specified according
     * to range of possible values for a Hawk
     */
    static public int getSpeed() {
        int hawk_speed = rand.nextInt(HAWK_SPEED_RANGE) + HAWK_MIN_SPEED;
        return hawk_speed;
    }
    /**
     * Returns a random int representing animal's health specified according
     * to range of possible values for a Hawk
     */
    static public int getHealth() {
        int hawk_health = rand.nextInt(HAWK_HEALTH_RANGE) + HAWK_MIN_HEALTH;
        return hawk_health;
    }
    /**
     * Returns a random int representing animal's prey sense specified according
     * to range of possible values for a Hawk
     */
    static public int getPreySense() {
        int hawk_prey_sense = rand.nextInt(HAWK_PREY_SENSE_RANGE) + HAWK_MIN_PREY_SENSE;
        return hawk_prey_sense;
    }
    /**
     * Returns a random int representing animal's relax level specified according
     * to range of possible values for a Hawk
     */
    static public int getMaxRelaxLevel() {
        int hawk_max_relax_level = rand.nextInt(HAWK_RELAX_LEVEL_RANGE) + HAWK_MIN_RELAX_LEVEL;
        return hawk_max_relax_level;
    }
}
