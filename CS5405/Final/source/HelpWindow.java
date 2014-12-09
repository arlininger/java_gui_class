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
public class HelpWindow extends JInternalFrame
{
	/**
	 * Create a Help Window.
	 */
	public HelpWindow()
	{
		super("Help", true, true, true, true);
		setLayout(new GridLayout(1,1));
		setSize(300,300);
//		setVisible(true);
		String helpContent = new StringBuilder()
			.append("Program Operation:\n")
			.append("\tBy default, all algorithms are displayed and selected. Algorithms \n")
			.append("can be selected and deselected in the Demos->Select Algorithms menu.\n")
			.append("If an algorithm's window is closed, it can be re-opened in the \n")
			.append("Demos->Algorithms menu.\n")
			.append("\n")
			.append("\tThe main window has a ToolBar with controls that control all algorithms\n")
			.append("selected in the Demos->Select Algorithms menu. Each algorithm window has \n")
			.append("it's own set of controls as well. The play button will resume any algorithm\n")
			.append("currently stopped. The reset button will suspend the running of an algorithm\n")
			.append("and randomize the data. The pause button will just suspend operation.\n")
			.append("\n")
			.append("\tThe tool bar on the main window has two additional controls. The text\n")
			.append("bar takes in integers. It determines the number of elements in the array\n")
			.append("to be sorted. By default it is 100. To change the number of elements, enter\n")
			.append("a new number and press <enter>. This number will affect individual algorithms\n")
			.append("as soon as they are reset.\n")
			.append("\n")
			.append("\tThe last control on the main window tool bar is a speed control. Moving the\n")
			.append("slider to the left reduces speed (increases the delay). Moving it to the right\n")
			.append("will increase speed (reduce delay).\n")
			.append("\n")
			.append("\tVarious other useful data (including information about the author, \n")
			.append("a description of the assignment, and a set of references can be found\n")
			.append("in the About menu.")
			.toString();
//		toFront();
		//JPanel panel = new JPanel();
		JTextArea textArea = new JTextArea(helpContent,30,15);
		textArea.setTabSize(3);
		textArea.setWrapStyleWord(true);
		JScrollPane scrollArea = new JScrollPane(textArea);
		add(scrollArea);
	}
}


