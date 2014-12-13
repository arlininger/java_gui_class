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
			.append("By default, all windows are closed. The various demos can be opened\n")
			.append("(or re-opened) from the Demos menu. Sound demos are under the sound\n")
			.append("menu. Image menus are under the Image menu.\n")
			.append("\n")
			.append("The Interactive Audio demo allows a user to select a clip to play.\n")
			.append("By default, the included GrumpyCat clip is selected.\n")
			.append("\n")
			.append("The Sequential demo cycles through 10 recorded audio clips. Due to\n")
			.append("difficulty finding the desired audio clips of Count von Count from\n")
			.append("Seasame Street, a recording of my own voice is used. Corresponding\n")
			.append("images that match the number are displayed while each sound clip\n")
			.append("is played.\n")
			.append("\n")
			.append("By default, the Sequential demo will play through all 10 clips in order.\n")
			.append("You can change the selected clip by selecting it in the menu on the right.\n")
			.append("\n")
			.append("The SlideShow demo slides a series of 10 images through the screen.\n")
			.append("The images are the same 10 images as from the Sequential Audio demo.\n")
			.append("This demo has no controls.\n")
			.append("\n")
			.append("The ZoomShow demo repeatedly zooms in and then out on the same 10\n")
			.append("images used previously. This demo has no controls.\n")
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


