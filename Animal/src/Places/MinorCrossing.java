package Places;

import Miscalenious.Draw;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Vector;

import static Constants.Constants.CHANCE_TO_CONNECT;
/**
 * Class MinorCrossing, crossing connected to some other places on the map
 */
public class MinorCrossing extends Place{
    private final Vector<Path> paths= new Vector<>(0);
    private final Vector <MinorCrossing> my_places= new Vector<MinorCrossing>(0);
    private final Vector <Draw> draw_paths;

    /**
     * Constructor for MinorCrossing Class
     * @param _x - (int) coordinate x
     * @param _y - (int) coordinate y
     * @param _places - (Vector) places present on the Map
     * @param _name - (String) name of the crossing
     * @param image - (Image) image of the crossing
     * @param _name_info - (JLabel) label used to display place's name
     * @param _place_info - (JLabel) label used to display name of place type
     * @param capacity_label - (JLabel) label used to display place's capacity relative to max capacity
     * @param location_label - (JLabel) label used to display place's location
     * @param _draw_paths - (Vector) paths to be drawn
     * @param form_connections - (boolean) variable that dictates with the crossing is allowed to try and
     *                         form connections with other crossings (form paths)
     */
    public MinorCrossing(int _x,int _y,String _name,Vector <MinorCrossing> _places,boolean form_connections, Image image,
                         JLabel _name_info,JLabel _place_info, JLabel capacity_label, JLabel location_label,
                         Vector<Draw> _draw_paths){
        super(_x,_y,_name,"Crossing",1,image, _name_info,_place_info,
                capacity_label, location_label);
        draw_paths=_draw_paths;
        if(form_connections) {
            this.formConnections(_places);
        }
    }

    /**
     * Method forms connections between this crossing and a place with certain probability
     * @param _places
     */
    private void formConnections(Vector <MinorCrossing> _places){
        Random rand = new Random();
        for (MinorCrossing place : _places) {
            if (rand.nextInt(100) < CHANCE_TO_CONNECT) {
                Path new_path = new Path(get_X(), get_Y(), place.get_X(), place.get_Y(), place);
                draw_paths.addElement(new Draw(get_X(), get_Y(), get_X(), get_Y()));
                paths.addElement(new_path);

                my_places.addElement(place);
                place.addPath(place.get_X(), place.get_Y(), get_X(), get_Y(), this);
            }
        }
    }

    /**
     * Method that adds a connection (path) between two places
     * @param start_x (int) x coordinate of the starting location
     * @param start_y (int) y coordinate of the starting location
     * @param end_x (int) x coordinate of the end location
     * @param end_y (int) y coordinate of the end location
     * @param crossing (MinorCrossing) end target
     */
    public void addPath(int start_x, int start_y, int end_x, int end_y, MinorCrossing crossing){
        Path new_path = new Path(start_x, start_y, end_x, end_y, crossing);
        draw_paths.addElement(new Draw(start_x, start_y, end_x, end_y));
        paths.addElement(new_path);
        my_places.addElement(crossing);
    }

    /**
     * Prints a Crossing (Used for debugging purposes)
     */
    public void printCrossing(){
        System.out.println("name= Minor_Crossing_");
        System.out.println("x= "+ get_X());
        System.out.println("y= "+ get_Y());
        for (Path path : paths) {
            System.out.println("new path:");
            for (int ii = 0; ii < path.getX_cords().size(); ii++) {
                System.out.println("path_x= " + path.getX_cords().get(ii));
                System.out.println("path_y= " + path.getY_cords().get(ii));
            }
        }
        for (MinorCrossing my_place : my_places) {
            System.out.println("place_x= " + my_place.get_X());
            System.out.println("place_y= " + my_place.get_Y());
        }
    }
    /**
     * @return (Vector) paths connected to the crossing
     */
    public Vector<Path> getPaths(){ return paths; }

    /**
     * @return (Vector) drawn paths
     */
    public Vector<Draw> getDrawPaths(){ return draw_paths; }

    public Path getSisterPath(Path new_path){
        for(Path temp_path: paths){
            if(temp_path.getA()==new_path.getA() && temp_path.getB()==new_path.getB()){
                return temp_path;
            }
        }
        return null;
    }

}
