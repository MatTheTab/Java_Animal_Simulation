package Constants;

import java.awt.*;

/**
 * Class containing constants to be used in other parts of the program. Contains ranges of numbers
 * for animal's stats as well as paths to animals' and destinations' pictures.
 */
public final class Constants {
    //MAP
    static Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int MAPSIZE_WIDTH = (int)size.getWidth();
    public static final int MAPSIZE_HEIGHT = (int)size.getHeight();
    public static final int NUM_HIDEOUTS=5;
    public static final int NUM_PLANTS=5;
    public static final int NUM_WATER_SOURCES=5;
    //PLACES
    public static final int CHANCE_TO_CONNECT=2; //%
    public static final int CHANCE_TO_PICK_RANDOM_PATH=5; //%
    public static final int NUM_POSSIBLE_CROSSROADS=5;
    //IMAGES
    public static int PLACE_SIZE=200;
    public static String DEAD_ANIMAL_IMAGE_PATH="bones.png";
    public static String PLANT_IMAGE_PATH="Plant_pixels.png";
    public static String WATER_SOURCE_IMAGE_PATH="watersource_pixels.png";
    public static String HIDEOUT_IMAGE_PATH="cave_pixels.png";
    public static String ZEBRA_IMAGE_PATH="Zebra_pixels.png";
    public static String ZEBRA_WATER_IMAGE_PATH="Zebra_water_pixels.png";
    public static String ZEBRA_FOOD_IMAGE_PATH="Zebra_food_pixels.png";
    public static String ZEBRA_SLEEP_IMAGE_PATH="Zebra_sleeping_pixels.png";
    public static String MEERKAT_IMAGE_PATH="meerkat_pixels.png";
    public static String MEERKAT_WATER_IMAGE_PATH="meerkat_water_pixels.png";
    public static String MEERKAT_FOOD_IMAGE_PATH="meerkat_food_pixels.png";
    public static String MEERKAT_SLEEP_IMAGE_PATH="meerkat_sleeping_pixels.png";
    public static String BUFFALO_IMAGE_PATH="Buffalo_pixels.png";
    public static String BUFFALO_WATER_IMAGE_PATH="Buffalo_water_pixels.png";
    public static String BUFFALO_FOOD_IMAGE_PATH="Buffalo_food_pixels.png";
    public static String BUFFALO_SLEEP_IMAGE_PATH="Buffalo_sleeping_pixels.png";
    public static String GAZELLE_IMAGE_PATH="gazelle_pixels.png";
    public static String GAZELLE_WATER_IMAGE_PATH="gazelle_water_pixels.png";
    public static String GAZELLE_FOOD_IMAGE_PATH="gazelle_food_pixels.png";
    public static String GAZELLE_SLEEP_IMAGE_PATH="gazelle_sleeping_pixels.png";
    public static String LION_IMAGE_PATH="Lion_pixels.png";
    public static String LION_ATTACK_IMAGE_PATH="Lion_attack_pixels.png";
    public static String LION_SLEEP_IMAGE_PATH="Lion_sleeping_pixels.png";
    public static String CROCODILE_IMAGE_PATH="crocodile_pixels.png";
    public static String CROCODILE_ATTACK_IMAGE_PATH="crocodile_attack_pixels.png";
    public static String CROCODILE_SLEEP_IMAGE_PATH="crocodile_sleeping_pixels.png";
    public static String HAWK_IMAGE_PATH="hawk_pixels.png";
    public static String HAWK_ATTACK_IMAGE_PATH="hawk_attack_pixels.png";
    public static String HAWK_SLEEP_IMAGE_PATH="hawk_sleeping_pixels.png";
    public static String HYENA_IMAGE_PATH="hyena_pixels.png";
    public static String HYENA_ATTACK_IMAGE_PATH="hyena_attack_pixels.png";
    public static String HYENA_SLEEP_IMAGE_PATH="hyena_sleeping_pixels.png";
    public static String CROSSING_IMAGE_PATH="crossing_2_pixels.png";
    //ANIMAL
    public static final int SLEEP_TIME=250;
    public static final String ANIMAL_SPECIES[]={"Lion","Crocodile","Hawk","Hyena","Buffalo","Zebra","Gazelle","Meerkat"};
    // PREDATOR
    public static final int PREDATOR_STARTING_RELAX_LEVEL=0;
    public static final int ATTACK_RANGE=3;
    // Prey
    public static final int THIRST_CHANCE=5; // in %
    public static final int STARVATION_CHANCE=5; // in %
    public static int REPRODUCTION_PROBABILITY=50; // Probability given in %
    public static final int WATER_INCREASE=3;
    public static final int FOOD_INCREASE=3;
    // BUFFALO
    public static final int BUFFALO_MAX_STRENGTH=105;
    public static final int BUFFALO_MIN_STRENGTH=25;
    public static final int BUFFALO_STRENGTH_RANGE=BUFFALO_MAX_STRENGTH-BUFFALO_MIN_STRENGTH;
    public static final int BUFFALO_MAX_SPEED=20;
    public static final int BUFFALO_MIN_SPEED=4;
    public static final int BUFFALO_SPEED_RANGE=BUFFALO_MAX_SPEED-BUFFALO_MIN_SPEED;
    public static final int BUFFALO_MAX_HEALTH=125;
    public static final int BUFFALO_MIN_HEALTH=25;
    public static final int BUFFALO_HEALTH_RANGE=BUFFALO_MAX_HEALTH-BUFFALO_MIN_HEALTH;
    public static final int BUFFALO_MAX_WATER_LEVEL=25;
    public static final int BUFFALO_MIN_WATER_LEVEL=10;
    public static final int BUFFALO_WATER_LEVEL_RANGE=BUFFALO_MAX_WATER_LEVEL-BUFFALO_MIN_WATER_LEVEL;
    public static final int BUFFALO_MAX_FOOD_LEVEL=20;
    public static final int BUFFALO_MIN_FOOD_LEVEL=5;
    public static final int BUFFALO_FOOD_LEVEL_RANGE=BUFFALO_MAX_FOOD_LEVEL-BUFFALO_MIN_FOOD_LEVEL;

