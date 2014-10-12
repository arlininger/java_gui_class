/*
 * Adam Lininger
 */

package code;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * The MainFrame class is the outermost object when run as an application. It only
 * serves the purpose of creating an outer frame window and containing the applet. All
 * the real logic happens in the applet for further down.
 */
class MainFrame extends JFrame
{
	/**
	 * Creates a Frame containing the applet.
	 * @param demo The applet to display in the frame.
	 */
	public MainFrame(JApplet demo)
	{
		super ("MainFrame");
		setSize(600,600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().add(demo);
		demo.init();
	}
}

/**
 * Demo is the driver for the entire program. It displays the top-level window and
 * contains the top-level logic for panel selection.
 */
public class Demo05 extends JApplet implements ActionListener
{
	/**
	 * Button for selecting the assignment window.
	 */
	JButton assignmentButton;
	/**
	 * Button for selecting the author window.
	 */
	JButton authorButton;
	/**
	 * Button for selecting the description window.
	 */
	JButton descriptionButton;

	/**
	 * Assignment window
	 */
	Assignment assignmentPanel;
	/**
	 * Description window
	 */
	Description descriptionPanel;
	/**
	 * Author window
	 */
	Author authorPanel;

	/**
	 * Creates the top-level applet.
	 * The layout of the top-level window is handled here.
	 */
	public Demo05()
	{
		getContentPane().setLayout(new FlowLayout());
		assignmentButton = new JButton("Assignment");
		authorButton = new JButton("Author");
		descriptionButton = new JButton("Description");

		assignmentButton.addActionListener(this);
		authorButton.addActionListener(this);
		descriptionButton.addActionListener(this);

		getContentPane().add(authorButton);
		getContentPane().add(descriptionButton);
		getContentPane().add(assignmentButton);

		assignmentPanel = new Assignment();
		descriptionPanel = new Description();
		authorPanel = new Author();

		getContentPane().add(assignmentPanel);
		getContentPane().add(descriptionPanel);
		getContentPane().add(authorPanel);

		assignmentPanel.setVisible(false);
		descriptionPanel.setVisible(false);
		authorPanel.setVisible(false);
		
		setSize(600,600);
		setVisible(true);
	}

	/**
	 * Primary entry point when run as an application.
	 * This function creates an instance of the Demo applet inside an
	 * instance of the MainFrame object. This allows all logic to be
	 * contained in the applet and remain common to both Applet and
	 * Application.
	 */
	public static void main(String[] args)
	{
		new MainFrame(new Demo05());
	}

	/**
	 * Displays the 
	 */
	//public void paint(Graphics g)
	//{
	//	super.paint(g);
	//} 

	/**
	 * Handle actions for the buttons in the top-level window.
	 * @param e The action to be handled.
	 */
	public void actionPerformed( ActionEvent e)
	{
		if (e.getSource() == assignmentButton)
		{
			assignmentPanel.setVisible(true);
			authorPanel.setVisible(false);
			descriptionPanel.setVisible(false);
		} else if (e.getSource() == authorButton)
		{
			assignmentPanel.setVisible(false);
			authorPanel.setVisible(true);
			descriptionPanel.setVisible(false);
		} else if (e.getSource() == descriptionButton)
		{
			assignmentPanel.setVisible(false);
			authorPanel.setVisible(false);
			descriptionPanel.setVisible(true);
		}
		repaint();
	}		

}

