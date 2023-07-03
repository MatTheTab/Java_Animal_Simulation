package Miscalenious;

import Animals.Predator;
import Screen.Map;

import javax.swing.*;
import java.awt.*;

/**
 * Abstract class implemented for the sake of inheritance (child classes: PreyDialog and PredatorDialog).
 * This class extends general Dialog class, contains labels meant to display animal's
 * species,health,strength, speed and other characteristics already visualized by the Dialog class.
 */
public abstract class AnimalDialog extends Dialog{
    private JLabel species_info,health_info, strength_info, speed_info;

    /** Constructor for the AnimalDialog Class
     * @param name - (String) name of the animal
     * @param species - (String) name of the species of animal
     * @param health - (int) health of the animal
     * @param strength - (int) strength of the animal
     * @param speed - (int) speed of the animal
     * @param layout_rows - (int) argument used in GridLayout
     * @param layout_cols - (int) argument used in GridLayout
     */
    public AnimalDialog(String name, String species, int health, int strength, int speed,int layout_rows,
                        int layout_cols){
        super(name,layout_rows,layout_cols);
        species_info=new JLabel(species);
        health_info=new JLabel("Health= "+health);
        strength_info=new JLabel("Strength= "+strength);
        speed_info=new JLabel("Speed= "+speed);
        getPanel().add(species_info);
        getPanel().add(health_info);
        getPanel().add(strength_info);
        getPanel().add(speed_info);
    }
}
