/**
 * @author Adam Lininger
 */

package code;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public abstract class Sortable extends JInternalFrame
{
	int[] array;
	int size;
	Random numberGenerator;
	public Sortable()
	{
		super("Bubble Sort",true,true,true,true);
		this.size = 100;
		setup();
	}
	public Sortable(int size)
	{
		super("Bubble Sort",true,true,true,true);
		this.size = size;
		setup();
	}
	private void setup()
	{
		numberGenerator = new Random();
		setSize(400,400);
		setVisible(true);
		toFront();
		reset();
	}

	public abstract void sort();

	public abstract void stop();

	public void reset()
	{
		this.stop();
		array = new int[this.size];
		for (int i = 0; i < this.size; i++)
		{
			array[i] = i;
		}
		for (int i = 0; i < this.size; i++)
		{
			int offset = numberGenerator.nextInt(this.size);
			int temp = array[i];
			array[i] = array[offset];
			array[offset] = temp;
		}
	}

	public void paint(Graphics g)
	{
		super.paint(g);

		for (int i = 0; i < size; i++)
		{
			g.drawLine(10,10+i,10+array[i],10+i);
		}
	}
}


