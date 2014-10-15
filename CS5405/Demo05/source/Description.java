/**
 * Adam Lininger
 */

package code;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * The Description class contains a description of the Homework assignment.
 * The express purpose of this class is to display the text of the homework
 * assignment in a JTextArea object.
 */
public class Description extends JInternalFrame
{
	/**
	 * Creates a Description object. As the Description object is display only
	 * all logic is handled here.
	 */
	public Description()
	{
		super("Description", true, true, true, true);
		setSize(600, 530);
		setOpaque(true);
		setVisible(true);
		toFront();
		
		String description = new StringBuilder()
		.append("Write a program (name it Demo05.java) display everything in a frame, ")
		.append("that menus and internal frames\n")
		.append("Place .java files in source directory .class files in the code directory.\n")
		.append("Use separate files for author description and demo.\n")
		.append("About menu\n")
		.append("\tAuthorIdentification\n")
		.append("\t\tUse internal frame (not panel)\n")
		.append("\t\tUse paint method to create this page.\n")
		.append("\tProblem description\n")
		.append("\t\tUse internal frame (not panel)\n")
		.append("\t\tUse JTextArea with scrollpane border to create this page.\n")
		.append("Demos menu\n")
		.append("\tProblem solution\n")
		.append("\t\tUse internalframe (not panel)\n")
		.append("\t\tUse the same problem as in HW04.\n")
		.append("\t\tUse two submenus for 2D and 3D\n")
		.append("\tUse menuitems in each submenu\n")
		.append("\t\tFor displaying the corresponding figure and its properties.\n")
		.append("Create javadoc documentation for every variable every function")
		.append(" and every class that you define.\n")
		.append("Program should be executable as applet as well as application.\n")
		.append("\tCreate a folder named CS5405. Create a subdirectory Demo05 inside CS5405. \n")
		.append("\tcd to Demo05\n")
		.append("\tCreate application/applet source files. Name the driver as Demo.java\n")
		.append("\tCompile all of them with\n")
		.append("\t\tjavac *.java \n")
		.append("\tIt will create corresponding files with extension\n")
		.append("\t\t.class\n")
		.append("\tCreate javadoc documentation\n")
		.append("\t\tjavdoc -d docs –author –version –private souce/*.java \n")
		.append("\tNow your Demo05 directory contains only four things: source")
		.append(" directory code directory, docs directory, \n")
		.append("\tand .html file.\n")
		.append("\t\tCreate a zip file Demo05.zip\n")
		.append("\tHow to submit assignment\n")
		.append("\t\tUpload the zip file On black board\n")
		.append("\t\tBring printed code and Sample output with screenshots to the class\n")
		.append("\t\tAttach this sheet for grade recording.\n")
		.append("Create html file as Demo05.html\n")
		.append("\twhich is a text file with only one line\n")
		.append("\t\t<applet code = code.Demo05 width = 600 height = 600></applet> \n")
		.append("Turn in the printed copy of source code and screenshots of program")
		.append(" output in the class.\n")
		.append("YOUR PROGRAM OUTPUT WILL BE IN a FRAME NOT on commandline.\n")
		.append("Check the application - does it work? Check the applet - does it work? \n")
		.append("If you need help ask me before the tuesday lecture.\n")
		.append("Note. Use GUI components that have been covered in the class as needed")
		.append(" to do your work.\n")
		.append("Create separate file for each page. Document these files using javadoc")
		.append(" style descriptions. This documentation \n")
		.append("should be constructive as discussed in the class not parroting.\n")
		.append("All code should be your original code not copy of some else’s. You can be")
		.append(" called to the office to explain your \n")
		.append("demo05 program if necessary to get additional information from you.\n")
			.toString();
		JTextArea mainArea = new JTextArea(description, 30, 50);
		mainArea.setTabSize(3);
		mainArea.setWrapStyleWord(true);
		JScrollPane scrollwindow = new JScrollPane(mainArea);
		this.add(scrollwindow);
	}
}


