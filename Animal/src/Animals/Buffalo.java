package Animals;

import Miscalenious.Converter;
import Places.MinorCrossing;
import Places.Path;

import javax.swing.*;

import java.util.Vector;

import static Constants.Constants.*;

/**
 * Buffalo class, subclass of Prey class, all the functionality remains unchanged from
 * the parent class. Implemented separately for clarity and convenience sake.
 */
public class Buffalo extends Prey{
    /**
     * Constructor of Buffalo class
     * @param x - (int) x coordinate of the animal
     * @param y - (int) y coordinate of the animal
     * @param _panel - (JPanel) panel on which the animal will be drawn
     * @param name_label - (JLabel) label for displaying animal's name
     * @param species_label - (JLabel) label for displaying animal's species
     * @param health_label - (JLabel) label for displaying animal's health
     * @param strength_label - (JLabel) label for displaying animal's strength
     * @param speed_label - (JLabel) label for displaying animal's speed
     * @param location_label - (JLabel) label for displaying animal's location
     * @param water_label - (JLabel) label for displaying animal's water level
     * @param food_label  - (JLabel) label for displaying animal's food level
     * @param hidden_label - (JLabel) label for displaying animal's hidden_status
     * @param _current_path - (Path) label for displaying animal's current_path
     * @param _current_path_position - (int) current position on the path vector
     * @param _crossings - (Vector) vector of crossings, used when selecting path to reach a target
     */
    public Buffalo(int x, int y, JPanel _panel, JLabel name_label, JLabel species_label,
                   JLabel health_label, JLabel strength_label, JLabel speed_label, JLabel location_label,
                   JLabel water_label, JLabel food_label, JLabel hidden_label,
                   Path _current_path, int _current_path_position, Vector<MinorCrossing> _crossings){
        super(x, y, NameGenerator.getName(), "Buffalo", BuffaloCreator.getStrength(),
                BuffaloCreator.getSpeed(), BuffaloCreator.getHealth(),
                BuffaloCreator.getMaxWaterLevel(), BuffaloCreator.getMaxFoodLevel(),
                BuffaloCreator.getCurrentWaterLevel(),
                BuffaloCreator.getCurrentFoodLevel(), _panel, Converter.pathToImage(BUFFALO_IMAGE_PATH),
                Converter.pathToImage(BUFFALO_SLEEP_IMAGE_PATH), Converter.pathToImage(BUFFALO_WATER_IMAGE_PATH),
                Converter.pathToImage(BUFFALO_FOOD_IMAGE_PATH),Converter.pathToImage(DEAD_ANIMAL_IMAGE_PATH),
                name_label, species_label, health_label, strength_label,
                speed_label, location_label,water_label, food_label, hidden_label,
                _current_path,_current_path_position,_crossings);
    }

}
