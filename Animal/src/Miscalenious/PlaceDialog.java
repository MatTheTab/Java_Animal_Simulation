package Miscalenious;

import javax.swing.*;
import java.awt.*;

/**
 * Class used for visualization fo the dialog that shows up when a Hideout is clicked on,
 * also the parent class for LifeSourceDialog
 */
public class PlaceDialog extends Dialog{

    private JLabel place_info,occupation_info, location_info;

    /**
     * Constructor for the PlaceDialog class
     * @param name (String) name of the place
     * @param place_type (String) type of location (Hideout, etc.)
     * @param occupation (int) current occupation
     * @param max_occupation (int) max occupation
     * @param x (int) the x coordinate
     * @param y (int) the y coordinate
     */
    public PlaceDialog(String name, String place_type,int occupation, int max_occupation, int x, int y){
        //possibly change for design reasons
            super(name,10,1);
            place_info=new JLabel(place_type);
            occupation_info=new JLabel("Current Occupation= "+occupation+"/"+max_occupation);
            location_info=new JLabel("Location_X= "+x+" Location_Y= "+y);
            getPanel().add(place_info);
            getPanel().add(occupation_info);
            getPanel().add(location_info);
        }
}

