package Animals;

import Miscalenious.Breeder;
import Miscalenious.PreyDialog;
import Places.*;
import Screen.Map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import java.util.Vector;

import static Constants.Constants.*;
import static java.lang.Thread.sleep;

/**
 * Prey class, a subclass of the Animal class, implements the runnable interface, as a means
 * of implementing multithreading.
 * <p>prey_thread - (Thread) thread of the predator, used to activate the run() method</p>
 * <p>private JLabel name_info,species_info,health_info, strength_info, speed_info, location_info,
 * water_info, food_info, hidden_info - (JLabel) labels representing different info</p>
 * <p>animal_mouse_listener - (MouseListener) object responsible for operating the click, on operations</p>
 * <p>max_water_level - (int) number representing the maximal possible water level of the animal </p>
 * max_food_level - (int) number representing the maximal possible food level of the animal
 * current_water_level - (int) number representing the current water level of the animal
 * current_food_level - (int) number representing the current food level of the animal
 * hiding - (boolean) variable representing the if the animal is hidden
 * waiting - (boolean) variable representing the if the animal is waiting for another to finish something
 * killed - (boolean) variable representing the if the animal has been killed
 * target - (Place) Animal's target
 * current_path - (Path) Prey's current path
 * destinations - (Vector) All possible destinations of the animal
 * current_path_position - (int) current position of the animal on the path vector
 * target_kind - (String) what kind of target is Prey looking for (water/hiding/food)
 * reproduced - (boolean) representing if animal is in hiding
 * panel - (JPanel) panel on which the simulation is drawn
 */
public abstract class Prey extends Animal implements Runnable{
    private Thread prey_thread;
    private int max_water_level;
    private int max_food_level;
    private int current_water_level;
    private int current_food_level;
    private boolean hiding=false, waiting,killed;
    private Place target;
    private Path current_path;
    Vector<MinorCrossing> destinations;
    private int current_path_position;
    private String target_kind;
    private boolean reproduced=false;
    private JLabel name_info,species_info,health_info, strength_info, speed_info, location_info,
            water_info, food_info, hidden_info;
    private JPanel panel;
    private MouseListener animal_mouse_listener;

    /**
     * Constructor for the Prey class, for more details look for Prey class documentation
     * @param _x - (int) sets x coordinate parameter
     * @param _y - (int) sets y coordinate parameter
     * @param _name - (String) sets name parameter
     * @param _species_name - (String) sets species_name parameter
     * @param _strength - (int) sets strength parameter
     * @param _speed - (int) sets speed parameter
     * @param _health - (int) sets health parameter
     * @param _max_water_level - (int) sets maximum possible water level for this Prey
     * @param _max_food_level - (int) sets maximum possible food level for this Prey
     * @param _current_water_level - (int) sets current water level for this Prey
     * @param _current_food_level - (int) sets current food level for this Prey
     * @param _panel - (JPanel) sets panel on which the game is drawn
     * @param _image - (Image) sets main_image
     * @param second_image - (Image) sets main_image
     * @param third_image - (Image) sets water_image
     * @param fourth_image - (Image) sets food_image
     * @param fifth_image - (Image) sets sleeping_image
     * @param name_label - (JLabel) sets name_label
     * @param species_label - (JLabel) sets species_name_label
     * @param health_label - (JLabel) sets health_label
     * @param strength_label - (JLabel) sets strength_label
     * @param speed_label - (JLabel) sets speed_label
     * @param location_label - (JLabel) sets location_label
     * @param water_label - (JLabel) sets water_label
     * @param food_label - (JLabel) sets food_label
     * @param hidden_label - (JLabel) sets hidden_label
     * @param _current_path - (Path) sets animal's current path
     * @param _current_path_position - (int) sets animal's position on path vector(by default 0)
     * @param _crossings - (Objects) all possible places for the Prey to visit
     */

