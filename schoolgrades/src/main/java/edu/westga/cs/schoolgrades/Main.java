package edu.westga.cs.schoolgrades;

import edu.westga.cs.schoolgrades.views.Gui;

/**
 * Main class for the SchoolGrades project
 * 
 * @author lewisb
 * @version cs6241
 */
public class Main {

    /**
     * Start point for the appliction.
     * 
     * @param args not used
     */
    public static void main(String[] args) {
        Gui theGui = new Gui();
        
        theGui.setVisible(true);
    }

}
