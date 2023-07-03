package Places;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Class used in creation of the WaterSource class object
 */
public class WaterSourceCreator {
    static private final Random rand= new Random();
    private static final List<String> names =new ArrayList<>(Arrays.asList("Lake Baikal", "Lough Neagh", "Caspian Sea",
    "Lake Tanganyika", "Lake Superior", "Lake MegaChad", "Loch Lomond", "Lake Victoria",
    "Loch Ness", "Mississippi River", "Nile River", "Ganges River", "Yangtze River",
    "Yangtze River", "Delaware River", "Angel Falls", "Niagara Falls", "Yosemite Falls",
    "Gullfoss", "Rhine Falls", "Mazury", "Lake Natron", "Good O' Lake"));

    /**
     * Picks a unique name from possible list names. Causes an error (sets name
     * to "Ooopsie" ) if there are no more unique names left
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
     * @return (int) WaterSource's capacity, picked at random from specified range
     */
    static public int getCapacity(){
        int water_source_capacity=rand.nextInt(15)+1;
        return water_source_capacity;
    }

    /**
     * @return (int) WaterSource's replenishing rate, picked at random from specified range
     */
    static public int getReplenishingSpeed(){
        int water_source_replenishing_speed=rand.nextInt(15)+1;
        return water_source_replenishing_speed;
    }

    /**
     * @return (int) WaterSource's amount of consumable material, picked at random from a specified range
     */
    static public int getConsumeMaterial(){
        return rand.nextInt(100)+10;
    }

    /**
     * @return (int) feeding rate of the WaterSource, picked at random from a specified range
     */
    static public int getFeedingRate(){
        return rand.nextInt(5)+1;
    }
}
