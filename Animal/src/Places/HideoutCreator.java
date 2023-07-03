package Places;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Class used in creation fo the Hideout
 */
public class HideoutCreator {
    private static Random rand=new Random();
    private static List<String> names =new ArrayList<>(Arrays.asList("Sanctuary", "Animal's Respite", "The Calm Cave",
    "Homely Hideout", "The Comfortable Cave", "The Safe Haven", "Restful Rise", "The Bunker",
    "Home Far from Home", "The Hide-away", "The Abode", "Predator-Go-Away", "Hidey-Hole",
    "The Safe Spot"));

    /**
     * Return hideout's unique name
     * @return name(String)
     */
    public static String getName(){
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
     * Returns a random integer from a range showing hideout's capacity
     * @return (int) capacity
     */
    public static int getCapacity(){
        return rand.nextInt(15)+1;
    }
}
