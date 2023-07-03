package Animals;

import java.util.Random;

import static Constants.Constants.*;
/**
 * MeerkatCreator class used in Meerkat's Constructor
 */
public abstract class MeerkatCreator {
    private static Random rand= new Random();
    /**
     * Returns a random int representing animal's strength specified according
     * to range of possible values for a Meerkat
     */
    static public int getStrength() {
        int meerkat_strength = rand.nextInt(MEERKAT_STRENGTH_RANGE) + MEERKAT_MIN_STRENGTH;
        return meerkat_strength;
    }
    /**
     * Returns a random int representing animal's speed specified according
     * to range of possible values for a Meerkat
     */
    static public int getSpeed() {
        int meerkat_speed = rand.nextInt(MEERKAT_SPEED_RANGE) + MEERKAT_MIN_SPEED;
        return meerkat_speed;
    }
    /**
     * Returns a random int representing animal's health specified according
     * to range of possible values for a Meerkat
     */
    static public int getHealth() {
        int meerkat_health = rand.nextInt(MEERKAT_HEALTH_RANGE) + MEERKAT_MIN_HEALTH;
        return meerkat_health;
    }
    /**
     * Returns a random int representing animal's max water level specified according
     * to range of possible values for a Meerkat
     */
    static public int getMaxWaterLevel() {
        int meerkat_max_water_level = rand.nextInt(MEERKAT_WATER_LEVEL_RANGE) + MEERKAT_MIN_WATER_LEVEL;
        return meerkat_max_water_level;
    }
    /**
     * Returns a random int representing animal's max food level specified according
     * to range of possible values for a Meerkat
     */
    static public int getMaxFoodLevel() {
        int meerkat_max_food_level = rand.nextInt(MEERKAT_FOOD_LEVEL_RANGE) + MEERKAT_MIN_FOOD_LEVEL;
        return meerkat_max_food_level;
    }
    /**
     * Returns a random int representing animal's current water level specified according
     * to range of possible values for a Meerkat
     */
    static public int getCurrentWaterLevel() {
        int meerkat_current_water_level = rand.nextInt(MEERKAT_MIN_WATER_LEVEL);
        return meerkat_current_water_level;
    }
    /**
     * Returns a random int representing animal's current food level specified according
     * to range of possible values for a Meerkat
     */
    static public int getCurrentFoodLevel() {
        int meerkat_current_food_level = rand.nextInt(MEERKAT_MIN_FOOD_LEVEL);
        return meerkat_current_food_level;
    }
}