    public Prey(int _x, int _y, String _name, String _species_name, int _strength,
                int _speed, int _health, int _max_water_level,
                int _max_food_level, int _current_water_level,
                int _current_food_level, JPanel _panel, Image _image,Image second_image,
                Image third_image, Image fourth_image, Image fifth_image, JLabel name_label, JLabel species_label,
                JLabel health_label, JLabel strength_label, JLabel speed_label, JLabel location_label,
                JLabel water_label, JLabel food_label, JLabel hidden_label,
                Path _current_path,int _current_path_position,Vector<MinorCrossing> _crossings){
        super(_x,_y,_name,_species_name,_strength,_speed,_health,_image,second_image, third_image, fourth_image,
                fifth_image);
        max_water_level=_max_water_level;
        max_food_level=_max_food_level;
        current_water_level=_current_water_level;
        current_food_level=_current_food_level;
        target=null;
        setSize(super.getMainImage().getWidth(this), super.getMainImage().getHeight(this));
        prey_thread=new Thread(this);
        panel=_panel;
        name_info=name_label;
        species_info=species_label;
        health_info=health_label;
        strength_info=strength_label;
        speed_info=speed_label;
        location_info=location_label;
        water_info=water_label;
        food_info=food_label;
        hidden_info=hidden_label;
        current_path=_current_path;
        current_path_position=_current_path_position;
        destinations=_crossings;
        waiting=false;
        killed=false;
        setVisible(false);
        prey_thread.start();
    }
    /**
     * Activates mouse listener by calling createMouseListener() method and adding it to the class
     */
    public void activateMouseListener(){
        animal_mouse_listener=this.createMouseListener();
        this.addMouseListener(animal_mouse_listener);
    }

    /**
     * @return hiding (boolean)
     */
    public boolean getHiding(){
        return this.hiding;
    }

    /**
     * @return max_water_level (int)
     */
    public int getMaxWaterLevel(){ return this.max_water_level; }

    /**
     * @return max_food_level (int)
     */
    public int setMaxFoodLevel(){ return this.max_food_level; }

    /**
     * Sets max_water_level as _water
     * @param _water (int)
     */
    public void setMaxWaterLevel(int _water){this.max_water_level=_water; }

    /**
     * Sets max_food_level as _food
     * @param _food (int)
     */
    public void setMaxFoodLevel(int _food){ this.max_food_level=_food; }

    /**
     * Sets Prey's target as new_target
     * @param new_target (Place)
     */
    public synchronized void setTarget(Place new_target){
        this.target=new_target;
        if(new_target instanceof Plant){
            this.target_kind="food";
        }
        if(new_target instanceof WaterSource){
            this.target_kind="water";
        }
        if(new_target instanceof Hideout){
            this.target_kind="hide";
        }
    }

    /**
     *  Returns Game's Panel
     * @return panel (JPanel)
     */
    public JPanel getPanel(){ return this.panel; }

    /**
     * Sets strength,speed,health,max_water_level and max_food_level respectively
     * @param _strength (int)
     * @param _speed (int)
     * @param _health (int)
     * @param _max_water_level (int)
     * @param _max_food_level (int)
     */
    public void setAll(int _strength,int _speed,int _health,int _max_water_level,int _max_food_level){
        super.setAll(_strength,_speed,_health);
        this.setMaxWaterLevel(_max_water_level);
        this.setMaxFoodLevel(_max_food_level);
    }

    /**
     * Method returns a boolean value that decides if an animal should look for food.
     * Decided based on current_food_level relative to max_food_level and random element.
     * @return (boolean)
     */
    private boolean lookForFood(){
        Random rand=new Random();
        if (current_food_level<max_food_level/2) {
            return rand.nextInt(max_food_level) > current_food_level;
        }
        return false;
    }
    /**
     * Method returns a boolean value that decides if an animal should look for water.
     * Decided based on current_water_level relative to max_water_level and random element.
     * @return (boolean)
     */
    private boolean lookForWater(){
        Random rand=new Random();
        if (current_water_level<max_water_level/2) {
            return rand.nextInt(max_water_level) > current_water_level;
        }
        return false;
    }

    /**
     * Checks if animal is thirsty/hungry enough to look for water/food. If yes-> sets the
     * target as some Plant/WaterSource, if not-> sets target to a hideout
     */
    public void findTarget(){
        if (lookForFood()){
                this.setTargetFood();
                return;
        }
        if (lookForWater()){
                this.setTargetWater();
                return;
        }
        this.setTargetHideout();
    }

    /**
     * Method checks if animal is on crossroad and if yes, calls method to check what crossroad it is
     */
    public void checkPath(){
        if(this.isOnCrossroad() && !(get_X()==target.get_X() && get_Y()==target.get_X())){
            getCrossroad(this);
        }
    }

    /**
     * Returns boolean value showing if animal is on crossroad or not
     * @return (boolean)
     */
    public boolean isOnCrossroad(){
        for(MinorCrossing crossing: destinations){
            if(crossing.get_X()==get_X() && crossing.get_Y()==get_Y()){
                crossing.incrementOccupation();
                return true;
            }
        }
        return false;
    }

