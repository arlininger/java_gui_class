/**
 * @author Adam Lininger
 */
package code;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * An enumeration of the various menu options used in this application.
 */
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
public class Application extends JDesktopPane implements ActionListener
{
	/**
	 * Array of menu items for this application. Indexed by the MenuItem Enumeration.
	 */
	JMenuItem[] menuItemArray;

	/**
	 * Array of the various windows that can be displayed. Indexed by the MenuItem Enumeration.
	 */
	JInternalFrame[] windowArray;

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
		menuItemArray = new JMenuItem[MenuItems.values().length];
		windowArray = new JInternalFrame[MenuItems.values().length];
		windowArray[MenuItems.AUTHOR.ordinal()] = new AuthorWindow();
		windowArray[MenuItems.DESCRIPTION.ordinal()] = new DescriptionWindow();
		windowArray[MenuItems.REFERENCES.ordinal()] = new ReferencesWindow();
		windowArray[MenuItems.HELP.ordinal()] = new HelpWindow();
		windowArray[MenuItems.INTERACTIVE.ordinal()] = new Interactive();
		windowArray[MenuItems.SEQUENTIAL.ordinal()] = new Sequential();
		windowArray[MenuItems.SLIDESHOW.ordinal()] = new SlideShow();
		windowArray[MenuItems.ZOOMSHOW.ordinal()] = new ZoomShow();
		for (MenuItems item : MenuItems.values()) {
			this.add(windowArray[item.ordinal()]);
		}

		this.addMenus();
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
	 * Handle actions performed at the top level of the application.
	 * @param e Event to be handled.
	 */
	public void actionPerformed(ActionEvent e)
	{
		for (MenuItems item : MenuItems.values()) {
			if (e.getSource() == menuItemArray[item.ordinal()])
			{
				if (windowArray[item.ordinal()].isClosed())
				{
					this.add(windowArray[item.ordinal()]);
				}
				windowArray[item.ordinal()].toFront();
				windowArray[item.ordinal()].setVisible(true);
			}
		}

	}
}
