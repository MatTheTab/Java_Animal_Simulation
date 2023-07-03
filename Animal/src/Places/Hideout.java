package Places;

import Animals.Prey;

import javax.swing.*;

import static Constants.Constants.HIDEOUT_IMAGE_PATH;

/**
 * Hideout Class represents Hideouts(caves) present on the game map, subclass of Place class.
 */
public class Hideout extends Place{
    /**
     * Hideout class constructor
     * @param _x - (int) x coordinate of the class
     * @param _y - (int) y coordinate of the class
     * @param _name_label - (JLabel) label used to display hideout's name
     * @param _place_label - (JLabel) label used to display name of place (hideout)
     * @param _capacity_label - (JLabel) label used to display hideout's capacity relative to max capacity
     * @param _location_label - (JLabel) label used to display hideout's location
     */
    public Hideout(int _x, int _y, JLabel _name_label, JLabel _place_label,
                   JLabel _capacity_label, JLabel _location_label){
        super(_x,_y,HideoutCreator.getName(),"Hideout",HideoutCreator.getCapacity(),Place.getStaticImage(HIDEOUT_IMAGE_PATH),
                _name_label, _place_label,_capacity_label, _location_label);
    }

    /**
     * Method returns boolean value determining if an animal can hide inside the hideout
     * @param target (Place)
     * @return if an animal can hide (boolean)
     */
    public static synchronized boolean canHide(Place target){
        if (target.getCapacity()>target.getCurrentOccupation()){
            target.incrementOccupation();
            return true;
        }
        return false;
    }
}
