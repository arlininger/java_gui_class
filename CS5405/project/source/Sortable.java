/**
 * @author Adam Lininger
 */

package code;

import java.util.*;
import javax.swing.*;

public abstract class Sortable extends JInternalFrame
{
	int[] array;
	int size;
	Random numberGenerator;
	public Sortable()
	{
		numberGenerator = new Random();
		this.size = 100;
	}
	public Sortable(int size)
	{
		numberGenerator = new Random();
		this.size = size;
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
}
