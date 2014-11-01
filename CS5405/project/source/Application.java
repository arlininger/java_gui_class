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
	BubbleSort bubble;
	/**
	 * Create the Application object.
	 * @param topLevel Reference to the parent object for adding menus.
	 */
	public Application(JApplet topLevel)
	{
		bubble = new BubbleSort();
		this.add(bubble);
	}
	
	/**
	 * Handle actions performed at the top level of the application.
	 * @param e Event to be handled.
	 */
	public void actionPerformed(ActionEvent e)
	{
	}
}
