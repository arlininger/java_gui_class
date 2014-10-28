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
		.append("Write a program (name the driver class Demo.java), \n")
		.append("It meets all the specifications of HW05, along with\n")
		.append("\tPlace all .java files are in source folder\n")
		.append("\tEach .java file begins with package command\n")
		.append("\t\tpackage code;\n")
		.append("\tCompile all of them with\n")
		.append("\t\tjavac –d . source/*.java \n")
		.append("\tThis will place all .class file are in code folder\n")
		.append("\tCreate javadoc documentation\n")
		.append("\t\tjavdoc -d docs –author –version –private ")
		.append("souce/*.java \n")
		.append("\tIt should be executable as application as well")
		.append(" as applet\n")
		.append("\t\tThe Demop.html changes to\n")
		.append("\t\t<applet code = code.Demo width = 600 height=600>")
		.append("</applet>\n")
		.append("\t\tfor application\n")
		.append("\t\t\tjava code.Demo\n")
		.append("\tNow your folder has .html file, source, code, ")
		.append("docs directories.\n")
		.append("Create a manifest file with one line\n")
		.append("\tMain-Class: code.Demo\n")
		.append("\tName it m.txt\n")
		.append("Create jar file\n")
		.append("\tjar -cvfm Demo.jar m.txt *\n")
		.append("Create Demoj.html file\n")
		.append("\t<applet code =code.Demo archive=Demo.jar width")
		.append(" = 600 height=600></applet>\n")
		.append("Now your HW06 directory has \n")
		.append("\tDemoj.html\n")
		.append("\tDemo.jar\n")
		.append("Create a zip file Demo.zip upload to Bb.\n")
		.append("Turn in the printed copy of source code and screenshots ")
		.append("of program output in the class for \n")
		.append("comments in grading.\n")
			.toString();
		JTextArea mainArea = new JTextArea(description, 30, 50);
		mainArea.setTabSize(3);
		mainArea.setWrapStyleWord(true);
		JScrollPane scrollwindow = new JScrollPane(mainArea);
		this.add(scrollwindow);
	}
}


