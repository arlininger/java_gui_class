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
public class ReferencesWindow extends JInternalFrame
{
	/**
	 * Create a Help Window.
	 */
	public ReferencesWindow()
	{
		super("Help", true, true, true, true);
		setLayout(new GridLayout(1,1));
		setSize(300,300);
//		setVisible(true);
		String helpContent = new StringBuilder()
			.append("References:\n")
			.append("\tNo code was borrowed or taken from another source. Several \n")
			.append("functions/classes that were not taught in class were used. \n")
			.append("Documentation on these items were found at \n")
			.append("https://docs.oracle.com/javase/8/docs/api and \n")
			.append("https://docs.oracle.com/javase/tutorial/.\n")
			.toString();
//		toFront();
		//JPanel panel = new JPanel();
		JTextArea textArea = new JTextArea(helpContent,30,30);
		textArea.setTabSize(3);
		textArea.setWrapStyleWord(true);
		JScrollPane scrollArea = new JScrollPane(textArea);
		add(scrollArea);
	}
}


