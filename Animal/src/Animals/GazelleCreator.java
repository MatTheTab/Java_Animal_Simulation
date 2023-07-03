package Animals;

import java.util.Random;

import static Constants.Constants.*;
/**
 * GazelleCreator class used in Gazelle's Constructor
 */
public abstract class GazelleCreator {
    /**
     * Returns a random int representing animal's strength specified according
     * to range of possible values for a Gazelle
     */
    private static Random rand= new Random();
    static public int getStrength() {
        int gazelle_strength = rand.nextInt(GAZELLE_STRENGTH_RANGE) + GAZELLE_MIN_STRENGTH;
        return gazelle_strength;
    }
    /**
     * Returns a random int representing animal's speed specified according
     * to range of possible values for a Gazelle
     */
    static public int getSpeed() {
        int gazelle_speed = rand.nextInt(GAZELLE_SPEED_RANGE) + GAZELLE_MIN_SPEED;
        return gazelle_speed;
    }
    /**
     * Returns a random int representing animal's health specified according
     * to range of possible values for a Gazelle
     */
    static public int getHealth() {
        int gazelle_health = rand.nextInt(GAZELLE_HEALTH_RANGE) + GAZELLE_MIN_HEALTH;
        return gazelle_health;
    }
    /**
     * Returns a random int representing animal's max water level specified according
     * to range of possible values for a Gazelle
     */
    static public int getMaxWaterLevel() {
        int gazelle_max_water_level = rand.nextInt(GAZELLE_WATER_LEVEL_RANGE) + GAZELLE_MIN_WATER_LEVEL;
        return gazelle_max_water_level;
    }
    /**
     * Returns a random int representing animal's max food level specified according
     * to range of possible values for a Gazelle
     */
    static public int getMaxFoodLevel() {
        int gazelle_max_food_level = rand.nextInt(GAZELLE_FOOD_LEVEL_RANGE) + GAZELLE_MIN_FOOD_LEVEL;
        return gazelle_max_food_level;
    }
    /**
     * Returns a random int representing animal's current water level specified according
     * to range of possible values for a Gazelle
     */
    static public int getCurrentWaterLevel() {
        int gazelle_current_water_level = rand.nextInt(GAZELLE_MIN_WATER_LEVEL);
        return gazelle_current_water_level;
    }
    /**
     * Returns a random int representing animal's current food level specified according
     * to range of possible values for a Gazelle
     */
    static public int getCurrentFoodLevel() {
        int gazelle_current_food_level = rand.nextInt(GAZELLE_MIN_FOOD_LEVEL);
        return gazelle_current_food_level;
    }
}
