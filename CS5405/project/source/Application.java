/**
 * @author Adam Lininger
 */
package code;

import java.awt.event.*;
import javax.swing.*;

/**
 * The core of the actual application.
 * This class handles creating all of the higher-level objects and top-level
 * menus.
 */
public class Application extends JDesktopPane implements ActionListener
{
	JMenuItem menuItems[] = new JMenuItem[7];
	JCheckBoxMenuItem checkBoxMenuItems[] = new JCheckBoxMenuItem[7];
	Sortable sortableItems[] = new Sortable[7];
	int algorithmCount = 7;

	//About menu items
	JMenuItem authorMenuItem;
	JMenuItem descriptionMenuItem;
	JMenuItem referencesMenuItem;
	JMenuItem helpMenuItem;

	//Help window
	HelpWindow myHelpWindow = null;
	DescriptionWindow myDescriptionWindow = null;
	AuthorWindow myAuthorWindow = null;
	ReferencesWindow myReferencesWindow = null;

	//ToolBar
	JToolBar myToolBar = new JToolBar("Controls");
	JButton pause = new JButton("Pause");
	JButton play = new JButton("Play");
	JButton reset = new JButton("Reset");

	//Size to be used for sorting algorithms
	int globalSize = 100;

	JApplet topLevel;
	/**
	 * Create the Application object.
	 * @param topLevel Reference to the parent object for adding menus.
	 */
	public Application(JApplet topLevel)
	{
		this.topLevel = topLevel;
		this.sortableItems[0] = new BubbleSort();
		this.sortableItems[1] = new InsertionSort();
		this.sortableItems[2] = new MergeSort();
		this.sortableItems[3] = new QuickSort();
		this.sortableItems[4] = new SelectionSort();
		this.sortableItems[5] = new ShellSort();
		this.sortableItems[6] = new HeapSort();
		for (int i = 0; i < algorithmCount; i++)
		{
			this.add(sortableItems[i]);
			sortableItems[i].setVisible(true);
		}

		this.addMenus();
		this.setupToolBar();
	}
	
	/**
	 * Returns the JToolBar that controls the application.
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

		//Setup Demos menu
		JMenu demosMenu = new JMenu("Demos");
			JMenu algorithmsMenu = new JMenu("Algorithms");
				this.menuItems[0] = new JMenuItem("Bubble");
				this.menuItems[1] = new JMenuItem("Insertion");
				this.menuItems[2] = new JMenuItem("Merge");
				this.menuItems[3] = new JMenuItem("Quick");
				this.menuItems[4] = new JMenuItem("Selection");
				this.menuItems[5] = new JMenuItem("Shell");
				this.menuItems[6] = new JMenuItem("Heap");
				for (int i = 0; i < algorithmCount; i++)
				{
					menuItems[i].addActionListener(this);
					algorithmsMenu.add(menuItems[i]);
					
				}
			demosMenu.add(algorithmsMenu);
			JMenu selectAlgorithmsMenu = new JMenu("Select Algorithms");
				checkBoxMenuItems[0] = new JCheckBoxMenuItem("Bubble",true);
				checkBoxMenuItems[1] = new JCheckBoxMenuItem("Insertion",true);
				checkBoxMenuItems[2] = new JCheckBoxMenuItem("Merge",true);
				checkBoxMenuItems[3] = new JCheckBoxMenuItem("Quick",true);
				checkBoxMenuItems[4] = new JCheckBoxMenuItem("Selection",true);
				checkBoxMenuItems[5] = new JCheckBoxMenuItem("Shell",true);
				checkBoxMenuItems[6] = new JCheckBoxMenuItem("Heap",true);
				for (int i = 0; i < algorithmCount; i++)
				{
					selectAlgorithmsMenu.add(checkBoxMenuItems[i]);
				}
			demosMenu.add(selectAlgorithmsMenu);
		mb.add(demosMenu);
	}


	/**
	 * Handle actions performed at the top level of the application.
	 * @param e Event to be handled.
	 */
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == play)
		{
			for (int i = 0; i < algorithmCount; i++)
			{
				if (checkBoxMenuItems[i].isSelected() && !sortableItems[i].isClosed())
				{
					sortableItems[i].play();
				}
			}
		}
		if (e.getSource() == pause)
		{
			for (int i = 0; i < algorithmCount; i++)
			{
				if (checkBoxMenuItems[i].isSelected() && !sortableItems[i].isClosed())
				{
					sortableItems[i].pause();
				}
			}
		}
		if (e.getSource() == reset)
		{
			for (int i = 0; i < algorithmCount; i++)
			{
				if (checkBoxMenuItems[i].isSelected() && sortableItems[i].isClosed())
				{
					sortableItems[i].reset();
				}
			}
		}
		for (int i = 0; i < algorithmCount; i++)
		{
			if (e.getSource() == menuItems[i])
			{
				if (sortableItems[i].isClosed())
				{
					this.add(sortableItems[i]);
				}
				sortableItems[i].toFront();
				sortableItems[i].setVisible(true);
			}
		}

		if (e.getSource() == helpMenuItem)
		{
			if (myHelpWindow == null)
			{
				myHelpWindow = new HelpWindow();
				this.add(myHelpWindow);
			}
			else if (myHelpWindow.isClosed())
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
			}
			else if (myDescriptionWindow.isClosed())
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
			}
			else if (myAuthorWindow.isClosed())
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
			}
			else if (myReferencesWindow.isClosed())
			{
				this.add(myReferencesWindow);
			}
			myReferencesWindow.toFront();
			myReferencesWindow.setVisible(true);
		}
	}
}