    //CROCODILE
    public static final int CROCODILE_MAX_STRENGTH=180;
    public static final int CROCODILE_MIN_STRENGTH=60;
    public static final int CROCODILE_STRENGTH_RANGE=CROCODILE_MAX_STRENGTH-CROCODILE_MIN_STRENGTH;
    public static final int CROCODILE_MAX_SPEED=8;
    public static final int CROCODILE_MIN_SPEED=3;
    public static final int CROCODILE_SPEED_RANGE=CROCODILE_MAX_SPEED-CROCODILE_MIN_SPEED;
    public static final int CROCODILE_MAX_HEALTH=150;
    public static final int CROCODILE_MIN_HEALTH=50;
    public static final int CROCODILE_HEALTH_RANGE=CROCODILE_MAX_HEALTH-CROCODILE_MIN_HEALTH;
    public static final int CROCODILE_MAX_PREY_SENSE=50;
    public static final int CROCODILE_MIN_PREY_SENSE=20;
    public static final int CROCODILE_PREY_SENSE_RANGE=CROCODILE_MAX_PREY_SENSE-CROCODILE_MIN_PREY_SENSE;
    public static final int CROCODILE_MAX_RELAX_LEVEL=15;
    public static final int CROCODILE_MIN_RELAX_LEVEL=5;
    public static final int CROCODILE_RELAX_LEVEL_RANGE=CROCODILE_MAX_RELAX_LEVEL-CROCODILE_MIN_RELAX_LEVEL;

