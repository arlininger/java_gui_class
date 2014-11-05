/**
 * @author Adam Lininger
 */
package code;

import java.awt.event.*;
import javax.swing.*;

/**
 * The menubar of the application.
 * This class handles all of the menus of the application. It should be
 * instancated by the main Application and the sorting algorithms handed back.
 */
public class AppMenu extends JMenuBar implements ActionListener
{
	JMenuItem authorMenuItem;
	JMenuItem problemMenuItem;
	JMenuItem referencesMenuItem;

	public AppMenu()
	{
		super();
		constructAboutMenu();
	}

	private void constructAboutMenu()
	{
		JMenu aboutMenu = new JMenu("About");
		authorMenuItem = new JMenuItem("Author");
		problemMenuItem = new JMenuItem("Problem Description");
		referencesMenuItem = new JMenuItem("References");
		
		authorMenuItem.addActionListener(this);
		problemMenuItem.addActionListener(this);
		referencesMenuItem.addActionListener(this);

		add(aboutMenu);
		aboutMenu.add(authorMenuItem);
		aboutMenu.add(problemMenuItem);
		aboutMenu.add(referencesMenuItem);
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == authorMenuItem)
		{
		} else if (e.getSource() == problemMenuItem)
		{
		} else if (e.getSource() == referencesMenuItem)
		{
		}
	}
}
