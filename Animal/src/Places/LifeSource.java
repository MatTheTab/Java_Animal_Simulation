package Places;

import Miscalenious.LifeSourceDialog;
import Miscalenious.PlaceDialog;
import Screen.Map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static java.lang.Thread.sleep;

/**
 * Class LifeSource as an abstract intermediary between Place and WaterSource/Plant
 */
public abstract class LifeSource extends Place implements Runnable{
    private MouseListener place_mouse_listener;
    private JLabel replenishing_info,consumption_info,feeding_rate_info;
    private int replenishing_speed,consumption_material,max_consumption_material,feeding_rate;
    private boolean can_continue;
    private Thread life_source_thread;

    /**
     * Constructor for LifeSource Class
     * @param _x - (int) x coordinate of the class
     * @param _y - (int) y coordinate of the class
     * @param _name_label - (JLabel) label used to display place's name
     * @param _place_label - (JLabel) label used to display name of place type
     * @param _capacity_label - (JLabel) label used to display place's capacity relative to max capacity
     * @param _location_label - (JLabel) label used to display place's location
     * @param _place_type - (JLabel) place type ("WaterSource", "Plant")
     * @param _capacity - (int) current capacity
     * @param _replenishing_speed - (int) how fast the resources are replenished
     * @param _consumption_material - (int) how much material is held
     * @param _feeding_rate - (int) how fast an animal is fed
     * @param _image - (Image) image to be displayed
     * @param _replenishing_label - (JLabel) label to display replenishing information
     * @param _consumption_label - (JLabel) label to display consumption information
     * @param feeding_label - (JLabel) label to display feeding information
     */
    public LifeSource(int _x, int _y, String _name, String _place_type, int _capacity, int _replenishing_speed,
                      int _consumption_material,int _feeding_rate, Image _image,
                      JLabel _name_label, JLabel _place_label, JLabel _capacity_label, JLabel _location_label,
                      JLabel _replenishing_label, JLabel _consumption_label, JLabel feeding_label){
        super(_x,_y,_name,_place_type, _capacity,_image, _name_label, _place_label,
                _capacity_label, _location_label);
        replenishing_speed=_replenishing_speed;
        feeding_rate=_feeding_rate;
        consumption_material=_consumption_material;
        max_consumption_material=consumption_material;
        replenishing_info=_replenishing_label;
        consumption_info=_consumption_label;
        feeding_rate_info=feeding_label;
        can_continue=true;
        life_source_thread=new Thread(this);
        life_source_thread.start();
    }

    /**
     * activates and creates object MouseListener
     */
    public void activatePlaceMouseListener(){
        place_mouse_listener= this.createMouseListener();
        this.addMouseListener(place_mouse_listener);
    }

    /**
     * Creates MouseListener object
     * @return MouseListener (Object)
     */
    public MouseListener createMouseListener(){
        //change this later on
        MouseListener ms=new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                LifeSourceDialog info=new LifeSourceDialog(LifeSource.super.getName(),
                        LifeSource.super.getPlaceType(),LifeSource.super.getCurrentOccupation(),
                        LifeSource.super.getCapacity(),LifeSource.super.get_X(),
                        LifeSource.super.get_Y(), replenishing_speed,consumption_material, max_consumption_material,
                        feeding_rate);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                LifeSource.super.getNameInfo().setText(LifeSource.super.getName());
                LifeSource.super.getPlaceInfo().setText(LifeSource.super.getPlaceType());
                LifeSource.super.getCapacityInfo().setText("capacity: "+
                        LifeSource.super.getCurrentOccupation()+"/"+
                                LifeSource.super.getCapacity());
                replenishing_info.setText("replenishment speed: "+replenishing_speed);
                LifeSource.super.getLocationInfo().setText("x: "+
                        LifeSource.super.get_X()+" y: "+LifeSource.super.get_Y());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                LifeSource.super.getNameInfo().setText("");
                LifeSource.super.getPlaceInfo().setText("");
                LifeSource.super.getCapacityInfo().setText("");
                consumption_info.setText("");
                replenishing_info.setText("");
                feeding_rate_info.setText("");
                LifeSource.super.getLocationInfo().setText("");
            }
        };
        return ms;
    }

    /**
     * Decreases resources by a specified integer amount
     * @param decrease_num (int) number to decrease resources by
     */
    public void decreaseResources(int decrease_num){
        if(consumption_material-decrease_num<0){
            consumption_material=0;
            return;
        }
        consumption_material-=decrease_num;
    }

    /**
     * Replenishes resources of the LifeSource object
     */
    public void replenishResources(){
        if(consumption_material+replenishing_speed*Map.getNumAnimals()>max_consumption_material){
            consumption_material=max_consumption_material;
            return;
        }
        consumption_material+=replenishing_speed* Map.getNumAnimals();
    }

    /**
     * Returns the amount of left resources
     * @return (int) number of resources left
     */
    public int getResources(){ return consumption_material; }

    public void stopThread(){
        can_continue=false;
    }

    /**
     * Method responsible for replenishing resources in given time intervals
     */
    public void run() {
        while (can_continue) {
            replenishResources();
            try {
                sleep(15000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * @return (int) feeding_rate
     */
    public int getFeedingRate(){ return feeding_rate; }

    /**
     * @return (int) number by which the replenishing rate will be multiplied, the number depends on number of animals
     */
    public static int feedMultiply(){ return 1+Map.getNumAnimals()/10; }
}
