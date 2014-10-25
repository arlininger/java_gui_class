/**
 * Adam Lininger
 */

package code;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * The MainFrame class is the outermost object when run as an application. It only
 * serves the purpose of creating an outer frame window and containing the applet. All
 * the real logic happens in the applet for further down.
 */
class MainFrame extends JFrame
{
	/**
	 * Creates a Frame containing the applet.
	 * @param demo The applet to display in the frame.
	 */
	public MainFrame(JApplet demo)
	{
		super ("MainFrame");
		setSize(600, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().add(demo);
		demo.init();
	}
}

/**
 * Demo is the driver for the entire program. It displays the top-level window and
 * contains the top-level logic for panel selection.
 */
public class Demo extends JApplet implements ActionListener
{
	/**
	 * The menu for assignment related items. 
	 */
	JMenu assignmentMenu;
	/**
	 * The menu for author related items. 
	 */
	JMenu authorMenu;
	/**
	 * The menu for description related items. 
	 */
	JMenu descriptionMenu;
	/**
	 * The desktop object in which all IFrames are displayed. 
	 */
	JDesktopPane desktopPane;
	/**
	 * Menu Item for selecting the assignment window.
	 */
	JMenuItem assignmentMenuItem;
	/**
	 * Menu Item for selecting the author window.
	 */
	JMenuItem authorMenuItem;
	/**
	 * Menu Item for selecting the description window.
	 */
	JMenuItem descriptionMenuItem;

	/**
	 * Window for the assignment.
	 */
	Assignment assignment;
	/**
	 * Description window.
	 */
	Description description;
	/**
	 * Author window.
	 */
	Author author;

	/**
	 * Creates the top-level applet.
	 * The layout of the top-level window is handled here.
	 */
	public Demo()
	{
		desktopPane = new JDesktopPane();
		desktopPane.setVisible(true);
		getContentPane().add(desktopPane);

		assignment = null;
		author = null;
		description = null;

		setSize(600, 600);
		setVisible(true);
		setupMenus();
	}

	/**
	 * Handles creating the menus. Called by the constructior. Should
	 * not be called again.
	 */
	private void setupMenus()
	{
		JMenuBar menuBar = new JMenuBar();
		assignmentMenu = new JMenu("Assignment");
		authorMenu = new JMenu("Author");
		descriptionMenu = new JMenu("Description");
		
		assignmentMenuItem = new JMenuItem("Show Assignment");
		authorMenuItem = new JMenuItem("Show Author");
		descriptionMenuItem = new JMenuItem("Show Description");

		menuBar.add(assignmentMenu);
		menuBar.add(authorMenu);
		menuBar.add(descriptionMenu);

		assignmentMenu.add(assignmentMenuItem);
		authorMenu.add(authorMenuItem);
		descriptionMenu.add(descriptionMenuItem);

		assignmentMenuItem.addActionListener(this);
		authorMenuItem.addActionListener(this);
		descriptionMenuItem.addActionListener(this);

		menuBar.setVisible(true);
		setJMenuBar(menuBar);
	}

	/**
	 * Primary entry point when run as an application.
	 * This function creates an instance of the Demo applet inside an
	 * instance of the MainFrame object. This allows all logic to be
	 * contained in the applet and remain common to both Applet and
	 * Application.
	 * @param args Unused.
	 */
	public static void main(String[] args)
	{
		new MainFrame(new Demo05());
	}

	/**
	 * Handle actions for the buttons in the top-level window.
	 * @param e The action to be handled.
	 */
	public void actionPerformed( ActionEvent e)
	{
		if (e.getSource() == assignmentMenuItem)
		{
			if (assignment == null)
			{
				assignment = new Assignment();
				desktopPane.add(assignment);
				assignmentMenu.add(assignment.getMenu());
			}
			if (assignment.isClosed())
			{
				desktopPane.add(assignment);
			}
			assignment.toFront();
			assignment.setVisible(true);
		} else if (e.getSource() == authorMenuItem)
		{
			if (author == null)
			{
				author = new Author();
				desktopPane.add(author);
			}
			if (author.isClosed())
			{
				desktopPane.add(author);
			}
			author.toFront();
			author.setVisible(true);
		} else if (e.getSource() == descriptionMenuItem)
		{
			if (description == null)
			{
				description = new Description();
				desktopPane.add(description);
			}
			if (description.isClosed())
			{
				desktopPane.add(description);
			}
			description.toFront();
			description.setVisible(true);
		}
		repaint();
	}		

}



