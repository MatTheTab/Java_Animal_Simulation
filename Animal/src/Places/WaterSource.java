package Places;

import Animals.Prey;

import javax.swing.*;

import static Constants.Constants.WATER_SOURCE_IMAGE_PATH;

/**
 * Class Representing the WaterSource in the simulation
 */
public class WaterSource extends LifeSource{
    /**
     * WaterSource Constructor
     * @param x - (int) x coordinate of the class
     * @param y - (int) y coordinate of the class
     * @param _name_label - (JLabel) label used to display place's name
     * @param _place_label - (JLabel) label used to display name of place type
     * @param _capacity_label - (JLabel) label used to display place's capacity relative to max capacity
     * @param _location_label - (JLabel) label used to display place's location
     * @param _replenishing_label - (JLabel) label to display replenishing information
     * @param _consumption_label - (JLabel) label to display consumption information
     * @param _feeding_rate_label - (JLabel) label to display feeding information
     */
    public WaterSource(int x, int y, JLabel _name_label, JLabel _place_label,
                       JLabel _capacity_label, JLabel _location_label, JLabel _replenishing_label,
                       JLabel _consumption_label, JLabel _feeding_rate_label){
        super(x,y,WaterSourceCreator.getName(),"Water Source",WaterSourceCreator.getCapacity(),
                WaterSourceCreator.getReplenishingSpeed(),WaterSourceCreator.getConsumeMaterial(), WaterSourceCreator.getFeedingRate(),
                Place.getStaticImage(WATER_SOURCE_IMAGE_PATH), _name_label, _place_label,
                _capacity_label, _location_label, _replenishing_label, _consumption_label,
                _feeding_rate_label);
    }

    /**
     * Method checks if an animal can drink at a given target
     * @param target - (Place) Place for which the statement is checked
     * @return (boolean) whether an animal can drink here or not
     */
    public static synchronized boolean canDrink(Place target){
        if(target.getCapacity()>target.getCurrentOccupation() && ((WaterSource)target).getResources()>0){
            target.incrementOccupation();
            return true;
        }
        return false;
    }
}
