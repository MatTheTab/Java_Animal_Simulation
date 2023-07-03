package Miscalenious;

import java.awt.*;

import static Constants.Constants.MAPSIZE_HEIGHT;
import static Constants.Constants.MAPSIZE_WIDTH;

/**
 * Class implemented as a means of visualizing paths
 */
public class Draw extends Component {
    private final int x1,x2,y1,y2;

    /**
     * Method draws a line from given x1,y1 to x2,y2
     * @param _x1 (int) x coordinate of the origin point
     * @param _y1 (int) y coordinate of the origin point
     * @param _x2 (int) x coordinate of the end point
     * @param _y2 (int) y coordinate of the end point
     */
    public Draw(int _x1,int _y1,int _x2,int _y2){
        x1=_x1;
        x2=_x2;
        y1=_y1;
        y2=_y2;
        this.setSize(MAPSIZE_WIDTH+1000,MAPSIZE_HEIGHT+1000);
    }

    /**
     * draws path using drawLine() method
     * @param g (Graphics)
     */
    public void DrawPath(Graphics g){
        Color brown=new Color(150,75,0);
        g.setColor(brown);
        g.drawLine(x1,y1,x2,y2);
    }

    public void paint(Graphics g){
        super.paint(g);
        DrawPath(g);
    }
}
