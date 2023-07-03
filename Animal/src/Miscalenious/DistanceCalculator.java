package Miscalenious;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * Class implemented as  a means of calculating distance between two points
 */
public class DistanceCalculator {
    /**
     * Static method calculates distance between two integer points
     * @param x1 (int) x of the first point
     * @param y1 (int) y of the first point
     * @param x2 (int) x of the second point
     * @param y2 (int) y of the second point
     * @return (float) calculated distance between 2 points
     */
    public static float getDistance(int x1,int y1,int x2,int y2){
        return (float) sqrt(pow((float) x1 - (float) x2, 2) + pow((float) y1 - (float) y2, 2));
    }
}
