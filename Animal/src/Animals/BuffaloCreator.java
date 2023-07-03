package Animals;

import java.util.Random;

import static Constants.Constants.*;

/**
 * BuffaloCreator class used in Buffalo's Constructor
 */
public abstract class BuffaloCreator {
    /**
     * Returns a random int representing animal's strength specified according
     * to range of possible values for a Buffalo
     */
    static private Random rand= new Random();
    static public int getStrength() {
        int buffalo_strength = rand.nextInt(BUFFALO_STRENGTH_RANGE) + BUFFALO_MIN_STRENGTH;
        return buffalo_strength;
    }
    /**
     * Returns a random int representing animal's speed specified according
     * to range of possible values for a Buffalo
     */
    static public int getSpeed() {
        int buffalo_speed = rand.nextInt(BUFFALO_SPEED_RANGE) + BUFFALO_MIN_SPEED;
        return buffalo_speed;
    }
    /**
     * Returns a random int representing animal's health specified according
     * to range of possible values for a Buffalo
     */
    static public int getHealth() {
        int buffalo_health = rand.nextInt(BUFFALO_HEALTH_RANGE) + BUFFALO_MIN_HEALTH;
        return buffalo_health;
    }
    /**
     * Returns a random int representing animal's max water level specified according
     * to range of possible values for a Buffalo
     */
    static public int getMaxWaterLevel() {
        int buffalo_max_water_level = rand.nextInt(BUFFALO_WATER_LEVEL_RANGE) + BUFFALO_MIN_WATER_LEVEL;
        return buffalo_max_water_level;
    }
    /**
     * Returns a random int representing animal's max food level specified according
     * to range of possible values for a Buffalo
     */
    static public int getMaxFoodLevel() {
        int buffalo_max_food_level = rand.nextInt(BUFFALO_FOOD_LEVEL_RANGE) + BUFFALO_MIN_FOOD_LEVEL;
        return buffalo_max_food_level;
    }
    /**
     * Returns a random int representing animal's current water level specified according
     * to range of possible values for a Buffalo
     */
    static public int getCurrentWaterLevel() {
        int buffalo_current_water_level = rand.nextInt(BUFFALO_MIN_WATER_LEVEL);
        return buffalo_current_water_level;
    }
    /**
     * Returns a random int representing animal's current food level specified according
     * to range of possible values for a Buffalo
     */
    static public int getCurrentFoodLevel() {
        int buffalo_current_food_level = rand.nextInt(BUFFALO_MIN_FOOD_LEVEL);
        return buffalo_current_food_level;
    }
}
