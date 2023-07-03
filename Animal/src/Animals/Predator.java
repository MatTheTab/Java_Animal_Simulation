package Animals;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import java.util.Vector;

import static Constants.Constants.*;
import static Miscalenious.Converter.intToBool;
import static java.lang.Math.*;
import static java.lang.Thread.sleep;
import GameMaster.GameMaster;
import Miscalenious.Converter;
import Miscalenious.DistanceCalculator;
import Miscalenious.PredatorDialog;
import Screen.Map;

import javax.swing.*;

/**
 * Predator class, a subclass of the Animal class, implements the runnable interface, as a means
 * of implementing multithreading.
 * <p>predator_thread - (Thread) thread of the predator, used to activate the run() method</p>
 * <p>prey_sense - (int) integer representing the distance from which the predator can see his prey</p>
 * <p>current_relax_level - (int) current relax level of the predator, if current_relax_level=0, then
 * status=hunting, else status=relax</p>
 * <p>kill_number - (int) number representing how many preys were killed by this predator</p>
 * <p>target_x - (int) represents x coordinate of the target(prey/random cord)</p>
 * <p>target_y - (int) represents y coordinate of the target(prey/random cord)</p>
 * <p>max_relax_level - (int) represents max possible relaxation level achieved after hunting</p>
 * <p>name_info,species_info,health_info, strength_info, speed_info, location_info,
 * status_info, kill_info,relax_level_info - (JLabel) labels representing different info</p>
 * <p>animal_mouse_listener - (MouseListener) object responsible for operating the click, on operations</p>
 */
public abstract class Predator extends Animal implements Runnable{
    private Thread predator_thread;
    private int prey_sense;
    private int current_relax_level,kill_number,target_x,target_y;
    private final int max_relax_level;
    private JLabel name_info,species_info,health_info, strength_info, speed_info, location_info,
            status_info, kill_info,relax_level_info;
    private MouseListener animal_mouse_listener;

    /**
     * Constructor for the Predator class, for more details look for Predator class documentation
     * @param _x - (int) sets x coordinate parameter
     * @param _y - (int) sets y coordinate parameter
     * @param _name - (String) sets name parameter
     * @param _species_name - (String) sets species_name parameter
     * @param _strength - (int) sets strength parameter
     * @param _speed - (int) sets speed parameter
     * @param _health - (int) sets health parameter
     * @param _prey_sense - (int) sets prey_sense parameter
     * @param _current_relax_level - (int) current_relax_level parameter
     * @param _max_relax_level - (int) sets max relax level parameter
     * @param _image - (Image) sets main_image parameter
     * @param _rest_image - (Image) rest_image parameter
     * @param attack_image - (Image) attack_image parameter
     * @param name_label - (JLabel) sets name_label parameter
     * @param species_label - (JLabel) sets species_label parameter
     * @param health_label - (JLabel) sets health_label parameter
     * @param strength_label - (JLabel) sets strength_label parameter
     * @param speed_label - (JLabel) sets speed_label parameter
     * @param location_label - (JLabel) sets location_label parameter
     * @param status_label - (JLabel) sets status_label parameter
     * @param relax_level_label - (JLabel) sets relax_level_label parameter
     * @param kill_label - (JLabel) sets kill_label parameter
     */
    public Predator(int _x, int _y, String _name, String _species_name, int _strength,
                    int _speed, int _health, int _prey_sense, int _current_relax_level,
                    int _max_relax_level, Image _image, Image _rest_image, Image attack_image,
                    JLabel name_label, JLabel species_label,
                    JLabel health_label, JLabel strength_label, JLabel speed_label, JLabel location_label,
                    JLabel status_label, JLabel relax_level_label, JLabel kill_label){
        super(_x,_y,_name,_species_name,_strength,_speed,_health, _image,
                _rest_image,null,null,attack_image);
        prey_sense=_prey_sense;
        current_relax_level=_current_relax_level;
        max_relax_level=_max_relax_level;
        setSize(super.getMainImage().getWidth(this),super.getMainImage().getHeight(this));
        predator_thread=new Thread(this);
        kill_number=0;
        target_x=setRandomX();
        target_y=setRandomY();
        name_info=name_label;
        species_info=species_label;
        health_info=health_label;
        strength_info=strength_label;
        speed_info=speed_label;
        location_info=location_label;
        status_info=status_label;
        relax_level_info=relax_level_label;
        kill_info=kill_label;
        predator_thread.start();
    }

    /**
     * Activates mouse listener by calling createMouseListener() method and adding it to the class
     */
    public void activateMouseListener(){
        animal_mouse_listener=this.createMouseListener();
        this.addMouseListener(animal_mouse_listener);
    }

    /**
     * returns status "relaxing" when current_relax_level>0 and "hunting" otherwise
     * @return hunting/relaxing (String)
     */
    public String getStatus(){
        if(current_relax_level>0){return "relaxing";}
        return "hunting";
    }

