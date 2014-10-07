/*
 * Adam Lininger
 */

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;


public class Author extends JPanel
{
	public Author()
	{
		TitledBorder panelBorder = new TitledBorder("Author");
		setBorder(panelBorder);

		Dimension size = new Dimension(600,530);
		setPreferredSize(size);
		setVisible(true);
	}

	public void paint(Graphics g)
	{
		super.paint(g);
		g.drawString("Adam Lininger\n",30,40);
		g.drawString("Homework 4\n",30,56);
	} 
}


