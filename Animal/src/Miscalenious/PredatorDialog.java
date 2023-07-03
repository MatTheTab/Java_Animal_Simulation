package Miscalenious;

import Animals.Predator;
import Screen.Map;

import javax.swing.*;

/**
 * Dialog class used for visualization of the Predator class when it gets clicked on
 */
public class PredatorDialog extends AnimalDialog{
    private JLabel location_info, kill_info, status_info, relax_info;

    /**
     * Constructor of Predator Class
     * @param name - (String) name of the animal
     * @param species - (String) name of the species of animal
     * @param health - (int) health of the animal
     * @param strength - (int) strength of the animal
     * @param speed - (int) speed of the animal
     * @param x - (int) x coordinate of the animal
     * @param y - (int) y coordinate of the animal
     * @param kill_count - (int) number of kills achieved by the animal
     * @param status - (String) current status (resting/hunting)
     * @param relax_level - (int) relaxation level
     * @param max_relax_level - (int) maximal possible relaxation level
     * @param _predator - (Predator) Predator whose dialog is meant to be displayed
     */
    public PredatorDialog(String name, String species, int health, int strength, int speed, int x, int y,
                          int kill_count, String status, int relax_level, int max_relax_level, Predator _predator){
        super(name,species,health,strength,speed,10,1);
        kill_info=new JLabel("Kill Count= "+kill_count);
        status_info=new JLabel("Status= "+status);
        relax_info=new JLabel("Relax Level= "+relax_level+"/"+max_relax_level);
        location_info=new JLabel("Current_X= "+x+" Current_Y= "+y);
        getPanel().add(kill_info);
        getPanel().add(status_info);
        getPanel().add(relax_info);
        getPanel().add(location_info);
        createPredatorDeleteButton(_predator);
        finalizePanel();
    }

    /**
     * Creates button that allows the deletion of the animal
     * @param _predator (Predator) to be deleted
     */
    public void createPredatorDeleteButton(Predator _predator){
        JButton button=new JButton("Delete Predator");
        button.addActionListener(e->{Map.deletePredator(_predator);});
        getPanel().add(button);
    }
}