    /**
     * sets random X according to maximum map width
     * @return rand.nextInt(MAPSIZE_WIDTH)
     */
    private int setRandomX(){
        Random rand=new Random();
        return rand.nextInt(MAPSIZE_WIDTH);
    }

    /**
     * sets random X according to maximum map height
     * @return rand.nextInt(MAPSIZE_HEIGHT)
     */
    private int setRandomY(){
        Random rand=new Random();
        return rand.nextInt(MAPSIZE_HEIGHT);
    }

    /**
     * increments predator's kill count
     */
    public void increaseKillCount(){ this.kill_number+=1; }

    /**
     * Calculates how much on the x-axis the predator should move, by using vector formulas
     * @param temp_x - (int) current_x
     * @param distance - (float) the distance between target and current position
     * @return (int) calculated number of steps
     */
    private int getNumStepsX(int temp_x, float distance){
        return (int)(abs(this.get_X()-temp_x)*(float) this.getSpeed()/distance);
    }

    /**
     * Calculates how much on the y-axis the predator should move, by using vector formulas
     * @param temp_y - (int) current_y
     * @param distance - (float) the distance between target and current position
     * @return (int) calculated number of steps
     */
    private int getNumStepsY(int temp_y, float distance){
        return (int)(abs(get_Y()-temp_y)*(float) this.getSpeed()/distance);
    }

    /**
     * Changes value of predator's x position in accordance with number of steps calculated in getNumStepsX(int, float)
     * @param temp_x - (int) current_x
     * @param x_steps - (int) calculated number of steps to be taken on the x-axis
     */
    private void setNewX(int temp_x, int x_steps){
        if(this.get_X()>temp_x){
            this.set_X(this.get_X()-x_steps);
        }
        else{
            this.set_X(this.get_X()+x_steps);
        }
    }
    /**
     * Changes value of predator's y position in accordance with number of steps calculated in getNumStepsY(int, float)
     * @param temp_y - (int) current_x
     * @param y_steps - (int) calculated number of steps to be taken on the x-axis
     */
    private void setNewY(int temp_y, int y_steps){
        if(get_Y()>temp_y){
            set_Y(get_Y()-y_steps);
        }
        else{
            set_Y(get_Y()+y_steps);
        }
    }

    /**
     * inRange calculates if Predator can sense/attack Prey
     * @param temp_x - (int) predator's current x
     * @param temp_y - (int) predator's current y
     * @param current_prey - Prey
     * @param range - (int) distance from which the predator can sense/attack Prey
     * @return (boolean) true-can hunt/see Prey or false-cannot hunt/see Prey
     */
    private synchronized boolean inRange(int temp_x, int temp_y, Prey current_prey, int range){
        if(current_prey==null){
            return false;
        }
        return ((DistanceCalculator.getDistance(temp_x,temp_y,get_X(),get_Y())
                <= range) && (!(current_prey.getHiding())));
    }

    /**
     * @return (int)max_relax_level
     */
    public int getMaxRelaxLevel(){ return this.max_relax_level; }

    /**
     * @param _new_relax_level
     */
    public void setCurrentRelaxLevel(int _new_relax_level ){ this.current_relax_level=_new_relax_level; }
    /**
     * Looks through the vector of Preys and decided if it any of them can be hunted or not
     * @return (int[]) 3 element array with [x,y,hunting], x,y are coordinates of the Prey to be hunted.
     * hunting is an integer that functions like boolean, meaning 0 means no Prey to be hunted, 1 means
     * there is Prey to be hunted
     */
    private synchronized int[] spotPrey(){
        boolean hunting=false;
        int temp_x = get_X();
        int temp_y = get_Y();
        Vector<Prey> preys=Map.getPreys();
        for(Prey current_prey:preys){
            temp_x=current_prey.get_X();
            temp_y=current_prey.get_Y();
            if(inRange(temp_x,temp_y,current_prey,this.prey_sense)){
                this.setCurrentImageNum(2);
                this.setChangeImage(true);
                setLocation(get_X()-getAttackImage().getWidth(this)/2,get_Y()-getAttackImage().getHeight(this)/2);
                repaint();
                hunting=true;
                break;
            }
        }
        return new int[]{temp_x, temp_y, Converter.boolToInt(hunting)};
    }

