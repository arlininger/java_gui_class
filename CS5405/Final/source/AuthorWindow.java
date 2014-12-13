/**
 * @author Adam Lininger
 */

package code;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * The Author window displays relevant information about the author of the applicaton.
 */
public class AuthorWindow extends JInternalFrame
{
	/**
	 * Create an Author Window.
	 */
	public AuthorWindow()
	{
		super("Author", true, true, true, true);
		setLayout(new GridLayout(1,1));
		setSize(300,300);
		String helpContent = new StringBuilder()
			.append("Adam Lininger\n")
			.append("(573)466-0044\n\n")
			.append("\tThis application is self-contained with in the Demo.jar \n")
			.append("file. It may be run by executing the line \n")
			.append("\"java -jar Demo.jar\" \n")
			.append("in any commandline on a system that has Java installed.")
			.toString();
		JTextArea textArea = new JTextArea(helpContent,30,30);
		textArea.setTabSize(3);
		textArea.setWrapStyleWord(true);
		JScrollPane scrollArea = new JScrollPane(textArea);
		add(scrollArea);
	}
}


