package Places;

import Animals.Prey;

import javax.swing.*;

import static Constants.Constants.PLANT_IMAGE_PATH;

/**
 * Class Representing the Vegetation and FoodSource in the simulation
 */
public class Plant extends LifeSource{
    /**
     * Plant Constructor
     * @param x - (int) x coordinate of the class
     * @param y - (int) y coordinate of the class
     * @param _name_label - (JLabel) label used to display place's name
     * @param _place_label - (JLabel) label used to display name of place type
     * @param _capacity_label - (JLabel) label used to display place's capacity relative to max capacity
     * @param _location_label - (JLabel) label used to display place's location
     * @param replenishing_label - (JLabel) label to display replenishing information
     * @param _consumption_label - (JLabel) label to display consumption information
     * @param _feeding_rate_label - (JLabel) label to display feeding information
     */
    public Plant(int x, int y, JLabel _name_label, JLabel _place_label,
                 JLabel _capacity_label, JLabel _location_label, JLabel replenishing_label,
                 JLabel _consumption_label, JLabel _feeding_rate_label){
        super(x,y,PlantCreator.getName(),"Vegetation",PlantCreator.getCapacity(),
                PlantCreator.getReplenishingSpeed(),PlantCreator.getConsumeMaterial(), PlantCreator.getFeedingRate(),
                Place.getStaticImage(PLANT_IMAGE_PATH), _name_label, _place_label, _capacity_label,
                _location_label, replenishing_label, _consumption_label, _feeding_rate_label);
    }

    /**
     * Method checks if an animal can eat at this place, weather it be due to capacity constraints or
     * the place not having enough consumable material.
     * @param target (Place) the place where the food is checked
     * @return (boolean) whether the animal can eat or not
     */
    public static synchronized boolean canEat(Place target){
        if(target.getCapacity()>target.getCurrentOccupation() && ((Plant)target).getResources()>0){
            target.incrementOccupation();
            return true;
        }
        return false;
    }
}