    /**
     * Static method checks what crossroad the animal is on according to the crossroad vector destinations
     * @param _prey (Prey)
     */
    public static void getCrossroad(Prey _prey){
        for(MinorCrossing crossing: _prey.destinations){
            if (crossing.get_X()==_prey.get_X() && crossing.get_Y()==_prey.get_Y()){
                getCrossroadPath(crossing,_prey);
                return;
            }
        }
    }

    /**
     * Static Method checks all paths leading from a crossing, if one of them leads to target
     * the animal will choose this path, if none of them lead to the target, the animal will pick a random path,
     * there is also a small chance that the animal will choose the wrong path. The method automatically
     * sets the current_path and path_position parameters.
     * @param crossing (Minor_Crossing)
     * @param _prey (Prey)
     */
    public static void getCrossroadPath(MinorCrossing crossing, Prey _prey){
        Random random=new Random();
        _prey.setCurrentPathPosition(0);
        if(random.nextInt(100)<CHANCE_TO_PICK_RANDOM_PATH){
            _prey.setCurrentPath(crossing.getPaths().get(random.nextInt(crossing.getPaths().size())));
            _prey.set_X(_prey.getCurrentPath().getX_cords().get(_prey.getCurrentPathPosition()));
            _prey.set_Y(_prey.getCurrentPath().getY_cords().get(_prey.getCurrentPathPosition()));
            Place.decrementOccupation(crossing);
            return;
        }
        for(Path path: crossing.getPaths()){
            if(_prey.getTarget().get_X()==path.getFinish().get_X() && _prey.getTarget().get_Y()==path.getFinish().get_Y()){
                _prey.setCurrentPath(path);
                _prey.set_X(_prey.getCurrentPath().getX_cords().get(_prey.current_path_position));
                _prey.set_Y(_prey.getCurrentPath().getY_cords().get(_prey.current_path_position));
                Place.decrementOccupation(crossing);
                return;
            }
        }
        _prey.setCurrentPath(crossing.getPaths().get(random.nextInt(crossing.getPaths().size())));
        _prey.set_X(_prey.getCurrentPath().getX_cords().get(_prey.current_path_position));
        _prey.set_Y(_prey.getCurrentPath().getY_cords().get(_prey.current_path_position));
        Place.decrementOccupation(crossing);
    }

    /**
     * Method or moving along the path, with the path being represented as vector of values
     * meaning that moving happens by updating the current_path_position field according to the value
     * of the speed parameter
     */
    public void moveAlongPath(){
        if(current_path_position+getSpeed()>=current_path.getX_cords().size()-1){
            Prey.getOnCrossroad(current_path,this);
            return;
        }
        set_X(current_path.getX_cords().get(current_path_position+super.getSpeed()));
        set_Y(current_path.getY_cords().get(current_path_position+super.getSpeed()));
        current_path_position=current_path_position+super.getSpeed();
    }

    /**
     * Method for the Prey to get on the Crossroad (last value in the Path Vector).
     * Created as a static method to avoid multithreading issues and to allow synchronization.
     * @param current_path (Path)
     * @param _prey (Prey)
     */

    public static synchronized void getOnCrossroad(Path current_path, Prey _prey){

        _prey.set_X(current_path.getX_cords().get(current_path.getX_cords().size()-1));
        _prey.set_Y(current_path.getY_cords().get(current_path.getY_cords().size()-1));
        _prey.setCurrentPathPosition(current_path.getX_cords().size()-1);
        _prey.checkPath();
    }

    /**
     * Return boolean value stating if animal is on target
     * @return (boolean)
     */
    private boolean isOnTarget(){
        if(this.target==null){return false;}
        return get_X() == target.get_X() && get_Y() == target.get_Y();
    }

    /**
     * Sets target of Prey as a random WaterSource and target_kind as "water"
     */
    private void setTargetWater(){
        this.target= Map.getRandomWaterSource();
        this.target_kind="water";
    }
    /**
     * Sets target of Prey as a random Plant and target_kind as "food"
     */
    private void setTargetFood(){
        this.target=Map.getRandomPlant();
        this.target_kind="food";
    }
    /**
     * Sets target of Prey as a random Hideout and target_kind as "hide"
     */
    private void setTargetHideout(){
        this.target=Map.getRandomHideout();
        this.target_kind="hide";
    }

