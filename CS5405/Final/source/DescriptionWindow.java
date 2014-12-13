/**
 * @author Adam Lininger
 */

package code;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * The Description class displays a window with the description of the project..
 */
public class DescriptionWindow extends JInternalFrame
{
	/**
	 * Create a Description Window.
	 */
	public DescriptionWindow()
	{
		super("Help", true, true, true, true);
		setLayout(new GridLayout(1,1));
		setSize(300,300);
		String helpContent = new StringBuilder()
			.append("Project: Display the functionality of images and audioclips\n")
			.append("for animation as below:\n")
			.append("Project: Write a program using new threads (Do not use old \n")
			.append("threads to get credit for the project) as discussed in the\n")
			.append("class for Algorithm Visualization. Your program should be \n")
			.append("menu driven as seen in the demos and previous\n")
			.append("assignments. Your program uses JInternalFrames (full \n")
			.append("functionality) and JPanels for proper display of the\n")
			.append("program components to do all the work. The JInternalFrames \n")
			.append("and JPanels may be placed in JApplet and/or JFrame. The \n")
			.append("program should be executable as an applet or an application. \n")
			.append("Use package command for packaging the appropriate files. Jar \n")
			.append("the whole package. Document  the  code  using  java  style \n")
			.append("code. Every class, function and variable has javadoc descriptive \n")
			.append("comments. Make  your  program  as  fancy  as  you  can.  \n")
			.append("Select your favorite 10 images and 10 audioclips whose sound \n")
			.append("matched the image\n")
			.append("Menus\n")
			.append("Project: Combine functionality images and audios:\n")
			.append("Menus:\n")
			.append("\tAbout\n")
			.append("\t\tAuthor\n")
			.append("\t\tProblem\n")
			.append("\t\tReferences\n")
			.append("\t\tHelp\n")
			.append("\tDemos\n")
			.append("\t\tAudio\n")
			.append("\t\t\tInteractive: allow user to select a clip. Use buttons\n")
			.append("\t\t\tto control play, stop, loop.\n")
			.append("\t\t\tSequential: Create an internal frame for automatically \n")
			.append("\t\t\tselecting clips sequentially from the audio directory \n")
			.append("\t\t\tand playing them in that order in an infinite loop. While the \n")
			.append("\t\t\tclip is playing, display an image related to the clip.\n")
			.append("\t\tImages\n")
			.append("\t\t\tSlidesShow: Display images all scaled to same dimensions and \n")
			.append("\t\t\tone after the other from right to left.\n")
			.append("\t\t\tZoomShow: Display images all scaled from min ( say 10x10) to \n")
			.append("\t\t\tmaximum (windowsize) dimension, then back to min before starting\n")
			.append("\t\t\tthe next image.\n")
			.toString();
		JTextArea textArea = new JTextArea(helpContent,30,30);
		textArea.setTabSize(3);
		textArea.setWrapStyleWord(true);
		JScrollPane scrollArea = new JScrollPane(textArea);
		add(scrollArea);
	}
}


