package Miscalenious;

import Animals.Prey;
import Places.Place;
import Screen.Map;

import javax.swing.*;
import java.util.Vector;

/**
 * Class Representing PreyDialog, allows for visualization of fields present in Prey when an animal is clicked on.
 */
public class PreyDialog extends AnimalDialog{
    private  JLabel location_info, water_info, food_info, hidden_info,target_info_1, target_info_2;
    private String target_to_add;

    /**
     * Constructor for PreyDialog class
     * @param name - (String) name of the animal
     * @param species - (String) name of the species of animal
     * @param health - (int) health of the animal
     * @param strength - (int) strength of the animal
     * @param speed - (int) speed of the animal
     * @param x - (int) x coordinate of the animal
     * @param y - (int) y coordinate of the animal
     * @param current_water_level - (int) current water level
     * @param max_water_level - (int) max possible water level
     * @param current_food_level - (int) current food level
     * @param max_food_level - (int) max possible food level
     * @param hidden - (boolean) checks if animal is hidden
     * @param target - (Place) target of the Prey
     * @param target_x - (int) x of the target
     * @param target_y - (int) y of the target
     * @param _prey - (Prey) Prey for which the dialog is created
     * @param targets - (Vector) all possible targets for the animal, used in creation of ComboBox object
     */
    public PreyDialog(String name, String species, int health, int strength, int speed, int x, int y,
                      int current_water_level, int max_water_level, int current_food_level,
                      int max_food_level, boolean hidden, String target, int target_x, int target_y,
                      Prey _prey, Vector<Place> targets) {
        super(name,species,health,strength,speed,10,1);
        water_info = new JLabel("Water_Level= " + current_water_level + "/" + max_water_level);
        food_info = new JLabel("Food_Level= " + current_food_level + "/" + max_food_level);
        hidden_info = new JLabel("Hidden_Status= " + hidden);
        target_info_1 = new JLabel("Target= " + target);
        target_info_2 = new JLabel("Target_X= " + target_x + " Target_Y= " + target_y);
        location_info = new JLabel("Current_X= " + x + " Current_Y= " + y);
        getPanel().add(water_info);
        getPanel().add(food_info);
        getPanel().add(hidden_info);
        getPanel().add(target_info_1);
        getPanel().add(target_info_2);
        getPanel().add(location_info);
        createPreyDeleteButton(_prey);
        createSetTargetCombo(_prey,targets);
        finalizePanel();
    }

    /**
     * Creates button that allows the user to delete Prey
     * @param _prey (Prey) to be deleted
     */
    public void createPreyDeleteButton(Prey _prey){
        JButton button = new JButton("Delete Prey");
        button.addActionListener(e -> {
            Map.deletePrey(_prey);
        });
        getPanel().add(button);
    }

    /**
     * ComboBox creation method to allow user to pick Animal's destination
     * @param _prey (Prey) Animal whose target is meant to be selected
     * @param targets (Vector) all possible targets
     */
    public void createSetTargetCombo(Prey _prey,Vector<Place> targets){
        JComboBox combo = new JComboBox();
        combo.setEditable(false);
        for (Place _target : targets) {
            combo.addItem(_target.getName());
        }
        combo.addActionListener(e -> {
            target_to_add = combo.getSelectedItem().toString();
            getPanel().repaint();
        });
        getPanel().add(combo);
        JButton button_2 = new JButton("Set Target");
        button_2.addActionListener(e -> {
            _prey.setTarget(Converter.targetFromString(target_to_add));
        });
        getPanel().add(button_2);
    }
}