    /**
     * Decrease current_water_level and current_food_level with set probability
     */
    private void decreaseResources(){
        Random rand=new Random();
        if(!waiting) {
            int rand_val = rand.nextInt(100);
            if (this.current_food_level > 0 && rand_val < THIRST_CHANCE) {
                this.current_food_level -= 1;
            }
            if (this.current_water_level > 0 && rand_val < STARVATION_CHANCE) {
                this.current_water_level -= 1;
            }
        }
    }

    /**
     * If there is no target, the method calls findTarget() method, otherwise
     * Prey moves along the path
     */
    private void lookForTarget(){
        if (target == null) {
            this.findTarget();
        }
        this.moveAlongPath();
    }

    /**
     * Prey acts on target, depending on target kind, the action is either drink(), eat() or hideSelf()
     */
    private void actOnTarget(){
        if(this.target_kind.equals("water") && WaterSource.canDrink(target)){
            drink();
            return;
        }
        if(this.target_kind.equals("food") && Plant.canEat(target)) {
            this.eat();
            return;
        }
        if(this.target_kind.equals("hide") && Hideout.canHide(target)){
            this.hideSelf();
        }
        else if(target_kind.equals("hide")){
            target=null;
        }
        else{
            waiting=true;
        }
    }

    /**
     * Method that makes Prey drink water until current_water_level=max_water_level
     */
    private void drink(){
        waiting=false;
        this.hiding=false;
        this.reproduced=false;
        while(true) {
            if (this.current_water_level + ((WaterSource)target).getFeedingRate()*LifeSource.feedMultiply()>= this.max_water_level) {
                this.current_water_level = this.max_water_level;
                target.decreaseResources(((WaterSource)target).getFeedingRate()*LifeSource.feedMultiply());
                WaterSource.decrementOccupation(target);
                this.target = null;
                break;
            } else {
                this.current_water_level += ((WaterSource)target).getFeedingRate()*LifeSource.feedMultiply();
                target.decreaseResources(((WaterSource)target).getFeedingRate()*LifeSource.feedMultiply());
            }
            try {
                sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    /**
     * Method that makes Prey eat until current_food_level=max_food_level
     */
    private void eat(){
        waiting=false;
        while(true) {
            this.hiding = false;
            this.reproduced = false;
            if (this.current_food_level + ((Plant)target).getFeedingRate()*LifeSource.feedMultiply() >= this.max_food_level) {
                this.current_food_level = this.max_food_level;
                target.decreaseResources(((Plant)target).getFeedingRate()*LifeSource.feedMultiply());
                Plant.decrementOccupation(target);
                this.target = null;
                break;
            } else {
                this.current_food_level += ((Plant)target).getFeedingRate()*LifeSource.feedMultiply();
                target.decreaseResources(((Plant)target).getFeedingRate()*LifeSource.feedMultiply());
            }
            try {
                sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Triggers when the animal is hiding inside a hideout. It checks if current_water_level
     * or current_food_level is low enough to go out of the hideout to search for it. If yes->
     * target is set accordingly and the animal is forced to look for Plant/WaterSource, If no->
     * Prey remains in hiding.
     */
    private void escapeHideout(){
        while(true) {
            this.decreaseResources();
            try {
                if(getContinue()) {
                    sleep(1000);
                }
                else{
                    break;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (this.lookForWater() || this.lookForFood()) {
                Hideout.decrementOccupation(target);
                this.target = null;
                break;
            }
        }
    }

    /**
     * Details how the animal hides itself, also allows for reproduction with some set probability.
     */
    private void hideSelf(){
        setLocation(get_X()-getMainImage().getWidth(this)/2,get_Y()-getMainImage().getHeight(this)/2);
        repaint();
        waiting=false;
        this.hiding=true;
        this.reproduce();
        this.escapeHideout();
    }

    /**
     * Creates copy of the Prey with set probability
     */
    public void reproduce(){
        Random rand=new Random();
        if(rand.nextInt(100)<REPRODUCTION_PROBABILITY && !reproduced){
            this.reproduced=true;
            Breeder.createCopy(this);
        }
    }

    /**
     * Method run() from the runnable() interface. Implemented for multithreading purposes.
     * Implements the main behaviour of the Prey.
     */
    @Override
    public void run() {
        while(this.getContinue()) {
            this.decreaseResources();
            if (!this.isOnTarget()) {
                this.hiding=false;
                this.lookForTarget();
            } else {
                this.actOnTarget();
            }
            try {
                sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            setLocation(get_X()-getMainImage().getWidth(this)/2,get_Y()-getMainImage().getHeight(this)/2);
            setVisible(true);
            repaint();
        }
        if(killed) {
            setSize(super.getAttackImage().getWidth(this),super.getAttackImage().getHeight(this));
            setCurrentImageNum(3);
            setLocation(get_X()-getMainImage().getWidth(this)/2, get_Y()-getMainImage().getHeight(this)/2);
            repaint();
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.setVisible(false);
        super.setImageNull();
        Map.deletePrey(this);
        this.join();
    }

    public void paint(Graphics g){
        super.repaint();
        if (getCurrentImageNum()==0){
            g.drawImage(super.getMainImage(), 0, 0, this);
        }
        if(getCurrentImageNum()==3){
            g.drawImage(super.getAttackImage(),0,0,this);
        }
        super.paint(g);
    }

    /**
     * Method used for joining the pey_thread
     */
    public void join(){
        try {
            this.prey_thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Creates MouseListener object for behaviour when clicked on/touched by cursor.
     * @return MouseListener (object)
     */
    public MouseListener createMouseListener(){
        MouseListener ms=new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PreyDialog info=new PreyDialog(Prey.super.getName(), Prey.super.getSpeciesName(),
                        Prey.super.getHealth(), Prey.super.getStrength(), Prey.super.getSpeed(),
                        Prey.super.get_X(), Prey.super.get_Y(), current_water_level, max_water_level,
                        current_food_level, max_food_level, hiding, target.getName(),
                        target.get_X(), target.get_Y(), Prey.this, Map.getPlaceVector());
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                name_info.setText(Prey.super.getName());
                species_info.setText(Prey.super.getSpeciesName());
                health_info.setText("health: "+Prey.super.getHealth());
                strength_info.setText("strength: "+Prey.super.getStrength());
                speed_info.setText("speed: "+Prey.super.getSpeed());
                water_info.setText("water level: "+current_water_level+"/"+max_water_level);
                food_info.setText("food level: "+current_food_level+"/"+max_food_level);
                hidden_info.setText("hidden: "+hiding);
                location_info.setText("x: "+Prey.super.get_X()+" y: "+Prey.super.get_Y());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                name_info.setText("");
                species_info.setText("");
                health_info.setText("");
                strength_info.setText("");
                speed_info.setText("");
                water_info.setText("");
                food_info.setText("");
                hidden_info.setText("");
                location_info.setText("");
            }
        };
        return ms;
    }

    /**
     * @return name_info (JLabel)
     */
    public JLabel getNameLabel(){ return name_info; }
    /**
     * @return species_info (JLabel)
     */
    public JLabel getSpeciesLabel(){ return species_info; }
    /**
     * @return health_info (JLabel)
     */
    public JLabel getHealthLabel(){ return health_info; }
    /**
     * @return strength_info (JLabel)
     */
    public JLabel getStrengthLabel(){ return strength_info; }
    /**
     * @return speed_info (JLabel)
     */
    public JLabel getSpeedLabel(){ return speed_info; }
    /**
     * @return location_info (JLabel)
     */
    public JLabel getLocationLabel(){ return location_info; }
    /**
     * @return water_info (JLabel)
     */
    public JLabel getWaterInfo(){ return water_info; }
    /**
     * @return food_info (JLabel)
     */
    public JLabel getFoodInfo(){ return food_info; }
    /**
     * @return hidden_info (JLabel)
     */
    public JLabel getHiddenInfo(){ return hidden_info; }
    /**
     * @return current_path(Path)
     */
    public Path getCurrentPath(){ return current_path; }
    /**
     * @return destinations (Vector)
     */
    public Vector<MinorCrossing> getDestinations() {return destinations;}

    /**
     * @return current_path_position (int)
     */
    public int getCurrentPathPosition() { return current_path_position; }
    /**
     * Sets current_path_position parameter as new_path_position
     * @param new_path_position
     */
    public void setCurrentPathPosition(int new_path_position){ current_path_position= new_path_position; }

    /**
     * @return target (Place)
     */
    public Place getTarget(){ return target; }

    /**
     * Sets current_path as new_path
     * @param new_path (Path)
     */
    public void setCurrentPath(Path new_path){ current_path= new_path;}

    /**
     * Sets killed parameter to true
     */
    public void setKilled(){ killed=true; }

}


