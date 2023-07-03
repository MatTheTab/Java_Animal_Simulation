package Places;

import Miscalenious.Draw;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

/**
 * Specialized class of MinorCrossing, connected to all other Places on the map
 */
public class MajorCrossing extends MinorCrossing{
    /**
     * Constructor for the MajorCrossing class
     * @param _x - (int) coordinate x
     * @param _y - (int) coordinate y
     * @param places - (Vector) places present on the Map
     * @param _name - (String) name of the crossing
     * @param image - (Image) image of the crossing
     * @param _name_info - (JLabel) label used to display place's name
     * @param _place_info - (JLabel) label used to display name of place type
     * @param capacity_label - (JLabel) label used to display place's capacity relative to max capacity
     * @param location_label - (JLabel) label used to display place's location
     * @param draw_paths - (Vector) paths to be drawn
     */
    public MajorCrossing(int _x, int _y, Vector<MinorCrossing> places, String _name,
                         Image image, JLabel _name_info, JLabel _place_info,
                         JLabel capacity_label, JLabel location_label, Vector<Draw> draw_paths){
        super(_x,_y,_name,places,false,image,_name_info, _place_info, capacity_label,
                location_label, draw_paths);
        for (MinorCrossing place : places) {
            Path new_path = new Path(_x, _y, place.get_X(), place.get_Y(), place);
            super.getDrawPaths().addElement(new Draw(_x, _y, place.get_X(), place.get_Y()));
            super.getPaths().addElement(new_path);
            place.addPath(place.get_X(), place.get_Y(), _x, _y, this);
        }
    }
}
