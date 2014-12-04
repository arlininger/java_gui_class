/**
 * @author Adam Lininger
 */

package code;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * The Help class displays a dialog box with a helpful description of the basic functionality
 * of this program.
 */
public class AuthorWindow extends JInternalFrame
{
	/**
	 * Create a Help Window.
	 */
	public AuthorWindow()
	{
		super("Help", true, true, true, true);
		setLayout(new GridLayout(1,1));
		setSize(300,300);
		setVisible(true);
		String helpContent = new StringBuilder()
			.append("Adam Lininger\n")
			.append("(573)466-0044\n\n")
			.append("\tThis application is self-contained with in the Demo.jar \n")
			.append("file. It may be run by executing the line \n")
			.append("\"java -jar Demo.jar\" \n")
			.append("in any commandline on a system that has Java installed.")
			.toString();
		toFront();
		//JPanel panel = new JPanel();
		JTextArea textArea = new JTextArea(helpContent,30,30);
		textArea.setTabSize(3);
		textArea.setWrapStyleWord(true);
		JScrollPane scrollArea = new JScrollPane(textArea);
		add(scrollArea);
	}
}


