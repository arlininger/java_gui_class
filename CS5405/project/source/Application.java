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
		//JMenuBar mb = new JMenuBar();
		AppMenu mb = new AppMenu();

		JMenu bubbleMenu = new JMenu("Bubble");
		mb.add(bubbleMenu);
		this.bubbleMenuItem = new JMenuItem("Bubble");
		bubbleMenu.add(this.bubbleMenuItem);
		
		JMenu insertionMenu = new JMenu("Insertion");
		mb.add(insertionMenu);
		this.insertionMenuItem = new JMenuItem("Insertion");
		insertionMenu.add(this.insertionMenuItem);
		
		topLevel.setJMenuBar(mb);
		bubbleMenuItem.addActionListener(this);
		insertionMenuItem.addActionListener(this);
	}
	/**
	 * Handle actions performed at the top level of the application.
	 * @param e Event to be handled.
	 */
	public void actionPerformed(ActionEvent e)
	{
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
	}
}
