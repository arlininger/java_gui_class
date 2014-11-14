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
	JMenuItem bubbleMenuItem;
	JCheckBoxMenuItem bubbleSelection;
	BubbleSort bubble = null;
	JMenuItem shellMenuItem;
	JCheckBoxMenuItem shellSelection;
	ShellSort shell = null;
	JMenuItem insertionMenuItem;
	JCheckBoxMenuItem insertionSelection;
	InsertionSort insertion = null;
	JMenuItem selectionMenuItem;
	JCheckBoxMenuItem selectionSelection;
	SelectionSort selection = null;
	JMenuItem quickMenuItem;
	JCheckBoxMenuItem quickSelection;
	QuickSort quick = null;

	//About menu items
	JMenuItem authorMenuItem;
	JMenuItem problemMenuItem;
	JMenuItem referencesMenuItem;
	JMenuItem helpMenuItem;

	//Help window
	HelpWindow myHelpWindow = null;

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
		this.addMenus();
		this.setupToolBar();
	}
	
	public JToolBar getToolBar()
	{
		return myToolBar;
	}
	
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
			problemMenuItem = new JMenuItem("Problem Description");
				problemMenuItem.addActionListener(this);
			aboutMenu.add(problemMenuItem);
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
				JMenu bubbleMenu = new JMenu("Bubble");
					this.bubbleMenuItem = new JMenuItem("Bubble");
						bubbleMenuItem.addActionListener(this);
					bubbleMenu.add(this.bubbleMenuItem);
				algorithmsMenu.add(bubbleMenu);
				JMenu shellMenu = new JMenu("Shell");
					this.shellMenuItem = new JMenuItem("Shell");
						shellMenuItem.addActionListener(this);
					shellMenu.add(this.shellMenuItem);
				algorithmsMenu.add(shellMenu);
				JMenu insertionMenu = new JMenu("Insertion");
					this.insertionMenuItem = new JMenuItem("Insertion");
						insertionMenuItem.addActionListener(this);
					insertionMenu.add(this.insertionMenuItem);
				algorithmsMenu.add(insertionMenu);
				JMenu selectionMenu = new JMenu("Selection");
					this.selectionMenuItem = new JMenuItem("Selection");
						selectionMenuItem.addActionListener(this);
					selectionMenu.add(this.selectionMenuItem);
				algorithmsMenu.add(selectionMenu);
				JMenu quickMenu = new JMenu("Quick");
					this.quickMenuItem = new JMenuItem("Quick");
						quickMenuItem.addActionListener(this);
					quickMenu.add(this.quickMenuItem);
				algorithmsMenu.add(quickMenu);
			demosMenu.add(algorithmsMenu);
			JMenu selectAlgorithmsMenu = new JMenu("Select Algorithms");
				this.bubbleSelection = new JCheckBoxMenuItem("Bubble",false);
				selectAlgorithmsMenu.add(this.bubbleSelection);
				this.shellSelection = new JCheckBoxMenuItem("Shell",false);
				selectAlgorithmsMenu.add(this.shellSelection);
				this.insertionSelection = new JCheckBoxMenuItem("Insertion",false);
				selectAlgorithmsMenu.add(this.insertionSelection);
				this.selectionSelection = new JCheckBoxMenuItem("Selection",false);
				selectAlgorithmsMenu.add(this.selectionSelection);
				this.quickSelection = new JCheckBoxMenuItem("Quick",false);
				selectAlgorithmsMenu.add(this.quickSelection);
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
			if (bubbleSelection.isSelected() && bubble != null)
			{
				bubble.play();
			}
			if (shellSelection.isSelected() && shell != null)
			{
				shell.play();
			}
			if (insertionSelection.isSelected() && insertion != null)
			{
				insertion.play();
			}
			if (selectionSelection.isSelected() && selection != null)
			{
				selection.play();
			}
			if (quickSelection.isSelected() && quick != null)
			{
				quick.play();
			}
		}
		if (e.getSource() == pause)
		{
			if (bubbleSelection.isSelected() && bubble != null)
			{
				bubble.pause();
			}
			if (shellSelection.isSelected() && shell != null)
			{
				shell.pause();
			}
			if (insertionSelection.isSelected() && insertion != null)
			{
				insertion.pause();
			}
			if (selectionSelection.isSelected() && selection != null)
			{
				selection.pause();
			}
			if (quickSelection.isSelected() && quick != null)
			{
				quick.pause();
			}
		}
		if (e.getSource() == reset)
		{
			if (bubbleSelection.isSelected() && bubble != null)
			{
				bubble.reset();
			}
			if (shellSelection.isSelected() && shell != null)
			{
				shell.reset();
			}
			if (insertionSelection.isSelected() && insertion != null)
			{
				insertion.reset();
			}
			if (selectionSelection.isSelected() && selection != null)
			{
				selection.reset();
			}
			if (quickSelection.isSelected() && quick != null)
			{
				quick.reset();
			}
		}
		if (e.getSource() == bubbleMenuItem)
		{
			if (bubble == null)
			{
				bubble = new BubbleSort(globalSize);
				this.add(bubble);
			}
			if (bubble.isClosed())
			{
				this.add(bubble);
			}
			bubble.toFront();
			bubble.setVisible(true);
		}
		if (e.getSource() == shellMenuItem)
		{
			if (shell == null)
			{
				shell = new ShellSort(globalSize);
				this.add(shell);
			}
			if (shell.isClosed())
			{
				this.add(shell);
			}
			shell.toFront();
			shell.setVisible(true);
		}
		if (e.getSource() == insertionMenuItem)
		{
			if (insertion == null)
			{
				insertion = new InsertionSort(globalSize);
				this.add(insertion);
			}
			if (insertion.isClosed())
			{
				this.add(insertion);
			}
			insertion.toFront();
			insertion.setVisible(true);
		}
		if (e.getSource() == selectionMenuItem)
		{
			if (selection == null)
			{
				selection = new SelectionSort(globalSize);
				this.add(selection);
			}
			if (selection.isClosed())
			{
				this.add(selection);
			}
			selection.toFront();
			selection.setVisible(true);
		}
		if (e.getSource() == quickMenuItem)
		{
			if (quick == null)
			{
				quick = new QuickSort(globalSize);
				this.add(quick);
			}
			if (quick.isClosed())
			{
				this.add(quick);
			}
			quick.toFront();
			quick.setVisible(true);
		}

		if (e.getSource() == helpMenuItem)
		{
//			if (myHelpWindow == null)
//			{
//				myHelpWindow = new HelpWindow();
//			}
//			if (myHelpWindow.isClosed())
//			{
//			}
//			myHelpWindow.toFront();
//			myHelpWindow.setVisible(true);
		}
	}
}
