/**
 * @author Adam Lininger
 */
package code;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * The core of the actual application.
 * This class handles creating all of the higher-level objects and top-level
 * menus. 
 */
public class Application extends JDesktopPane implements ActionListener, ChangeListener
{
	//About menu items
	/**
	 * Author Menu entry.
	 */
	JMenuItem authorMenuItem;

	/**
	 * Description Menu entry.
	 */
	JMenuItem descriptionMenuItem;

	/**
	 * References Menu entry.
	 */
	JMenuItem referencesMenuItem;

	/**
	 * Help Menu entry.
	 */
	JMenuItem helpMenuItem;

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
			authorMenuItem = new JMenuItem("Author");
				authorMenuItem.addActionListener(this);
			aboutMenu.add(authorMenuItem);
			descriptionMenuItem = new JMenuItem("Problem Description");
				descriptionMenuItem.addActionListener(this);
			aboutMenu.add(descriptionMenuItem);
			referencesMenuItem = new JMenuItem("References");
				referencesMenuItem.addActionListener(this);
			aboutMenu.add(referencesMenuItem);
			helpMenuItem = new JMenuItem("Help");
				helpMenuItem.addActionListener(this);
			aboutMenu.add(helpMenuItem);
		mb.add(aboutMenu);

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
		if (e.getSource() == helpMenuItem)
		{
			if (myHelpWindow == null)
			{
				myHelpWindow = new HelpWindow();
				this.add(myHelpWindow);
			} else if (myHelpWindow.isClosed())
			{
				this.add(myHelpWindow);
			}
			myHelpWindow.toFront();
			myHelpWindow.setVisible(true);
		}
		if (e.getSource() == descriptionMenuItem)
		{
			if (myDescriptionWindow == null)
			{
				myDescriptionWindow = new DescriptionWindow();
				this.add(myDescriptionWindow);
			} else if (myDescriptionWindow.isClosed())
			{
				this.add(myDescriptionWindow);
			}
			myDescriptionWindow.toFront();
			myDescriptionWindow.setVisible(true);
		}
		if (e.getSource() == authorMenuItem)
		{
			if (myAuthorWindow == null)
			{
				myAuthorWindow = new AuthorWindow();
				this.add(myAuthorWindow);
			} else if (myAuthorWindow.isClosed())
			{
				this.add(myAuthorWindow);
			}
			myAuthorWindow.toFront();
			myAuthorWindow.setVisible(true);
		}
		if (e.getSource() == referencesMenuItem)
		{
			if (myReferencesWindow == null)
			{
				myReferencesWindow = new ReferencesWindow();
				this.add(myReferencesWindow);
			} else if (myReferencesWindow.isClosed())
			{
				this.add(myReferencesWindow);
			}
			myReferencesWindow.toFront();
			myReferencesWindow.setVisible(true);
		}
		if (e.getSource() == sizeControl)
		{
		}
	}
}
