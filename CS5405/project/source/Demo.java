/**
 * @author Adam Lininger
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
		setSize(760,700);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(demo);
		demo.init();
	}
}

/**
 * Demo is the driver for the entire program. It displays the top-level window and
 * contains the top-level logic for panel selection.
 */
public class Demo extends JApplet
{
	/**
	 * The core of the application.
	 */
	Application mainApp;
	/**
	 * Creates the top-level applet.
	 * The layout of the top-level window is handled here.
	 */
	public Demo()
	{
//		getContentPane().setLayout(new GridLayout(1, 1, 1, 1));
		getContentPane().setLayout(new BorderLayout());
		mainApp = new Application(this);
		getContentPane().add(mainApp);
		getContentPane().add(mainApp.getToolBar(),BorderLayout.NORTH);
		setSize(760,700);
		setVisible(true);
	}

	/**
	 * Primary entry point when run as an application.
	 * This function creates an instance of the Demo applet inside an
	 * instance of the MainFrame object. This allows all logic to be
	 * contained in the applet and remain common to both Applet and
	 * Application.
	 *
	 * @param args Ignored
	 */
	public static void main(String[] args)
	{
		new MainFrame(new Demo());
	}
}

