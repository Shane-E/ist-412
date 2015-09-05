package view;

import javax.swing.*;

/**
 * Created by Shane on 9/2/15.
 */
public class MainMenu extends JMenuBar{
    JMenuBar menu;
    JMenu menuFile, menuRunType, menuConfig;
    JMenuItem closeApp, selectSourceDirectory, selectJDK;
    JRadioButtonMenuItem singleRun, batchRun;
    ButtonGroup menuRunTypeRadios;

    public MainMenu(){
        //Set up menu bar
        menu = new JMenuBar();

        //Set up menu items that are displayed on bar.
        menuFile = new JMenu("File");
        menuRunType = new JMenu("Run Type");
        menuConfig = new JMenu("Config");

        //Set up menu sub-items that are shown beneath a menu item.
        closeApp = new JMenuItem("Exit");
        selectSourceDirectory = new JMenuItem("Select Config File"); //Select Source Directory
        selectJDK = new JMenuItem("Select JDK");

        //Set up button group for menu radio buttons.
        menuRunTypeRadios = new ButtonGroup();

        //Set up menu radio button sub-items.
        singleRun = new JRadioButtonMenuItem("Single Run");
        batchRun = new JRadioButtonMenuItem("Batch Run");

        //Set default selection for run type.
        singleRun.setSelected(true);

        //Add radio buttons to button group.
        menuRunTypeRadios.add(singleRun);
        menuRunTypeRadios.add(batchRun);

        //Add options to the menubar.
        this.add(menuFile);
        this.add(menuRunType);
        this.add(menuConfig);

        //Adds options in dropdown format for menu item.
        menuFile.add(closeApp);
        menuConfig.add(selectJDK);
        menuConfig.add(selectSourceDirectory);
        menuRunType.add(singleRun);
        menuRunType.add(batchRun);
    }
}