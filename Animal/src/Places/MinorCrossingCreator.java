package Places;

import java.util.Random;

/**
 * Class used in creation of MinorCrossing
 */
public class MinorCrossingCreator {
    static private Random rand= new Random();
    final private static String[] names={"Crossing McCross", "Crossing 2, Electric Boogaloo",
    "Rondo Rataje", "Big O' Crossing", "The King Crossing", "The New Crossing", "The Nice Crossing"};

    /**
     * @return valid name of a crossing (String)
     */
    public static String getName(){
        int name_num= rand.nextInt(names.length);
        return names[name_num];
    }
}