    /**
     * Uses spotPrey() method to see if there is a Prey to be hunted, if yes Prey's x and y are selected as
     * target_x and target_y. Otherwise, random coordinated are selected.
     */
    private void lookForPrey(){
        int [] temp_hunting_arr=spotPrey();
        int temp_x=temp_hunting_arr[0];
        int temp_y=temp_hunting_arr[1];
        boolean hunting=intToBool(temp_hunting_arr[2]);
        if (!hunting){
            if(DistanceCalculator.getDistance(get_X(),get_Y(),target_x,target_y)<50) {
                target_x = Map.getRandomCordX();
                target_y = Map.getRandomCordY();
            }
            temp_x=target_x;
            temp_y=target_y;
        }
        float distance= DistanceCalculator.getDistance(temp_x,temp_y,get_X(),get_Y());
        int x_steps=getNumStepsX(temp_x, distance);
        int y_steps=getNumStepsY(temp_y, distance);
        this.setNewX(temp_x, x_steps);
        this.setNewY(temp_y, y_steps);
    }

    /**
     * Checks if Prey is within attack range, if yes attack is performed and GameMaster.resolveFight()
     * is called to decide on the outcome
     * @return (boolean) result true-> successful hunt, false-> unsuccessful
     */
    protected synchronized boolean attack(){
        Vector<Prey> preys=Map.getPreys();
        for(Prey current_prey:preys){
            if (inRange(current_prey.get_X(),current_prey.get_Y(),current_prey,ATTACK_RANGE)) {
                return GameMaster.resolve_fight(this, current_prey);
            }
        }
        return true;
    }

    /**
     * Joins Predator's thread
     */
    public void join(){
        try {
            this.predator_thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * run() method used for multithreading, within it Predator's behaviour is controlled and decided.
     * When a thread is terminated, run() method makes the image associated with object disappear
     * and then ends.
     */


    @Override
    public void run() {
        setChangeImage(false);
        while(this.getContinue()) {
            if (this.current_relax_level > 0) {
                setChangeImage(true);
                this.setCurrentImageNum(1);
                setLocation(get_X()-getRestImage().getWidth(this)/2, get_Y()-getRestImage().getHeight(this)/2);
                repaint();
                current_relax_level -= 1;
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                this.lookForPrey();
                if (!this.attack()) {
                    setChangeImage(true);
                    this.setCurrentImageNum(1);
                    setLocation(get_X()-getRestImage().getWidth(this)/2, get_Y()-getRestImage().getHeight(this)/2);
                    repaint();
                    try {
                        sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            if (!getChangeImage()) {
                this.setCurrentImageNum(0);
                setLocation(get_X()-getMainImage().getWidth(this)/2, get_Y()-getMainImage().getHeight(this)/2);
                repaint();
            }
            try {
                sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            setChangeImage(false);
        }
        this.setVisible(false);
        setImageNull();
        this.join();
    }

    public void paint(Graphics g){
        if(getCurrentImageNum()==0) {
            g.drawImage(super.getMainImage(), 0, 0, this);
            super.paint(g);
        }
        else if(getCurrentImageNum()==1){
            g.drawImage(super.getRestImage(), 0, 0, this);
            super.paint(g);
        }
        else if(getCurrentImageNum()==2){
            g.drawImage(super.getAttackImage(),0,0,this);
            super.paint(g);
        }
    }

    /**
     * Responsible for creation of MouseListener used when Predator is clicked or touched with the cursor.
     * @return MouseListener (object)
     */
    public MouseListener createMouseListener(){
        MouseListener ms=new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String temp_status=getStatus();
                PredatorDialog info=new PredatorDialog(Predator.super.getName(), Predator.super.getSpeciesName(),
                        Predator.super.getHealth(), Predator.super.getStrength(), Predator.super.getSpeed(),
                        Predator.super.get_X(), Predator.super.get_Y(),kill_number,temp_status,current_relax_level,
                        max_relax_level, Predator.this);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                name_info.setText(Predator.super.getName());
                species_info.setText(Predator.super.getSpeciesName());
                health_info.setText("health: "+Predator.super.getHealth());
                strength_info.setText("strength: "+Predator.super.getStrength());
                speed_info.setText("speed: "+Predator.super.getSpeed());
                if(current_relax_level==0) {
                    status_info.setText("status: hunting");
                }
                else{
                    status_info.setText("status: resting");
                }
                relax_level_info.setText("relax_level: "+current_relax_level);
                kill_info.setText("kill count: "+kill_number);
                location_info.setText("x: "+Predator.super.get_X()+" y: "+Predator.super.get_Y());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                name_info.setText("");
                species_info.setText("");
                health_info.setText("");
                strength_info.setText("");
                speed_info.setText("");
                status_info.setText("");
                relax_level_info.setText("");
                kill_info.setText("");
                location_info.setText("");
            }
        };
        return ms;
    }

    public JLabel getNameLabel(){ return name_info; }

    public JLabel getSpeciesLabel(){ return species_info; }

    public JLabel getHealthLabel(){ return health_info; }

    public JLabel getStrengthLabel(){ return strength_info; }

    public JLabel getSpeedLabel(){ return speed_info; }

    public JLabel getLocationLabel(){ return location_info; }
}