    //GAZELLE
    public static final int GAZELLE_MAX_STRENGTH=70;
    public static final int GAZELLE_MIN_STRENGTH=20;
    public static final int GAZELLE_STRENGTH_RANGE=GAZELLE_MAX_STRENGTH-GAZELLE_MIN_STRENGTH;
    public static final int GAZELLE_MAX_SPEED=9;
    public static final int GAZELLE_MIN_SPEED=3;
    public static final int GAZELLE_SPEED_RANGE=GAZELLE_MAX_SPEED-GAZELLE_MIN_SPEED;
    public static final int GAZELLE_MAX_HEALTH=70;
    public static final int GAZELLE_MIN_HEALTH=20;
    public static final int GAZELLE_HEALTH_RANGE=GAZELLE_MAX_HEALTH-GAZELLE_MIN_HEALTH;
    public static final int GAZELLE_MAX_WATER_LEVEL=15;
    public static final int GAZELLE_MIN_WATER_LEVEL=10;
    public static final int GAZELLE_WATER_LEVEL_RANGE=GAZELLE_MAX_WATER_LEVEL-GAZELLE_MIN_WATER_LEVEL;
    public static final int GAZELLE_MAX_FOOD_LEVEL=30;
    public static final int GAZELLE_MIN_FOOD_LEVEL=10;
    public static final int GAZELLE_FOOD_LEVEL_RANGE=GAZELLE_MAX_FOOD_LEVEL-GAZELLE_MIN_FOOD_LEVEL;

    //HAWK
    public static final int HAWK_MAX_STRENGTH=50;
    public static final int HAWK_MIN_STRENGTH=20;
    public static final int HAWK_STRENGTH_RANGE=HAWK_MAX_STRENGTH-HAWK_MIN_STRENGTH;
    public static final int HAWK_MAX_SPEED=50;
    public static final int HAWK_MIN_SPEED=25;
    public static final int HAWK_SPEED_RANGE=HAWK_MAX_SPEED-HAWK_MIN_SPEED;
    public static final int HAWK_MAX_HEALTH=40;
    public static final int HAWK_MIN_HEALTH=20;
    public static final int HAWK_HEALTH_RANGE=HAWK_MAX_HEALTH-HAWK_MIN_HEALTH;
    public static final int HAWK_MAX_PREY_SENSE=100;
    public static final int HAWK_MIN_PREY_SENSE=40;
    public static final int HAWK_PREY_SENSE_RANGE=HAWK_MAX_PREY_SENSE-HAWK_MIN_PREY_SENSE;
    public static final int HAWK_MAX_RELAX_LEVEL=7;
    public static final int HAWK_MIN_RELAX_LEVEL=4;
    public static final int HAWK_RELAX_LEVEL_RANGE=HAWK_MAX_RELAX_LEVEL-HAWK_MIN_RELAX_LEVEL;

    //HYENA
    public static final int HYENA_MAX_STRENGTH=100;
    public static final int HYENA_MIN_STRENGTH=40;
    public static final int HYENA_STRENGTH_RANGE=HYENA_MAX_STRENGTH-HYENA_MIN_STRENGTH;
    public static final int HYENA_MAX_SPEED=17;
    public static final int HYENA_MIN_SPEED=5;
    public static final int HYENA_SPEED_RANGE=HYENA_MAX_SPEED-HYENA_MIN_SPEED;
    public static final int HYENA_MAX_HEALTH=90;
    public static final int HYENA_MIN_HEALTH=50;
    public static final int HYENA_HEALTH_RANGE=HYENA_MAX_HEALTH-HYENA_MIN_HEALTH;
    public static final int HYENA_MAX_PREY_SENSE=70;
    public static final int HYENA_MIN_PREY_SENSE=40;
    public static final int HYENA_PREY_SENSE_RANGE=HYENA_MAX_PREY_SENSE-HYENA_MIN_PREY_SENSE;
    public static final int HYENA_MAX_RELAX_LEVEL=7;
    public static final int HYENA_MIN_RELAX_LEVEL=2;
    public static final int HYENA_RELAX_LEVEL_RANGE=HYENA_MAX_RELAX_LEVEL-HYENA_MIN_RELAX_LEVEL;

