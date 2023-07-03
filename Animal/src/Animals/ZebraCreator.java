package Animals;

import java.util.Random;

import static Constants.Constants.*;
/**
 * ZebraCreator class used in Zebra's Constructor
 */
public abstract class ZebraCreator {
    private static Random rand= new Random();
    /**
     * Returns a random int representing animal's strength specified according
     * to range of possible values for a Zebra
     */
    static public int getStrength() {
        int zebra_strength = rand.nextInt(ZEBRA_STRENGTH_RANGE) + ZEBRA_MIN_STRENGTH;
        return zebra_strength;
    }
    /**
     * Returns a random int representing animal's speed specified according
     * to range of possible values for a Zebra
     */
    static public int getSpeed() {
        int zebra_speed = rand.nextInt(ZEBRA_SPEED_RANGE) + ZEBRA_MIN_SPEED;
        return zebra_speed;
    }
    /**
     * Returns a random int representing animal's health specified according
     * to range of possible values for a Zebra
     */
    static public int getHealth() {
        int zebra_health = rand.nextInt(ZEBRA_HEALTH_RANGE) + ZEBRA_MIN_HEALTH;
        return zebra_health;
    }
    /**
     * Returns a random int representing animal's max water level specified according
     * to range of possible values for a Zebra
     */
    static public int getMaxWaterLevel() {
        int zebra_max_water_level = rand.nextInt(ZEBRA_WATER_LEVEL_RANGE) + ZEBRA_MIN_WATER_LEVEL;
        return zebra_max_water_level;
    }
    /**
     * Returns a random int representing animal's max food level specified according
     * to range of possible values for a Zebra
     */
    static public int getMaxFoodLevel() {
        int zebra_max_food_level = rand.nextInt(ZEBRA_FOOD_LEVEL_RANGE) + ZEBRA_MIN_FOOD_LEVEL;
        return zebra_max_food_level;
    }
    /**
     * Returns a random int representing animal's current water level specified according
     * to range of possible values for a Zebra
     */
    static public int getCurrentWaterLevel() {
        int zebra_current_water_level = rand.nextInt(ZEBRA_MIN_WATER_LEVEL);
        return zebra_current_water_level;
    }
    /**
     * Returns a random int representing animal's current food level specified according
     * to range of possible values for a Zebra
     */
    static public int getCurrentFoodLevel() {
        int zebra_current_food_level = rand.nextInt(ZEBRA_MIN_FOOD_LEVEL);
        return zebra_current_food_level;
    }
}
