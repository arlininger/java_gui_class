/**
 * @author Adam Lininger
 */
package code;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

enum MenuItems
{
	AUTHOR,
	DESCRIPTION,
	REFERENCES,
	HELP,
	INTERACTIVE,
	SEQUENTIAL,
	SLIDESHOW,
	ZOOMSHOW
}

/**
 * The core of the actual application.
 * This class handles creating all of the higher-level objects and top-level
 * menus. 
 */
public class Application extends JDesktopPane implements ActionListener, ChangeListener
{
	/**
	 * Array of menu items for this application.
	 */
	JMenuItem[] menuItemArray;

	JInternalFrame[] windowArray;
	/**
	 * JInternalFrame for Help Window.
	 */
	HelpWindow myHelpWindow = null;

	/**
	 * JInternalFrame for Description Window.
	 */
	DescriptionWindow myDescriptionWindow = null;

	/**
	 * JInternalFrame for Author Window.
	 */
	AuthorWindow myAuthorWindow = null;

	/**
	 * JInternalFrame for References Window.
	 */
	ReferencesWindow myReferencesWindow = null;

	/**
	 * Window for displaying Sequential images.
	 */
	ZoomShow zoomShow = null;
	/**
	 * Toolbar for main window controls.
	 */
	JToolBar myToolBar = new JToolBar("Controls");

	/**
	 * Main window pause control.
	 */
	JButton pause = new JButton("Pause");

	/**
	 * Main window play control.
	 */
	JButton play = new JButton("Play");

	/**
	 * Main window reset control.
	 */
	JButton reset = new JButton("Reset");

	/**
	 * Size control.
	 */
	JTextField sizeControl = new JTextField("100",4);

	/**
	 * Speed control.
	 */
	JSlider speedControl = new JSlider(0,49,39);

	/**
	 * Number of items to sort.
	 */
	int globalSize = 100;

	/**
	 * Reference to the top-level applet.
	 */
	JApplet topLevel;

	/**
	 * Create the Application object.
	 * @param topLevel Reference to the parent object for adding menus.
	 */
	public Application(JApplet topLevel)
	{
		this.topLevel = topLevel;
		zoomShow = new ZoomShow();
		this.add(zoomShow);
		menuItemArray = new JMenuItem[MenuItems.values().length];
		windowArray = new JInternalFrame[MenuItems.values().length];
		windowArray[MenuItems.AUTHOR.ordinal()] = new AuthorWindow();
		windowArray[MenuItems.DESCRIPTION.ordinal()] = new DescriptionWindow();
		windowArray[MenuItems.REFERENCES.ordinal()] = new ReferencesWindow();
		windowArray[MenuItems.HELP.ordinal()] = new HelpWindow();
//		windowArray[MenuItems.INTERACTIVE.ordinal()] = new InteractiveWindow();
//		windowArray[MenuItems.SEQUENTIAL.ordinal()] = new SequentialWindow();
//		windowArray[MenuItems.SLIDESHOW.ordinal()] = new SlideShowWindow();
		windowArray[MenuItems.ZOOMSHOW.ordinal()] = new ZoomShow();

		this.addMenus();
		this.setupToolBar();
	}
	
	/**
	 * Returns the JToolBar that controls the application.
	 * @return The toolbar attached to this application.
	 */
	public JToolBar getToolBar()
	{
		return myToolBar;
	}
	
	/**
	 * Create the toolBar and add the buttons.
	 */
	private void setupToolBar()
	{
		//Setup toolbar
		myToolBar.add(play);
			play.addActionListener(this);
		myToolBar.add(pause);
			pause.addActionListener(this);
		myToolBar.add(reset);
			reset.addActionListener(this);
		myToolBar.add(sizeControl);
			sizeControl.addActionListener(this);
		myToolBar.add(speedControl);
			speedControl.addChangeListener(this);
	}

	/**
	 * Create the menus.
	 */
	private void addMenus()
	{
		//Setup menubar
		JMenuBar mb = new JMenuBar();
		topLevel.setJMenuBar(mb);

		//Setup About menu
		JMenu aboutMenu = new JMenu("About");
			menuItemArray[MenuItems.AUTHOR.ordinal()] = new JMenuItem("Author");
			aboutMenu.add(menuItemArray[MenuItems.AUTHOR.ordinal()]);
			menuItemArray[MenuItems.DESCRIPTION.ordinal()] = new JMenuItem("Problem Description");
			aboutMenu.add(menuItemArray[MenuItems.DESCRIPTION.ordinal()]);
			menuItemArray[MenuItems.REFERENCES.ordinal()] = new JMenuItem("References");
			aboutMenu.add(menuItemArray[MenuItems.REFERENCES.ordinal()]);
			menuItemArray[MenuItems.HELP.ordinal()] = new JMenuItem("Help");
			aboutMenu.add(menuItemArray[MenuItems.HELP.ordinal()]);
		mb.add(aboutMenu);

		JMenu demosMenu = new JMenu("Demos");
			JMenu audioMenu = new JMenu("Audio");
				menuItemArray[MenuItems.INTERACTIVE.ordinal()] = new JMenuItem("Interactive");
				audioMenu.add(menuItemArray[MenuItems.INTERACTIVE.ordinal()]);
				menuItemArray[MenuItems.SEQUENTIAL.ordinal()] = new JMenuItem("Sequential");
				audioMenu.add(menuItemArray[MenuItems.SEQUENTIAL.ordinal()]);
			demosMenu.add(audioMenu);
			JMenu imagesMenu = new JMenu("Images");
				menuItemArray[MenuItems.SLIDESHOW.ordinal()] = new JMenuItem("Slide Show");
				imagesMenu.add(menuItemArray[MenuItems.SLIDESHOW.ordinal()]);
				menuItemArray[MenuItems.ZOOMSHOW.ordinal()] = new JMenuItem("Zoom Show");
				imagesMenu.add(menuItemArray[MenuItems.ZOOMSHOW.ordinal()]);
			demosMenu.add(imagesMenu);
		mb.add(demosMenu);
		
		for (MenuItems item : MenuItems.values()) {
			menuItemArray[item.ordinal()].addActionListener(this);
		}

	}

	/**
	 * Listen for state changes on the speed slider.
	 * @param e Event that occurred.
	 */
	public void stateChanged(ChangeEvent e)
	{
		if (e.getSource() == speedControl)
		{
			int speed = 50-speedControl.getValue();
		}
	}
	/**
	 * Handle actions performed at the top level of the application.
	 * @param e Event to be handled.
	 */
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == play)
		{
		}
		if (e.getSource() == pause)
		{
		}
		if (e.getSource() == reset)
		{
		}
		for (MenuItems item : MenuItems.values()) {
			if (e.getSource() == windowArray[item.ordinal()])
			{
				if (windowArray[item.ordinal()].isClosed())
				{
					this.add(windowArray[item.ordinal()]);
				}
				windowArray[item.ordinal()].toFront();
				windowArray[item.ordinal()].setVisible(true);
			}
		}

		if (e.getSource() == sizeControl)
		{
		}
	}
}
