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
public class DescriptionWindow extends JInternalFrame
{
	/**
	 * Create a Help Window.
	 */
	public DescriptionWindow()
	{
		super("Help", true, true, true, true);
		setLayout(new GridLayout(1,1));
		setSize(300,300);
		setVisible(true);
		String helpContent = new StringBuilder()
			.append("Description stuff\n")
			.append("Write a program to solve the following ")
			.append("Algorithm visualization ")
			.append("problem using Java’s ")
			.append("new version of Threads. ")
			.append("Project: ")
			.append("Display the ")
			.append("functionality of Multi")
			.append("-")
			.append("tasking as below:\n")
			.append("MenuBar has menus : About, Demos, MultiTasking, possibly a digital clock.\n")
			.append("\tAbout has four submenus\n")
			.append("\t\tAuthor: your name, phone etc, instructions how to load andexecute the program.\n")
			.append("\t\tProblem Description: as stated here\n")
			.append("\t\tHelp: Provide the user help explaining the functionality of the program.\n")
			.append("\t\tReferences: You must give reference to credit the developer if you borrow any code from")
			.append("anywhere. Do not lose credit for not being able to explain your program code.\n")
			.append("\tDemos menu\n")
			.append("\t\tSorting Algorithms\n")
			.append("\t\tSelect algorithms\n")
			.append("\t\tEach algorithm has separate control\n")
			.append("\t\t\tPause\n")
			.append("\t\t\tStop\n")
			.append("\t\t\tStart\n")
			.append("\t\tImplement the following algorithms for visualizing how the algorithm does the sorting\n")
			.append("\t\t\tBubble sort\n")
			.append("\t\t\tInsertion Sort\n")
			.append("\t\t\tSelection Sort\n")
			.append("\t\t\tMerge Sort\n")
			.append("\t\t\tQuick Sort\n")
			.append("\t\t\tHeap Sort\n")
			.append("\t\t\tShell Sort\n")
			.append("\tMultiTasking has one submenu to specify which algorithms (at least 2 and at most 4) are displayed in parallel.\n")
			.append("\t\tAllow the user to select algorithms to compare their visually executing time.\n")
			.append("\t\tThe selected algorithms are displayed simultaneously.\n")
			.append("\t\tEach algorithm has the same sleep time.\n")
			.append("\tDigital Clock Menu\n")
			.append("Grading Criteria\n")
			.append("Presentation and Demonstration of the project.\n")
			.append("Each member in the group presents a section of total presentation.\n")
			.append("Tell what they learnt in this project, what is his/her contribution.\n")
			.append("Grading will be based on Implementation and Documentation, Presentation and Demonstration.\n")
			.toString();
		toFront();
		JTextArea textArea = new JTextArea(helpContent,30,30);
		textArea.setTabSize(3);
		textArea.setWrapStyleWord(true);
		JScrollPane scrollArea = new JScrollPane(textArea);
		add(scrollArea);
	}
}


