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

		Dimension size = new Dimension(600,530);
		setPreferredSize(size);
		setVisible(true);
	}

	public void paint(Graphics g)
	{
		super.paint(g);
		System.out.format("Insert description here\n");
	} 
}


