/*
 * Adam Lininger
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MainFrame extends JFrame
{
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

public class Demo extends JApplet implements ActionListener
{
	Shape[] myShapes = new Shape[6];
	JButton assignmentButton;
	JButton authorButton;
	JButton descriptionButton;

	Assignment assignmentPanel;
	Description descriptionPanel;
	Author authorPanel;


	public Demo()
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

	public static void main(String[] args)
	{
		new MainFrame(new Demo());
		System.out.println("\n\n\nFrame Demo Application");
	}

	public void paint(Graphics g)
	{
		super.paint(g);
	} 

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

