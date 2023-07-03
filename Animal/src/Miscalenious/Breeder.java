package Miscalenious;

import Animals.*;
import Screen.Map;

/**
 * Class created to implement the reproduction of animals. Used with  certian probability when
 * an animal enters a Hideout.
 */
public class Breeder {
    /**
     * Creates copy of an animal by checking what species of Prey it belongs to
     * and activating the corresponding copy function, for example copyBuffalo, copyGazelle, etc.
     * Copying works only for Preys and if new species is implemented, new code and
     * corresponding copy method should be added here. The copied animal is an exact copy of the parent.
     * @param _prey (Prey) animal to be replicated
     */
    public static void createCopy(Prey _prey){
        if(_prey instanceof Buffalo){
            copyBuffalo(_prey);
            return;
        }
        if(_prey instanceof Gazelle){
            copyGazelle(_prey);
            return;
        }
        if(_prey instanceof Meerkat){
            copyMeerkat(_prey);
            return;
        }
        if(_prey instanceof Zebra){
            copyZebra(_prey);
        }
    }

    /**
     * Method responsible for copying the Prey of species "Buffalo". It creates a new Buffalo and
     * then uses the method setAll() present in Prey class to copy attributes of the parent. Later
     * the new animal is added to the map.
     * @param _prey
     */
    private static void copyBuffalo(Prey _prey){
        Buffalo new_buffalo=new Buffalo(_prey.get_X(),_prey.get_Y(), _prey.getPanel(), _prey.getNameLabel(),_prey.getSpeciesLabel(),
                _prey.getHealthLabel(), _prey.getStrengthLabel(),_prey.getSpeedLabel(), _prey.getLocationLabel(),
                _prey.getWaterInfo(), _prey.getFoodInfo(), _prey.getHiddenInfo(),
                _prey.getCurrentPath(), _prey.getCurrentPathPosition(), _prey.getDestinations());
        new_buffalo.setAll(_prey.getStrength(),_prey.getSpeed(), _prey.getHealth(), _prey.getMaxWaterLevel(),_prey.setMaxFoodLevel());
        new_buffalo.activateMouseListener();
        Map.addPrey(new_buffalo);
        new_buffalo.getPanel().add(new_buffalo);
    }
    /**
     * Method responsible for copying the Prey of species "Gazelle". It creates a new Gazelle and
     * then uses the method setAll() present in Prey class to copy attributes of the parent. Later
     * the new animal is added to the map.
     * @param _prey
     */
    private static void copyGazelle(Prey _prey){
        Gazelle new_gazelle=new Gazelle(_prey.get_X(),_prey.get_Y(), _prey.getPanel(), _prey.getNameLabel(), _prey.getSpeciesLabel(),
                _prey.getHealthLabel(), _prey.getStrengthLabel(),_prey.getSpeedLabel(), _prey.getLocationLabel(),
                _prey.getWaterInfo(), _prey.getFoodInfo(), _prey.getHiddenInfo(),
                _prey.getCurrentPath(), _prey.getCurrentPathPosition(), _prey.getDestinations());
        new_gazelle.setAll(_prey.getStrength(),_prey.getSpeed(), _prey.getHealth(), _prey.getMaxWaterLevel(),_prey.setMaxFoodLevel());
        new_gazelle.activateMouseListener();
        Map.addPrey(new_gazelle);
        new_gazelle.getPanel().add(new_gazelle);
    }
    /**
     * Method responsible for copying the Prey of species "Meerkat". It creates a new Meerkat and
     * then uses the method setAll() present in Prey class to copy attributes of the parent. Later
     * the new animal is added to the map.
     * @param _prey
     */
    private static void copyMeerkat(Prey _prey){
        Meerkat new_meerkat=new Meerkat(_prey.get_X(), _prey.get_Y(), _prey.getPanel(), _prey.getNameLabel(), _prey.getSpeciesLabel(),
                _prey.getHealthLabel(), _prey.getStrengthLabel(),_prey.getSpeedLabel(), _prey.getLocationLabel(),
                _prey.getWaterInfo(), _prey.getFoodInfo(), _prey.getHiddenInfo(),
                _prey.getCurrentPath(), _prey.getCurrentPathPosition(), _prey.getDestinations());
        new_meerkat.setAll(_prey.getStrength(),_prey.getSpeed(), _prey.getHealth(), _prey.getMaxWaterLevel(),_prey.setMaxFoodLevel());
        new_meerkat.activateMouseListener();
        Map.addPrey(new_meerkat);
        new_meerkat.getPanel().add(new_meerkat);
    }
    /**
     * Method responsible for copying the Prey of species "Zebra". It creates a new Zebra and
     * then uses the method setAll() present in Prey class to copy attributes of the parent. Later
     * the new animal is added to the map.
     * @param _prey
     */
    private static void copyZebra(Prey _prey){
        Zebra new_zebra=new Zebra(_prey.get_X(), _prey.get_Y(), _prey.getPanel(), _prey.getNameLabel(), _prey.getSpeciesLabel(),
                _prey.getHealthLabel(), _prey.getStrengthLabel(),_prey.getSpeedLabel(), _prey.getLocationLabel(),
                _prey.getWaterInfo(), _prey.getFoodInfo(), _prey.getHiddenInfo(),
                _prey.getCurrentPath(), _prey.getCurrentPathPosition(), _prey.getDestinations());
        new_zebra.setAll(_prey.getStrength(),_prey.getSpeed(), _prey.getHealth(), _prey.getMaxWaterLevel(),_prey.setMaxFoodLevel());
        new_zebra.activateMouseListener();
        Map.addPrey(new_zebra);
        new_zebra.getPanel().add(new_zebra);
    }
}
