package Screen;

import Animals.*;
import Miscalenious.Draw;
import Places.*;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static Constants.Constants.*;

/**
 * Class responsible for visualization of the simulation/game map and creation of animals, places, etc.
 * The class is also responsible for handling the user input, such as responding to a request to add an animal, etc.
 */
public class Map extends JPanel {
    private static int current_animal_id=0;
    private static Vector<Prey> prey_vector = new Vector<Prey>(0);
    private static Vector<Predator> predator_vector=new Vector<Predator>(0);
    private static Vector<WaterSource> water_source_vector=new Vector<WaterSource>(0);
    private static Vector<Plant> plant_vector=new Vector<Plant>(0);
    private static Vector<Hideout> hideout_vector=new Vector<Hideout>(0);
    private static Vector<MinorCrossing> crossings=new Vector<MinorCrossing>(0);
    private static Vector<Draw> draw_paths=new Vector<Draw>(0);
    private MajorCrossing major_crossing;
    private JPanel panel;
    private JLabel name_label;
    private JLabel species_label;
    private JLabel health_label,strength_label,speed_label,
            specific_label1, specific_label2, specific_label3, location_label;
    private String animal_to_add="Lion";
    private JToolBar control_panel;
    private JComboBox combo;

    /**
     * Responsible for adding Prey to prey_vector
     * @param _prey
     */
    public synchronized static void addPrey(Prey _prey){ prey_vector.addElement(_prey); }

    /**
     * Responsible for adding Predator to predator_vector
     * @param _predator
     */
    public synchronized static void addPredator(Predator _predator){ predator_vector.addElement(_predator); }

    /**
     * Responsible for adding WaterSource to corresponding vector
     * @param _water_source
     */
    public static void addWaterSource(WaterSource _water_source){ water_source_vector.addElement(_water_source); }

    /**
     * Responsible for adding Plant to corresponding vector
     * @param _plant
     */
    public static void addPlant(Plant _plant){ plant_vector.addElement(_plant); }

    /**
     * Responsible for adding Hideout to corresponding vector
     * @param _hideout
     */
    public static void addHideout(Hideout _hideout){ hideout_vector.addElement(_hideout); }

    /**
     * Return vector of all Hideouts
     * @return hideout_vector
     */
    public static Vector<Hideout> getHideoutVector(){ return hideout_vector; }
    /**
     * Return vector of all WaterSources
     * @return water_source_vector
     */
    public static Vector<WaterSource> getWaterSourceVector(){ return water_source_vector; }
    /**
     * Return vector of all Plants
     * @return plant_vector
     */
    public static Vector<Plant> getPlantVector(){ return plant_vector; }
    /**
     * Return vector of all Places (Hideouts,WaterSources,Plants abstracted as Place)
     * @return place_vector
     */
    public static Vector<Place> getPlaceVector(){
        Vector<Place> place_vector=new Vector<Place>(0);
        for(Hideout hideout: Map.getHideoutVector()){
            place_vector.add(hideout);
            }
        for(WaterSource water_source: Map.getWaterSourceVector()){
            place_vector.add(water_source);
            }
        for(Plant plant: Map.getPlantVector()){
            place_vector.add(plant);
            }
        return place_vector;
    }

