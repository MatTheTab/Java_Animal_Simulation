package Animals;

import java.util.Random;

import static Constants.Constants.*;
/**
 * CrocodileCreator class used in Crocodile's Constructor
 */
public abstract class CrocodileCreator {
    /**
     * Returns a random int representing animal's strength specified according
     * to range of possible values for a Crocodile
     */
    private static Random rand= new Random();
    static public int getStrength() {
        int Crocodile_strength = rand.nextInt(CROCODILE_STRENGTH_RANGE) + CROCODILE_MIN_STRENGTH;
        return Crocodile_strength;
    }
    /**
     * Returns a random int representing animal's speed specified according
     * to range of possible values for a Crocodile
     */
    static public int getSpeed() {
        int crocodile_speed = rand.nextInt(CROCODILE_SPEED_RANGE) + CROCODILE_MIN_SPEED;
        return crocodile_speed;
    }
    /**
     * Returns a random int representing animal's health specified according
     * to range of possible values for a Crocodile
     */
    static public int getHealth() {
        int crocodile_health = rand.nextInt(CROCODILE_HEALTH_RANGE) + CROCODILE_MIN_HEALTH;
        return crocodile_health;
    }
    /**
     * Returns a random int representing animal's prey sense specified according
     * to range of possible values for a Crocodile
     */
    static public int getPreySense() {
        int crocodile_prey_sense = rand.nextInt(CROCODILE_PREY_SENSE_RANGE) + CROCODILE_MIN_PREY_SENSE;
        return crocodile_prey_sense;
    }
    /**
     * Returns a random int representing animal's max relax level specified according
     * to range of possible values for a Crocodile
     */
    static public int getMaxRelaxLevel() {
        int crocodile_max_relax_level = rand.nextInt(CROCODILE_RELAX_LEVEL_RANGE) + CROCODILE_MIN_RELAX_LEVEL;
        return crocodile_max_relax_level;
    }
}
