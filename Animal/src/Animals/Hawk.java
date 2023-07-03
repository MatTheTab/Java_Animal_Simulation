package Animals;

import Miscalenious.Converter;

import javax.swing.*;

import static Constants.Constants.*;
/**
 * Hawk class, subclass of Predator class, all the functionality remains unchanged from
 * the parent class. Implemented separately for clarity and convenience sake.
 */
public class Hawk extends Predator{
    /**
     * Constructor of Hawk class
     * @param x - (int) x coordinate of the animal
     * @param y - (int) y coordinate of the animal
     * @param name_label - (JLabel) label for displaying animal's name
     * @param species_label - (JLabel) label for displaying animal's species
     * @param health_label - (JLabel) label for displaying animal's health
     * @param strength_label - (JLabel) label for displaying animal's strength
     * @param speed_label - (JLabel) label for displaying animal's speed
     * @param location_label - (JLabel) label for displaying animal's location
     * @param status_label - (JLabel) label for displaying animal's status, e.g. hunting,resting
     * @param relax_level_label - (JLabel) label for displaying animal's current_relax_level
     * @param kill_label - (JLabel) label for displaying animal's current kill_count
     */
    public Hawk(int x, int y, JLabel name_label, JLabel species_label, JLabel health_label,
                JLabel strength_label, JLabel speed_label, JLabel location_label,
                JLabel status_label, JLabel relax_level_label, JLabel kill_label){
        super(x, y, NameGenerator.getName(), "Hyena", HawkCreator.getStrength(),
                HawkCreator.getStrength(), HawkCreator.getHealth(),
                HawkCreator.getPreySense(), 0,
                HawkCreator.getMaxRelaxLevel(), Converter.pathToImage(HAWK_IMAGE_PATH),
                Converter.pathToImage(HAWK_SLEEP_IMAGE_PATH), Converter.pathToImage(HAWK_ATTACK_IMAGE_PATH),
                name_label, species_label,health_label, strength_label,
                speed_label, location_label,status_label, relax_level_label, kill_label);
    }
}
