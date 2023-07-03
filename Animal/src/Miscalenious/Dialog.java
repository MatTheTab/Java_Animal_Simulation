package Miscalenious;

import javax.swing.*;
import java.awt.*;

import static Constants.Constants.MAPSIZE_HEIGHT;
import static Constants.Constants.MAPSIZE_WIDTH;

/**
 * Dialog Class implemented for the sake of inheritance. Has information about the name of Animal/location
 * as name_info and holds both JPanel and JFrame necessary for displaying that information.
 */
public abstract class Dialog {
    JLabel name_info;
    private JPanel new_panel=new JPanel();
    private JFrame info=new JFrame();
    /**
     * Constructor for the Dialog Class
     * @param name (String) name of the object to be displayed
     * @param layout_rows (int) argument used when creating GridLayout
     * @param layout_cols (int) argument used when creating GridLayout
     */
    public Dialog(String name,int layout_rows,int layout_cols){
        info.setSize(MAPSIZE_WIDTH/3,MAPSIZE_HEIGHT/2);
        info.setResizable(true);
        info.setVisible(true);
        info.setLocation(MAPSIZE_WIDTH/3,MAPSIZE_HEIGHT/3);
        name_info=new JLabel(name);
        new_panel.setLayout(new GridLayout(layout_rows,layout_cols));
        new_panel.add(name_info);
    }

    public JFrame getFrame(){ return info; }

    /**
     * @return (JPanel) new_panel
     */
    public JPanel getPanel(){ return new_panel; }

    /**
     * adds new_panel to the JFrame, done at the end to finalize the dialog creation process
     */
    public void finalizePanel(){ info.add(new_panel); }
}
