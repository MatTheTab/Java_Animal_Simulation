package Animals;

import java.util.Random;

/**
 * Abstract class responsible for storing and picking random names from predefined names array
 */
public abstract class NameGenerator {
    static private final String[] names={"Liam", "Kai", "Xavier", "John", "Mat", "Jojo", "Wilhelm",
    "Olivia", "Kai", "Juliet", "Margaret", "Bob", "Jack", "Nevile", "Aigon", "Ned", "Gru", "Shrek",
    "Steve", "Henry", "Violet", "Clark", "Michael", "Morgan", "Al", "Sigmund", "Marcus", "Mark",
    "Jeff", "Arthur"};
    static private Random rand=new Random();

    /**
     * Method responsible for returning a random name from a predefined array of names
     * @return name (String)
     */
    static public String getName(){
        int name_num= rand.nextInt(names.length);
        return names[name_num];
    };
}
