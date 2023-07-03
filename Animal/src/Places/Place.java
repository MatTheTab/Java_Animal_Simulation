package Places;

import Miscalenious.PlaceDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static Constants.Constants.PLACE_SIZE;

/**
 * Abstract class representing Places like Hideout/WaterSource/Plant
 */
public abstract class Place extends Component{
    private final int x;
    private final int y;
    private final String name;
    private final String place_type;
    private int current_occupation;
    private final int capacity;

    private final JLabel name_info;
    private final JLabel place_info;
    private final JLabel capacity_info;
    private final JLabel location_info;

    private final Image image;

    /**
     * Constructor for Place Class
     * @param _x - (int) x coordinate
     * @param _y - (int) y coordinate
     * @param _name - (String) name of the place
     * @param _place_type - (String) name of place type
     * @param _capacity - (int) max place's capacity
     * @param _image - (Image) Place's image
     * @param _name_info - (JLabel) label showing place's name
     * @param _place_info - (JLabel) label showing place's info
     * @param capacity_label - (JLabel) label showing place's capacity
     * @param location_label - (JLabel) label showing place's location
     */
    public Place(int _x,int _y,String _name,String _place_type, int _capacity, Image _image,JLabel _name_info,JLabel _place_info,
                 JLabel capacity_label, JLabel location_label){
        x=_x;
        y=_y;
        current_occupation=0;
        name=_name;
        capacity=_capacity;
        place_type=_place_type;
        image=_image;
        name_info=_name_info;
        place_info=_place_info;
        capacity_info=capacity_label;
        location_info=location_label;
        setLocation(x-image.getWidth(this)/2,y-image.getHeight(this)/2);
    }

    /**
     * Activates and creates MouseListener object
     */
    public void activatePlaceMouseListener(){
        MouseListener place_mouse_listener = this.createMouseListener();
        this.addMouseListener(place_mouse_listener);
    }

    /**
     * responsible for drawing and repainting a location
     */
    public void drawPlace(){
        this.setVisible(true);
        this.setSize(image.getWidth(this),image.getHeight(this));
        repaint();
    }

    /**
     * @return (int) x coordinate of the Place
     */
    public int get_X(){ return x;}

    /**
     * @return (int) y coordinate of the Place
     */
    public int get_Y(){ return y;}

    /**
     * @return (String) Place's name
     */
    public String getName(){ return name; }

    /**
     * @return (String) description of the place type
     */
    public String getPlaceType(){ return place_type; }

    /**
     * @return (int) Maximum capacity
     */
    public int getCapacity(){ return capacity; }

    /**
     * @return (int) Current occupation (Number of animals inside)
     */
    public int getCurrentOccupation(){ return current_occupation; }

    /**
     * Method that gets image from a given path and returns it
     * @param image_path (String) path to the image
     * @return (Image) from getImage()
     */
    public static Image getStaticImage(String image_path){
        ImageIcon place_icon=new ImageIcon(image_path);
        return place_icon.getImage();
    }

    public void paint(Graphics g){ g.drawImage(image,0,0,this); }

    /**
     * Method for creating MouseListener object, including functionality for the Place-type object
     * @return MouseListener (object)
     */
    public MouseListener createMouseListener(){
        //change this later on
        return new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PlaceDialog info=new PlaceDialog(name,place_type,current_occupation,capacity,x,y);
                info.finalizePanel();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                name_info.setText(name);
                place_info.setText(place_type);
                capacity_info.setText("capacity: "+current_occupation+"/"+capacity);
                location_info.setText("x: "+x+" y: "+y);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                name_info.setText("");
                place_info.setText("");
                capacity_info.setText("");
                location_info.setText("");
            }
        };
    }

    /**
     * @return (JLabel) name_info
     */
    public JLabel getNameInfo(){ return name_info; }
    /**
     * @return (JLabel) place_info
     */
    public JLabel getPlaceInfo(){ return place_info; }
    /**
     * @return (JLabel) location_info
     */
    public JLabel getLocationInfo(){ return location_info; }
    /**
     * @return (JLabel) capacity_info
     */
    public JLabel getCapacityInfo(){ return capacity_info; }
    /**
     * Increases current occupation by one
     */
    public void incrementOccupation(){ current_occupation+=1; }
    /**
     * decreases current occupation by one
     * @param _target - (Place) target whose population is meant to be decreased
     */
    public static synchronized void decrementOccupation(Place _target){
        _target.current_occupation-=1;
    if (_target.current_occupation<0){
    _target.current_occupation=0; }
    }
    /**
     * Sets a new occupation for this Place according to input value
     * @param new_occupation - (int) new occupation to be set
     */
    public void setCurrentOccupation(int new_occupation){ current_occupation=new_occupation; }

    /**
     * Decreases resources by of the place by n, overloaded in child classes
     * @param n - (int) number by which the resources are meant to be decreased
     */
    public void decreaseResources( int n){}

}
