package Places;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Class used for creating a new Plant object
 */
public class PlantCreator {
    static private final Random rand= new Random();
    final private static String[] species={"Baseball Plant", "Corpse Flower","Dragon Arum","African Starfish Flower",
            "Hydnora Africana", "Giant Water Lily", "Elephant-Foot Yam", "Grass", "Monkey Tail Cactus",
            "Tropical Pitcher Plants", "Venus Flytrap"};

    private static final List<String> names =new ArrayList<>(Arrays.asList("Greatwood", "The Oasis", "Lurnia of the Lakes", "Tuft of Plants", "The Great Plants",
    "Forest of Giant Plants", "The Succulent Meadow", "Cliffside Vegetation", "Grass",
            "Hydnora Africana", "Giant Water Lily", "Elephant-Foot Yam", "Baseball Plant", "Corpse Flower",
            "Dragon Arum","African Starfish Flower"));

    /**
     * @return (int) Plant's capacity, picked at random from specified range
     */
    static public int getCapacity(){
        int plant_capacity=rand.nextInt(15)+1;
        return plant_capacity;
    }

    /**
     * @return (int) Plant's replenishing rate, picked at random from specified range
     */
    static public int getReplenishingSpeed(){
        int plant_replenishing_speed=rand.nextInt(15)+1;
        return plant_replenishing_speed;
    }

    /**
     * Picks a unique name from possible list names. Causes an error (sets name to "Ooopsie") if there are
     * no more unique names left
     * @return (String) new_name
     */
    static public String getName(){
        if(names.size()==0){
            System.out.println("Error");
            return "Ooopsie";
        }
        int name_num= rand.nextInt(names.size());
        String new_name=names.get(name_num);
        names.remove(name_num);
        return new_name;
    }

    /**
     * @return (int) Plant's amount of consumable material, picked at random from a specified range
     */
    static public int getConsumeMaterial(){
        return rand.nextInt(100)+10;
    }

    /**
     * @return (int) feeding rate of the plant, picked at random from a specified range
     */
    static public int getFeedingRate(){ return rand.nextInt(5)+1; }
}
