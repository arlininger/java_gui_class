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
	BubbleSort bubble;
	JMenuItem insertionMenuItem;
	InsertionSort insertion;
	JMenuItem selectionMenuItem;
	SelectionSort selection;

	//About menu items
	JMenuItem authorMenuItem;
	JMenuItem problemMenuItem;
	JMenuItem referencesMenuItem;

	JApplet topLevel;
	/**
	 * Create the Application object.
	 * @param topLevel Reference to the parent object for adding menus.
	 */
	public Application(JApplet topLevel)
	{
		this.topLevel = topLevel;
		bubble = null;
		this.addMenus();
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
		mb.add(aboutMenu);

		JMenu algorithmsMenu = new JMenu("Algorithms");
			JMenu bubbleMenu = new JMenu("Bubble");
				this.bubbleMenuItem = new JMenuItem("Bubble");
					bubbleMenuItem.addActionListener(this);
				bubbleMenu.add(this.bubbleMenuItem);
			algorithmsMenu.add(bubbleMenu);
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
		mb.add(algorithmsMenu);
	}


	/**
	 * Handle actions performed at the top level of the application.
	 * @param e Event to be handled.
	 */
	public void actionPerformed(ActionEvent e)
	{
		//TODO Consider putting this stuff in the Sort class
		if (e.getSource() == bubbleMenuItem)
		{
			if (bubble == null)
			{
				bubble = new BubbleSort();
				this.add(bubble);
			}
			if (bubble.isClosed())
			{
				this.add(bubble);
			}
			bubble.toFront();
			bubble.setVisible(true);
		}
		if (e.getSource() == insertionMenuItem)
		{
			if (insertion == null)
			{
				insertion = new InsertionSort();
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
				selection = new SelectionSort();
				this.add(selection);
			}
			if (selection.isClosed())
			{
				this.add(selection);
			}
			selection.toFront();
			selection.setVisible(true);
		}
	}
}
