package GameMaster;

import Animals.Predator;
import Animals.Prey;
import Screen.Map;

/**
 * Class used to resolve conflicts between animals.
 */
public class GameMaster {
    /**
     * Static method used to resolve a conflict between Predator - attacker and Prey - defender.
     * This method calculates the difference in strength between the two animals and
     * decreases health of the defender according to that difference. If the current health of
     * the defender falls to 0 or below, the method ends Prey's thread and returns true as a means to signal
     * to the attacker that the hunt was successful. Otherwise, the method returns false.
     * @param attacker (Predator)
     * @param defender (Prey)
     * @return if hunt was successful (boolean)
     */
    static public synchronized boolean resolve_fight(Predator attacker, Prey defender){
        int strength_difference=attacker.getStrength()-defender.getStrength();
        if(defender.getHiding()==true){
            return false;
        }
        if(strength_difference>0){
            defender.setHealth(defender.getHealth()-strength_difference);
            if (defender.getHealth()<=0){
                defender.setKilled();
                Map.deletePrey(defender);
                attacker.increaseKillCount();
                attacker.setCurrentRelaxLevel(attacker.getMaxRelaxLevel());
                return true;
            }
        }
        return false;
    }

}
