/*
 * Adam Lininger
 */

package code;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * The Author class displays the author and assignment number.
 */
public class Author extends JInternalFrame
{
	/**
	 * Creates the Author class.
	 */
	public Author()
	{
		super("Author", true, true, true, true);
		setSize(200, 130);
		setVisible(true);
		toFront();
	}

	/**
	 * Handles displaying the author and homework number.
	 * @param g Graphics object used for drawing strings.
	 */
	public void paint(Graphics g)
	{
		super.paint(g);
		g.drawString("Adam Lininger\n", 30, 40);
		g.drawString("Homework 4\n", 30, 56);
	} 
}


