package Miscalenious;

import Places.Hideout;
import Places.Place;
import Places.Plant;
import Places.WaterSource;
import Screen.Map;

import javax.swing.*;
import java.awt.*;

/**
 * Class used for converting values from one type to another, in cases where such conversions
 * were not originally implemented in Java.
 */
public class Converter {
    /**
     * Converts integer to a boolean value, such that 0 = false, !0 = true
     * @param val (int) value to be converted
     * @return (boolean) val != 0
     */
    public static boolean intToBool(int val) {
        return val != 0;
    }

    /**
     * Converts a boolean value to an integer, true=1 and false=0
     * @param val (boolean) value to be converted
     * @return (int) converted value, val ? 1 : 0
     */
    public static int boolToInt(boolean val) {
        return val ? 1 : 0;
    }

    /**
     * Converts path to an image to an Image type object
     * @param file_path (String) path to a JPEG/PDF file
     * @return (Image) image found on the specified address
     */
    public static Image pathToImage(String file_path){
        ImageIcon icon =new ImageIcon(file_path);
        return icon.getImage();
    }

    /**
     * Checks through Hideouts, WaterSources and Plants and returns
     * Hideout/WaterSource/Plant that has the same name as one given as the input.
     * If no such place is found, the method returns a random place and prints an "error"
     * @param place_name (String) name to be found
     * @return (Place) Hideout/WaterSource/Plant
     */
    public static Place targetFromString(String place_name){
        for(Hideout hideout: Map.getHideoutVector()){
            if(hideout.getName().equals(place_name)){
                return hideout;
            }
        }
        for(WaterSource water_source: Map.getWaterSourceVector()){
            if(water_source.getName().equals(place_name)){
                return water_source;
            }
        }
        for(Plant plant: Map.getPlantVector()){
            if(plant.getName().equals(place_name)){
                return plant;
            }
        }
        System.out.println("error");
        return Map.getRandomHideout();
    }
}