package Animals;

import java.util.Random;

import static Constants.Constants.*;
/**
 * HyenaCreator class used in Hyena's Constructor
 */
public abstract class HyenaCreator {
    private static Random rand= new Random();
    /**
     * Returns a random int representing animal's strength specified according
     * to range of possible values for a Hyena
     */
    static public int getStrength() {
        int hyena_strength = rand.nextInt(HYENA_STRENGTH_RANGE) + HYENA_MIN_STRENGTH;
        return hyena_strength;
    }
    /**
     * Returns a random int representing animal's speed specified according
     * to range of possible values for a Hyena
     */
    static public int getSpeed() {
        int hyena_speed = rand.nextInt(HYENA_SPEED_RANGE) + HYENA_MIN_SPEED;
        return hyena_speed;
    }
    /**
     * Returns a random int representing animal's health specified according
     * to range of possible values for a Hyena
     */
    static public int getHealth() {
        int hyena_health = rand.nextInt(HYENA_HEALTH_RANGE) + HYENA_MIN_HEALTH;
        return hyena_health;
    }
    /**
     * Returns a random int representing animal's prey sense specified according
     * to range of possible values for a Hyena
     */
    static public int getPreySense() {
        int hyena_prey_sense = rand.nextInt(HYENA_PREY_SENSE_RANGE) + HYENA_MIN_PREY_SENSE;
        return hyena_prey_sense;
    }
    /**
     * Returns a random int representing animal's max relax level specified according
     * to range of possible values for a Hyena
     */
    static public int getMaxRelaxLevel() {
        int hyena_max_relax_level = rand.nextInt(HYENA_RELAX_LEVEL_RANGE) + HYENA_MIN_RELAX_LEVEL;
        return hyena_max_relax_level;
    }
}
