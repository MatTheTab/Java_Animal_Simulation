package Miscalenious;

import Places.LifeSource;
import Screen.Map;

import javax.swing.*;

/**
 * Class for dialog panel that shows when a LifeSource (WaterSource/Plant) is clicked on
 */
public class LifeSourceDialog extends PlaceDialog{
    JLabel replenishing_label, consumption_label,feeding_rate_label;

    /**
     * Constructor for LifeSourceDialog
     * @param name (String) name of the place
     * @param place_type (String) type of location (WaterSource/Vegetation, etc.)
     * @param occupation (int) current occupation
     * @param max_occupation (int) max occupation
     * @param x (int) the x coordinate
     * @param y (int) the y coordinate
     * @param replenishing_speed (int) the speed of replenishing of resources
     * @param consumption_material (int) how much consumable material location currently holds
     * @param max_consumption_material (int) how much consumable material can the location hold
     * @param feeding_rate (int) at what rate is the animal fed in this location
     */
    public LifeSourceDialog(String name, String place_type,int occupation, int max_occupation, int x, int y,
                            int replenishing_speed, int consumption_material, int max_consumption_material,
                            int feeding_rate){
        super(name, place_type,occupation, max_occupation, x, y);
        replenishing_label=new JLabel("Replenishment Rate= " + replenishing_speed);
        consumption_label=new JLabel("Consumable Material left= " + consumption_material+"/"+max_consumption_material);
        feeding_rate_label=new JLabel("feeding rate: "+feeding_rate*(LifeSource.feedMultiply()));
        super.getPanel().add(replenishing_label);
        super.getPanel().add(consumption_label);
        super.getPanel().add(feeding_rate_label);
        this.finalizePanel();
    }
}