    //LION
    public static final int LION_MAX_STRENGTH=150;
    public static final int LION_MIN_STRENGTH=50;
    public static final int LION_STRENGTH_RANGE=LION_MAX_STRENGTH-LION_MIN_STRENGTH;
    public static final int LION_MAX_SPEED=20;
    public static final int LION_MIN_SPEED=10;
    public static final int LION_SPEED_RANGE=LION_MAX_SPEED-LION_MIN_SPEED;
    public static final int LION_MAX_HEALTH=150;
    public static final int LION_MIN_HEALTH=50;
    public static final int LION_HEALTH_RANGE=LION_MAX_HEALTH-LION_MIN_HEALTH;
    public static final int LION_MAX_PREY_SENSE=70;
    public static final int LION_MIN_PREY_SENSE=30;
    public static final int LION_PREY_SENSE_RANGE=LION_MAX_PREY_SENSE-LION_MIN_PREY_SENSE;
    public static final int LION_MAX_RELAX_LEVEL=15;
    public static final int LION_MIN_RELAX_LEVEL=5;
    public static final int LION_RELAX_LEVEL_RANGE=LION_MAX_RELAX_LEVEL-LION_MIN_RELAX_LEVEL;

    //MEERKAT
    public static final int MEERKAT_MAX_STRENGTH=25;
    public static final int MEERKAT_MIN_STRENGTH=15;
    public static final int MEERKAT_STRENGTH_RANGE=MEERKAT_MAX_STRENGTH-MEERKAT_MIN_STRENGTH;
    public static final int MEERKAT_MAX_SPEED=8;
    public static final int MEERKAT_MIN_SPEED=2;
    public static final int MEERKAT_SPEED_RANGE=MEERKAT_MAX_SPEED-MEERKAT_MIN_SPEED;
    public static final int MEERKAT_MAX_HEALTH=30;
    public static final int MEERKAT_MIN_HEALTH=10;
    public static final int MEERKAT_HEALTH_RANGE=MEERKAT_MAX_HEALTH-MEERKAT_MIN_HEALTH;
    public static final int MEERKAT_MAX_WATER_LEVEL=15;
    public static final int MEERKAT_MIN_WATER_LEVEL=10;
    public static final int MEERKAT_WATER_LEVEL_RANGE=MEERKAT_MAX_WATER_LEVEL-MEERKAT_MIN_WATER_LEVEL;
    public static final int MEERKAT_MAX_FOOD_LEVEL=15;
    public static final int MEERKAT_MIN_FOOD_LEVEL=10;
    public static final int MEERKAT_FOOD_LEVEL_RANGE=MEERKAT_MAX_FOOD_LEVEL-MEERKAT_MIN_FOOD_LEVEL;

    //ZEBRA
    public static final int ZEBRA_MAX_STRENGTH=65;
    public static final int ZEBRA_MIN_STRENGTH=15;
    public static final int ZEBRA_STRENGTH_RANGE=ZEBRA_MAX_STRENGTH-ZEBRA_MIN_STRENGTH;
    public static final int ZEBRA_MAX_SPEED=13;
    public static final int ZEBRA_MIN_SPEED=5;
    public static final int ZEBRA_SPEED_RANGE=ZEBRA_MAX_SPEED-ZEBRA_MIN_SPEED;
    public static final int ZEBRA_MAX_HEALTH=80;
    public static final int ZEBRA_MIN_HEALTH=10;
    public static final int ZEBRA_HEALTH_RANGE=ZEBRA_MAX_HEALTH-ZEBRA_MIN_HEALTH;
    public static final int ZEBRA_MAX_WATER_LEVEL=25;
    public static final int ZEBRA_MIN_WATER_LEVEL=15;
    public static final int ZEBRA_WATER_LEVEL_RANGE=ZEBRA_MAX_WATER_LEVEL-ZEBRA_MIN_WATER_LEVEL;
    public static final int ZEBRA_MAX_FOOD_LEVEL=20;
    public static final int ZEBRA_MIN_FOOD_LEVEL=10;
    public static final int ZEBRA_FOOD_LEVEL_RANGE=ZEBRA_MAX_FOOD_LEVEL-ZEBRA_MIN_FOOD_LEVEL;
}
