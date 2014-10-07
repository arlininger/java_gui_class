/*
 * Adam Lininger
 */

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;


public class Description extends JPanel
{

	public Description()
	{
		TitledBorder panelBorder = new TitledBorder("Description Output");
		setBorder(panelBorder);
		String description = new StringBuilder()
			.append("Write a program (name it Demo4.java) that displays buttons for \n")
			.append("\tUserIdentification\n")
			.append("\t\tUse paint method to create this page.\n")
			.append("\tProblem description\n")
			.append("\t\tUse JTextArea with border to create this page.\n")
			.append("\tProblem solution\n")
			.append("\t\tDisplay everything in a frame.\n")
			.append("\t\tUse the same problem as in HW03.\n")
			.append("\t\tDisplay two buttons one 2D and one for 3D.\n")
			.append("\t\tOn clicking a button only then it shows the options buttons for 2D figures (or 3D figures).\n")
			.append("\t\tOn click of the option button, the program displays the corresponding figure and its properties.\n")
			.append("\t\tCreate javadoc documentation for every variable, every function and every class that you define.\n")
			.append("Program should be executable as applet as well as application.\n")
			.append("\tCreate a folder named CS5405. Create a subdirectory Demo04 inside CS5405. \n")
			.append("\tcd to Demo04\n")
			.append("\tCreate application/applet source files. Name the driver as Demo.java\n")
			.append("\tCompile all of them with\n")
			.append("\t\tjavac *.java \n")
			.append("\tIt will create corresponding files with extension\n")
			.append("\t\t.class\n")
			.append("\tCreate javadoc documentation\n")
			.append("\t\tjavdoc -d docs –author –version –private *.java \n")
			.append("\tNow all the .java, .class files, .html file and docs directory are in the same directory Demo04\n")
			.append("\t\tCreate a zip file Demo04.zip\n")
			.append("\tHow to submit assignment\n")
			.append("\t\tUpload the zip file On Black board\n")
			.append("\t\tBring printed code and Sample output with screenshots to the class\n")
			.append("\t\tAttach this sheet for grade recording.\n")
			.append("Create html file as Demo04.html\n")
			.append("\twhich is a text file with only one line\n")
			.append("\t\t<applet code = Demo04 width = 600 height = 600></applet> \n")
			.append("Turn in the printed copy of source code and screenshots of program output in the class.\n")
			.append("YOUR PROGRAM OUTPUT WILL BE IN a FRAME, NOT on commandline.\n")
			.append("Check the application - does it work?\n")
			.append("Check the applet - does it work? \n")
			.append("I you need help ask me before the lecture.\n")
			.append("Note. Use GUI components that have been covered in the class, as needed to do your work.\n")
			.append("Create separate file for each page. Document these files using javadoc style descriptions. This documentation \n")
			.append("should be constructive as discussed in the class, not parroting.\n")
			.append("All code should be your original code not copy of some else’s. You can be called to the office to explain your\n")
			.append("demo04 program if necessary to get additional information from you.\n")
			.toString();
		JTextArea mainArea = new JTextArea(description,8,25);
		this.add(mainArea);

		Dimension size = new Dimension(600,530);
		setPreferredSize(size);
		setVisible(true);
	}

}