    /**
     * Creates Map by opening a window and setting appropriate size
     */
    public static void createMap(){
        JFrame frame=new JFrame("Savanna Simulation");
        frame.add(new Map());
        frame.setSize(MAPSIZE_WIDTH,MAPSIZE_HEIGHT);
        frame.setResizable(true);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Returns a random path from vector of crossings
     * @return new_path(Path)
     */
    public Path getRandomCrossCords(){
        Random random=new Random(System.currentTimeMillis());
        int cc=random.nextInt(crossings.size());
        MinorCrossing temp_crossing=crossings.get(cc);
        Path new_path=temp_crossing.getPaths().get(random.nextInt(temp_crossing.getPaths().size()));
        return new_path;
    }

    /**
     * Creates and places on the map a new animal as chosen by the user
     * @param _animal new animal to be added
     */
    public void getAnimalOnMap(String _animal){
            Prey new_prey;
            Predator new_predator;
            Path start_path=getRandomCrossCords();
            int start_x=start_path.getX_cords().get(0);
            int start_y=start_path.getY_cords().get(0);
            switch(_animal) {
                case "Buffalo":
                    new_prey = new Buffalo(start_x, start_y,panel, name_label, species_label, health_label,
                            strength_label, speed_label, location_label, specific_label1, specific_label2,
                            specific_label3,start_path, 0, crossings);
                    new_prey.activateMouseListener();
                    Map.addPrey(new_prey);
                    this.panel.add(new_prey);
                    break;
                case "Gazelle":
                    new_prey = new Gazelle(start_x, start_y,panel, name_label, species_label, health_label,
                            strength_label, speed_label, location_label, specific_label1, specific_label2,
                            specific_label3, start_path, 0, crossings);
                    new_prey.activateMouseListener();
                    Map.addPrey(new_prey);
                    this.panel.add(new_prey);
                    break;
                case "Meerkat":
                    new_prey = new Meerkat(start_x, start_y, panel, name_label, species_label, health_label,
                            strength_label, speed_label, location_label, specific_label1, specific_label2,
                            specific_label3, start_path, 0, crossings);
                    new_prey.activateMouseListener();
                    Map.addPrey(new_prey);
                    this.panel.add(new_prey);
                    break;
                case "Zebra":
                    new_prey = new Zebra(start_x, start_y, panel, name_label, species_label, health_label,
                            strength_label, speed_label, location_label,specific_label1, specific_label2,
                            specific_label3, start_path, 0, crossings);
                    new_prey.activateMouseListener();
                    Map.addPrey(new_prey);
                    this.panel.add(new_prey);
                    break;
                case "Lion":
                    new_predator=new Lion(Map.getRandomCordX(),Map.getRandomCordY(),name_label, species_label, health_label,
                            strength_label, speed_label, location_label,specific_label1, specific_label2,
                            specific_label3);
                    new_predator.activateMouseListener();
                    Map.addPredator(new_predator);
                    this.panel.add(new_predator);
                    break;
                case "Crocodile":
                    new_predator=new Crocodile(Map.getRandomCordX(),Map.getRandomCordY(),name_label, species_label, health_label,
                            strength_label, speed_label, location_label, specific_label1, specific_label2,
                            specific_label3);
                    new_predator.activateMouseListener();
                    Map.addPredator(new_predator);
                    this.panel.add(new_predator);
                    break;
                case "Hyena":
                    new_predator=new Hyena(Map.getRandomCordX(),Map.getRandomCordY(),name_label, species_label, health_label,
                            strength_label, speed_label, location_label, specific_label1, specific_label2,
                            specific_label3);
                    new_predator.activateMouseListener();
                    Map.addPredator(new_predator);
                    this.panel.add(new_predator);
                    break;
                case "Hawk":
                    new_predator=new Hawk(Map.getRandomCordX(),Map.getRandomCordY(),name_label, species_label, health_label,
                            strength_label, speed_label, location_label, specific_label1, specific_label2,
                            specific_label3);
                    new_predator.activateMouseListener();
                    Map.addPredator(new_predator);
                    this.panel.add(new_predator);
                    break;
                default:
                    System.out.println("Naming Error");
            }
    }

    /**
     * creates n water sources
     * @param n - (int) number of water sources to be created
     */
    public void createNWaterSources(int n){
        for(int i=0;i<n;i++){
            this.createWaterSource();
        }
    }
    /**
     * creates n hideouts
     * @param n - (int) number of hideouts to be created
     */
    public void createNHideouts(int n){
        for(int i=0;i<n;i++){
            this.createHideout();
        }
    }
    /**
     * creates n plants
     * @param n - (int) number of plants to be created
     */
    public void createNPlants(int n){
        for(int i=0;i<n;i++){
            this.createPlant();
        }
    }

    /**
     * creates a new Water Source (from more details see WaterSource class and constructor documentation)
     */
    public void createWaterSource(){
        WaterSource new_watersource=new WaterSource(Map.getRandomCordX(), Map.getRandomCordY(), this.name_label, this.species_label,
                this.health_label,this.strength_label, this.speed_label,location_label,specific_label1);
        new_watersource.activatePlaceMouseListener();
        Map.addWaterSource(new_watersource);
    }
    /**
     * creates a new Hideout (from more details see Hideout class and constructor documentation)
     */
    public void createHideout(){
        Hideout new_hideout=new Hideout(Map.getRandomCordX(), Map.getRandomCordY(), this.name_label, this.species_label,
                this.health_label, this.strength_label);
        new_hideout.activatePlaceMouseListener();
        Map.addHideout(new_hideout);
    }
    /**
     * creates a new Plant (from more details see Plant class and constructor documentation)
     */
    public void createPlant(){
        Plant new_plant=new Plant(Map.getRandomCordX(),Map.getRandomCordY(), this.name_label, this.species_label,
                this.health_label, this.strength_label, this.speed_label,location_label,specific_label1);
        new_plant.activatePlaceMouseListener();
        Map.addPlant(new_plant);
    }
    /**
     * creates a crossroads connecting all existing Places and
     * randomly generates additional crossroads.
     */
    public void createCrossRoads(){
        for(Hideout hideout: hideout_vector){
            this.createCrossRoad(hideout.get_X(),hideout.get_Y(),false);
        }
        for(Plant plant: plant_vector){
            this.createCrossRoad(plant.get_X(),plant.get_Y(),false);
        }
        for(WaterSource water_source: water_source_vector){
            this.createCrossRoad(water_source.get_X(), water_source.get_Y(),false);
        }
        Random random=new Random();
        int num_additional_cross_roads=random.nextInt(NUM_POSSIBLE_CROSSROADS);
        for(int i=0;i<=num_additional_cross_roads;i++){
            this.createCrossRoad(getRandomCordX(),getRandomCordY(),true);
        }
    }
    /**
     * creates a new MinorCrossing (from more details see MinorCrossing class and constructor documentation)
     */
    public void createCrossRoad(int _x, int _y,boolean show){
        MinorCrossing new_crossing=new MinorCrossing(_x,_y,MinorCrossingCreator.getName(),
                crossings,true, Place.getStaticImage(CROSSING_IMAGE_PATH), name_label,
                species_label, health_label, strength_label, draw_paths);
        crossings.addElement(new_crossing);
        if (show) {
            new_crossing.drawPlace();
            panel.add(new_crossing);
            new_crossing.activatePlaceMouseListener();
        }
    }
    /**
     * creates a new MajorCrossing (from more details see MajorCrossing class and constructor documentation)
     */
    public void createMajorCrossRoad(){
        Random random=new Random();
        MajorCrossing new_major_crossing=new MajorCrossing(getRandomCordX(),
                getRandomCordY(),crossings, MinorCrossingCreator.getName(),
                Place.getStaticImage(CROSSING_IMAGE_PATH), name_label, species_label,
                health_label, strength_label, draw_paths);
        crossings.addElement(new_major_crossing);
        new_major_crossing.drawPlace();
        panel.add(new_major_crossing);
        new_major_crossing.activatePlaceMouseListener();
        major_crossing=new_major_crossing;
    }

    public void drawPaths(){
        for(Draw path: draw_paths){
            panel.add(path);
        }
    }

    /**
     * calls drawPlace() method for every element in hideout_vector, plant_vector and water_source_vector
     */
    public void getStaticImages(){
        for(Hideout hideout: hideout_vector){
            hideout.drawPlace();
            panel.add(hideout);
        }
        for(Plant plant: plant_vector){
            plant.drawPlace();
            panel.add(plant);
        }
        for(WaterSource water_source: water_source_vector){
            water_source.drawPlace();
            panel.add(water_source);
        }

    }

    /**
     * Adds control panel (ComboBox) and button to allow user to control Prey behaviour
     */
    public void addControlPanel(){
        JButton stopButton=new JButton("Stop");
        stopButton.addActionListener(e->{stop();});
        JButton button=new JButton("Add Animal");
        button.addActionListener(e->{getAnimalOnMap(this.animal_to_add);});
        combo=new JComboBox();
        combo.setEditable(false);
        for(String animal_species:ANIMAL_SPECIES) {
            combo.addItem(animal_species);
        }
        combo.addActionListener(e->{animal_to_add=combo.getSelectedItem().toString();control_panel.repaint();});
        name_label=new JLabel("");
        species_label=new JLabel("");
        health_label=new JLabel("");
        strength_label=new JLabel("");
        speed_label=new JLabel("");
        specific_label1=new JLabel("");
        specific_label2=new JLabel("");
        specific_label3=new JLabel("");
        location_label=new JLabel("");
        control_panel=new JToolBar("Control Panel",SwingConstants.HORIZONTAL);
        control_panel.setBackground(Color.WHITE);
        control_panel.setVisible(true);
        control_panel.setLayout(new GridLayout(20,1));
        control_panel.add(button);
        control_panel.add(combo);
        control_panel.add(stopButton);
        control_panel.add(name_label);
        control_panel.add(species_label);
        control_panel.add(health_label);
        control_panel.add(strength_label);
        control_panel.add(speed_label);
        control_panel.add(specific_label1);
        control_panel.add(specific_label2);
        control_panel.add(specific_label3);
        control_panel.add(location_label);
        add(control_panel,BorderLayout.EAST);
    }

    /**
     * Map constructor
     */
    public Map(){
        this.panel=new JPanel();
        panel.setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        this.addControlPanel();
        this.createNHideouts(NUM_HIDEOUTS);
        this.createNPlants(NUM_PLANTS);
        this.createNWaterSources(NUM_WATER_SOURCES);
        this.createCrossRoads();
        this.createMajorCrossRoad();
        this.getStaticImages();
        this.drawPaths();
        panel.setLayout(null);
        add(this.panel,BorderLayout.CENTER);
       // repaint();
        panel.repaint();
    }

    /**
     * Stop method stops execution of all animal threads and deletes them, also clears all Places of their inhabitants
     */
    public synchronized void stop(){
        for(Predator s:predator_vector){
            s.stopThread();
        }
        predator_vector.clear();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for(WaterSource water_source:water_source_vector){
            water_source.setCurrentOccupation(0);
        }
        for(Plant plant:plant_vector){
            plant.setCurrentOccupation(0);
        }
        for(Hideout hideout: hideout_vector){
            hideout.setCurrentOccupation(0);
        }
        for(MinorCrossing crossing:crossings){
            crossing.setCurrentOccupation(0);
        }
        for(Prey s:prey_vector){
            s.stopThread();
        }
        //prey_vector.clear();
    }

    /**
     * unambiguously compares two animals
     * @param animal1 (Prey) animal to be compared
     * @param animal2 (Prey) another animal to be compared
     * @return (boolean) same or not
     */
    public static boolean isSameAnimal(Animal animal1, Animal animal2){
        if (animal1.getAnimalId()==animal2.getAnimalId()){
            return true;
        }
        return false;
    }

    /**
     * deletes Prey from prey_vector
     * @param _prey (Prey) to be deleted
     */
    public static synchronized void deletePrey(Prey _prey){
        for(int i=0;i<prey_vector.size();i++){
            if(isSameAnimal(_prey,prey_vector.get(i))){
                prey_vector.get(i).stopThread();
                prey_vector.remove(i);
                return;
            }
        }
    }
    /**
     * deletes Predator from predator_vector
     * @param _predator (Predator to be deleted)
     */
    public static void deletePredator(Predator _predator){
        for(int i=0;i<predator_vector.size();i++){
            if(isSameAnimal(_predator,predator_vector.get(i))){
                predator_vector.get(i).stopThread();
                predator_vector.remove(i);
                return;
            }
        }
    }

    /**
     * @return prey_vector
     */
    public synchronized static Vector<Prey> getPreys(){ return prey_vector; }

    /**
     * @return current_animal_id, used for indexing
     */
    public static int getCurrentAnimalId(){ return current_animal_id;}
    /**
     * increments animal_id by one, used for indexing
     */
    public static void incrementAnimalId(){ current_animal_id+=1; }

    /**
     * @return (WaterSource) random WaterSource from the vector
     */
    public static WaterSource getRandomWaterSource(){
        Random rand=new Random();
        return  water_source_vector.get(rand.nextInt(water_source_vector.size()));
    }
    /**
     * @return (Plant) random Plant from the vector
     */
    public static Plant getRandomPlant(){
        Random rand=new Random();
        return  plant_vector.get(rand.nextInt(plant_vector.size()));
    }
    /**
     * @return (Hideout) random Hideout from the vector
     */
    public static Hideout getRandomHideout(){
        Random rand=new Random();
        return  hideout_vector.get(rand.nextInt(hideout_vector.size()));
    }

    /**
     * @return (int) random X cord within the game map
     */
    public static int getRandomCordX(){
        Random rand=new Random();
        return rand.nextInt(MAPSIZE_WIDTH-300)+100;
    }
    /**
     * @return (int) random Y cord within the game map
     */
    public static int getRandomCordY(){
        Random rand=new Random();
        return rand.nextInt(MAPSIZE_HEIGHT-300)+100;
    }

    /**
     * @return (int) number of animals (Preys + Predators)
     */
    public static int getNumAnimals(){ return prey_vector.size()+predator_vector.size();}
}
