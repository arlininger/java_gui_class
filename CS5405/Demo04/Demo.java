/*
 * Adam Lininger
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Assignment;

class MainFrame extends JFrame
{
	public MainFrame(JApplet demo)
	{
		super ("MainFrame");
		setSize(400,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().add(demo);
		demo.init();
	}
}

public class Demo extends JApplet implements ActionListener
{
	Shape[] myShapes = new Shape[6];
	JButton circleButton;
	JButton squareButton;
	JButton triangleButton;
	JButton sphereButton;
	JButton cubeButton;
	JButton tetrahedronButton;
	Integer lastShapeIndex = -1;

	public Demo()
	{
		getContentPane().setLayout(new FlowLayout());

		Assignment thirdPanel = new Assignment();
		thirdPanel.setVisible(true);
		
		setSize(400,400);
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

}
