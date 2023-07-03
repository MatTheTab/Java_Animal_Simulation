package Animals;

import Screen.Map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/**
 * Animal class is an abstract class that inherits after the Component class
 * for the purposes of animal visualizations later used in Prey and Predator classes.
 * The class also implements the Runnable interface as a means of implementation
 * of multithreading. This feature is used in Predator and Prey subclasses.
 * The class consists of several private parameters. <p></p>
 * animal_id - (int) used to unambiguously represent an animal <p></p>
 * name - (String) name of the animal <p></p>
 * species_name - (String) name of animal species, currently only 8 animal species are implemented <p></p>
 * strength - (int) strength of the animal, taking into consideration when a fight between a predator
 *                 and prey is happening <p></p>
 * speed - (int) speed of animal, determines what distance an animal can move within one
 *              run() loop circulation <p></p>
 * health - (int) health of an animal, taken into consideration when deciding if Prey is
 *               eaten or survives an attack <p></p>
 * current_image_num - (int) decides what image is meant to be displayed for each animal, the
 *                          image can change depending on animal state, e.g. attacking/dying <p></p>
 * x - (int) current x coordinate of the animal <p></p>
 * y - (int) current y coordinate of the animal <p></p>
 * can_continue - (boolean) used to determine if the animal can continue
 *                     the run method. If can_continue=false, then the run() method escapes
 *                     the main loop <p></p>
 * change_image - (boolean) checks if animal's image should change <p></p>
 * main_image - (Image) image to be displayed in the default animal state <p></p>
 * rest_image - (Image) image to be displayed when an animal is resting <p></p>
 * water_image - (Image) to be displayed when an animal is drinking <p></p>
 * food_image - (Image) to be displayed when an animal is eating <p></p>
 * attack_image - (Image) to be displayed when an animal is attacking/being attacked <p></p>
 *
 */
public abstract class Animal extends Component implements Runnable {
    private int animal_id;
    private String name,species_name;
    private int strength;
    private int speed;
    private int health,current_image_num;
    private int x,y;
    private boolean can_continue,change_image;
    private Image main_image, rest_image,water_image,food_image,attack_image;

    /**
     * Constructor of an abstract Animal class. For more detailed overview of the parameters, please view
     * tne Animal class documentation.
     * @param _x - (int) used to set Animal.x=_x
     * @param _y - (int) used to set Animal.y=_y
     * @param _name - (String) used to set Animal.name=_name
     * @param _species_name - (String) used to set Animal.species_name=_species_name
     * @param _strength - (int) used to set Animal.strength=_strength
     * @param _speed - (int) used to set Animal.speed=_speed
     * @param _health - (int) used to set Animal.health=_health
     * @param _image - (Image) used to set Animal.main_image=_image
     * @param _rest_Image - (Image) used to set Animal.rest_image=_rest_image
     * @param _water_image - (Image) used to set Animal.water_image=_water_image
     * @param _food_image - (Image) used to set Animal.food_image=_food_image
     * @param _attack_image - (Image) used to set Animal.attack_image=_attack_image
     */
    public Animal(int _x, int _y, String _name, String _species_name, int _strength,
                  int _speed, int _health, Image _image, Image _rest_Image, Image _water_image,
                  Image _food_image, Image _attack_image){
        x=_x;
        y=_y;
        name=_name;
        species_name=_species_name;
        strength=_strength;
        speed=_speed;
        health=_health;
        can_continue=true;
        animal_id= Map.getCurrentAnimalId();
        Map.incrementAnimalId();
        // Change later for the love of God
        main_image=_image;
        rest_image=_rest_Image;
        water_image=_water_image;
        food_image=_food_image;
        attack_image=_attack_image;
        current_image_num=0;
        change_image=false;
    }
    /**
     * method returns x parameter of the Animal class
     * @return x
     */
    public int get_X(){ return this.x; }
    /**
     * method used to set x parameter of the Animal class, Animal.x=new_x
     * @param new_x
     */
    public void set_X(int new_x){ this.x=new_x; }
    /**
     * method returns y parameter of the Animal class
     * @return y
     */
    public int get_Y(){ return this.y; }
    /**
     * method used to set x parameter of the Animal class, Animal.y=new_y
     * @param new_y
     */
    public void set_Y(int new_y){ this.y=new_y; }
    /**
     * method returns strength parameter of the Animal class
     * @return strength
     */
    public int getStrength(){ return this.strength; }
    /**
     * method used to set strength parameter of the Animal class, Animal.strength=_strength
     * @param _strength
     */
    public void setStrength(int _strength){ this.strength=_strength;}
    /**
     * method returns speed parameter of the Animal class
     * @return speed
     */
    public int getSpeed(){ return this.speed; }
    /**
     * method used to set speed parameter of the Animal class, Animal.speed=_speed
     * @param _speed
     */
    public void setSpeed(int _speed){ this.speed=_speed; }
    /**
     * method returns health parameter of the Animal class
     * @return health
     */
    public int getHealth(){ return this.health; }
    /**
     * method returns continue parameter of the Animal class
     * @return continue
     */
    public boolean getContinue(){ return can_continue; }
    /**
     * Stops thread ending the run() method
     */
    public void stopThread(){ this.can_continue=false; }
    /**
     * method used to set health parameter of the Animal class, Animal.health=new_health
     * @param new_health
     */
    public void setHealth(int new_health){ this.health=new_health; }
    /**
     * method returns id parameter of the Animal class
     * @return id
     */
    public int getAnimalId(){ return this.animal_id; }
    /**
     * method used to set strength, speed and health parameters using respective set methods
     * @param _strength
     * @param _speed
     * @param _health
     */
    public void setAll(int _strength, int _speed, int _health){
        this.setStrength(_strength);
        this.setSpeed(_speed);
        this.setHealth(_health);
    }
    /**
     * method returns main_image parameter of the Animal class
     * @return main_image
     */
    public Image getMainImage(){ return this.main_image; }
    /**
     * method returns rest_image parameter of the Animal class
     * @return rest_image
     */
    public Image getRestImage(){ return this.rest_image; }
    /**
     * method returns water_image parameter of the Animal class
     * @return water_image
     */
    public Image getWaterImage(){ return this.water_image; }
    /**
     * method returns food_image parameter of the Animal class
     * @return food_image
     */
    public Image getFoodImage(){ return this.food_image; }
    /**
     * method returns attack_image parameter of the Animal class
     * @return attack_image
     */
    public Image getAttackImage(){ return this.attack_image; }
    /**
     * method returns name parameter of the Animal class
     * @return name
     */
    public String getName(){ return this.name; }
    /**
     * method returns species_name parameter of the Animal class
     * @return species_name
     */
    public String getSpeciesName(){ return this.species_name; }
    /**
     * sets main_image of the Animal class as null, performed after run() method finishes
     */
    public void setImageNull(){
        this.main_image=null;
    }
    /**
     * method used to set current_image_num parameter of the Animal class, Animal.current_image_num=new_num
     * @param new_num
     */
    public void setCurrentImageNum(int new_num){ this.current_image_num=new_num; }
    /**
     * method returns current_image_num parameter of the Animal class
     * @return current_image_num
     */
    public int getCurrentImageNum(){ return current_image_num; }
    /**
     * method used to set change_image parameter of the Animal class, Animal.change_image=new_change
     * @param new_change
     */
    public void setChangeImage(boolean new_change){ change_image=new_change; }
    /**
     * method returns change_image parameter of the Animal class
     * @return change_image
     */
    public boolean getChangeImage(){ return change_image; }
}
