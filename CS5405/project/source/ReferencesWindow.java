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
	 * @param parent The parent window of the help window.
	 */
	public ReferencesWindow()
	{
		super("Help", true, true, true, true);
		setLayout(new GridLayout(1,1));
		setSize(300,300);
		setVisible(true);
		String helpContent = new StringBuilder()
			.append("References stuff\n")
			.toString();
		toFront();
		//JPanel panel = new JPanel();
		JTextArea textArea = new JTextArea(helpContent,30,30);
		JScrollPane scrollArea = new JScrollPane(textArea);
		add(scrollArea);
	}
}


