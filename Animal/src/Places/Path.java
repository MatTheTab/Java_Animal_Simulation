package Places;

import Miscalenious.DistanceCalculator;

import java.util.Vector;

/**
 * Class used when creating a path connecting two locations
 */
public class Path {
    private float a,b;
    private Vector<Integer> x_cords;
    private Vector<Integer> y_cords;
    private MinorCrossing finish;
    /**
     * Method that adds a connection (path) between two places
     * @param _start_x (int) x coordinate of the starting location
     * @param _start_y (int) y coordinate of the starting location
     * @param _end_x (int) x coordinate of the end location
     * @param _end_y (int) y coordinate of the end location
     * @param _finish (MinorCrossing) end target
     */
    public Path(int _start_x, int _start_y, int _end_x, int _end_y, MinorCrossing _finish){
        x_cords= new Vector<>(0);
        y_cords= new Vector<>(0);
        x_cords.addElement(_start_x);
        y_cords.addElement(_start_y);
        int length= (int) DistanceCalculator.getDistance(_start_x,_start_y,_end_x,_end_y);
        a=(float)(_end_y-_start_y)/(float)(_end_x-_start_x);
        b=(float)_start_y-a*(float)_start_x;
        int x_step=_end_x-_start_x;
        for(int i=0;i<=length;i++){
            x_cords.addElement((int)(_start_x+ i*((float)x_step/(float)length)));
        }
        for (Integer x_cord : x_cords) {
            y_cords.addElement((int) (a * (float) x_cord + b));
        }
        x_cords.addElement(_end_x);
        y_cords.addElement(_end_y);
        finish=_finish;
    }

    public float getA(){ return a; }
    public float getB(){ return b; }

    public void setFinish(MinorCrossing new_crossing){ finish=new_crossing; }

    public MinorCrossing getFinish(){ return finish; }

    public Vector<Integer> getX_cords(){ return x_cords; }

    public Vector<Integer> getY_cords(){ return y_cords; }
}
