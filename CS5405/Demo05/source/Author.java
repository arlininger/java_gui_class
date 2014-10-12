/*
 * Adam Lininger
 */

package code;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

/**
 * The Author class displays the author and assignment number.
 */
public class Author extends JPanel
{
	/**
	 * Creates the Author class.
	 */
	public Author()
	{
		TitledBorder panelBorder = new TitledBorder("Author");
		setBorder(panelBorder);

		Dimension size = new Dimension(600,530);
		setPreferredSize(size);
		setVisible(true);
	}

	/**
	 * Handles displaying the author and homework number.
	 */
	public void paint(Graphics g)
	{
		super.paint(g);
		g.drawString("Adam Lininger\n",30,40);
		g.drawString("Homework 4\n",30,56);
	} 
}


